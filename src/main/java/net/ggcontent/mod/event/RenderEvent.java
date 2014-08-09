package net.ggcontent.mod.event;

/*
 * Author 0Zerotiger, feel free to use and change this class as much as you want, but don't remove this line
 */

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent.SetArmorModel;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RenderEvent {	
	
	private static final ResourceLocation goldcrown = new ResourceLocation("turpem:textures/titles/goldcrown.png");
	private static final ResourceLocation silvercrown = new ResourceLocation("turpem:textures/titles/silvercrown.png");
	private static final ResourceLocation donatorcrown = new ResourceLocation("turpem:textures/titles/donatorcrown.png");
	
	@SubscribeEvent
	public void renderPlayerNameTag(RenderLivingEvent.Specials.Pre event){
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer client = Minecraft.getMinecraft().thePlayer;
			EntityPlayer player = (EntityPlayer) event.entity;	            	
			if(net.ggcontent.mod.util.MathHelper.calculateDistanceEntities3D(client, player) <= event.renderer.NAME_TAG_RANGE && (Ggcontent.developers.contains(player.getCommandSenderName())  || Ggcontent.helpful.contains(player.getCommandSenderName()) || Ggcontent.donators.contains(player.getCommandSenderName()))){
				
				float playerViewY = client.prevRotationYaw + (client.rotationYaw - client.prevRotationYaw);
				float playerViewX = client.prevRotationPitch + (client.rotationPitch - client.prevRotationPitch);	
				float f1 = 0.016666668F;
				
				/**
				 * Change this value to move it more to the left
				 * If you want to move it to the right make it negative, or change those lines
				 * tessellator.addVertexWithUV
				 */
				float offset = 20;
				
				GL11.glPushMatrix();
					GL11.glTranslatef((float)event.x, (float)event.y + player.height + 0.3F, (float)event.z);
					GL11.glNormal3f(0.0F, 1.0F, 0.0F);
					GL11.glRotatef(-playerViewY, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(playerViewX, 1.0F, 0.0F, 0.0F);
					GL11.glScalef(-f1, -f1, f1);
					GL11.glDisable(GL11.GL_LIGHTING);
					GL11.glDepthMask(false);
					GL11.glEnable(GL11.GL_BLEND);
					OpenGlHelper.glBlendFunc(770, 771, 1, 0);
					Tessellator tessellator = Tessellator.instance;
					tessellator.startDrawingQuads();
					if(Ggcontent.developers.contains(player.getCommandSenderName()))
						FMLClientHandler.instance().getClient().renderEngine.getTexture(goldcrown);
					else if(Ggcontent.helpful.contains(player.getCommandSenderName()))
						FMLClientHandler.instance().getClient().renderEngine.getTexture(silvercrown);
					else
						FMLClientHandler.instance().getClient().renderEngine.getTexture(donatorcrown);
					tessellator.setColorRGBA_F(1F, 1F, 1F, 0.3F);
					tessellator.addVertexWithUV((double)(-offset - 20), -4D, 0.0D, 0, 0);
					tessellator.addVertexWithUV((double)(-offset - 20), 12D, 0.0D, 0, 1);
					tessellator.addVertexWithUV((double)(-offset - 2), 12D, 0.0D, 1, 1);
					tessellator.addVertexWithUV((double)(-offset - 2), -4D, 0.0D, 1, 0);	
					tessellator.draw();
					GL11.glDepthMask(true);
					GL11.glEnable(GL11.GL_LIGHTING);
					GL11.glDisable(GL11.GL_BLEND);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					GL11.glPopMatrix();
			}			        
		}
	}
}
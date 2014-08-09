package net.ggcontent.mod.handler;

import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.helpers.CapeHelper;
import net.ggcontent.mod.helpers.PlayerHelper;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GGEventHandler 
{
	@SubscribeEvent
	@SideOnly(Side.CLIENT)		
	public void renderPlayerSpecials(RenderPlayerEvent.Specials.Pre event) {
		if (event.entityPlayer instanceof AbstractClientPlayer) {
			final AbstractClientPlayer playerClient = (AbstractClientPlayer)event.entityPlayer;
			if (!event.renderCape) {
				
			} else {
				PlayerHelper.renderCapes(playerClient);
			}
			PlayerHelper.renderSkins(playerClient);
		} else {
			
			return;
		}
	}
	

	
	
	
	@SubscribeEvent
	 public void renderPlayerNameTag(RenderLivingEvent.Specials.Pre event){

	}


}


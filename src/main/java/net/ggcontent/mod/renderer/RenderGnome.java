package net.ggcontent.mod.renderer;

import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.entity.EntityCyclops;
import net.ggcontent.mod.entity.EntityGnome;
import net.ggcontent.mod.model.ModelCyclops;
import net.ggcontent.mod.model.ModelGnome;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderGnome extends RenderLiving {
	
	private static final ResourceLocation texture = new ResourceLocation(Ggcontent.MODID + ":" + "textures/model/Gnome.png");
	
	protected ModelGnome modelEntity;

	public RenderGnome(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);		
		modelEntity = ((ModelGnome) mainModel);
		
	}
	
	public void renderGnome(EntityGnome entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderGnome((EntityGnome)entityLiving, x, y, z, u, v);
			}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderGnome((EntityGnome)entity, x, y, z, u, v);
	}
	
	
	

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;		
	}

	

}

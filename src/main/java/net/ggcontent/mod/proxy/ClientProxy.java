package net.ggcontent.mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.entity.EntityCyclops;
import net.ggcontent.mod.entity.EntityGnome;
import net.ggcontent.mod.model.ModelCyclops;
import net.ggcontent.mod.model.ModelGnome;
import net.ggcontent.mod.renderer.ItemRenderObsidianTable;
import net.ggcontent.mod.renderer.RenderCyclops;
import net.ggcontent.mod.renderer.RenderGnome;
import net.ggcontent.mod.renderer.RenderObsidianTable;
import net.ggcontent.mod.tileentity.TileEntityObsidianTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;


public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		
		//ObsidianTable
		TileEntitySpecialRenderer render = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Ggcontent.blockObsidianTable), new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));
		
		
		//Entities
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelCyclops(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGnome.class, new RenderGnome(new ModelGnome(), 0.3F));
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
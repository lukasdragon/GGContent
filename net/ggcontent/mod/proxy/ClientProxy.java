package net.ggcontent.mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.renderer.ItemRenderObsidianTable;
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
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
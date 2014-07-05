package net.ggcontent.mod.handler;

import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.container.ContainerAlabasterOven;
import net.ggcontent.mod.container.ContainerMagicTable;
import net.ggcontent.mod.gui.GuiAlabasterOven;
import net.ggcontent.mod.gui.GuiMagicTable;
import net.ggcontent.mod.tileentity.TileEntityAlabasterOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Ggcontent.guiIDalabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new ContainerAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
			    
			}
		}
		
		if(ID == Ggcontent.guiIDMagicTable) {
			return ID == Ggcontent.guiIDMagicTable && world.getBlock(x, y, z) == Ggcontent.blockMagicTable ? new ContainerMagicTable(player.inventory, world, x, y, z) : null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Ggcontent.guiIDalabasterOven:
				if (entity instanceof TileEntityAlabasterOven) {
					return new GuiAlabasterOven(player.inventory, (TileEntityAlabasterOven) entity);
				}
				return null;
			    
			}
		}
		if(ID == Ggcontent.guiIDMagicTable) {
			return ID == Ggcontent.guiIDMagicTable && world.getBlock(x, y, z) == Ggcontent.blockMagicTable ? new GuiMagicTable(player.inventory, world, x, y, z) : null;
		}
		
		
		return null;
	}

}

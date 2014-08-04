package net.ggcontent.mod.handler;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
    
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == Ggcontent.itemTreePitch) return 800;
		if(fuel.getItem() == Ggcontent.itemDiamondCoal) return 9999;
		return 0;
	}

}

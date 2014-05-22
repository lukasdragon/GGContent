package net.glggcontent.mod.handler;

import net.glggcontent.mod.Glggcontent;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {
    
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == Glggcontent.itemTreePitch) return 800;
		if(fuel.getItem() == Glggcontent.itemDiamondCoal) return 69696969;
		return 0;
	}

}

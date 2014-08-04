package net.ggcontent.mod.items;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MEssence extends Item{
	
	
	public MEssence() {
							
				this.setCreativeTab(Ggcontent.GGEssence);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
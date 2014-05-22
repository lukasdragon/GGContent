package net.glggcontent.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.glggcontent.mod.Glggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class NCItems extends Item{

	public NCItems() {
				getCreativeTab();
				this.setCreativeTab(Glggcontent.GLGGTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Glggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	
}

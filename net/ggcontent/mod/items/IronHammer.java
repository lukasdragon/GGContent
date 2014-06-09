package net.ggcontent.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class IronHammer extends Item{
	
	public IronHammer() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setNoRepair();
		this.setCreativeTab(Ggcontent.GGTab);
	}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
		
	}
	
}

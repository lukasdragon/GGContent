package net.glggcontent.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.glggcontent.mod.Glggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;

public class LukasHoe extends ItemHoe {

	public LukasHoe(ToolMaterial p_i45343_1_) {
		super(p_i45343_1_);
		this.setCreativeTab(Glggcontent.GLGGTab);
	}
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
this.itemIcon = iconRegister.registerIcon(Glggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));

}

}

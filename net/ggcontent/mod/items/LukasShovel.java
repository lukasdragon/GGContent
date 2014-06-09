package net.ggcontent.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;

public class LukasShovel extends ItemSpade {

	public LukasShovel(ToolMaterial arg0) {
		super(arg0);
		this.setCreativeTab(Ggcontent.GLGGTab);
	}
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister) {
this.itemIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));

}
}

package net.ggcontent.mod.blocks;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LifeBlock extends Block{

	public LifeBlock(Material material) {
		super(material);
		
		this.setStepSound(soundTypePiston);
		this.setCreativeTab(Ggcontent.GLGGTab);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
			}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
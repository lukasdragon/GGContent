package net.glggcontent.mod.blocks;

import net.glggcontent.mod.Glggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BarkBlock extends Block{

	public BarkBlock(Material material) {
		super(material);
		
		this.setStepSound(soundTypeWood);
		this.setCreativeTab(Glggcontent.GLGGTab);
		
					}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Glggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
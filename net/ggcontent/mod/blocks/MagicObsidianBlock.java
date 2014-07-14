package net.ggcontent.mod.blocks;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MagicObsidianBlock extends Block {

	public MagicObsidianBlock(Material material) {
		super(material);
		
		this.setHardness(30.0F);
		this.setResistance(20.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(Ggcontent.GGEssence);
		
		
	}

	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}

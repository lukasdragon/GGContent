package net.ggcontent.mod.blocks;

import java.util.Random;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoftObsidianBlock extends Block {

	public SoftObsidianBlock(Material material) {
		super(material);
		
		this.setHardness(30.0F);
		this.setResistance(20.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(Ggcontent.GGTab);
		
		
	}

	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
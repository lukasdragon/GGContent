package net.glggcontent.mod.blocks;

import java.util.Random;

import net.glggcontent.mod.Glggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreBlock extends Block {

	public OreBlock(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		getCreativeTabToDisplayOn();
		this.setCreativeTab(Glggcontent.GLGGTab);
	}

	public Item getItemDropped(int i, Random random, int j) {
		return this == Glggcontent.oreGodOre ? Glggcontent.itemGodlyMetal : Item.getItemFromBlock(this);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Glggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
}
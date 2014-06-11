package net.ggcontent.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ggcontent.mod.Ggcontent;
import net.ggcontent.mod.tileentity.TileEntityObsidianTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ObsidianBlock extends BlockContainer {

	public ObsidianBlock(Material material) {
		super(material);
		
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
		
		this.setCreativeTab(Ggcontent.GGTab);
		
	}
	
	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityObsidianTable();
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}

}

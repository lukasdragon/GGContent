package net.ggcontent.mod.blocks;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MagicTable extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon MagicTableTop;

	public MagicTable() {
		super(Material.ground);

		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(Ggcontent.GGEssence);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.MagicTableTop : this.blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + "MagicTableSide");
		this.MagicTableTop = iconRegister.registerIcon(Ggcontent.MODID + ":" + "MagicTableTop");
	}

	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		if (!player.isSneaking()) {
			player.openGui(Ggcontent.instance, Ggcontent.guiIDMagicTable, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}


}



package net.ggcontent.mod.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.BlockJukebox;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class GGRecord extends ItemRecord
{
	public GGRecord(String name)
	{
		super("shire");
		setUnlocalizedName(name);
		setTextureName(name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Ggcontent.GGTab);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal()
    {
        return "Lukas Olson - Shire Remix";
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(Ggcontent.MODID, "shire");
    }
}
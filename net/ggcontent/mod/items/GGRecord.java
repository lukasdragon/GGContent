package net.ggcontent.mod.items;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GGRecord extends ItemRecord
{
	public final String title;
	public GGRecord(String name, String title)
	{
		super(name.toLowerCase().replace("disc", ""));
		setUnlocalizedName(name);
		setTextureName(Ggcontent.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(Ggcontent.GGTab);
		this.title=title;
	}
		
	@Override
    @SideOnly(Side.CLIENT)
    public String getRecordNameLocal()
    {
        return title;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ResourceLocation getRecordResource(String name)
    {
        return new ResourceLocation(Ggcontent.MODID, name.substring(8));
    }
}
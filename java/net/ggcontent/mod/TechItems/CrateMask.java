package net.ggcontent.mod.TechItems;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrateMask extends Item{
	
	
	public CrateMask() {
							
				this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {}
		 itemstack.stacksize
		if(entity instanceof Entityplayer){
		   player.inventory.addItemStackToInventoryplayer.inventory.addItemStackToInventory(new ItemStack(randomItems[rand.nextInt(randomItems.length())]));
	}
	
	
}

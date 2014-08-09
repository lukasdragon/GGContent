package net.ggcontent.mod.TechItems;

import java.util.Random;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CrateMaskOne extends Item{
	
	
	public CrateMaskOne() {
							
				this.setCreativeTab(null);
	}
	
	 private static final Item[] randomItems = new Item[] {Items.apple, Item.getItemFromBlock(Blocks.stone)};
	 @Override
	 public void onUpdate(ItemStack itemstack, World world, Entity entity, int p_77663_4_, boolean inHand) {

	 if(!world.isRemote && entity instanceof EntityPlayer){
	 EntityPlayer player = (EntityPlayer)entity;
	 Random rand = new Random();
	 itemstack.stackSize--;
	 player.inventory.addItemStackToInventory(new ItemStack(randomItems[rand.nextInt(randomItems.length)]));
	 }
	 super.onUpdate(itemstack, world, entity, p_77663_4_, inHand);
	 }

	
	
}

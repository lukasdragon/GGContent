package net.ggcontent.mod.items;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class FoodPutridBall extends ItemFood{

	public FoodPutridBall(int p_i45339_1_, float p_i45339_2_,
			boolean p_i45339_3_) {
		super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
		
		this.setCreativeTab(Ggcontent.GGTab);
				
		
	}
	
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
	{
	       if (!player.capabilities.isCreativeMode){
	            --itemstack.stackSize;
	            }
	               if(!world.isRemote){
	                      player.addPotionEffect(new PotionEffect(9, 8 * 20, 4));
	                      player.addPotionEffect(new PotionEffect(17, 8 * 20, 0));
	                      player.addPotionEffect(new PotionEffect(18, 8 * 20, 5));
	                      player.addPotionEffect(new PotionEffect(23, 1 * 20, 0));
	             }
	      return itemstack;
	 }
	


}

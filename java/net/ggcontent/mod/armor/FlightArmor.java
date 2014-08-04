package net.ggcontent.mod.armor;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FlightArmor extends ItemArmor {

	public FlightArmor(ArmorMaterial material, int id,
			int slot) {
		super(material, id, slot);
		this.setCreativeTab(Ggcontent.GGEssence);

		if(slot == 0) {
			this.setTextureName(Ggcontent.MODID + ":FlightHelm");
		}else if (slot == 1) {
			this.setTextureName(Ggcontent.MODID + ":FlightChest");
		}else if (slot == 2) {
			this.setTextureName(Ggcontent.MODID + ":FlightLegs");
		}else if (slot == 3) {
			this.setTextureName(Ggcontent.MODID + ":FlightBoots");
		}	
	}
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type) {
		if (itemstack.getItem() == Ggcontent.armorFlightHelm || itemstack.getItem() == Ggcontent.armorFlightChest || itemstack.getItem() == Ggcontent.armorFlightBoots) {  
				return Ggcontent.MODID + ":textures/model/armor/flight_layer_1.png";
		}else if (itemstack.getItem() == Ggcontent.armorFlightLegs) {  
			return Ggcontent.MODID + ":textures/model/armor/flight_layer_2.png";
		}else{
			return null;
		}
	}
		
		public void onCreated(ItemStack itemstack, World world, EntityPlayer entityplayer) {

			if (itemstack.getItem() == Ggcontent.armorFlightBoots) {
				itemstack.addEnchantment(Enchantment.featherFalling, 10);			
			}
		}


		
		@Override
		public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		 ItemStack helmet = player.getCurrentArmor(3);
		 ItemStack plate = player.getCurrentArmor(2);
		 ItemStack legs = player.getCurrentArmor(1);
		 ItemStack boots = player.getCurrentArmor(0);
		 int duration = 15;

		 if (helmet != null && plate != null && legs != null && boots != null) {
		 if (helmet.getItem() == Ggcontent.armorFlightHelm && plate.getItem() == Ggcontent.armorFlightChest && legs.getItem() == Ggcontent.armorFlightLegs && boots.getItem() == Ggcontent.armorFlightBoots) {
		 player.capabilities.allowFlying = true;
		 }
		 }else if (!player.capabilities.isCreativeMode){
				player.capabilities.allowFlying = false;
		 }
		} 
				
			
	            
	               	
	        
	        
	    
	    }

		
		
		 

	


package net.ggcontent.mod.handler;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class CraftingHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event) {
		
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
			if (event.craftMatrix.getStackInSlot(i) != null) {
				
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if (item0 != null && item0.getItem() == Ggcontent.itemIronHammer) {
					ItemStack K = new ItemStack(Ggcontent.itemIronHammer, 2, (item0.getItemDamage() + 1));
					
					if (K.getItemDamage() >= K.getMaxDamage()) {
						K.stackSize--;
						
					}
					
				event.craftMatrix.setInventorySlotContents(i,  K);
					}
				
				ItemStack item1 = event.craftMatrix.getStackInSlot(i);
				if (item1 != null && item1.getItem() == Ggcontent.itemIronPunch) {
					ItemStack K = new ItemStack(Ggcontent.itemIronPunch, 2, (item1.getItemDamage() + 1));
					
					if (K.getItemDamage() >= K.getMaxDamage()) {
						K.stackSize--;
						
					}
					
				event.craftMatrix.setInventorySlotContents(i,  K);
					}
				
				ItemStack item2 = event.craftMatrix.getStackInSlot(i);
				if (item2 != null && item2.getItem() == Ggcontent.itemMoneyPress) {
					ItemStack K = new ItemStack(Ggcontent.itemMoneyPress, 2, (item2.getItemDamage() + 1));
					
					if (K.getItemDamage() >= K.getMaxDamage()) {
						K.stackSize--;
						
					}
					
				event.craftMatrix.setInventorySlotContents(i,  K);
					}
				
				
				}
			}
		}
	
	}
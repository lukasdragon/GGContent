package net.ggcontent.mod.crafting;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {
	
	
	public static void removeRecipe() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
		/*
		 for blocks simply put the following line before the block:
		 Item.getItemFromBlock(INSERT BLOCK HERE) 		  		  
		 */
			
		  while(remover.hasNext()) {
			  ItemStack itemstack = remover.next().getRecipeOutput();
			  if(itemstack != null && itemstack.getItem() == Items.book){
				  remover.remove();
			  }else if (itemstack != null && itemstack.getItem() == Items.flint_and_steel){
				  remover.remove();
			  }
				  
		  }
	}

}

package net.ggcontent.mod.items;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InfiniSword extends ItemSword {


	public InfiniSword(ToolMaterial arg0) {
		super(arg0);
		this.setCreativeTab(null);
			}
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(Ggcontent.MODID + ":" + this.getUnlocalizedName().substring(5));
		
	}
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {    
    par1ItemStack.addEnchantment(Enchantment.looting, 10);
    par1ItemStack.addEnchantment(Enchantment.infinity, 10);    
    }
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase hitEntity, EntityLivingBase attackingEntity) {
	hitEntity.setFire(4);
	 hitEntity.addPotionEffect(new PotionEffect(Potion.invisibility.id, 500, 4));
	 hitEntity.addPotionEffect(new PotionEffect(Potion.wither.id, 500, 5));
	return true;
	}

}

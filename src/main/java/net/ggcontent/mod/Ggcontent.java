package net.ggcontent.mod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.logging.log4j.Logger;

import net.ggcontent.mod.MobHandlers.CyclopsHandler;
import net.ggcontent.mod.MobHandlers.CreatureHandler;
import net.ggcontent.mod.TechItems.CrateMaskOne;
import net.ggcontent.mod.armor.FlightArmor;
import net.ggcontent.mod.blocks.AlabasterOven;
import net.ggcontent.mod.blocks.BarkBlock;
import net.ggcontent.mod.blocks.CrateBlock;
import net.ggcontent.mod.blocks.LifeBlock;
import net.ggcontent.mod.blocks.MagicObsidianBlock;
import net.ggcontent.mod.blocks.MagicTable;
import net.ggcontent.mod.blocks.MetalBlock;
import net.ggcontent.mod.blocks.ObsidianBlock;
import net.ggcontent.mod.blocks.OreBlock;
import net.ggcontent.mod.blocks.SoftObsidianBlock;
import net.ggcontent.mod.crafting.RecipeRemover;
import net.ggcontent.mod.entity.EntityCyclops;
import net.ggcontent.mod.entity.EntityGnome;
import net.ggcontent.mod.handler.CraftingHandler;
import net.ggcontent.mod.handler.FuelHandler;
import net.ggcontent.mod.handler.GGEventHandler;
import net.ggcontent.mod.handler.GuiHandler;
import net.ggcontent.mod.items.AirBottle;
import net.ggcontent.mod.items.CrateKey;
import net.ggcontent.mod.items.GGRecord;
import net.ggcontent.mod.items.InfiniSword;
import net.ggcontent.mod.items.IronHammer;
import net.ggcontent.mod.items.IronPunch;
import net.ggcontent.mod.items.LukasAxe;
import net.ggcontent.mod.items.LukasHoe;
import net.ggcontent.mod.items.LukasPickaxe;
import net.ggcontent.mod.items.LukasShovel;
import net.ggcontent.mod.items.LukasSword;
import net.ggcontent.mod.items.MEssence;
import net.ggcontent.mod.items.MoneyPress;
import net.ggcontent.mod.items.NCItems;
import net.ggcontent.mod.items.StingerSword;
import net.ggcontent.mod.items.foodManna;
import net.ggcontent.mod.items.FoodPutridBall;
import net.ggcontent.mod.proxy.CommonProxy;
import net.ggcontent.mod.tileentity.TileEntityAlabasterOven;
import net.ggcontent.mod.worldgen.GgWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(name = "Ggcontent", modid = Ggcontent.MODID, version = Ggcontent.VERSION)
public class Ggcontent
{
    public static final String MODID = "ggcontent";
    public static final String VERSION = "ALPHA 6.7";    
    
    GgWorldGen eventWorldGen = new GgWorldGen();        
    
    public static CreativeTabs GGTab;
    public static CreativeTabs GGEssence;
    
    public static ToolMaterial LukasMaterial = EnumHelper.addToolMaterial("LukasMaterial", 2, 500, 8.0F, 2.0F, 14);
    public static ToolMaterial GodMaterial = EnumHelper.addToolMaterial("GodMaterial", 40, 9000, 10.0F, 3.0F, 30);
    public static ArmorMaterial FlightArmorMaterial = EnumHelper.addArmorMaterial("FlightArmorMaterial", 25, new int[] {2, 6, 5, 2}, 25);   
    
    public static ArrayList<String> developers = new ArrayList();
    public static ArrayList<String> donators = new ArrayList();
    
    @Instance(MODID)
    public static Ggcontent instance;
    
    //ingots
    public static Item itemLukasIngot;
    public static Item itemAkermaniteIngot;
    public static Item itemNiobiumIngot;
    public static Item itemSpheneIngot;
    public static Item itemStibniteIngot;
    public static Item itemGodlyMetal;
    public static Item itemAlabasterGem;
    public static Item itemSteelIngot;
    
    
    //items
    public static Item itemGlggDollar;
    public static Item itemSpheneCog;
    public static Item itemIronWasher;
    public static Item itemIronDisc;
    public static Item itemIronCoin;
    public static Item itemGoldDisc;
    public static Item itemGoldCoin;
    public static Item itemAlabasterIron;    
    
    
    //Records    
    public static Item itemMiracleRecord;   
    public static Item itemGabenRecord;
    
    
    //ores
    public static Block oreLukasOre;
    public static Block oreAkermaniteOre;
    public static Block oreNiobiumOre;
    public static Block oreSpheneOre;
    public static Block oreStibniteOre;
    public static Block oreGodOre;
    public static Block oreAlabasterOre;
    
    //Blocks
    public static Block blockLukasBlock;
    public static Block blockSpheneBlock;
    public static Block blockLifeBlock;  
    public static Block blockBarkBlock;
    public static Block blockObsidianTable;
    public static Block blockSoftObsidianBlock;    
    
    
    //Machines
    public static Block blockAlabasterOvenIdle;
    public static Block blockAlabasterOvenActive;
    public static final int guiIDalabasterOven = 0;
    public static Block blockMagicTable;
    public static final int guiIDMagicTable = 1;
	public static final String helpful = null;
    
    //Fuels
    public static Item itemTreePitch;
    public static Item itemDiamondCoal;
    
    //Tools
    public static Item itemIronHammer;
    public static Item itemIronPunch;
    public static Item itemMoneyPress;
    public static Item itemLukasSword;
    public static Item itemLukasAxe;
    public static Item itemLukasShovel;
    public static Item itemLukasHoe;
    public static Item itemLukasPickaxe;
    
    //Crates
    public static Block blockCrateOne;
    public static Item itemCrateKey;
    
  
    
    //Private
    public static Item itemStingerSword;
    public static Item itemInfiniSword;
    
    
    public static int armorFlightHelmID;
    public static int armorFlightChestID;
    public static int armorFlightLegsID;
    public static int armorFlightBootsID;
    
    
    public static Item armorFlightHelm;
    public static Item armorFlightChest;
    public static Item armorFlightLegs;
    public static Item armorFlightBoots;
    //Foods
    
    public static Item foodManna;  
    public static Item foodPutridBall;
    
    
    //GG Essences
    public static Item itemBaseEssence;
    public static Item itemEarthEssence;
    public static Item itemWaterEssence;
    public static Item itemFireEssence;
    public static Item itemAirEssence;
    public static Item itemMagmaEssence;
    
    //Technical
    public static Item itemCrateMaskOne;
    
    public static Item itemAirBottle;
    
    public static Block blockMagicObsidianBlock;
    
   
    
    @SidedProxy(clientSide = "net.ggcontent.mod.proxy.ClientProxy", serverSide = "net.ggcontent.mod.proxy.CommonProxy")
    public static CommonProxy ggProxy;
        
	
    
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent PreEvent){
    
    	GameRegistry.registerWorldGenerator(eventWorldGen, 0);
    	
    	
    	GGTab = new CreativeTabs("GG Content") {
    		@SideOnly(Side.CLIENT)
    		 		public Item getTabIconItem() {
    			return Item.getItemFromBlock(blockAlabasterOvenActive);
    		}
    		
    		
    	};
    	
    	GGEssence = new CreativeTabs("GG Essence") {
    		@SideOnly(Side.CLIENT)
    		 		public Item getTabIconItem() {
    			return Item.getItemFromBlock(blockMagicTable);
    		}
    		
    		
    	};
    	    	
	   //Ingot    	
    	itemLukasIngot = new NCItems().setUnlocalizedName("LukasIngot");
    	GameRegistry.registerItem(itemLukasIngot, "LukasIngot");
    	
    	itemSpheneIngot = new NCItems().setUnlocalizedName("SpheneIngot");
    	GameRegistry.registerItem(itemSpheneIngot, "SpheneIngot");
    	
    	itemNiobiumIngot = new NCItems().setUnlocalizedName("NiobiumIngot");
    	GameRegistry.registerItem(itemNiobiumIngot, "NiobiumIngot");
    	
    	itemStibniteIngot = new NCItems().setUnlocalizedName("StibniteIngot");
    	GameRegistry.registerItem(itemStibniteIngot, "StibniteIngot");
    	    	
    	itemAkermaniteIngot = new NCItems().setUnlocalizedName("AkermaniteIngot");
    	GameRegistry.registerItem(itemAkermaniteIngot, "AkermaniteIngot");
    	
    	itemAlabasterGem = new NCItems().setUnlocalizedName("AlabasterGem");
    	GameRegistry.registerItem(itemAlabasterGem, "AlabasterGem");
    	
    	itemSteelIngot = new NCItems().setUnlocalizedName("SteelIngot");
    	GameRegistry.registerItem(itemSteelIngot, "SteelIngot");
    	
    	
    	
    	//Items
    	itemGlggDollar = new NCItems().setUnlocalizedName("GlggDollar");
    	GameRegistry.registerItem(itemGlggDollar, "GlggDollar");
    	
    	itemIronWasher = new NCItems().setUnlocalizedName("IronWasher");
    	GameRegistry.registerItem(itemIronWasher, "IronWasher");
    	
    	itemIronDisc = new NCItems().setUnlocalizedName("IronDisc");
    	GameRegistry.registerItem(itemIronDisc, "IronDisc");
    	
    	itemIronCoin = new NCItems().setUnlocalizedName("IronCoin");
    	GameRegistry.registerItem(itemIronCoin, "IronCoin");
    	    	
    	itemAlabasterIron = new NCItems().setUnlocalizedName("AlabasterIron");
    	GameRegistry.registerItem(itemAlabasterIron, "AlabasterIron");
    	
    	itemGoldCoin = new NCItems().setUnlocalizedName("GoldCoin");
    	GameRegistry.registerItem(itemGoldCoin, "GoldCoin");
    	
    	itemGoldDisc = new NCItems().setUnlocalizedName("GoldDisc");
    	GameRegistry.registerItem(itemGoldDisc, "GoldDisc");
    	   	
    	    	    	
    	itemSpheneCog = new NCItems().setUnlocalizedName("SpheneCog");
    	GameRegistry.registerItem(itemSpheneCog, "SpheneCog");
    	
    	//Records    	
    	itemMiracleRecord = new GGRecord("miracleDisc", "Patti LaBelle - Are You Ready For A Miracle?");  
   	      	
    	itemGabenRecord = new GGRecord("gabenDisc", "Mastgrr - Stop A Gaben"); 
    	
    	
    	//Fuel items
    	itemTreePitch = new NCItems().setUnlocalizedName("TreePitch");
    	GameRegistry.registerItem(itemTreePitch, "TreePitch");
    	
    	itemDiamondCoal = new NCItems().setUnlocalizedName("DiamondCoal");
    	GameRegistry.registerItem(itemDiamondCoal, "DiamondCoal");
    	
    	//Tools
    	itemIronHammer = new IronHammer().setUnlocalizedName("IronHammer");
    	GameRegistry.registerItem(itemIronHammer, "IronHammer");
    	
    	itemIronPunch = new IronPunch().setUnlocalizedName("IronPunch");
    	GameRegistry.registerItem(itemIronPunch, "IronPunch");
    	    	
    	itemMoneyPress = new MoneyPress().setUnlocalizedName("MoneyPress");
    	GameRegistry.registerItem(itemMoneyPress, "MoneyPress");
    	
    	
    	itemLukasSword = new LukasSword(LukasMaterial).setUnlocalizedName("LukasSword");
    	GameRegistry.registerItem(itemLukasSword, "LukasSword");
 
    	itemLukasAxe = new LukasAxe(LukasMaterial).setUnlocalizedName("LukasAxe");
    	GameRegistry.registerItem(itemLukasAxe, "LukasAxe");
    	
    	itemLukasShovel = new LukasShovel(LukasMaterial).setUnlocalizedName("LukasShovel");
    	GameRegistry.registerItem(itemLukasShovel, "LukasShovel");

    	itemLukasHoe = new LukasHoe(LukasMaterial).setUnlocalizedName("LukasHoe");
    	GameRegistry.registerItem(itemLukasHoe, "LukasHoe");
    	
    	itemLukasPickaxe = new LukasPickaxe(LukasMaterial).setUnlocalizedName("LukasPickaxe");
    	GameRegistry.registerItem(itemLukasPickaxe, "LukasPickaxe");
    	
    	itemStingerSword = new StingerSword(GodMaterial).setUnlocalizedName("StingerSword");
    	GameRegistry.registerItem(itemStingerSword, "StingerSword");
    	
    	itemInfiniSword = new InfiniSword(GodMaterial).setUnlocalizedName("InfiniSword");
    	GameRegistry.registerItem(itemInfiniSword, "InfiniSword");
    	
    	//Ore Drops
    	itemGodlyMetal = new NCItems().setUnlocalizedName("GodlyMetal");
    	GameRegistry.registerItem(itemGodlyMetal, "GodlyMetal");
    	
    	
    	//Armor
    	armorFlightHelm = new FlightArmor(FlightArmorMaterial, armorFlightHelmID, 0).setUnlocalizedName("FlightHelm");
    	GameRegistry.registerItem(armorFlightHelm, "FlightHelm");
    	
    	armorFlightChest = new FlightArmor(FlightArmorMaterial, armorFlightChestID, 1).setUnlocalizedName("FlightChest");
    	GameRegistry.registerItem(armorFlightChest, "FlightChest");
    	
    	armorFlightLegs = new FlightArmor(FlightArmorMaterial, armorFlightLegsID, 2).setUnlocalizedName("FlightLegs");
    	GameRegistry.registerItem(armorFlightLegs, "FlightLegs");
    	
    	armorFlightBoots = new FlightArmor(FlightArmorMaterial, armorFlightBootsID, 3).setUnlocalizedName("FlightBoots");
    	GameRegistry.registerItem(armorFlightBoots, "FlightBoots");
    	
    	
    	//Blocks
    	blockLifeBlock = new LifeBlock(Material.lava).setBlockName("LifeBlock");
    	GameRegistry.registerBlock(blockLifeBlock, "LifeBlock");
    	
    	blockBarkBlock = new BarkBlock(Material.wood).setBlockName("BarkBlock");
    	GameRegistry.registerBlock(blockBarkBlock, "BarkBlock");
    	
    	blockObsidianTable = new ObsidianBlock(Material.rock).setBlockName("ObsidianTable");
    	GameRegistry.registerBlock(blockObsidianTable, "ObsidianTable");
    	
    	blockSoftObsidianBlock = new SoftObsidianBlock(Material.rock).setBlockName("SoftObsidian");
    	GameRegistry.registerBlock(blockSoftObsidianBlock, "SoftObsidian");
    	
    	blockMagicObsidianBlock = new MagicObsidianBlock(Material.rock).setBlockName("MagicObsidian");
    	GameRegistry.registerBlock(blockMagicObsidianBlock, "MagicObsidian");
    	
    	//Machines
    	blockAlabasterOvenIdle = new AlabasterOven(false).setBlockName("AlabasterOvenIdle").setCreativeTab(GGTab).setHardness(3.5F);
    	GameRegistry.registerBlock(blockAlabasterOvenIdle, "AlabasterOvenIdle");
    	
    	blockAlabasterOvenActive = new AlabasterOven(true).setBlockName("AlabasterOvenActive").setLightLevel(0.625F).setHardness(3.5F);
    	GameRegistry.registerBlock(blockAlabasterOvenActive, "AlabasterOvenActive");
    	
    	
    	blockMagicTable = new MagicTable().setBlockName("MagicTable");
    	GameRegistry.registerBlock(blockMagicTable, "MagicTable");
    	
    	//Metal Blocks    	
    	blockLukasBlock = new MetalBlock(Material.iron).setBlockName("LukasBlock");
    	GameRegistry.registerBlock(blockLukasBlock, "LukasBlock");
    	
    	blockSpheneBlock = new MetalBlock(Material.iron).setBlockName("SpheneBlock");
    	GameRegistry.registerBlock(blockSpheneBlock, "SpheneBlock");
    	
    	
    	//Ores
    	oreLukasOre = new OreBlock(Material.rock).setBlockName("LukasOre");
    	GameRegistry.registerBlock(oreLukasOre, "LukasOre");
    	
    	oreAkermaniteOre = new OreBlock(Material.rock).setBlockName("AkermaniteOre");
    	GameRegistry.registerBlock(oreAkermaniteOre, "AkermaniteOre");
    
    	oreNiobiumOre = new OreBlock(Material.rock).setBlockName("NiobiumOre");
    	GameRegistry.registerBlock(oreNiobiumOre, "NiobiumOre");
    	
    	oreSpheneOre = new OreBlock(Material.rock).setBlockName("SpheneOre");
    	GameRegistry.registerBlock(oreSpheneOre, "SpheneOre");

    	oreStibniteOre = new OreBlock(Material.rock).setBlockName("StibniteOre");
    	GameRegistry.registerBlock(oreStibniteOre, "StibniteOre");
    	
    	oreGodOre = new OreBlock(Material.rock).setBlockName("GodOre");
    	GameRegistry.registerBlock(oreGodOre, "GodOre");
    	
    	oreAlabasterOre = new OreBlock(Material.rock).setBlockName("AlabasterOre");
    	GameRegistry.registerBlock(oreAlabasterOre, "AlabasterOre");
    	
    	
    	//Food
    	foodManna = new foodManna(8, 0.6F, false).setUnlocalizedName("Manna").setCreativeTab(GGTab).setTextureName(Ggcontent.MODID + ":Manna");
    	GameRegistry.registerItem(foodManna, "Manna");
    	
    	foodPutridBall = new FoodPutridBall(8, 0.6F, false).setUnlocalizedName("PutridBall").setCreativeTab(GGTab).setTextureName(Ggcontent.MODID + ":PutridBall");
    	GameRegistry.registerItem(foodPutridBall, "PutridBall");
    	
    	
    	//Essences
    	itemBaseEssence = new MEssence().setUnlocalizedName("BaseEssence");
    	GameRegistry.registerItem(itemBaseEssence, "BaseEssence");    	
    	
    	itemEarthEssence = new MEssence().setUnlocalizedName("EarthEssence");
    	GameRegistry.registerItem(itemEarthEssence, "EarthEssence");
    	
    	itemWaterEssence = new MEssence().setUnlocalizedName("WaterEssence");
    	GameRegistry.registerItem(itemWaterEssence, "WaterEssence");
    	
    	
    	itemFireEssence = new MEssence().setUnlocalizedName("FireEssence");
    	GameRegistry.registerItem(itemFireEssence, "FireEssence");
    	    	
    	
    	itemAirEssence = new MEssence().setUnlocalizedName("AirEssence");
    	GameRegistry.registerItem(itemAirEssence, "AirEssence");
    	
    	
    	itemMagmaEssence = new MEssence().setUnlocalizedName("MagmaEssence");
    	GameRegistry.registerItem(itemMagmaEssence, "MagmaEssence");
    	
    	
    	itemAirBottle = new AirBottle().setUnlocalizedName("AirBottle");
    	GameRegistry.registerItem(itemAirBottle, "AirBottle");
    	
    	//Technical
    	itemCrateMaskOne = new CrateMaskOne().setUnlocalizedName("CrateMaskOne");
    	GameRegistry.registerItem(itemCrateMaskOne, "CrateMaskOne");
    	
    	//Crates & Keys
    	itemCrateKey = new CrateKey().setUnlocalizedName("CrateKey");
    	GameRegistry.registerItem(itemCrateKey, "CrateKey");
    	
    	blockCrateOne = new CrateBlock(Material.wood).setBlockName("CrateOne");
    	GameRegistry.registerBlock(blockCrateOne, "CrateOne");
    
    	
    	//Renderers
    	ggProxy.registerRenderThings();
    	   	    	   	
    	
    	
    	
    	      	
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event){
    	
    	
    	//Recipes
    	RecipeRemover.removeRecipe();
    	
    	GameRegistry.addRecipe(new ItemStack(blockLukasBlock), new Object[]{"CCC", "CCC", "CCC", 'C' ,itemLukasIngot});
    	GameRegistry.addRecipe(new ItemStack(itemSpheneCog, 4), new Object[]{" X ", "XFX", " X ", 'X', itemSpheneIngot, 'F', Items.flint});
    	GameRegistry.addRecipe(new ItemStack(blockAlabasterOvenIdle, 1), new Object[]{"ADA", "A A", "AAA", 'A', itemAlabasterIron, 'D', Items.diamond});
    	
    	GameRegistry.addRecipe(new ItemStack(blockObsidianTable, 1), new Object[] {"OOO", "O O", 'O', blockSoftObsidianBlock});
    	GameRegistry.addRecipe(new ItemStack(blockObsidianTable, 1), new Object[] {"OOO", "O O", 'O', Blocks.obsidian});
    	GameRegistry.addRecipe(new ItemStack(Items.book, 2), new Object[]{"LLL", "PPP", "LLL", 'L', Items.leather, 'P', Items.paper});
    	
    	
    	GameRegistry.addRecipe(new ItemStack(itemIronDisc, 4), new Object[]{"IH", 'I', Items.iron_ingot, 'H', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
    	GameRegistry.addRecipe(new ItemStack(itemIronWasher, 1), new Object[]{"DP", 'D', itemIronDisc, 'P', new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
    	GameRegistry.addRecipe(new ItemStack(itemIronCoin, 1), new Object[]{"DM", 'D', itemIronDisc, 'M', new ItemStack(itemMoneyPress, 1, OreDictionary.WILDCARD_VALUE)});
    	GameRegistry.addRecipe(new ItemStack(itemGoldDisc, 4), new Object[]{"GH", 'G', Items.gold_ingot, 'H', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE)});
    	GameRegistry.addRecipe(new ItemStack(itemIronPunch, 1), new Object[]{"III", "III", " I ", 'I', Items.iron_ingot});
    	GameRegistry.addRecipe(new ItemStack(itemIronHammer, 1), new Object[]{"III", " I ", " S ", 'I', Items.iron_ingot, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemMoneyPress, 1), new Object[]{"SSS", "SIS", " I ", 'S', Items.iron_ingot, 'S', itemSteelIngot});
    	
    	GameRegistry.addRecipe(new ItemStack(itemGoldCoin, 1), new Object[]{"HM", 'H', itemGoldDisc, 'M', new ItemStack(itemMoneyPress, 1, OreDictionary.WILDCARD_VALUE)});
    	
    	GameRegistry.addRecipe(new ItemStack(itemLukasSword, 1), new Object[] {" L ", " L ", " S ", 'L', itemLukasIngot, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemLukasAxe, 1), new Object[] {"LL ", "LS ", " S ", 'L', itemLukasIngot, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemLukasShovel, 1), new Object[] {" L ", " S ", " S ", 'L', itemLukasIngot, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemLukasHoe, 1), new Object[] {"LL ", " S ", " S ", 'L', itemLukasIngot, 'S', Items.stick});
    	GameRegistry.addRecipe(new ItemStack(itemLukasHoe, 1), new Object[] {" LL", " S ", " S ", 'L', itemLukasIngot, 'S', Items.stick});
    	
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(itemLukasIngot, 9), new Object[]{blockLukasBlock});
    	GameRegistry.addShapelessRecipe(new ItemStack(itemDiamondCoal, 2), new Object[]{Items.coal, Items.diamond});
    	GameRegistry.addShapelessRecipe(new ItemStack(itemAlabasterIron, 1), new Object[]{itemAlabasterGem, Items.iron_ingot});
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.flint_and_steel, 1), new Object[]{Items.flint, itemSteelIngot});
    	GameRegistry.addShapelessRecipe(new ItemStack(blockBarkBlock, 4), new Object[]{Blocks.log, Blocks.log, Blocks.log, Blocks.log});
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.log, 4), new Object[]{blockBarkBlock, blockBarkBlock, blockBarkBlock, blockBarkBlock});
    	GameRegistry.addShapelessRecipe(new ItemStack(Ggcontent.itemAirBottle, 1), new Object[]{Items.glass_bottle});
    	
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(blockMagicObsidianBlock, 1), new Object[]{Blocks.obsidian, Blocks.obsidian, Blocks.obsidian, itemBaseEssence});
    	GameRegistry.addShapelessRecipe(new ItemStack(itemCrateMaskOne, 1), new Object[]{Blocks.dirt});
    	GameRegistry.addShapelessRecipe(new ItemStack(blockMagicObsidianBlock, 1), new Object[]{blockSoftObsidianBlock, blockSoftObsidianBlock, blockSoftObsidianBlock, itemBaseEssence});
    	GameRegistry.addRecipe(new ItemStack(blockMagicTable, 1), new Object[]{"DRD", "OEO", "OOO", 'D', Items.diamond, 'R', Items.redstone, 'O', blockMagicObsidianBlock, 'E', itemBaseEssence});
    	
    	//Smelting
    	GameRegistry.addSmelting(oreLukasOre, new ItemStack(itemLukasIngot), 20);
    	GameRegistry.addSmelting(oreSpheneOre, new ItemStack(itemSpheneIngot), 20);
    	GameRegistry.addSmelting(oreNiobiumOre, new ItemStack(itemNiobiumIngot), 20);
    	GameRegistry.addSmelting(oreAkermaniteOre, new ItemStack(itemAkermaniteIngot), 20);
    	GameRegistry.addSmelting(oreStibniteOre, new ItemStack(itemStibniteIngot), 20);
    	GameRegistry.addSmelting(oreAlabasterOre, new ItemStack(itemAlabasterGem), 20);
    	GameRegistry.addSmelting(Items.iron_ingot, new ItemStack(itemSteelIngot), 0);  	
    	
    	    	    	    	
    	    	
    	
    	
    	//Registry
    	FMLCommonHandler.instance().bus().register(new CraftingHandler());
    	GameRegistry.registerFuelHandler(new FuelHandler());
    	
    	GameRegistry.registerTileEntity(TileEntityAlabasterOven.class, "AlabasterOven");
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	
    	//Entities
    	CyclopsHandler.registerMonsters(EntityCyclops.class, "Cyclops");    	
    	CreatureHandler.registerMonsters(EntityGnome.class, "Gnome");
    	
    	//Event Handler
    	MinecraftForge.EVENT_BUS.register(new GGEventHandler());
    	
    	
    	
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent postEvent){   	 	
    	//net.ggcontent.mod.proxy.ClientProxy.addCapes();    	    	
              
         readListFromUrl("Developer List", developers, "your direct link"); 
    }
    
    /**
     * Loads a list from a url
     */
    private void readListFromUrl(String name, ArrayList<String> list, String urlString)
    {
    	try {     
    		URL url = new URL(urlString);
    		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
    		String donatorlist;
    		while ((donatorlist = in.readLine()) != null){
    			donators.add(donatorlist);     
    		}
    		FMLLog.getLogger().info("[" + MODID + "] Read " + name + " from " + url + " : " + donators.toString());        

    		in.close();
    	}
    	catch (MalformedURLException e){
    		FMLLog.getLogger().info("[" + MODID + "] Couldn't read " + name + " from url. MalformedURLException");
    	}
    	catch (IOException e){
    		FMLLog.getLogger().info("[" + MODID + "] Couldn't read " + name + " from url. IOException");
    	}
    }
}
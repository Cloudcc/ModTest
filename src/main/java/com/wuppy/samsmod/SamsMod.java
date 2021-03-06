package com.wuppy.samsmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.util.EnumHelper;

@Mod(modid = SamsMod.MODID, version = SamsMod.VERSION)
public class SamsMod {
	
	public static final String MODID = "wuppy29_samsmod";
	public static final String VERSION = "1.0";

	//Items
	public static Item key;
	public static Item samdust;
	public static Item samingot;
	
	//Food
	public static Item berry;
	
	//Tools
	public static Item samspax;
	public static Item sampaxe1;
	public static Item sampickaxe;
	public static Item samhoe;
	public static Item samaxe;
	public static Item samsword;
	public static Item samshovel;
	ToolMaterial samium = EnumHelper.addToolMaterial("samium", 3, 1000, 9.5F, 3.5F, 10);
	
	//Armor
	public static Item samchest;
	public static Item samhelmet;
	public static Item samleggings;
	public static Item samboots;
	ArmorMaterial samarmor = EnumHelper.addArmorMaterial("samarmor", 20, new int[] { 3, 8,6,3}, 10);
	
	//Blocks
	public static Block samStone;
	
	//plants
	public static Block samPlant;
	public static Item samseed;
	
	//TileEntity
	public static Block samTE;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//TileEntity
		samTE = new BlockSamTE();
		GameRegistry.registerBlock(samTE, "SamTE");
		GameRegistry.registerTileEntity(TileEntitySam.class, "TE_samTE");
		
		//plants
		samseed = new ItemSamSeed(samPlant);
		GameRegistry.registerItem(samseed, "SamSeed");
		samPlant  =  new BlockSamPlant();
		GameRegistry.registerBlock(samPlant, "SamPlant");
		
		
		//Blocks
		samStone = new BlockSamStone();
		GameRegistry.registerBlock(samStone,ItemSamStone.class, "SamStone");
		
		//Armor
		samhelmet = new ItemSamArmor(samarmor,0, "samhelmet");
		samchest = new ItemSamArmor(samarmor,1, "samchest");
		samleggings = new ItemSamArmor(samarmor,2, "samleggings");
		samboots = new ItemSamArmor(samarmor,3, "samboots");
		
		GameRegistry.registerItem(samchest, "SamsChest");
		GameRegistry.registerItem(samhelmet, "SamsHelmet");
		GameRegistry.registerItem(samleggings, "Samsleggings");
		GameRegistry.registerItem(samboots, "SamsBoots");
		
		
		//Tools
		samspax = new ItemSamSpax(samium, "samspax");
		sampaxe1 = new ItemSamPaxe1(samium, "sampaxe1");
		samaxe = new ItemSamAxe(samium, "samaxe");
		samhoe = new ItemSamHoe(samium, "samhoe");
		samsword = new ItemSamSword(samium, "samsword");
		samshovel = new ItemSamShovel(samium, "samsword");
		sampickaxe = new ItemSamPickaxe(samium, "sampickaxe");
		GameRegistry.registerItem(samspax, "Sam's Spax");
		GameRegistry.registerItem(sampaxe1, "Sam's Paxe1");
		GameRegistry.registerItem(samaxe, "Sam's Axe");
		GameRegistry.registerItem(samsword, "Sam's Sword");
		GameRegistry.registerItem(samhoe, "Sam's Hoe");
		GameRegistry.registerItem(samshovel, "Sam's Shovel");
		GameRegistry.registerItem(sampickaxe, "Sam's Pickaxe");
		
		//Food
		berry = new ItemBerry(3, 0.3F, true, "berry");
		GameRegistry.registerItem(berry, "Berry");
		
		//Items
		samdust = new ItemSamGeneric("samDust");
		samingot = new ItemSamGeneric("samIngot");
		key = new ItemKey();
		GameRegistry.registerItem(key, "Key");
		GameRegistry.registerItem(samdust, "SamDust");
		GameRegistry.registerItem(samingot, "SamIngot");
	
		
				
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass), Blocks.dirt, Blocks.vine
				);
		GameRegistry.addSmelting(Items.flint, new ItemStack(Blocks.gravel, 1, 1), 50F);
		GameRegistry.addRecipe(new ItemStack(Items.apple),
				"XXX",
				"XXX",
				"XXX",
				'X', Blocks.leaves
		);
		GameRegistry.addRecipe(new ItemStack(Items.arrow),
				"YZ",
				"X ",
				'X' , Items.flint,'Y',Items.stick,'Z',Blocks.leaves
				);
		GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 1),
				"XY",
				'X', Items.redstone, 'Y', new ItemStack(Items.dye, 1, 1)
				);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1), Items.redstone, new ItemStack(Items.dye, 1, 1)
				);
		GameRegistry.addSmelting(Blocks.stone,  new ItemStack(Blocks.stonebrick), 0.1F
				);
		ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword);
		enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 1);
		
		GameRegistry.addShapelessRecipe(enchantedSwordItemStack, 
					Items.flint, Items.stone_sword
				);
		
		ItemStack enchantedSword2ItemStack = new ItemStack(Items.diamond_sword);
		enchantedSword2ItemStack.addEnchantment(Enchantment.knockback, 1);
		
		GameRegistry.addShapelessRecipe(enchantedSword2ItemStack, Items.gunpowder, Items.diamond_sword
		);
		
		//Dungeon changes
		DungeonHooks.removeDungeonMob("Spider");
		DungeonHooks.addDungeonMob("Creeper", 100);
		
		ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.saddle));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new
				ItemStack(Blocks.cobblestone), 25, 50, 10));
		DungeonHooks.addDungeonMob("Enderman", 100);
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(Blocks.diamond_block), 5, 10 ,10));
		
		
	}
}





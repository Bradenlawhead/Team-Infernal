package main;

import Tools.BloodArmor;
import Tools.InfernalArmor;
import Tools.InfernoBow;
import Tools.ItemBAxe;
import Tools.ItemBHoe;
import Tools.ItemBPickaxe;
import Tools.ItemBShovel;
import Tools.ItemBSword;
import Tools.ItemIAxe;
import Tools.ItemIHoe;
import Tools.ItemIPickaxe;
import Tools.ItemIShovel;
import Tools.ItemISword;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import generation.WorldGen;
import itemsblocks.BlockBasalt;
import itemsblocks.BlockEbonLeaves;
import itemsblocks.BlockEbonLog;
import itemsblocks.BlockFireBrick;
import itemsblocks.BlockLavaCap;
import itemsblocks.BlockLeavesEbon;
import itemsblocks.BlockLogEbon;
import itemsblocks.BlockOreBlood;
import itemsblocks.BlockOreInfernium;
import itemsblocks.BlockOreStar;
import itemsblocks.BlockSaplingEbon;
import itemsblocks.BlockStorageStar;
import itemsblocks.ItemBloodRock;
import itemsblocks.ItemEctoplasm;
import itemsblocks.ItemInfernium;
import itemsblocks.ItemRune;
import itemsblocks.ItemStarcillium;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import proxy.CommonProxy;

@Mod(modid = "AI", name = "The Augmented Inferno", version = "1.2")
public class Mainclass {

	@SidedProxy(clientSide = "proxy.ClientProxy", serverSide = "proxy.CommonProxy")
	public static CommonProxy proxy;
	//items
	public static Item Rune;
	public static Item Ectoplasm;
	public static Item SpiritFruit;
	public static Item BloodRock;
	public static Item Infernium;
	public static Item Starcillium;
	
	
	//blocks
	public static Block InferniumOre;
	public static Block BloodRockOre;
	public static Block StarcilliumOre;
	public static Block FireBricks;
	public static Block BasaltRock;
	public static Block LavaCap;
	public static Block EbonLog;
	public static Block EbonLeaves;
	public static Block EbonSapling;
	
	
	//STORAGE BLOCKS
	public static Block StarcilliumBlock;
	
	
	//armor-tools
	
	//Infernium
	public static Item ISword;
	public static Item IPickaxe;
	public static Item IShovel;
	public static Item IHoe;
	public static Item IAxe;
	
	public static Item IHelm;
	public static Item IChest;
	public static Item ILegs;
	public static Item IBoots;
	
	//Blood Rock
	public static Item BRSword;
	public static Item BRPickaxe;
	public static Item BRShovel;
	public static Item BRHoe;
	public static Item BRAxe;
	
	public static Item BRHelm;
	public static Item BRChest;
	public static Item BRLegs;
	public static Item BRBoots;
	
	
	//Tools
	public static Item InfernalBow;
	
	
	
	public static final Item.ToolMaterial InfernalTools = EnumHelper.addToolMaterial("Fierytools", 4, 2000, 10.0f, 4.0f,
			10);
	public static final Item.ToolMaterial BloodyTools = EnumHelper.addToolMaterial("Bloodytools", 4, 1460, 9.0f, 4.0f,
			10);

	public static final ItemArmor.ArmorMaterial InfernalArmor = EnumHelper.addArmorMaterial("Fieryset", 200,
			new int[] { 3, 8, 6, 3 }, 60);
	public static final ItemArmor.ArmorMaterial BloodArmor = EnumHelper.addArmorMaterial("Bloodyset", 200,
			new int[] { 3, 8, 6, 3 }, 60);
	

	@Instance
	public static Mainclass modInstance;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ModLivingDropsEvent());
		//ITEMS
		
		EbonSapling = new BlockSaplingEbon().setBlockName("EbonSapling")
				.setBlockTextureName("ai:sapling_ebon").setCreativeTab(CreativeTabs.tabDecorations);
		//GameRegistry.registerBlock(EbonSapling,EbonSapling.getUnlocalizedName().substring(5));
		
		LavaCap = new BlockLavaCap(Material.grass).setBlockName("Lava Cap")
				.setBlockTextureName("ai:lava_mushroom").setCreativeTab(CreativeTabs.tabDecorations);
		GameRegistry.registerBlock(LavaCap,LavaCap.getUnlocalizedName().substring(5));
		
		Rune = new ItemRune().setUnlocalizedName("RuneStone")
				.setTextureName("ai:rune_rock").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Rune, Rune.getUnlocalizedName().substring(5));
		
		Starcillium = new ItemStarcillium().setUnlocalizedName("Starcillium")
				.setTextureName("ai:starcillium").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Starcillium, Starcillium.getUnlocalizedName().substring(5));
		
		BloodRock = new ItemBloodRock().setUnlocalizedName("BloodRock")
				.setTextureName("ai:bloodrock").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(BloodRock, BloodRock.getUnlocalizedName().substring(5));
		
		Infernium = new ItemInfernium().setUnlocalizedName("Infernium")
				.setTextureName("ai:infernium").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Infernium, Infernium.getUnlocalizedName().substring(5));
		
		Ectoplasm = new ItemEctoplasm().setUnlocalizedName("Ectoplasm")
				.setTextureName("ai:ectoplasm").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(Ectoplasm, Ectoplasm.getUnlocalizedName().substring(5));
		
		SpiritFruit = new ItemFood(4, false).setUnlocalizedName("SpiritFruit")
				.setTextureName("ai:spirit_fruit").setCreativeTab(CreativeTabs.tabFood);
		GameRegistry.registerItem(SpiritFruit, SpiritFruit.getUnlocalizedName().substring(5));
		
		
		//STORAGE BLOCKS
		StarcilliumBlock =  new BlockStorageStar(Material.rock).setBlockName("StarcilliumBlock")
				.setBlockTextureName("ai:starcillium_block").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(StarcilliumBlock,StarcilliumBlock.getUnlocalizedName().substring(5));
		
		
		
		
		
		
		//BLOCKS
		
		StarcilliumOre =  new BlockOreStar(Material.rock).setBlockName("StarcilliumOre")
				.setBlockTextureName("ai:starcillium_ore").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(StarcilliumOre,StarcilliumOre.getUnlocalizedName().substring(5));
		
		BloodRockOre =  new BlockOreBlood(Material.rock).setBlockName("BloodRockOre")
				.setBlockTextureName("ai:bloodrock_ore").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(BloodRockOre, BloodRockOre.getUnlocalizedName().substring(5));
		
		InferniumOre =  new BlockOreInfernium(Material.rock).setBlockName("InferniumOre")
				.setBlockTextureName("ai:infernium_ore").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(InferniumOre, InferniumOre.getUnlocalizedName().substring(5));
		
		FireBricks =  new BlockFireBrick(Material.rock).setBlockName("BasaltBricks")
				.setBlockTextureName("ai:brick_fire").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(FireBricks, FireBricks.getUnlocalizedName().substring(5));
		
		BasaltRock =  new BlockBasalt(Material.rock).setBlockName("Basalt")
				.setBlockTextureName("ai:basalt").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(BasaltRock, BasaltRock.getUnlocalizedName().substring(5));
		
		EbonLog =  new BlockLogEbon(Material.wood).setBlockName("EbonLog")
				.setBlockTextureName("ai:").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(EbonLog,EbonLog.getUnlocalizedName().substring(5));
		EbonLeaves =  new BlockLeavesEbon(Material.leaves).setBlockName("EbonLeaves")
				.setBlockTextureName("ai:").setCreativeTab(CreativeTabs.tabBlock);
		GameRegistry.registerBlock(EbonLeaves,EbonLeaves.getUnlocalizedName().substring(5));
		
		
		//Tools
		
		
		//Infernium
		ISword = new ItemISword(InfernalTools).setUnlocalizedName("InferniumSword")
				.setTextureName("ai:infernium_sword").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(ISword, ISword.getUnlocalizedName().substring(5));
		IPickaxe = new ItemIPickaxe(InfernalTools).setUnlocalizedName("InferniumPickaxe")
				.setTextureName("ai:infernium_pickaxe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(IPickaxe, IPickaxe.getUnlocalizedName().substring(5));
		IHoe = new ItemIHoe(InfernalTools).setUnlocalizedName("InferniumHoe")
				.setTextureName("ai:infernium_hoe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(IHoe, IHoe.getUnlocalizedName().substring(5));
		IShovel = new ItemIShovel(InfernalTools).setUnlocalizedName("InferniumShovel")
				.setTextureName("ai:infernium_shovel").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(IShovel, IShovel.getUnlocalizedName().substring(5));
		IAxe = new ItemIAxe(InfernalTools).setUnlocalizedName("InferniumAxe")
				.setTextureName("ai:infernium_axe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(IAxe, IAxe.getUnlocalizedName().substring(5));
		
		

		IHelm = new InfernalArmor(InfernalArmor, 0, 0).setUnlocalizedName("InfernalHelmet")
				.setTextureName("ai:infernium_helmet").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(IHelm,IHelm.getUnlocalizedName().substring(5));
		IChest = new InfernalArmor(InfernalArmor, 0, 1).setUnlocalizedName("InfernalChestplate")
				.setTextureName("ai:infernium_chestplate").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(IChest,IChest.getUnlocalizedName().substring(5));
		ILegs = new InfernalArmor(InfernalArmor, 0, 2).setUnlocalizedName("InfernalLeggings")
				.setTextureName("ai:infernium_leggings").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(ILegs,ILegs.getUnlocalizedName().substring(5));
		IBoots = new InfernalArmor(InfernalArmor, 0, 3).setUnlocalizedName("InfernalBoots")
				.setTextureName("ai:infernium_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(IBoots,IBoots.getUnlocalizedName().substring(5));
		
		
		
		//Blood Rock
		BRSword = new ItemBSword(BloodyTools).setUnlocalizedName("BloodSword")
				.setTextureName("ai:bloodrock_sword").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(BRSword,BRSword.getUnlocalizedName().substring(5));
		BRPickaxe = new ItemBPickaxe(BloodyTools).setUnlocalizedName("BloodPickaxe")
				.setTextureName("ai:bloodrock_pickaxe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(BRPickaxe,BRPickaxe.getUnlocalizedName().substring(5));
		BRHoe = new ItemBHoe(BloodyTools).setUnlocalizedName("BloodHoe")
				.setTextureName("ai:bloodrock_hoe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(BRHoe,BRHoe.getUnlocalizedName().substring(5));
		BRShovel = new ItemBShovel(BloodyTools).setUnlocalizedName("BloodShovel")
				.setTextureName("ai:bloodrock_shovel").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(BRShovel ,BRShovel .getUnlocalizedName().substring(5));
		BRAxe = new ItemBAxe(BloodyTools).setUnlocalizedName("BloodAxe")
				.setTextureName("ai:bloodrock_axe").setCreativeTab(CreativeTabs.tabTools);
		GameRegistry.registerItem(BRAxe, BRAxe.getUnlocalizedName().substring(5));
		
		
		

		BRHelm = new BloodArmor(BloodArmor, 0, 0).setUnlocalizedName("BloodHelmet")
				.setTextureName("ai:bloodrock_helmet").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(BRHelm,BRHelm.getUnlocalizedName().substring(5));
		BRChest = new BloodArmor(BloodArmor, 0, 1).setUnlocalizedName("BloodChestplate")
				.setTextureName("ai:bloodrock_chestplate").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(BRChest,BRChest.getUnlocalizedName().substring(5));
		BRLegs = new BloodArmor(BloodArmor, 0, 2).setUnlocalizedName("BloodLeggings")
				.setTextureName("ai:bloodrock_leggings").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(BRLegs,BRLegs.getUnlocalizedName().substring(5));
		BRBoots = new BloodArmor(BloodArmor, 0, 3).setUnlocalizedName("BloodBoots")
				.setTextureName("ai:bloodrock_boots").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(BRBoots,BRBoots.getUnlocalizedName().substring(5));
		
		
		//Tools
		InfernalBow = new InfernoBow().setUnlocalizedName("InfernalBow")
				.setTextureName("ai:infernal_bow").setCreativeTab(CreativeTabs.tabCombat);
		GameRegistry.registerItem(InfernalBow,InfernalBow.getUnlocalizedName().substring(5));
		
		
		
		//world gen
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		
		//Smelting
		GameRegistry.addSmelting(BloodRockOre, new ItemStack(BloodRock), 5.0f);
		GameRegistry.addSmelting(InferniumOre, new ItemStack(Infernium), 5.0f);
		GameRegistry.addSmelting(StarcilliumOre, new ItemStack(Starcillium), 5.0f);
		
		
		
		
		
	//CRAFTING	
		//Blocks
		//STORAGE BLOCKS
		GameRegistry.addRecipe(new ItemStack(StarcilliumBlock),
				new Object[] { "SSS", "SSS", "SSS", 'S', Starcillium });
		
		
		
		
		
		//Infernium
		GameRegistry.addRecipe(new ItemStack(IPickaxe),
				new Object[] { "CCC", " S ", " S ", 'C', Infernium, 'S',Items.stick });
		GameRegistry.addRecipe(new ItemStack(IAxe),
				new Object[] { "CC ", "CS ", " S ", 'C',  Infernium, 'S',Items.stick  });
		GameRegistry.addRecipe(new ItemStack(IShovel),
				new Object[] { " C ", " S ", " S ", 'C',  Infernium, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(IHoe),
				new Object[] { "CC ", " S ", " S ", 'C',  Infernium, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(ISword),
				new Object[] { " S ", " S ", " C ", 'S',  Infernium, 'C', Items.stick });
		
		GameRegistry.addShapedRecipe(new ItemStack(IHelm), new Object[] { "sss", "s s", 's', Infernium });
		GameRegistry.addShapedRecipe(new ItemStack(IChest), new Object[] { "s s", "sss", "sss", 's', Infernium });
		GameRegistry.addShapedRecipe(new ItemStack(ILegs), new Object[] { "sss", "s s", "s s", 's', Infernium });
		GameRegistry.addShapedRecipe(new ItemStack(IBoots), new Object[] { "s s", "s s", 's', Infernium });
		
		
		
		//Blood Rock
		GameRegistry.addRecipe(new ItemStack(BRPickaxe),
				new Object[] { "CCC", " S ", " S ", 'C', BloodRock, 'S',Items.stick });
		GameRegistry.addRecipe(new ItemStack(BRAxe),
				new Object[] { "CC ", "CS ", " S ", 'C', BloodRock, 'S',Items.stick  });
		GameRegistry.addRecipe(new ItemStack(BRShovel),
				new Object[] { " C ", " S ", " S ", 'C',  BloodRock, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(BRHoe),
				new Object[] { "CC ", " S ", " S ", 'C',  BloodRock, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(BRSword),
				new Object[] { " S ", " S ", " C ", 'S',  BloodRock, 'C', Items.stick });
		
		GameRegistry.addShapedRecipe(new ItemStack(BRHelm), new Object[] { "sss", "s s", 's', BloodRock });
		GameRegistry.addShapedRecipe(new ItemStack(BRChest), new Object[] { "s s", "sss", "sss", 's', BloodRock });
		GameRegistry.addShapedRecipe(new ItemStack(BRLegs), new Object[] { "sss", "s s", "s s", 's', BloodRock });
		GameRegistry.addShapedRecipe(new ItemStack(BRBoots), new Object[] { "s s", "s s", 's', BloodRock });
		
		//Items/Tools
		GameRegistry.addRecipe(new ItemStack(SpiritFruit),
				new Object[] { "CCC", "CSC", "CCC", 'C', Ectoplasm, 'S',Items.apple });
		
		GameRegistry.addRecipe(new ItemStack(InfernalBow),
				new Object[] { "CCC", "CSC", "CCC", 'C', Infernium, 'S', Items.bow });
		
		
		
		proxy.registerRenderThings();
		MobRegistering.mainRegistry();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
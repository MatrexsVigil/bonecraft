package com.pam.bonecraft;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;

import com.pam.bonecraft.block.BlockPamFossil;
import com.pam.bonecraft.config.ConfigHolder;
import com.pam.bonecraft.item.BoneArmorMaterial;
import com.pam.bonecraft.item.ItemPamAxe;
import com.pam.bonecraft.item.ItemPamBoneArmor;
import com.pam.bonecraft.item.ItemPamHoe;
import com.pam.bonecraft.item.ItemPamPickaxe;
import com.pam.bonecraft.item.ItemPamShovel;
import com.pam.bonecraft.item.ItemPamSword;
import com.pam.bonecraft.setup.ModSetup;
import net.minecraftforge.fml.config.ModConfig;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Bonecraft.MODID)
public class Bonecraft
{

	public static final String MODID = "bonecraft";
	
	public static ModSetup setup = new ModSetup();
	
	
	public Bonecraft() 
	{

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        final ModLoadingContext modLoadingContext = ModLoadingContext.get();

        
        modLoadingContext.registerConfig(ModConfig.Type.SERVER, ConfigHolder.SERVER_SPEC);

    }

	private void setup(final FMLCommonSetupEvent event) {
        setup.init();
    }
	
	@ObjectHolder("bonecraft:fossil")
    public static final BlockPamFossil fossil = null;

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents 
    {
    	
    	
    	
    	@SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
    		
    		event.getRegistry().register(new BlockPamFossil(Block.Properties.create(Material.ROCK)).setRegistryName("fossil"));
        }
    	
    	
    	
		@SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) 
		{
			
			
			@SuppressWarnings("unused")
			net.minecraft.item.Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
			
			event.getRegistry().register(new ItemPamBoneArmor(BoneArmorMaterial.BONE, EquipmentSlotType.HEAD, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonehelmitem"));
			event.getRegistry().register(new ItemPamBoneArmor(BoneArmorMaterial.BONE, EquipmentSlotType.CHEST, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonechestitem"));
			event.getRegistry().register(new ItemPamBoneArmor(BoneArmorMaterial.BONE, EquipmentSlotType.LEGS, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonelegsitem"));
			event.getRegistry().register(new ItemPamBoneArmor(BoneArmorMaterial.BONE, EquipmentSlotType.FEET, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonebootsitem"));
			
			event.getRegistry().register(new ItemPamAxe(ItemTier.IRON, 9, 0.9F, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("boneaxeitem"));
			event.getRegistry().register(new ItemPamHoe(ItemTier.IRON, 1, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonehoeitem"));
			event.getRegistry().register(new ItemPamPickaxe(ItemTier.IRON, 4, 1.2F, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonepickaxeitem"));
			event.getRegistry().register(new ItemPamShovel(ItemTier.IRON, 4.5F, 1F, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("boneshovelitem"));
			event.getRegistry().register(new ItemPamSword(ItemTier.IRON, 6, 1.6F, new Item.Properties().maxStackSize(1).group(setup.itemGroup)).setRegistryName("bonesworditem"));			
		
			event.getRegistry().register(new BlockItem(Bonecraft.fossil, new Item.Properties().group(setup.itemGroup)).setRegistryName("fossil"));
		}
		
		
		
    }
    
}



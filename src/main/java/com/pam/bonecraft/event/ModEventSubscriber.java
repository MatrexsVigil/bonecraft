package com.pam.bonecraft.event;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus.MOD;

import com.pam.bonecraft.Bonecraft;
import com.pam.bonecraft.config.ConfigHelper;
import com.pam.bonecraft.config.ConfigHolder;
import com.pam.bonecraft.worldgen.WorldGenPamFossil;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@EventBusSubscriber(modid = Bonecraft.MODID, bus = MOD)
public final class ModEventSubscriber 
{

    @SubscribeEvent
    public static void onCommonSetup(final FMLCommonSetupEvent event)
    {
    	WorldGenPamFossil.setupOreGen();
    }

	

	@SubscribeEvent
	public static void onModConfigEvent(final ModConfig.ModConfigEvent event)
	{
		final ModConfig config = event.getConfig();

		if (config.getSpec() == ConfigHolder.SERVER_SPEC) {
			ConfigHelper.bakeServer(config);
		}
	}

    

} 
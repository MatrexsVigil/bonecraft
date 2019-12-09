package com.pam.bonecraft.config;

import net.minecraftforge.fml.config.ModConfig;


public final class ConfigHelper
{

	@SuppressWarnings("unused")
	private static ModConfig serverConfig;

	public static void bakeServer(final ModConfig config)
	{
		serverConfig = config;

		BonecraftConfig.enableFossil = ConfigHolder.SERVER.serverEnableFossil.get();

	}

	@SuppressWarnings("unused")
	private static void setValueAndSave(final ModConfig modConfig, final String path, final Object newValue)
	{
		modConfig.getConfigData().set(path, newValue);
		modConfig.save();
	}

}

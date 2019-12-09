package com.pam.bonecraft.config;

import com.pam.bonecraft.Bonecraft;

import net.minecraftforge.common.ForgeConfigSpec;

final class ServerConfig
{

	final ForgeConfigSpec.BooleanValue serverEnableFossil;


	ServerConfig(final ForgeConfigSpec.Builder builder)
	{
		builder.push("general");
		serverEnableFossil = builder
				.comment("Enable fossil generation in world?")
				.translation(Bonecraft.MODID + ".config.serverEnableFossil")
				.define("serverEnableFossil", true);
		builder.pop();
	}

}

package com.pam.bonecraft.block;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class BlockPamFossil extends OreBlock
{
	
	 
	public BlockPamFossil(Properties properties) {
		super(Properties.create(Material.ROCK).sound(SoundType.METAL).hardnessAndResistance(2.0F));
	}


}

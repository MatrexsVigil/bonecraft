package com.pam.bonecraft.setup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;


public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("tabBonecraft") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.BONE);
        }
    };

    public void init() {

    }

}

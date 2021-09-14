package com.arjun.coppermod.item;

import com.arjun.coppermod.CopperModMAIN;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CopperedCoal extends Item {
    public CopperedCoal(){
        super(new Properties().group(CopperModMAIN.COPPER_TAB));
    }
    @Override
    public int getBurnTime(ItemStack itemStack)
    {
        return 1200;
    }
}

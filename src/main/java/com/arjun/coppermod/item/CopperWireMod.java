package com.arjun.coppermod.item;

import com.arjun.coppermod.CopperModMAIN;
import com.arjun.coppermod.util.Registration;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;

public class CopperWireMod {
    public static final RegistryObject<Item>  COPPER_WIRE =
            Registration.ITEMS.register("copper_wire",
                    () -> new Item(new Item.Properties().group(CopperModMAIN.COPPER_TAB)));

    public static void register() { }

}

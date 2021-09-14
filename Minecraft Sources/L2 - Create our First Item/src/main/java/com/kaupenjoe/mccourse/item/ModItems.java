package com.kaupenjoe.coppermod.item;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.util.Registration;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModItems
{
    public static final RegistryObject<Item> COPPER_INGOT =
            Registration.ITEMS.register("copper_ingot",
            () -> new Item(new Item.Properties().group(CopperModMAIN.TAB)));

    public static void register() { }
}

package com.kaupenjoe.coppermod.world.dimension;

import com.kaupenjoe.coppermod.CopperModMAIN;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class ModDimensions
{
    public static RegistryKey<World> KJDim;

    public static void register()
    {
        KJDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
                new ResourceLocation(CopperModMAIN.MOD_ID, "kjdim"));
    }
}

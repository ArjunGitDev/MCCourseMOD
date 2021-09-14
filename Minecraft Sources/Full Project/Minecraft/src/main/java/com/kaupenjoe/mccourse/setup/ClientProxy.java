package com.kaupenjoe.coppermod.setup;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.block.ModBlocks;
import com.kaupenjoe.coppermod.container.ModContainers;
import com.kaupenjoe.coppermod.entity.ModEntityTypes;
import com.kaupenjoe.coppermod.entity.render.BuffaloRenderer;
import com.kaupenjoe.coppermod.item.ModSpawnEggItem;
import com.kaupenjoe.coppermod.screens.ElectrifierScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CopperModMAIN.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements IProxy
{
    @Override
    public void init()
    {
        RenderTypeLookup.setRenderLayer(ModBlocks.ZUCCINI_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.REDWOOD_SAPLING.get(), RenderType.getCutout());

        ScreenManager.registerFactory(ModContainers.ELECTRIFIER_CONTAINER.get(), ElectrifierScreen::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFFALO.get(), BuffaloRenderer::new);

        ModSpawnEggItem.initSpawnEggs();
    }

    @Override
    public World getClientWorld()
    {
        return Minecraft.getInstance().world;
    }
}

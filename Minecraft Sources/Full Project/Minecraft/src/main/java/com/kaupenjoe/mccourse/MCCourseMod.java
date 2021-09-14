package com.kaupenjoe.coppermod;

import com.kaupenjoe.coppermod.block.ModBlocks;
import com.kaupenjoe.coppermod.block.ModFluids;
import com.kaupenjoe.coppermod.container.ModContainers;
import com.kaupenjoe.coppermod.entity.BuffaloEntity;
import com.kaupenjoe.coppermod.entity.ModEntityTypes;
import com.kaupenjoe.coppermod.events.ModEvents;
import com.kaupenjoe.coppermod.item.ModItems;
import com.kaupenjoe.coppermod.setup.ClientProxy;
import com.kaupenjoe.coppermod.setup.IProxy;
import com.kaupenjoe.coppermod.setup.ServerProxy;
import com.kaupenjoe.coppermod.tileentity.ModTileEntities;
import com.kaupenjoe.coppermod.util.Config;
import com.kaupenjoe.coppermod.util.Registration;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CopperModMAIN.MOD_ID)
public class CopperModMAIN
{
    public static final String MOD_ID = "coppermod";

    public static final ItemGroup COURSE_TAB = new ItemGroup("courseTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.COPPER_WIRE.get());
        }
    };

    public static IProxy proxy;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public CopperModMAIN()
    {
        proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> ServerProxy::new);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        registerModAdditions();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        registerConfigs();

        proxy.init();

        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntityTypes.BUFFALO.get(), BuffaloEntity.setCustomAttributes().create());
        });

        loadConfigs();
    }

    private void registerConfigs()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
    }

    private void loadConfigs()
    {
        Config.loadConfigFile(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve("coppermod-client.toml").toString());
        Config.loadConfigFile(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("coppermod-server.toml").toString());
    }

    private void registerModAdditions()
    {
        // Inits the registration of our additions
        Registration.init();

        // registers items, blocks etc added by our mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModTileEntities.register();
        ModContainers.register();
        ModEntityTypes.register();

        // register mod events
        MinecraftForge.EVENT_BUS.register(new ModEvents());
    }
}

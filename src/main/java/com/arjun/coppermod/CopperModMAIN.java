package com.arjun.coppermod;

import com.arjun.coppermod.block.ModBlocks;
import com.arjun.coppermod.block.ModFluids;
import com.arjun.coppermod.events.ModEvents;
import com.arjun.coppermod.item.ModItems;
import com.arjun.coppermod.tileentity.ModTileEntities;
import com.arjun.coppermod.util.Registration;
import com.arjun.coppermod.item.CopperWireMod;
import com.arjun.coppermod.util.setup.ClientProxy;
import com.arjun.coppermod.util.setup.IProxy;
import com.arjun.coppermod.util.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CopperModMAIN.MOD_ID)
public class CopperModMAIN {
    public static final String MOD_ID = "coppermod";

    public static final ItemGroup COPPER_TAB = new ItemGroup("copper_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COPPER_INGOT.get());
        }
    };

    public static IProxy proxy;
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public CopperModMAIN() {
        proxy = DistExecutor.safeRunForDist( () -> ClientProxy::new, () -> ServerProxy::new);
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);


        // Register the mod Classes
        registerModClasses();


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        proxy.init();
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    private void registerModClasses(){
        // Initializes the Registration of the mod
        Registration.init();

        // Registers items, blocks, and etc of the mod
        ModItems.register();
        ModBlocks.register();
        ModFluids.register();
        ModTileEntities.register();
        CopperWireMod.register();


        // Registers Mod Events
        MinecraftForge.EVENT_BUS.register(new ModEvents());

    }
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}

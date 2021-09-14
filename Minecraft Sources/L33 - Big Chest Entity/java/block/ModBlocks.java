package com.kaupenjoe.coppermod.block;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.item.BigChestItemStackTileEntityRenderer;
import com.kaupenjoe.coppermod.tileentity.ModTileEntities;
import com.kaupenjoe.coppermod.util.Registration;
import com.mojang.serialization.Codec;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.AbstractFeatureSizeType;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.VinesFeature;
import net.minecraft.world.gen.treedecorator.AlterGroundTreeDecorator;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL)));

    public static final RegistryObject<Block> TEST_BLOCK = register("test_block",
            () -> new TestBlock(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(3f, 10f).sound(SoundType.METAL).notSolid()));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new CopperOre(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f)
                    .sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static final RegistryObject<Block> BIG_CHEST = registerTileEntity("big_chest",
            () -> new BigChestBlock(AbstractBlock.Properties.create(Material.ROCK)
                    .hardnessAndResistance(3f, 10f), () -> ModTileEntities.BIG_CHEST_TILE_ENTITY.get()));

    /*public static final RegistryObject<TreeDecoratorType<NewCocoaTreeDecorator>> OTHER_COCOA =
            register("other_cocoa_decorator",
                    NewCocoaTreeDecorator.provider);

    private static <T extends TreeDecorator> RegistryObject<?> register(String p_236877_0_, Codec<T> p_236877_1_) {
        return Registration.TREE_DECORATORS.register(p_236877_0_,
                () -> new TreeDecoratorType(p_236877_1_));
    }

    public static final TreeDecoratorType<AlterGroundTreeDecorator> ALTER_GROUND =
            register("alter_ground", AlterGroundTreeDecorator.field_236859_a_);
*/
    public static final RegistryObject<Block> COPPER_STAIRS =
            register("copper_stairs", () -> new StairsBlock(() -> ModBlocks.COPPER_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_FENCE =
            register("copper_fence", () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_FENCE_GATE =
            register("copper_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)));


    public static final RegistryObject<Block> COPPER_BUTTON =
            register("copper_button", () -> new StoneButtonBlock(AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE =
            register("copper_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    AbstractBlock.Properties.create(Material.IRON)));

    public static final RegistryObject<Block> COPPER_SLAB =
            register("copper_slab", () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)));


    public static final RegistryObject<Block> ZUCCINI_CROP =
            Registration.BLOCKS.register("zuccini_crop",
                    () -> new ZucciniCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static final RegistryObject<Block> ELECTRIFIER =
            register("electrifier", () -> new Electrifier(AbstractBlock.Properties.create(Material.IRON)
                    .hardnessAndResistance(4f).harvestTool(ToolType.PICKAXE)));


    public static final RegistryObject<Block> REDWOOD_PLANK = register("redwood_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> REDWOOD_LOG = register("redwood_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> REDWOOD_LEAVES = register("redwood_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.from(Blocks.OAK_LEAVES)));


    public static final RegistryObject<Block> REDWOOD_SAPLING = register("redwood_sapling",
            () -> new RedwoodSapling(
                    () -> new RedwoodTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)
            ));

    public static void register()
    {

    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(CopperModMAIN.COURSE_TAB)));
        return toReturn;
    }

    private static <T extends Block>RegistryObject<T> register(String name, Supplier<T> block, BlockItem blockItem)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> blockItem);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<T> registerTileEntity(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(CopperModMAIN.COURSE_TAB).setISTER(() -> BigChestItemStackTileEntityRenderer::new)));
        return toReturn;
    }
}

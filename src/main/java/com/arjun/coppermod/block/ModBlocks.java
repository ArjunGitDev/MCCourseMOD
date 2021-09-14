package com.arjun.coppermod.block;

import com.arjun.coppermod.CopperModMAIN;
import com.arjun.coppermod.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final RegistryObject<Block> COPPER_BLOCK = register("copper_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(6f, 20f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).slipperiness(1f)));

    public static final RegistryObject<Block> RUSTED_COPPER = register("rusted_copper",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(6f, 20f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).slipperiness(0.4f).harvestLevel(2)));

    public static final RegistryObject<Block> COPPER_ORE = register("copper_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(6f, 20f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE).slipperiness(1f).harvestLevel(2)));

    public static final RegistryObject<Block> ZUCCHINI_CROP =
            Registration.BLOCKS.register("zucchini_crop",
                    () -> new ZucchiniCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));



    public static final RegistryObject<Block> ELECTRIFIER
    = register("electrifier", () -> new Electrifier(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(8f, 12.5f).sound(SoundType.METAL).slipperiness(0.0001f).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static void register() { }
    private static  <T extends Block>RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(CopperModMAIN.COPPER_TAB)));
        return toReturn;
    }


}

package com.kaupenjoe.coppermod.data;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider
{
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, CopperModMAIN.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(ModBlocks.COPPER_BLOCK.get());
        simpleBlock(ModBlocks.COPPER_ORE.get());
    }
}

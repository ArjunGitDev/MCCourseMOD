package com.kaupenjoe.coppermod.data;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.block.ModBlocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, CopperModMAIN.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(Tags.Blocks.ORES).add(ModBlocks.COPPER_ORE.get());

        super.registerTags();
    }
}

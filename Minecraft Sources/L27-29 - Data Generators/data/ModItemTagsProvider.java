package com.kaupenjoe.coppermod.data;

import com.kaupenjoe.coppermod.CopperModMAIN;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider
{
    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(dataGenerator, blockTagProvider, CopperModMAIN.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        super.registerTags();
    }
}

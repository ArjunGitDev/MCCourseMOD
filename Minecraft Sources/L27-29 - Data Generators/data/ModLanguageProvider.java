package com.kaupenjoe.coppermod.data;

import com.kaupenjoe.coppermod.CopperModMAIN;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider
{
    public ModLanguageProvider(DataGenerator gen, String locale)
    {
        super(gen, CopperModMAIN.MOD_ID, locale);
    }

    @Override
    protected void addTranslations()
    {
        String locale = this.getName().replace("Languages: ", "");

        switch (locale)
        {
            case "en_us":
                add("item.coppermod.copper_ingot", "Copper Ingot");
                add("advancements.story.copper_block.title", "Coppering");
                add("advancements.story.copper_block.description", "Acquire Copper Blocks");
                break;
            default:
                break;
        }
    }
}

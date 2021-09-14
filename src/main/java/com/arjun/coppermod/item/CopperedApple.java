package com.arjun.coppermod.item;

import com.arjun.coppermod.CopperModMAIN;
import com.arjun.coppermod.util.Config;
import com.arjun.coppermod.util.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import java.util.List;

public class CopperedApple extends Item {
    public CopperedApple(){
        super(new Properties().group(CopperModMAIN.COPPER_TAB)
        .food(new Food.Builder()
                .hunger(10)
                .saturation(1.5f)
                .effect(() -> new EffectInstance
                        (Effects.GLOWING, Config.COPPERED_REGEN_DURATION.get(), 1), 0.5f)
                .build()
        ));
    }

    @Override
    public void addInformation(ItemStack stack, World world,
                               List<ITextComponent> tooltip, ITooltipFlag flag) {
        if(KeyboardHelper.isHoldingLeftShift()){
            tooltip.add(new StringTextComponent("Turns mob in to regenerating ingots..."));
        }
        else if (KeyboardHelper.isHoldingCtrl()){
            tooltip.add(new StringTextComponent("Turns mob in to regenerating ingots..."));
        }
        else{
            tooltip.add(new StringTextComponent("Hold" + "\u00A7e" + " SHIFT " + "\u00A7e" + "or " + "\u00A77"+ "Ctrl" + "for more info"));
        }

        super.addInformation(stack, world, tooltip, flag);
    }
}

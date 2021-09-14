package com.arjun.coppermod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper {
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingLeftShift(){
        return InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(),
                GLFW.GLFW_KEY_LEFT_SHIFT);
    }

    public static boolean isHoldingCtrl(){
        return InputMappings.isKeyDown(Minecraft.getInstance().getMainWindow().getHandle(),
                GLFW.GLFW_KEY_LEFT_CONTROL);
    }
}

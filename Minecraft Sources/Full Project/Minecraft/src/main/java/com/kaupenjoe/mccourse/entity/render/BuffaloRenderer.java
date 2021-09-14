package com.kaupenjoe.coppermod.entity.render;

import com.kaupenjoe.coppermod.CopperModMAIN;
import com.kaupenjoe.coppermod.entity.BuffaloEntity;
import com.kaupenjoe.coppermod.entity.model.BuffaloModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffaloRenderer extends MobRenderer<BuffaloEntity, BuffaloModel<BuffaloEntity>>
{
    public BuffaloRenderer(EntityRendererManager renderManagerIn)
    {
        super(renderManagerIn, new BuffaloModel<>(), 0.9f);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffaloEntity entity)
    {
        return new ResourceLocation(CopperModMAIN.MOD_ID, "textures/entity/buffalo.png");
    }
}

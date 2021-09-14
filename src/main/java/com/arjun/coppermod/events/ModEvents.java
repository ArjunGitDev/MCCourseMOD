package com.arjun.coppermod.events;

import com.arjun.coppermod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;

import java.util.Collection;

public class ModEvents {
    @SubscribeEvent

    public void onCopperedEntity(AttackEntityEvent event) {
        if (event.getPlayer().getHeldItemMainhand().getItem() == ModItems.COPPERED_APPLE.get()){
            if (event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity) event.getTarget();

                if (target instanceof MobEntity && (event.getTarget() instanceof LivingEntity)) {
                    PlayerEntity player = event.getPlayer();

                    // Deletes the item
                    player.getHeldItemMainhand().shrink(1);

                    target.addPotionEffect(new EffectInstance(Effects.INSTANT_DAMAGE, 40, 2));

                    if (!player.world.isRemote()) {
                        String msg = TextFormatting.RED + target.getName().toString()+ "is dying now!";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onCopperedEntityDrops(LivingDropsEvent event)
    {
        LivingEntity entity = event.getEntityLiving();

        if(entity instanceof MobEntity)
        {
            World world = entity.getEntityWorld();
            Collection<ItemEntity> drops = event.getDrops();

            LogManager.getLogger().debug(entity.getActivePotionEffects());

            if (entity.isPotionActive(Effects.INSTANT_DAMAGE))
            {
                drops.add(new ItemEntity(world, entity.getPosX(), entity.getPosY(), entity.getPosZ(),
                        new ItemStack(ModItems.COPPER_INGOT.get())));
            }
        }
    }

    @SubscribeEvent
    public String onWorldLoad(WorldEvent event){
        ActiveRenderInfo render = new ActiveRenderInfo();
        //render.update();
        return "";
    }
}

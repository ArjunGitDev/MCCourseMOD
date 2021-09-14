package com.kaupenjoe.coppermod.events;

import com.kaupenjoe.coppermod.block.ModBlocks;
import com.kaupenjoe.coppermod.command.ReturnHomeCommand;
import com.kaupenjoe.coppermod.command.SetHomeCommand;
import com.kaupenjoe.coppermod.item.ModItems;
import com.kaupenjoe.coppermod.util.Config;
import com.kaupenjoe.coppermod.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.client.event.DrawHighlightEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeResourcePack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.command.ConfigCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.jmx.Server;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModEvents
{
    @SubscribeEvent
    public void onCommandsRegister(RegisterCommandsEvent event)
    {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}

package com.arjun.coppermod.util.setup;

import com.arjun.coppermod.CopperModMAIN;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

import java.rmi.ServerException;

@Mod.EventBusSubscriber(modid = CopperModMAIN.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class ServerProxy implements IProxy{
    @Override
    public void init() {

    }

    @Override
    public World getClientWorld() throws ServerException {
       throw new ServerException("Cannot get world, this cannot be ran on server");
    }
}

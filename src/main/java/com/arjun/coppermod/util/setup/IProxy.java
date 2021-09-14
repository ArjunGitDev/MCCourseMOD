package com.arjun.coppermod.util.setup;

import net.minecraft.world.World;

import java.rmi.ServerException;

public interface IProxy {
    void init();

    World getClientWorld() throws ServerException;
}

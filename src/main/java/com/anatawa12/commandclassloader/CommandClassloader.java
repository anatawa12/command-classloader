package com.anatawa12.commandclassloader;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkCheckHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Map;

@Mod(modid = CommandClassloader.MOD_ID)
public class CommandClassloader {
    public static final String MOD_ID = "command-classloader";

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        if (event.getSide() == Side.CLIENT)
            ClientCommandHandler.instance.registerCommand(new ClientCommandLoadClass());
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandLoadClass());
    }

    @NetworkCheckHandler
    public boolean networkCheck(Map<String, String> mods, Side side) {
        return true;
    }
}

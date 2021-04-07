package com.anatawa12.commandclassloader;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.client.IClientCommand;

import javax.annotation.Nonnull;

public class ClientCommandLoadClass extends CommandLoadClassBase implements IClientCommand {
    @Nonnull
    @Override
    public String getName() {
        return "c:load-class";
    }

    @Override
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
        return false;
    }
}

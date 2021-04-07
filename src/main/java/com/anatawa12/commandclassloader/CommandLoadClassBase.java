package com.anatawa12.commandclassloader;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class CommandLoadClassBase extends CommandBase {
    @Nonnull
    @Override
    public String getUsage(@Nullable ICommandSender sender) {
        return "/" + getName() + " <class fqName>";
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {
        if (args.length != 1) throw new WrongUsageException(getUsage(null));
        if (args[0].length() <= 0) throw new WrongUsageException(getUsage(null));

        try {
            Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            //noinspection NoTranslation
            throw new CommandException("could not load class: %s", args[0]);
        }
        //noinspection NoTranslation
        sender.sendMessage(new TextComponentTranslation("load class successfully: %s", args[0]));
    }
}

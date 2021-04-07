package com.anatawa12.commandclassloader;

import javax.annotation.Nonnull;

public class CommandLoadClass extends CommandLoadClassBase {
    @Nonnull
    @Override
    public String getName() {
        return "s:load-class";
    }
}

package de.asula.papertemplate;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class PaperTemplate extends JavaPlugin {
    @Getter
    private static PaperTemplate instance;

    public PaperTemplate() {
        getSLF4JLogger().info("PaperTemplate Constructor call");
    }

    @Override
    public void onEnable() {
        instance = this;
        getSLF4JLogger().info("PaperTemplate onEnable");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getSLF4JLogger().info("PaperTemplate onDisable");
        super.onDisable();
    }
}

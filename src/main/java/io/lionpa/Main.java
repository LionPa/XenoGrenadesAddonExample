package io.lionpa;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static FileConfiguration config;

    @Override
    public void onEnable() {
        config = getConfig();
        Recipes.init();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {

    }
    public static FileConfiguration config(){
        return config;
    }
}

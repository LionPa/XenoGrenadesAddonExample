package io.lionpa;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static FileConfiguration config;
    private static Plugin plugin;
    @Override
    public void onEnable() {
        plugin = this;
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
    public static Plugin getPlugin(){
        return plugin;
    }
}
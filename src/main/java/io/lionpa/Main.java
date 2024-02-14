package io.lionpa;

import io.lionpa.grenades.FloodFill;
import org.bukkit.Bukkit;
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
        Bukkit.getPluginManager().registerEvents(new FloodFill(),this);
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
package io.lionpa;

import org.bukkit.configuration.file.FileConfiguration;

public class Settings {
    private static final FileConfiguration c = Main.config();
    public static final String GRAVITY_GRENADE_NAME = c.getString("gravity_grenade_name");
    public static final double GRAVITY_GRENADE_POWER = c.getDouble("gravity_grenade_power");
    public static final int GRAVITY_GRENADE_MODEL = c.getInt("gravity_grenade_model");
    public static final double GRAVITY_GRENADE_THROW_POWER = c.getDouble("gravity_grenade_throw_power");
    public static final boolean GRAVITY_GRENADE_DO_DISPENSER = c.getBoolean("gravity_grenade_do_dispenser");
}

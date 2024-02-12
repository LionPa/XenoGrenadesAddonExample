package io.lionpa;

import io.lionpa.grenades.GravityGrenadeBehavior;
import org.bukkit.Material;

public class Items {
    public static final Grenade gravityGrenade = new Grenade(
            Settings.GRAVITY_GRENADE_POWER,       // is power, just value you can use, and user can change
            new GravityGrenadeBehavior(),         // is Behavior of your grenade
            Settings.GRAVITY_GRENADE_MODEL,       // is customModelData (item paper)
            Settings.GRAVITY_GRENADE_NAME,        // is how display name in inventory
            "gravity_grenade",                    // is id
            Material.GRAY_CANDLE,                 // is material which placed when user disable resource pack in config
            Settings.GRAVITY_GRENADE_THROW_POWER, // is throw power of grenade
            Settings.GRAVITY_GRENADE_DO_DISPENSER // is can dispenser dispense your grenade
    );
    // You can do it in one line, but to explain how it works, I did it in a few lines
}

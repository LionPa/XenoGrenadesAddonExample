package io.lionpa.grenades;

import io.lionpa.Grenade;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.projectiles.ProjectileSource;


public class SmokeGrenadeBehavior implements GrenadeBehavior {

    @Override
    public void explode(Location location, Entity entity, ProjectileSource projectileSource) {
        FloodFill flood = new FloodFill(location.toBlock(),location.getWorld(),5,15);
        flood.start();
    }
    @Override
    public void fly(Location location, Entity entity) {

    }
    @Override
    public void init(Grenade grenade) {

    }
}
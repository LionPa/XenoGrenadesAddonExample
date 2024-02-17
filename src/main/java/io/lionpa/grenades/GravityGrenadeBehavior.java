package io.lionpa.grenades;

import io.lionpa.Grenade;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

public class GravityGrenadeBehavior implements GrenadeBehavior{
    @Override
    public void explode(Location location, Entity entity, ProjectileSource projectileSource) {
        location.getNearbyEntities(2,1,2).forEach(entity1 -> { //Getting near entities and add levitation effect
            if (entity1 instanceof LivingEntity living)
                living.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION,20*5,1,false,false,false));
        });
        location.getWorld().spawnParticle(Particle.CLOUD,location,50,1,0.1,1,0.01f); //Spawning particles
    }
    @Override
    public void fly(Location location, Entity entity) {}

    @Override
    public void collide(Location location, Entity entity, Block block, BlockFace blockFace, Vector vector) {

    }

    @Override
    public void init(Grenade grenade) {
        // Add you own options
    }
}

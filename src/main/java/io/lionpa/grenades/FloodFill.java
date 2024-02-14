package io.lionpa.grenades;

import io.lionpa.Main;
import io.papermc.paper.math.Position;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class FloodFill implements Listener {


    private final int maxStep;
    private final World w;
    private final Position start;
    private ArrayList<Position> checked = new ArrayList<>();
    private ArrayList<Position> filled = new ArrayList<>();
    private ArrayList<Position> render = new ArrayList<>();

    //private ArrayList<Entity> hidedEntities = new ArrayList<>();

    public FloodFill(Position start, World w, int maxStep, double distance) {
        this.maxStep = maxStep;
        this.w = w;
        this.start = start;
        //BukkitTask entitiesTask = new BukkitRunnable() {
        //    @Override
        //    public void run() {
        //        Location l = start.toLocation(w);

        //        Collection<Player> players = l.getNearbyPlayers(40);

        //        for (Entity e : hidedEntities){
        //            if (!render.contains(e.getLocation().toBlock())){
        //                hidedEntities.remove(e);
        //                players.forEach(player -> {player.showEntity(Main.getPlugin(),e);});
        //            }
        //        }
        //        hidedEntities.clear();
        //        Collection<LivingEntity> entities = l.getNearbyLivingEntities(10,10,10);
        //        for (Entity e : entities){
        //            if (render.contains(e.getLocation().toBlock())){
        //                hidedEntities.add(e);
        //                players.forEach(player -> {player.hideEntity(Main.getPlugin(),e);});
        //            }
        //        }
        //    }
        //}.runTaskTimer(Main.getPlugin(),0,5);
        BukkitTask particleTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (filled!=null)
                    for (Position p : filled)
                        w.spawnParticle(Particle.CLOUD, p.toLocation(w).toCenterLocation(), 2, 0.45, 0.45, 0.45, 0);
                for (Position p : render)
                    w.spawnParticle(Particle.CLOUD, p.toLocation(w).toCenterLocation(), 1, 0.45, 0.45, 0.45, 0);
            }
        }.runTaskTimer(Main.getPlugin(), 0, 1);
        new BukkitRunnable() {
            @Override
            public void run() {
                Location s = start.toLocation(w);
                for (Position p: filled){
                    if (s.distanceSquared(p.toLocation(w))<distance){
                        render.add(p);
                    }
                }
                checked = null;
                filled = null;
            }
        }.runTaskLater(Main.getPlugin(),maxStep+1);

        new BukkitRunnable() {
            @Override
            public void run() {
                particleTask.cancel();
                //entitiesTask.cancel();
                //for (Entity e : hidedEntities){
                //    Bukkit.getOnlinePlayers().forEach(player -> {player.showEntity(Main.getPlugin(),e);});
                //}
                render = null;
            }
        }.runTaskLater(Main.getPlugin(),200);


    }
    public void start(){
        step(start,0);
    }

    private void step(Position pos, int step) {
        if (step < maxStep) {
            check(pos.offset(1, 0, 0), step);
            check(pos.offset(-1, 0, 0), step);
            check(pos.offset(0,1,0), step);
            check(pos.offset(0,-1,0), step);
            check(pos.offset(0, 0, 1), step);
            check(pos.offset(0, 0, -1), step);
        }
    }
    private void check(Position pos, int step) {
        if (checked.contains(pos)) return;
        checked.add(pos);
        if (pos.toLocation(w).getBlock().isPassable()) {
            filled.add(pos);
            final int s = ++step;
            new BukkitRunnable() {
                @Override
                public void run() {
                    step(pos, s);
                }
            }.runTaskLater(Main.getPlugin(), 1);
        }
    }
    public FloodFill() {
        maxStep = 0;
        w = null;
        start = null;
    }
}

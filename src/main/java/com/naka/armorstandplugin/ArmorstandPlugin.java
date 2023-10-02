package com.naka.armorstandplugin;

import org.bukkit.GameMode;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArmorstandPlugin extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler
    public void onEntityDameage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof ArmorStand && event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            if (player.getGameMode() == GameMode.ADVENTURE) {
                event.setCancelled(true);
                player.sendMessage("アドベンチャーでは防具盾に攻撃はできません");
            }
        }
    }
}

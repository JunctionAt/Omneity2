package at.junction.omneity.spawn;

import at.junction.omneity.Omneity;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {
    Spawn spawn;

    SpawnListener(Spawn spawn){
        this.spawn = spawn;
    }
    @EventHandler
    void onPlayerLoginEvent(PlayerLoginEvent event){
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()){
            player.teleport(spawn.configuration.LOCATION);
            if (spawn.configuration.FIRST_JOIN_MESSAGE_ENABLED){
                spawn.plugin.getServer().broadcastMessage(spawn.configuration.FIRST_JOIN_MESSAGE);
            }
        }
    }

    @EventHandler
    void onPlayerPortalEvent(PlayerPortalEvent event){
        if (event.getFrom().getWorld().getEnvironment() == World.Environment.THE_END && spawn.configuration.BED_DISABLED){
            event.setTo(spawn.configuration.LOCATION);
        }
    }

    @EventHandler
    void onPlayerRespawnEvent(PlayerRespawnEvent event){
        if (event.isBedSpawn() && spawn.configuration.BED_DISABLED){
            event.setRespawnLocation(spawn.configuration.LOCATION);
        }
    }

}

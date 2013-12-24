package at.junction.omneity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OmneityListener implements Listener {
    Omneity plugin;
    public OmneityListener(Omneity plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e){
        //Example event
        e.setCancelled(true);
        e.getPlayer().sendMessage("NO BUILD");
    }
}

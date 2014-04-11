package at.junction.omneity.xp;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class XpListener implements Listener {
    Xp xp;

    public XpListener(Xp xp){
        this.xp = xp;
    }
    @EventHandler
    void onPlayerExpChangeEvent(PlayerExpChangeEvent event){
        event.setAmount((int)(event.getAmount() * xp.configuration.MULTIPLIER));
    }
}

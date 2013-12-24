package at.junction.omneity.at.junction.omneity.ActionSigns;

import org.bukkit.Location;


public class TeleportSign implements ActionSign {
    private Location location;
    private Location to;

    public Location getLocation() {
        return location;
    }

    public Location getTo() {
        return to;
    }

    public TeleportSign(Location location, Location to){
        this.location = location;
        this.to = to;
    }



}

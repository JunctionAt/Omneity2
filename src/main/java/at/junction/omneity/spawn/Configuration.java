package at.junction.omneity.spawn;

import org.bukkit.Location;
import org.bukkit.World;

public class Configuration {
    private Spawn spawn;
    public Location LOCATION;
    public boolean FIRST_JOIN_MESSAGE_ENABLED;
    public String FIRST_JOIN_MESSAGE;
    public boolean BED_DISABLED;


    public Configuration(Spawn spawn){
        this.spawn = spawn;
        this.load();
    }

    public void load(){
        //world:x:y:z:pitch:yaw
        String [] temp = spawn.config.getString("location").split(":");
        LOCATION = new Location(spawn.plugin.getServer().getWorld(temp[0]),
                Double.parseDouble(temp[0]), Double.parseDouble(temp[2]),
                Double.parseDouble(temp[3]), Float.parseFloat(temp[4]),
                Float.parseFloat(temp[5]));

        FIRST_JOIN_MESSAGE_ENABLED = spawn.config.getBoolean("first-join-message-enabled");
        FIRST_JOIN_MESSAGE = spawn.config.getString("first-join-message");
        BED_DISABLED = spawn.config.getBoolean("bed-disabled");

    }
}

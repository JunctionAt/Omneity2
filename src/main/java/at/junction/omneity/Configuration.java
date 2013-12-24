package at.junction.omneity;

public class Configuration {
    Omneity plugin;
    public Boolean ACTION_SIGNS_ENABLED;
    public Configuration(Omneity plugin){
        this.plugin = plugin;
    }

    void load(){
        ACTION_SIGNS_ENABLED = plugin.getConfig().getBoolean("actionSigns.enabled");
    }

}

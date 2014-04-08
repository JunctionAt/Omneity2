package at.junction.omneity;

import java.util.List;

public class Configuration {
    Omneity plugin;
    public List<String> ENABLED_MODULES;

    public Configuration(Omneity plugin){
        this.plugin = plugin;
    }

    void load(){
        plugin.reloadConfig();

        ENABLED_MODULES = plugin.getConfig().getStringList("modules");
    }

}

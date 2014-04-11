package at.junction.omneity;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Module  {
    /*Use:
    Extend Module class
    Overwrite defaultConfig with your plugins config
    call super(plugin) in your constructor
    Override run() to do something when your plugin runs!
     */
    public Omneity plugin;
    public YamlConfiguration config = null;
    public String defaultConfig = "";

    public Module(Omneity plugin) {
        this.plugin = plugin;
        try {
            this.load();
        } catch (Exception e){
            plugin.getServer().getLogger().severe(String.format("Module %s failed to load", this.getClass().getName()));
            e.printStackTrace();
        }
    }

    public void load() throws InvalidConfigurationException, IOException {
        //Load Configuration
        File configFile = new File(String.format("%s%s%s", plugin.getDataFolder(), this.getClass().getName(), ".yml"));
        if (!configFile.exists()) {
            (config = new YamlConfiguration()).loadFromString(defaultConfig);
            config.save(configFile);
        } else {
            (config = new YamlConfiguration()).load(configFile);
        }

    }

    public void reload() throws InvalidConfigurationException, IOException {
        //Reload Configuration
        this.load();
    }

    public boolean run() {
        throw new UnsupportedOperationException("Method not implemented");
    }


}

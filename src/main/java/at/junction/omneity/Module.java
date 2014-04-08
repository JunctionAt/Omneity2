package at.junction.omneity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public abstract class Module {
    boolean loaded = false;
    Omneity plugin;
    YamlConfiguration config = null;
    String defaultConfig = "";

    public Module(Omneity plugin) {
        this.plugin = plugin;
        try {
            this.load();
        } catch (Exception e){
            plugin.getServer().getLogger().severe(String.format("Module %s failed to load", this.getClass().getName()));
            e.printStackTrace();
        }
    }


    public boolean onCommand(CommandSender sender, Command command, String name, String[] args) {
        throw new UnsupportedOperationException("Method not implemented");
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
}

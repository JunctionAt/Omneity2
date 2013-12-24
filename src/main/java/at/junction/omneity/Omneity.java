package at.junction.omneity;

import at.junction.omneity.at.junction.omneity.ActionSigns.ActionSignsListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Omneity extends JavaPlugin {

    Configuration config;
    @Override
    public void onEnable(){
        config = new Configuration(this);
        config.load();
        getServer().getPluginManager().registerEvents(new OmneityListener(this), this);
        if (config.ACTION_SIGNS_ENABLED){
            getServer().getPluginManager().registerEvents(new ActionSignsListener(this), this);
        }
    }
    @Override
    public void onDisable(){

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String name, String[] args){
        //Main Plugin Commands
        if (command.getName().equalsIgnoreCase("omneity-reload")){
            config.load();
            return true;
        } else if (command.getName().equals("something-else")){
            sender.sendMessage("Words");
            return true;
        }

        //Action Signs Commands
        if (config.ACTION_SIGNS_ENABLED){
            if (command.getName().equals("reload-signs-config")){
                //do things
            } else if (command.getName().equals("sign")){
                //CRUD stuff
            }
        }


        return true;
    }
}

package at.junction.omneity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public class Omneity extends JavaPlugin {

    Configuration config;
    CommandMap commandMap = null;
    @Override
    public void onEnable(){
        config = new Configuration(this);
        config.load();

        //Do any other setup BEFORE this try/catch
        try {
            Field field = SimplePluginManager.class.getDeclaredField("commandMap");
            field.setAccessible(true);
            commandMap = (CommandMap)(field.get(getServer().getPluginManager()));
        } catch (NoSuchFieldException e){
            this.setEnabled(false);
            getServer().getLogger().severe("Could not load commandMap - omneity disabling");
            e.printStackTrace();
        } catch (IllegalAccessException e){
            this.setEnabled(false);
            getServer().getLogger().severe("Could not load commandMap - omneity disabling");
            e.printStackTrace();
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



        return true;
    }

}

package at.junction.omneity;

import at.junction.omneity.spawn.Spawn;
import at.junction.omneity.xp.Xp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public class Omneity extends JavaPlugin {

    Configuration config;
    CommandMap commandMap = null;
    Map<String, Module> moduleMap = new HashMap<String, Module>();
    @Override
    public void onEnable(){
        config = new Configuration(this);
        config.load();

        //Better way? Not sure.
        Xp xp = new Xp(this);
        Spawn spawn = new Spawn(this);
        for (String module: config.ENABLED_MODULES){
            if (module.equalsIgnoreCase("xp")){
                moduleMap.put("xp", xp);
            } else if (module.equalsIgnoreCase("spawn")){
                moduleMap.put("spawn", spawn);
            }
        }

        for (Module m : moduleMap.values()){
            m.onEnable();
        }
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
        for (Module m : moduleMap.values()){
            m.onDisable();
        }
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

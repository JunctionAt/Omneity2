package at.junction.omneity.spawn;

import at.junction.omneity.Command;
import at.junction.omneity.CustomExecutor;
import at.junction.omneity.Module;
import at.junction.omneity.Omneity;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn extends Module {
    String defaultConfig = "I STILL NEED TO DO THIS";
    final Configuration configuration;
    public Spawn(Omneity plugin) {
        super(plugin);
        configuration = new Configuration(this);


    }

    @Override
    public void onEnable(){
        SpawnListener listener = new SpawnListener(this);
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        Command command = new Command("spawn", "Teleport player to spawn", "/spawn", null, plugin);
        command.plugin = plugin;
        command.registerCommand("omneity.spawn", new CustomExecutor() {
            @Override
            public boolean run(CommandSender sender, String alias, String[] args) {
                if (sender instanceof Player){
                    sender.sendMessage("Whoosh!");
                    ((Player)sender).teleport(configuration.LOCATION);
                } else {
                    sender.sendMessage(ChatColor.RED + "This command can only be ran by players");
                }
                return true;
            }
        });
    }
}

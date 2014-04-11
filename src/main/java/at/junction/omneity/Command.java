package at.junction.omneity;

import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class Command extends org.bukkit.command.Command {
    CustomExecutor executor;
    public Omneity plugin;
//    List<String> tabComplete;
    /*Both of these MUST be defined. Yay java!*/
    private Command(String name) {
        super(name);
    }

    /*Both of these MUST be defined. Yay java!*/
    private Command(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }
    public Command(String name, String description, String usageMessage, List<String> aliases, Omneity plugin) {
        super(name, description, usageMessage, aliases);
        this.plugin = plugin;

    }
    public void registerCommand(String permission, CustomExecutor ce) {
        executor = ce;
        this.setPermission(permission);
        //Actually register plugin here
        plugin.commandMap.register("/", this);
    }

    @Override
    public boolean execute(CommandSender commandSender, String alias, String[] args) {
        return executor.run(commandSender, alias, args);
    }
}

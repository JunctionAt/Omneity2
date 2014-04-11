package at.junction.omneity;

import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;

public class Command extends org.bukkit.command.Command {
    CustomExecutor executor;
//    List<String> tabComplete;
    /*Both of these MUST be defined. Yay java!*/
    Command(String name) {
        super(name);
    }

    /*Both of these MUST be defined. Yay java!*/
    Command(String name, String description, String usageMessage, List<String> aliases) {
        super(name, description, usageMessage, aliases);
    }

    public void registerCommand(List<String> tabComplete, String usage, String permission, String[] aliases, CustomExecutor ce) {
        executor = ce;
        this.setPermission(permission);
//        this.tabComplete = tabComplete;
        this.usageMessage = usage;
        this.setAliases(Arrays.asList(aliases));

    }

    @Override
    public boolean execute(CommandSender commandSender, String alias, String[] args) {
        return executor.run(commandSender, alias, args);
    }
}

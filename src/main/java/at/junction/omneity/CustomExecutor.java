package at.junction.omneity;

import org.bukkit.command.CommandSender;

public interface CustomExecutor {
    boolean run(CommandSender sender, String alias, String[] args);
}

package at.junction.omneity.at.junction.omneity.ActionSigns;

import at.junction.omneity.Module;
import at.junction.omneity.Omneity;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class ActionSigns extends Module{

    public ActionSigns(Omneity plugin){
        super(plugin);
    }



    public boolean onCommand(CommandSender sender, Command command, String name, String[] args){
        return true;
    }
}

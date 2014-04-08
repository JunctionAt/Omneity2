package at.junction.omneity.at.junction.omneity.ActionSigns;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class GiveSign implements Sign {
    private Location location;
    private ItemStack itemStack;

    public Location getLocation(){
        return location;
    }

    public ItemStack getItemStack(){
        return itemStack;
    }

    public GiveSign(Location location, ItemStack itemStack){
        this.location = location;
        this.itemStack = itemStack;
    }

}

package at.junction.omneity.xp;

public class Configuration {
    public Xp xp;

    public double MULTIPLIER;


    public Configuration(Xp xp){
        xp = xp;
        this.load();
    }
    public void load(){
        MULTIPLIER = xp.config.getDouble("multiplier");
    }
}

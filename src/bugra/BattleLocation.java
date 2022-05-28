package bugra;

public abstract class BattleLocation  extends Location{
    Monsters monsters;

    public BattleLocation(Player player, String name, Monsters monsters) {
        super(player);
        this.name = name;
        this.monsters = monsters;
    }

    public boolean getLocation(){

        return true;
    }
}

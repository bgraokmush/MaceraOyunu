package bugra;

public class Inventory {
    private boolean water,food,firewood;
    private String weaponName,armorName;
    private int weaponDamage,armorAvoid;

    Inventory(){
        this.water = false;
        this.firewood = false;
        this.food = false;
        this.weaponDamage = 0;
        this.armorAvoid = 0;
        this.weaponName = null;
        this.armorName = null;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getArmorAvoid() {
        return armorAvoid;
    }

    public void setArmorAvoid(int armorAvoid) {
        this.armorAvoid = armorAvoid;
    }
}

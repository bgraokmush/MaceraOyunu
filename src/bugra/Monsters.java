package bugra;

import java.util.Random;

public class Monsters {
    private String name;
    private int damage,award, health, maxCount, realHealth;


    public Monsters(String name, int damage, int award, int health, int maxCount) {
        this.name = name;
        this.damage = damage;
        this.award = award;
        this.health = health;
        this.maxCount = maxCount;
        setRealHealth(health);

    }

    public int monsterCount(){
        Random r = new Random();
        return r.nextInt(this.maxCount) + 1;
    }
    public void monsterStats(){
        System.out.println("----------------------------------------");
        System.out.println(
                this.getName() + " değerleri: \n" +
                        "Can: " + this.getHealth() +" Hasar: " + this.getDamage() + " Ödül: " + this.getAward());
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getRealHealth() {
        return realHealth;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }
}

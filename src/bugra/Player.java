package bugra;

import java.util.Scanner;

public class Player {
    private int damage,health,money, realHealth;
    private String name, characterName;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);
    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectCharacter(){
        switch (characterMenu()){
                //Samuray case
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
                //Okçu case
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
                //Asker case
            case 3:
                initPlayer("Asker",8,24,5);
                break;
                //Default case
            default:
                setCharacterName("Samuray");
                setDamage(5);
                setHealth(21);
                setMoney(15);
        }
        System.out.println("Karakter Oluşturuldu!");
        writeCharacterStats();
    }

    public int characterMenu(){
        System.out.println("Tekrar hoş geldin " + getName() + "! \n" +
                "Lütfen bir karakter Seç: \n" +
                "(1)Samuray -> \tHasar:5 \tSağlık:21\t Para:15 \n" +
                "(2)Okçu    -> \tHasar:7 \tSağlık:18\t Para:20\n" +
                "(3)Asket   -> \tHasar:8 \tSağlık:24\t Para:5 \n" +
                "(seçim yapmak için rakamları kullan)");
            int charId = scanner.nextInt();

            while (charId<1 || charId>3){
                System.out.println("Lütfen geçerli bir rakam gir!");
                charId = scanner.nextInt();
            }
            return charId;
    }
    public int getTotalDamage(){
        return this.getDamage() + this.getInventory().getWeaponDamage();
    }

    public void initPlayer(String characterName, int damage, int health, int money){
        setCharacterName(characterName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setRealHealth(health);
    }

    public void writeCharacterStats(){
        System.out.println("Senin Adın: " + getName() + "\n"
                + getCharacterName() +"\t Hasar:" + getDamage()
                + "\t Sağlık:" + getHealth() + "\t Bakiye:" + getMoney());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getRealHealth() {
        return realHealth;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }
}

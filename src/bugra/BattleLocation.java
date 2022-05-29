package bugra;

public abstract class BattleLocation  extends Location{
    protected Monsters monsters;

    public BattleLocation(Player player, String name, Monsters monsters) {
        super(player);
        this.name = name;
        this.monsters = monsters;
    }

    public boolean getLocation(){
        int monsterCount = monsters.monsterCount();
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println(
                "Şuan " + this.getName() + " bölgesindesin. \n" +
                monsterCount +  " adet " + monsters.getName() + "bulunuyor! \n" +
                "Ne yapacaksın? \n" +
                "(S)Savaş - (k)Kaç");
        char selectCase = scanner.nextLine().charAt(0);

        if(selectCase == 'S' || selectCase == 's'){
            if(combat(monsterCount)){
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları yendiniz!");
                return true;
            }else{
                System.out.println("Öldünüz");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int monsterCount){

        for (int i = 1; i <= monsterCount; i++) {
            System.out.println("----------------------------------------");
            System.out.println("");
            System.out.println(i + "." + monsters.getName() +  "ile savaşıyorsun \n");
            playerStats();
            monsterStats();
        }

        return true;
    }
    public void playerStats(){
        System.out.println(
                player.getName() + " oyuncusunun değerleri: \n" +
                "Karakter: " + player.getCharacterName() +"-> Can: " + player.getHealth() + "Hasar: " + player.getDamage() + " Bakiye: " + player.getMoney());
        if (player.getInventory().getWeaponDamage() > 0){
            System.out.println("Silah: " + player.getInventory().getWeaponName());
        }
        if (player.getInventory().getArmorAvoid() > 0){
            System.out.println("Zırh: " + player.getInventory().getArmorName());
        }
    }
    public void monsterStats(){
        System.out.println("----------------------------------------");
        System.out.println(
                monsters.getName() + " değerleri: \n" +
                "Can: " + monsters.getHealth() +" Hasar: " + monsters.getDamage() + " Ödül: " + monsters.getAward());
    }

}

package bugra;

public abstract class BattleLocation  extends Location {
    protected Monsters monsters;

    public BattleLocation(Player player, String name, Monsters monsters) {
        super(player);
        this.name = name;
        this.monsters = monsters;
    }

    public boolean getLocation(){
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println(
                "Şuan " + this.getName() + " bölgesindesin. \n" +
                (monsters.monsterCount()+1) +  " adet " + monsters.getName() + "bulunuyor! \n" +
                "Ne yapacaksın? \n" +
                "(S)Savaş - (k)Kaç");
        char selectCase = scanner.nextLine().charAt(0);

        if(selectCase == 'S' || selectCase == 's'){
            if(combat(monsters.monsterCount())){
                System.out.println(this.getName() + " bölgesindeki tüm düşmanları yendiniz!");

                return true;
            }
            if (player.getHealth() <= 0) {
                System.out.println("Öldünüz!");
                return false;
            }
        }
        return true;
    }

    public boolean combat(int monsterCount){

        for (int i = 1; i <= monsterCount; i++) {
            //Her öldürülen canavardan sonra canın sıfırlanması için
            monsters.setHealth(monsters.getRealHealth());

            System.out.println("----------------------------------------");
            System.out.println("");
            System.out.println(i + "." + monsters.getName() +  "ile savaşıyorsun \n");
            player.writeCharacterStats();
            monsters.monsterStats();
            while (player.getHealth()>0 && monsters.getHealth()>0){
                System.out.println("(V) vur - (K) kaç");
                char selectCase = scanner.nextLine().charAt(0);

                if(selectCase == 'V' || selectCase == 'v'){

                    System.out.println("Siz vurdunuz!");
                    //eğer silahınız var ise rastgele oranla vuruş yapıyorsun
                    if(player.getInventory().getWeaponDamage()>0){
                        monsters.setHealth(monsters.getHealth()-(player.getDamage()+ random.nextInt(player.getInventory().getWeaponDamage())+1 ));
                    }else{
                        monsters.setHealth(monsters.getHealth()-player.getDamage());
                    }
                    System.out.println(monsters.getName() + " canı: " +monsters.getHealth() + "\n");

                    afterHit();
                    if(monsters.getHealth() > 0) {

                        System.out.println(monsters.getName() + " vurdu!");
                        //eğer kalkanın var ise rastgele oranla korunma sağlıyorsun

                        if(player.getInventory().getArmorAvoid() >0){
                            player.setHealth(player.getHealth()- (monsters.getDamage() - random.nextInt(player.getInventory().getArmorAvoid()) +1 ));
                        }else{
                            player.setHealth(player.getHealth()- monsters.getDamage());
                        }
                        System.out.println("Sizin Canınız: " + player.getHealth());

                        afterHit();
                    }
                }else{
                    break;
                }
            }
            if (monsters.getHealth() <= 0 && player.getHealth()>0){
                System.out.println(i + "." + monsters.getName() + " öldü! \n" +
                        "Şu kadar para kazandın: " + monsters.getAward());
                player.setMoney(monsters.getAward() + player.getMoney());
                System.out.println("Güncel bakiyen: " + player.getMoney());


            }
        }

        return true;
    }

    public void afterHit(){

    }

}

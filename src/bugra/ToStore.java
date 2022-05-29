package bugra;

public class ToStore extends NormalLocation{

    public ToStore(Player player) {
        super(player, "Mağaza");
    }

    public boolean getLocation(){
        System.out.println("");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println(
                "Mağaza' ya Hoş geldin. \n" +
                "Bu alanda Alışveriş Yapabilirsin"+
                "Bakiye: " + player.getMoney() +"\n"+
                "(1) Silahlar \n" +
                "(2) Zırhlar \n" +
                "(3) Çıkış");
        System.out.println("Seçiminiz: ");
        int selTool = scanner.nextInt();
        int selItemID;
        switch (selTool){
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println("Satın alacağınız Silahı seçin: \n" +
                           "(1)Tabanca  -> \tÜcret:25 \tHasar:2 \n" +
                           "(2)Kılıç    -> \tÜcret:35 \tHasar:3 \n" +
                           "(3)Tüfek    -> \tÜcret:45 \tHasar:7 \n" +
                           "(4) Çıkış...");
        System.out.println("Seçiminiz: ");
        int selWeaponID = scanner.nextInt();
        return selWeaponID;
    }

    public void buyWeapon(int itemID){
        int damage = 0, price=0;
        String weaponName =null;

        switch (itemID){
            case 1:
                damage = 2;
                weaponName = "Tabanca";
                price = 5;
                break;
            case 2:
                damage = 3;
                weaponName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Tüfek";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor!");
                getLocation();
                break;
            default:
                System.out.println("Lütfen Geçerli bir rakam girin.");
                weaponMenu();
                break;
        }
        if(price>0){
            if(player.getMoney() >= price) {
                player.getInventory().setWeaponDamage(damage);
                player.getInventory().setWeaponName(weaponName);
                player.setMoney(player.getMoney()-price);

                System.out.println(weaponName + " satın Alımı Gerçekleşti \n" +
                        "Önceki hasarınız: " + player.getDamage() +"\n" +
                        "Yeni hasarınız: " + player.getTotalDamage() );
                System.out.println("Kalan para: " + player.getMoney());

                //Geçerli hasarın silah aldıktan sonra toplanmasını sağlıyor
                player.setDamage(player.getTotalDamage());

            }else{
                System.out.println("Bakiye Yetersiz!");
                weaponMenu();
            }
        }

    }

    public int armorMenu(){
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println("Satın alacağınız Silahı seçin: \n" +
                "(1)Hafif Zırh  -> \tÜcret:15 \tKoruman:1 \n" +
                "(2)Orta Zırh   -> \tÜcret:25 \tKoruma:3 \n" +
                "(3)Ağır Zırh   -> \tÜcret:40 \tKoruma:5 \n" +
                "(4) Çıkış...");
        System.out.println("Seçiminiz: ");
        int selArmorID = scanner.nextInt();
        return selArmorID;
    }


    public void buyArmor(int itemID){
        int armor = 0, price=0;
        String armorName =null;

        switch (itemID){
            case 1:
                armor = 1;
                armorName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                armor = 3;
                armorName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                armor = 5;
                armorName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor!");
                getLocation();
                break;
            default:
                System.out.println("Lütfen Geçerli bir rakam girin.");
                weaponMenu();
                break;
        }
        if(price>0){
            if(player.getMoney() >= price) {
                player.getInventory().setArmorName(armorName);
                player.getInventory().setArmorAvoid(armor);
                player.setMoney(player.getMoney()-price);
                System.out.println(armorName + " satın Alımı Gerçekleşti \n" +
                        "Yeni Korumanız: " + player.getInventory().getArmorAvoid());
                System.out.println("Kalan para: " + player.getMoney());

            }else{
                System.out.println("Bakiye Yetersiz!");
                weaponMenu();
            }
        }

    }
}

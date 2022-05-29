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
                break;
            case 3:
                break;
            default:
                break;
        }
        return true;
    }

    public int weaponMenu(){
        System.out.println("");
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
                price = 25;
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
                getLocation();
            default:
                System.out.println("Lütfen Geçerli bir rakam girin.");
                weaponMenu();
                break;
        }
        if(player.getMoney() > price) {
            player.getInventory().setWeaponDamage(damage);
            player.getInventory().setWeaponName(weaponName);
            player.setMoney(player.getMoney()-price);

            System.out.println(weaponName + " satın Alımı Gerçekleşti \n" +
                    "Önceki hasarınız: " + (player.getDamage()-player.getInventory().getWeaponDamage()) +"\n" +
                    "Yeni hasarınız: " + (player.getDamage()));
            System.out.println("Kalan para: " + player.getMoney());
        }else{
            System.out.println("Bakiye Yetersiz!");
            weaponMenu();
        }




    }
}

package bugra;

public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }


    public boolean getLocation(){
        //getRealHealth() karakterin ilk sağlığını tutan değişkene bağlı
        System.out.println("Canınız yenilendi! \n" +
                "Güvenli evde bulunuyorsunuz!");
        player.setHealth(player.getRealHealth());
        return true;
    }
}

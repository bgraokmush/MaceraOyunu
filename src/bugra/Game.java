package bugra;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scanner = new Scanner(System.in);
    void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoş Geldin! \n" +
                "Oyna Başlamadan Önce Adını Girmelisin: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCharacter();
        start();
    }

    public void start(){
        while (true){
            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("");
            System.out.println("Eylem gerçekleştirmek için bölge seçin: ");
            System.out.println(
                    "(1)Güvenli Ev -> Size ait güvenli alan, düşman bulunmuyor. \n" +
                            "(2)Mağara     -> Burada Zombi olma ihtimali var! \n" +
                            "(3)Orman      -> Burada Vampir olma ihtimali var!\n" +
                            "(4)Nehir      -> Burada Ayı olma ihtimali var!\n" +
                            "(5)Mağaza     -> Silah veya Zırh satın alabilirsiniz \n" +
                            "Gitmek istediğiniz yeri seçin: ");

            int selectLocation = scanner.nextInt();
            while (selectLocation<1 || selectLocation>5){
                System.out.println("Geçerli bir giriş yapmalısın!");
                selectLocation = scanner.nextInt();
            }
            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 5:
                    location = new ToStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }
            if(location.getLocation()){
                System.out.println("Oyun bitti!");
                break;
            }
        }
    }
}

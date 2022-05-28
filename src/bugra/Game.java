package bugra;

import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Macera Oyununa Hoş Geldin! \n" +
                "Oyna Başlamadan Önce Adını Girmelisin: ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
    }
}

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to the Advanture Game!");
        //System.out.print("Please enter your name: ");
        //String playerName = input.nextLine();
        Player player = new Player("sibonto");
        System.out.println("Welcome " + player.getName());
        player.selectChar();

        Location location;
        while (true) {
            System.out.println();
            System.out.println("Locations");
            System.out.println("1 - Safe House");
            System.out.println("2 - Tool Store");
            System.out.println("3 - Cave | Reward: Food");
            System.out.println("4 - Forest | Reward: Wood");
            System.out.println("5 - River | Reward: Water");
            System.out.println("0 - Exit - Finish the Game");
            System.out.print("Please select your location: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    player.printInfo();
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;

                default:
                    location = new SafeHouse(player);

            }
            if (location == null) {
                System.out.println("Game Finished! See you next time!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game Over");
                break;
            }
        }
    }
}

import lombok.Data;

import java.util.Scanner;

@Data
public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inv;

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar : charList) {
            System.out.println("Karakter: " + gameChar.getName() +
                    "\t ID: " + gameChar.getId() +
                    "\t Damage: " + gameChar.getDamage() +
                    "\t Health: " + gameChar.getHealth() +
                    "\t Money: " + gameChar.getMoney());
        }
        System.out.println("----------------");
        System.out.print("Please select your character: ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;

        }
        // System.out.println("Character: " + this.getCharName() + ", Damage: " + this.getDamage() + ", Health: " + this.getHealth() + ", Money: " + this.getMoney());

    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println(
                "Weapon: " + this.getInv().getWeapon().getName() +
                        ", Armor: " + this.getInv().getArmor().getName() +
                        ", Block: " + this.getInv().getArmor().getBlock() +
                        ", Damage: " + this.getDamage() +
                        ", Health: " + this.getHealth() +
                        ", Money: " + this.getMoney());
    }

    public int getTotalDamage() {
        return damage + this.getInv().getWeapon().getDamage();
    }

}

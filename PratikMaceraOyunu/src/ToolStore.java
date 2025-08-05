import java.util.Scanner;

public class ToolStore extends NormalLoc {
    private Scanner input = new Scanner(System.in);

    public ToolStore(Player player) {
        super(player, "Store");

    }

    @Override
    public boolean onLocation() {
        System.out.println();
        System.out.println("Welcome to Tool Store");
        boolean showMenu = true;
        while (showMenu) {

            System.out.println("1- Weapons");
            System.out.println("2- Armors");
            System.out.println("3- Exit");
            System.out.print("Enter your choice: ");
            int selectCase = input.nextInt();
            while (selectCase < 0 || selectCase > 3) {
                System.out.println("Please enter a number between 1 and 3");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                case 3:
                    System.out.println("See you again!");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon() {
        System.out.println("Weapons: ");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " = " + w.getName() + " | Price: " + w.getPrice() + " | Damage: " + w.getDamage());
        }
        System.out.println("0 - Exit");
    }


    public void buyWeapon() {
        System.out.print("Choose your weapon: ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print("Please enter a number between 0 and 3");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money!");
                } else {
                    System.out.println("You bought " + selectedWeapon.getName());
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Your balance: " + this.getPlayer().getMoney());
                    this.getPlayer().getInv().setWeapon(selectedWeapon);

                }
            }
        }
    }

    public void printArmor() {
        System.out.println("Armors: ");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " = " + a.getName() + " | Price: " + a.getPrice() + " | Block: " + a.getBlock());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.println("Choose your armour: ");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.print("Please enter a number between 0 and 3");
            selectArmorID = input.nextInt();

        }
        if (selectArmorID != 0) {


            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Not enough money!");

                } else {
                    System.out.println("You bought " + selectedArmor.getName());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    System.out.println("Your balance: " + this.getPlayer().getMoney());
                    this.getPlayer().getInv().setArmor(selectedArmor);

                }
            }
        }
    }
}

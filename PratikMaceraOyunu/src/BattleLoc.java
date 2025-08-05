import java.util.Random;

public abstract class BattleLoc extends Location {
    private Monster monster;
    private String award;
    private int maxMonster;

    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {

        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();

        System.out.println("You are at: " + this.getName());
        System.out.println("Becareful! " + monsterNumber + " " + this.getMonster().getName() + " around here!");
        System.out.print("<F>ight or <L>eave: ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("F")) {
            if (combat(monsterNumber)) {
                System.out.println(this.getName() + " cleared!");
                return true;
            }
        }


        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You are dead!");
            return false;
        }
        return true;
    }


    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.print("<H>it or <F>orfeit: ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("H")) {
                    System.out.println("You hit: " + this.getPlayer().getTotalDamage() + " to " + this.getMonster().getName());
                    this.getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0 && this.getPlayer().getHealth() > 0) {
                        System.out.println();
                        System.out.println("You have been hit!");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInv().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();

                    }


                    if (this.getMonster().getHealth() <= 0) {
                        System.out.println(this.getMonster().getName() + " has been killed!");
                        System.out.println(this.getMonster().getReward() + " gold looted!");
                        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getReward());
                        System.out.println("New balance: " + this.getPlayer().getMoney());
                        System.out.println("---------------------");
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public void afterHit() {
        System.out.println("Your life = " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + "'s current life = " + this.getMonster().getHealth());
    }

    public void playerStats() {
        System.out.println("Player Stats");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Weapon: " + this.getPlayer().getInv().getWeapon().getName());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Armor: " + this.getPlayer().getInv().getArmor().getName());
        System.out.println("Block: " + this.getPlayer().getInv().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
    }

    public void monsterStats(int i) {
        System.out.println();
        System.out.println(i + "." + this.getMonster().getName() + " Stats");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getMonster().getHealth());
        System.out.println("Damage: " + this.getMonster().getDamage());
        System.out.println("Reward: " + this.getMonster().getReward() + " gold");
    }

    public int randomMonsterNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}

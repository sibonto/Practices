public class Monster {
    private int id;
    private int damage;
    private int health;
    private String name;
    private int reward;
    private int defaultHealth;

    public Monster(int id, String name, int damage, int health, int reward) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.reward = reward;
        this.defaultHealth = health;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }
}

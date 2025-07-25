class Fighter {

    String name;
    int damage;
    int health;
    int weight;
    int maxHealth;
    double dodge;
    double special;
    double heal;

    Fighter(String name, int damage, int health, int weight, double dodge, double special, double heal) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.weight = weight;
        this.dodge = dodge;
        this.special = special;
        this.heal = heal;
        this.maxHealth = health;

    }

    int hit(Fighter foe) {
        int actualDamage = this.damage;
        if (isSpecialAttack()) {
            actualDamage *= 2;
            System.out.println(this.name + " ÖZEL YETENEĞİNİ kullandı! (2 katı hasar!)");
        }

        if (this.health > 0 && this.health < maxHealth && isHeal()) {
            this.health = Math.min(this.health + 10, this.maxHealth);
            System.out.println(this.name + " kendine can bastı! (Yeni can: " + this.health + ")");

        }
        System.out.println(this.name + " => " + foe.name + " " + actualDamage + " hasar vurdu");

        if (foe.isDodge()) {
            System.out.println(foe.name + " gelen hasarı blockladı!");
            System.out.println("--------");
            return foe.health;
        }
        int newHealth = foe.health - actualDamage;
        return Math.max(newHealth, 0);
    }

    boolean isDodge() {
        double randomNumber = Math.random() * 100;
        return randomNumber <= this.dodge;
    }

    boolean isSpecialAttack() {
        return Math.random() * 100 <= this.special;

    }

    boolean isHeal() {
        return Math.random() * 100 <= this.heal;
    }
}

public class Hero {

    protected String name;

    protected int Health = 50;
    protected int Stamina = 25;
    protected int Strength = 5;
    protected int Agility = 5;
    protected int Attack;
    protected int Defend;
    protected int damage;

    Hero(String Name) {
        this.name = Name;
    }

    Hero(String Name, int Strength, int Agility) {
        this.name = Name;
        this.Strength = Strength;
        this.Agility = Agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public int getHealth() {
        return Health;
    }

    public void setHealth(int Health) {
        this.Health = Health;
    }

    public int getStrength() {
        return Strength;
    }

    public void setStrength(int Strength) {
        if (Strength >= 0) {
            this.Strength = Strength;
        }
    }

    public int getAgility() {
        return Agility;
    }

    public void setAgility(int Agility) {
        if (Agility >= 0) {
            this.Agility = Agility;
        }
    }

    public int getStamina() {
        return Stamina;
    }

    public void setStamina(int Stamina) {
        if (Stamina >= 0) {
            this.Stamina = Stamina;
        }
    }

    public void addHealth(int addHealth) {
        //if(addHealth >= 0)
        Health = addHealth + Health;
    }

    public int removeHealth(int removeHealth) {
        if (0 <= removeHealth) {
            Health = (Health - removeHealth);
        }
        return Health;
    }

    public void printStat() {
        System.out.println(name);
        System.out.println(Strength);
        System.out.println(Agility);
        System.out.println(Stamina);
        System.out.println(Health);
    }

    public int Defend() {
        Stamina = Stamina - 4;

        Die d20;

        d20 = new Die();

        d20.setSides(20);

        d20.roll();

        d20.getValue();

        int Defend = d20.getValue() + Agility;
        if (Stamina < 4) {
            Defend = 0;
            rest();
        }
        return Defend;

    }

    public int Attack() {
        Stamina = Stamina - 6;

        Die d20;

        d20 = new Die();

        d20.setSides(20);

        d20.roll();

        d20.getValue();
        if (Stamina > 6) {
            Attack = d20.getValue() + Strength;
        } else if (Stamina < 6) {

            rest();
            Attack = 0;
        }

        return Attack;

    }

    private void rest() {
        Die d6;
        Die d8;
        Die d10;
        d6 = new Die();
        d8 = new Die();
        d10 = new Die();

        d6.setSides(6);
        d8.setSides(8);
        d10.setSides(10);
        d6.roll();
        d8.roll();
        d10.roll();

        d6.getValue();
        d8.getValue();
        d10.getValue();

        if (d6.getValue() > d8.getValue() && d6.getValue() > d10.getValue()) {
            Health = d6.getValue() + Health;
            Stamina = d10.getValue() + d8.getValue();
        } else if (d8.getValue() > d6.getValue() && d8.getValue() > d10.getValue()) {
            Health = d8.getValue() + Health;
            Stamina = d10.getValue() + d6.getValue();
        } else if (d10.getValue() > d6.getValue() && d10.getValue() > d8.getValue()) {
            Health = d10.getValue() + Health;
            Stamina = d6.getValue() + d8.getValue();
        }

    }
}


import java.util.Scanner;


public class BattleManager {

    public Hero setupHero(String Name) {
        Hero h1 = new Hero(Name);

        Die d12;
        Die d10;
        Die d8;

        d12 = new Die();
        d12.setSides(12);
        d12.roll();
        d12.getValue();

        d10 = new Die();
        d10.setSides(10);
        d10.roll();
        d10.getValue();

        d8 = new Die();
        d8.setSides(8);
        d8.roll();
        d8.getValue();

        if (d12.getValue() > d8.getValue() && d12.getValue() > d10.getValue()) {
            h1.setStrength(d12.getValue());
            h1.setAgility(d10.getValue() + d8.getValue());
        } else if (d8.getValue() > d12.getValue() && d8.getValue() > d10.getValue()) {
            h1.setStrength(d8.getValue());
            h1.setAgility(d10.getValue() + d12.getValue());
        } else if (d10.getValue() > d12.getValue() && d10.getValue() > d8.getValue()) {
            h1.setStrength(d10.getValue());
            h1.setAgility(d12.getValue() + d8.getValue());
        }

        return h1;

    }
        public Hero setup(String Name, String Equipment) {
        Hero h1 = new Hero(Name);

        Die d12;
        Die d10;
        Die d8;

        d12 = new Die();
        d12.setSides(12);
        d12.roll();
        d12.getValue();

        d10 = new Die();
        d10.setSides(10);
        d10.roll();
        d10.getValue();

        d8 = new Die();
        d8.setSides(8);
        d8.roll();
        d8.getValue();

        if (d12.getValue() > d8.getValue() && d12.getValue() > d10.getValue()) {
            h1.setStrength(d12.getValue());
            h1.setAgility(d10.getValue() + d8.getValue());
        } else if (d8.getValue() > d12.getValue() && d8.getValue() > d10.getValue()) {
            h1.setStrength(d8.getValue());
            h1.setAgility(d10.getValue() + d12.getValue());
        } else if (d10.getValue() > d12.getValue() && d10.getValue() > d8.getValue()) {
            h1.setStrength(d10.getValue());
            h1.setAgility(d12.getValue() + d8.getValue());
        }

        return h1;

    }

    public void Round(Hero a, Hero b) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Press a for attack or d for defend(Hero 1)");

        String move = scan.nextLine();
        if (move.equals("a")) {
            a.Attack();
        } else if (move.equals("d")) {
            a.Defend();

        }
        System.out.println("Press a for attack or d for defend(Hero 2)");

        String move1 = scan.nextLine();
        if (move1.equals("a")) {
            b.Attack();
        } else if (move1.equals("d")) {
            b.Defend();

        }

        if (move.equals("a")) {

            if (move1.equals("a")) {
                a.Attack = a.Attack();
                b.Attack = b.Attack();
                a.removeHealth(b.Attack);
                b.removeHealth(a.Attack);
            } else {
                a.Attack = a.Attack();
                b.Defend = b.Defend();
                int damage = a.Attack - b.Defend;
                if (damage > 0) {
                    b.removeHealth(Math.abs(damage));
                }
            }
        }
        if (move.equals("d")) {
            if (move1.equals("d")) {
                a.Defend = a.Defend();
                b.Defend = b.Defend();
            } else {
                a.Defend = a.Defend();
                b.Attack = b.Attack();
                int damage = b.Attack - a.Defend;
                if (damage > 0) {
                    a.removeHealth(Math.abs(damage));
                }

            }

        }
        //System.out.println("End of a round");    
    }

    public Hero Battle(Hero a, Hero b, int rounds) {
        Hero winner;
        int i = 0;

        while (i < rounds) {

            Round(a, b);
            i++;
        }

        if (a.getHealth() > b.getHealth()) {
            System.out.println("Hero 1 is the Winner");
            winner = a;
        } else if (a.getHealth() < b.getHealth()) {
            System.out.println("Hero 2 is Winner");
            winner = b;
        } else {

            Die d1;
            d1 = new Die();
            d1.setSides(2);
            d1.roll();
            d1.getValue();
            if (d1.getValue() == 1) {
                System.out.println("Hero 1 wins by chance");
                winner = a;
            } else {
                System.out.println("Hero 2 wins by chance");
                winner = b;
            }
        }
        return winner;

    }
    public Hero tournament(Hero[]list){
        Hero[] currentRound = list;
        Hero winner = null;
        while(currentRound .length > 1){
            Hero[] nextRound;
            int s = (int) Math.ceil(currentRound.length/2.0);
            nextRound = new Hero[s];
            
            int i =0;
            int j =0;
            if(currentRound.length %2 == 1){
                nextRound[0] = currentRound[0];
                j++;
                i++;
            }
            //System.out.println("Hello");
            
            for ( ;i < currentRound.length; i=i+2) {
               winner = Battle(currentRound[i],currentRound[i+1],3);
            nextRound[j] = winner;
                j++;
            }
            
           currentRound = nextRound;
            
        }
        
        return winner;
    }
}
    
            

        

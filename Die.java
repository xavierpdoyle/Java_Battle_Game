import java.util.Random;

public class Die 
{
    private int sides;
    private int value;
   
    public void roll()
    {
        Random r = new Random();
        value = r.nextInt(sides)+1;
    }
    
    public int getSides()
    {
        return sides;
    }
    public void setSides(int sides)
    {
        this.sides = sides;
    }
    public int getValue()
    {
        return value;
    }
}


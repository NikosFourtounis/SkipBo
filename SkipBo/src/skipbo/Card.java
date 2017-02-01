
package skipbo;


public abstract class Card
{
    protected int value;
    //int id;
    
    public Card()
    {
        value=-1;
    }
    public Card(int value)
    {
        this.value=value;
    }
    public int getValue()
    {
        return value;
    }
    public abstract void print();
}

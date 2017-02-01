
package skipbo;

public class SimpleCard extends Card
{

    public SimpleCard(int value)
    {
        super(value);
    }
    @Override
    public void print()
    {
        System.out.print(value);
    }
    
    
}


package skipbo;

public class SkipBoBaladeurSimple extends Card implements SkipBoBaladeur
{

    public SkipBoBaladeurSimple()
    {
        super(0);
    }
    public SkipBoBaladeurSimple(int value)
    {
        super(value);
    }
    @Override
    public void print()
    {
        System.out.print("SimB");
    }

    @Override
    public void setValue(int value)
    {
        this.value=value;
    }

    
    
    
}

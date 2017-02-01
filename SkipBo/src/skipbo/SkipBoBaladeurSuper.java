
package skipbo;

public class SkipBoBaladeurSuper extends Card implements SkipBoBaladeur
{

    public SkipBoBaladeurSuper()
    {
        super(0);
    }
    @Override
    public void print()
    {
        System.out.print("SupB");
    }

    @Override
    public void setValue(int value)
    {
        this.value=value;
    }
    
}

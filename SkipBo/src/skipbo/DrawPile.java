
package skipbo;

import java.util.ArrayList;
import java.util.Random;

public class DrawPile extends Structure implements Pile
{
    
    public DrawPile()
    {
        for(int i=0;i<12;i++)
        {
            for(int y=0;y<12;y++)
            {
                list.add(new SimpleCard(y+1));
            }
        }
        for(int i=0;i<8;i++)
        {
            list.add(new SkipBoBaladeurSimple());
        }
        for(int i=0;i<4;i++)
        {
            list.add(new SkipBoBaladeurSuper());
        }
        for(int i=0;i<4;i++)
        {
            list.add(new SkipBoEraser());
        }
    }
    public void Shuffle()
    {
        Random rnd = new Random();
        for(int i=0;i<160;i++)
        {
            Card temp;
            int random=rnd.nextInt(159)+1;
            temp=list.get(i);
            list.set(i, list.get(random));
            list.set(random, temp);
        }
    }
    public void addPile(ArrayList<Card> list)
    {
        list.addAll(list);
    }
    @Override
    public Card getTopCard()
    {
        Card card=list.get(list.size()-1);
        list.remove(list.size()-1);
        return card;
    }

    
}

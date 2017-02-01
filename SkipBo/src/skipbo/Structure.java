
package skipbo;

import java.util.ArrayList;

public abstract class Structure
{
    protected ArrayList<Card> list=new ArrayList<Card>();

    Card getCard(int cardpicked)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    Card getCardType(int cardpicked)
    {
        return list.get(cardpicked);
    }

    Card getTopCard()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getTopCardValue()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
            
}

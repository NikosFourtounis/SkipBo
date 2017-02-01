
package skipbo;

public class StockPile extends Structure
{
    
    public void addCard(Card card)
    {
        list.add(card);
    }
    public int getSize()
    {
        return list.size();
    }
    public Card getTopCardType()
    {
        return list.get(list.size()-1);
    }
    public Card getTopCard()
    {
        Card card=list.get(list.size()-1);
        list.remove(list.size()-1);
        return card;
    }
    public int getTopCardValue()
    {
        return list.get(list.size()-1).value;
    }
}


package skipbo;

public class DiscardPile extends Structure implements Pile
{
    public void addCard(Card card)
    {
        list.add(card);
    }
    @Override
    public Card getTopCard()
    {
        Card card=list.get(list.size()-1);
        list.remove(list.size()-1);
        return card;
    }
    public Card geCard(int number)
    {
        Card card=list.get(number);
        list.remove(number);
        return card;
    }
    public Card getTopCardType()
    {
        return list.get(list.size()-1);
    }
    public int size()
    {
        return list.size();
    }
    public int getTopCardValue()
    {
        return list.get(list.size()-1).getValue();
    }
}

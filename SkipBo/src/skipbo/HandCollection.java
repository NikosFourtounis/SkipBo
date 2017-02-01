
package skipbo;

public class HandCollection extends Structure
{
    public Card getCard(int number)
    {
        Card card=list.get(number-1);
        list.remove(number-1);
        return card;
    }
    public Card getCardType(int number)
    {
        Card card=list.get(number);
        return card;
    }
    public int getCardsNumber()
    {
        return list.size();
    }
    public void addCard(Card card)
    {
        list.add(card);
    }
}

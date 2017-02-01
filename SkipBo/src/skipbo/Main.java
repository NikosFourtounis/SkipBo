 //Νικόλαος Φουρτούνης icsd13195
//Δημήτριος Λάσκαρης icsd10101
package skipbo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    //Αρχικά φτιάχνω όλα τα αντικείμενα που θα χρειαστώ για ένα παιχνιδι
    //Τα θετω static για να μπορω να τα βλεπω σε ολη την κλασση τις main
    static ArrayList<DiscardPile> DiscardList1=new ArrayList<DiscardPile>();
    static ArrayList<DiscardPile> DiscardList2=new ArrayList<DiscardPile>();
    static ArrayList<BuildingPile> BuildingList=new ArrayList<BuildingPile>();
    static Scanner keyboard = new Scanner(System.in); 
    static DrawPile dp1= new DrawPile();
    static StockPile sp1=new StockPile();
    static StockPile sp2=new StockPile();
    static HandCollection hc1=new HandCollection();
    static HandCollection hc2=new HandCollection();
    static ArrayList<Card> AllCardsList=new ArrayList<Card>();//Λιστα με όλες τις κάρτες
    public static void main(String[] args)
    {
        //Προσθετωστις λιστες μου τα αντικειμενα των piles
        DiscardList1.add(new DiscardPile());
        DiscardList1.add(new DiscardPile());
        DiscardList1.add(new DiscardPile());
        DiscardList1.add(new DiscardPile());
        DiscardList2.add(new DiscardPile());
        DiscardList2.add(new DiscardPile());
        DiscardList2.add(new DiscardPile());
        DiscardList2.add(new DiscardPile());
        BuildingList.add(new BuildingPile());
        BuildingList.add(new BuildingPile());
        BuildingList.add(new BuildingPile());
        BuildingList.add(new BuildingPile());
        //Και ανακατέβω την τράπουλα
        dp1.Shuffle();
        //Μοιράζω τις κάρτες στις stock Piles
        DealStockPiles(dp1,sp1,sp2);
        //Κρατάω μεταβλητή για το τέλος του γύρου
        Menu menu=new Menu();
        int a=0;
        while(a==0)
        {
            System.out.println(menu.getplayer1());
            if(menu.getplayer1()!="")
            {
                System.out.println(menu.getplayer1());
                Frame pane=new Frame(hc2,sp2,DiscardList2,dp1,BuildingList,sp1,DiscardList1,hc1,menu.getplayer1(),menu.getplayer2());
                a=1;
            }
        }
    }
    public static void DealHandCollection(DrawPile dp1,HandCollection hc1,HandCollection hc2)
    {//Μοιρασμα στα χέρια των παικτων αν εχουν λιγότερες απο 5 κάρτες
        while(hc1.getCardsNumber()<5)
        {
            hc1.addCard(dp1.getTopCard());
        }
        while(hc2.getCardsNumber()<5)
        {
            hc2.addCard(dp1.getTopCard());
        }
    }
    public static void DealStockPiles(DrawPile dp1,StockPile sp1,StockPile sp2)
    {//μοιρασμα στις stockPiles
        for(int i=0;i<30;i++)
        {
            sp1.addCard(dp1.getTopCard());
            sp2.addCard(dp1.getTopCard());
        }
    }    
    
    
}

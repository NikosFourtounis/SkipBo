package skipbo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
public class DrawingPanel extends JPanel implements MouseListener
{//Φτιανχω τις αναλογες ιδιοτητες για να περασω σε αυτες, ολες τις δομες που κραταω τις καρτες
    private int selectedx1;
    private int selectedx2;
    private int selectedy1;
    private int selectedy2;
    private HandCollection hc2;
    private HandCollection hc1;
    private StockPile sp2;
    private StockPile sp1;
    private ArrayList<DiscardPile> DiscardList2;
    private ArrayList<DiscardPile> DiscardList1;
    private ArrayList<BuildingPile> BuildingList;
    private DrawPile dp1;
    private Structure structurepicked=null;
    private int cardpicked=0;
    private int playerplaying=1;
    private String player1;
    private String player2;
    public DrawingPanel(DrawPile dp1,HandCollection hc2,StockPile sp2,ArrayList<DiscardPile> DiscardList2,ArrayList<BuildingPile> BuildingList,StockPile sp1,ArrayList<DiscardPile> DiscardList1,HandCollection hc1,String player1,String player2)
    {//Τις τραβάω μέσω του constructor και τις εκχωρώ μέσα στις ιδιότητες
        addMouseListener(this);
        this.hc2=hc2;
        this.hc1=hc1;
        this.sp2=sp2;
        this.sp1=sp1;
        this.DiscardList2=DiscardList2;
        this.DiscardList1=DiscardList1;
        this.BuildingList=BuildingList;
        this.dp1=dp1;
        this.player1=player1;
        this.player2=player2;
    }
    public void paintComponent(Graphics g)
    {//Μετά μέσα στην paintComponent αρχίζω και ζωγραφίζω όλες τις κάρτες του παιχνιδιού
        int distance;
        g.setColor(Color.LIGHT_GRAY);//Χρωματίζω την περιοχή κάθε φορά 
        g.fillRect(0, 0, 400, 350);
        //HAND 2
        //Παρακάτω υπαρχουν τα if που ελέχγουν αν ο χρήστης εχει επιλέξει μια κάρτα απο το Hand 2, μέσω συντεταγμένων
        //που εκχωρεί κάθε φορά η Mouseclicked
        if(selectedx1>=80 && selectedx1<=105 && selectedy1>=20 && selectedy1<=60&&playerplaying==2)
        {//Σημαδεύω την κάρτα με κίτρινο περίγραμα
            g.setColor(Color.yellow);
            g.drawRect(78, 19, 28, 42); 
            if(structurepicked==null)//Κρατάω σε σχετικές μεταβλητές ποια κάρτα έχω επιλέξει
            {
                structurepicked=hc2;
                cardpicked=1;
            }          
        }//και ομοίως κάνω και για όλες τις άλλες κάρτες του Hand 2
        else if(selectedx1>=130 && selectedx1<=150 && selectedy1>=20 && selectedy1<=60&&playerplaying==2)
        {
            g.setColor(Color.yellow);
            g.drawRect(128, 19, 28, 42);
            if(structurepicked==null)
            {
                structurepicked=hc2;
                cardpicked=2;
            }
        }
        else if(selectedx1>=180 && selectedx1<=210 && selectedy1>=20 && selectedy1<=60&&playerplaying==2)
        {
            g.setColor(Color.yellow);
            g.drawRect(178, 19, 28, 42);
            if(structurepicked==null)
            {
                structurepicked=hc2;
                cardpicked=3;
            }
        }
        else if(selectedx1>=230 && selectedx1<=260 && selectedy1>=20 && selectedy1<=60&&playerplaying==2)
        {
            g.setColor(Color.yellow);
            g.drawRect(228, 19, 28, 42);
            if(structurepicked==null)
            {
                structurepicked=hc2;
                cardpicked=4;
            }
        }  
        else if(selectedx1>=280 && selectedx1<=310 && selectedy1>=20 && selectedy1<=60&&playerplaying==2)
        {
            g.setColor(Color.yellow);
            g.drawRect(278, 19, 28, 42);
            if(structurepicked==null)
            {
                structurepicked=hc2;
                cardpicked=5;
            }
        }
        //STOCK PILE 2, Επίσης έχω if, για το αν ο παίκτης έχει clickαρει στο StockPile 2
        else if(selectedx1>=30 && selectedx1<=65&&selectedy1>=80&& selectedy1<=120&&playerplaying==2)
        {
            if(structurepicked==null)//Κρατάω σε μεταβλητη οτι διάλεξε την StockPile 2
            {
                structurepicked=sp2;
            }     
            g.setColor(Color.yellow);
            g.drawRect(29, 79, 28, 42);
        }
        //DISCARD 2, Σχετικά if για το αν ο παικτης παίξει κάρτα απο Discard Pile, ή πάνω σε DiscardPile
        else if(selectedx1>=80 && selectedx1<=105 && selectedy1>=80 && selectedy1<=120&&playerplaying==2)
        {//Παρακάτω ελέγχω αν ο παίκτης παει να παίξει μια κάρτα απο το HandCollection, πάνω στο Discard
            if(structurepicked!=null&&structurepicked!=DiscardList2.get(0))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList2.get(0).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=1;//Επίσης Τερματίζω τον γύρο του
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);//και μοιράζω κάρτες
                }
            }
            else if(DiscardList2.get(0).size()!=0)//Σε αυτό το if θα μπει όταν ο παίκτης θέλει να παίξει κάρτα απο το DiscardPile
            {
                structurepicked=DiscardList2.get(0);
                g.setColor(Color.yellow);
                g.drawRect(78, 79, 28, 42);
            }   
        }//Ομοίως πράτω και στα άλλα 3 DiscardPile του παίκτη 2
        else if(selectedx1>=130 && selectedx1<=150 && selectedy1>=80 && selectedy1<=120&&playerplaying==2)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList2.get(1))
            {
                
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList2.get(1).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=1;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }   
            }
            else if(DiscardList2.get(1).size()!=0)
            {
                structurepicked=DiscardList2.get(1);
                g.setColor(Color.yellow);
                g.drawRect(128, 79, 28, 42);
            }  
        }
        else if(selectedx1>=180 && selectedx1<=210 && selectedy1>=80 && selectedy1<=120&&playerplaying==2)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList2.get(2))
            {
                if(structurepicked instanceof HandCollection)
                DiscardList2.get(2).addCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                playerplaying=1;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
            }
            else if(DiscardList2.get(2).size()!=0)
            {
                structurepicked=DiscardList2.get(2);
                g.setColor(Color.yellow);
                g.drawRect(178, 79, 28, 42);
            }  
        }
        else if(selectedx1>=230 && selectedx1<=260 && selectedy1>=80 && selectedy1<=120&&playerplaying==2)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList2.get(3))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList2.get(3).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=1;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }
                
            }
            else if(DiscardList2.get(3).size()!=0)
            {
                structurepicked=DiscardList2.get(3);
                g.setColor(Color.yellow);
                g.drawRect(228, 79, 28, 42);
            }  
        }
        //BUILDING PILE, Στα If αυτά ελέγχω αν οι παίτκες προσπαθούν να παίξουν στα Building Piles
        else if(selectedx1>=80 && selectedx1<=105 && selectedy1>=140 && selectedy1<=180)
        {//Παρακάτω ελέγχω αν ο παίκτης παίζει κάρτα απο το χέρι του, και αν αυτή είναι συμβατή
            if(structurepicked instanceof HandCollection && BuildingList.get(0).returnSize()==(structurepicked.getCardType(cardpicked-1).getValue()-1))
            {
                BuildingList.get(0).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }//Παρακάτω ελέγχω αν ο παίκτης παίζει κάρτα απο το StockPile του ή κάποιο DiscardPile και άν είναι συμβατή
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile) &&BuildingList.get(0).returnSize()==(structurepicked.getTopCardValue()-1))
            {
                BuildingList.get(0).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }//Παρακάτω ελέγχω αν παίζει κάρτα απο το Discard Pile ή StockPile και ειναι καποια SkipBo
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)&& structurepicked.getTopCardValue()==0)
            {
                BuildingList.get(0).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }//Παρακάτω ελέγχω αν παίζει κάρτα απο το HandCollection και ειναι καποια SkipBo
            else if(structurepicked instanceof HandCollection &&structurepicked.getCardType(cardpicked-1).getValue()==0)
            {
                BuildingList.get(0).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else
            {
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            g.setColor(Color.yellow);
            g.drawRect(78, 139, 28, 42);
        }//Ακριβώς το ίδιο κάνω και για τα άλλα 3 Building Piles παρακάτω
        else if(selectedx1>=130 && selectedx1<=150 && selectedy1>=140 && selectedy1<=180)
        {
            if(structurepicked instanceof HandCollection && BuildingList.get(1).returnSize()==(structurepicked.getCardType(cardpicked-1).getValue()-1))
            {
                BuildingList.get(1).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)  &&BuildingList.get(1).returnSize()==(structurepicked.getTopCardValue()-1))
            {
                BuildingList.get(1).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)&& structurepicked.getTopCardValue()==0)
            {
                BuildingList.get(1).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            
            else if(structurepicked instanceof HandCollection &&structurepicked.getCardType(cardpicked-1).getValue()==0)
            {
                BuildingList.get(1).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else
            {
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            g.setColor(Color.yellow);
            g.drawRect(128, 139, 28, 42);
        }
        else if(selectedx1>=180 && selectedx1<=210 && selectedy1>=140 && selectedy1<=180)
        {
            if(structurepicked instanceof HandCollection && BuildingList.get(2).returnSize()==(structurepicked.getCardType(cardpicked-1).getValue()-1))
            {
                BuildingList.get(2).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)  &&BuildingList.get(2).returnSize()==(structurepicked.getTopCardValue()-1))
            {
                BuildingList.get(2).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)&& structurepicked.getTopCardValue()==0)
            {
                BuildingList.get(2).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            
            else if(structurepicked instanceof HandCollection &&structurepicked.getCardType(cardpicked-1).getValue()==0)
            {
                BuildingList.get(2).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else
            {
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            g.setColor(Color.yellow);
            g.drawRect(178, 139, 28, 42);
        }
        else if(selectedx1>=230 && selectedx1<=260 && selectedy1>=140 && selectedy1<=180)
        {
            if(structurepicked instanceof HandCollection && BuildingList.get(3).returnSize()==(structurepicked.getCardType(cardpicked-1).getValue()-1))
            {
                BuildingList.get(3).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)  &&BuildingList.get(3).returnSize()==(structurepicked.getTopCardValue()-1))
            {
                BuildingList.get(3).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else if((structurepicked instanceof DiscardPile || structurepicked instanceof StockPile)&& structurepicked.getTopCardValue()==0)
            {
                BuildingList.get(3).AddCard(structurepicked.getTopCard());
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            
            else if(structurepicked instanceof HandCollection &&structurepicked.getCardType(cardpicked-1).getValue()==0)
            {
                BuildingList.get(3).AddCard(structurepicked.getCard(cardpicked));
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            else
            {
                structurepicked=null;
                selectedx1=0;
                cardpicked=0;
            }
            g.setColor(Color.yellow);
            g.drawRect(228, 139, 28, 42);
        }  
        //STOCK PILE 1,Επίσης έχω if, για το αν ο παίκτης έχει clickαρει στο StockPile 1
        else if(selectedx1>=30 && selectedx1<=65&&selectedy1>=200&& selectedy1<=240&&playerplaying==1)
        {
            if(structurepicked==null)
            {
                structurepicked=sp1;//Κρατάω ότι έχει επιλέξει την StockPile 1
            }     
            g.setColor(Color.yellow);
            g.drawRect(29, 199, 28, 42);
        }
        //DISCARD 1,Στην Discard 1, κάνω ακριβώς ότι κάνω και με την Discard 2 παραπάνω
        else if(selectedx1>=80 && selectedx1<=105 && selectedy1>=200 && selectedy1<=240&&playerplaying==1)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList1.get(0))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList1.get(0).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=2;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }                                                                      //DISCARD PILE 0
            }
            else if(DiscardList1.get(0).size()!=0)
            {
                structurepicked=DiscardList1.get(0);
                g.setColor(Color.yellow);
                g.drawRect(78, 199, 28, 42);
            }            
        }
        else if(selectedx1>=130 && selectedx1<=150 && selectedy1>=200 && selectedy1<=240&&playerplaying==1)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList1.get(1))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList1.get(1).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=2;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }                                                                   //DISCARDPILE 1
            }
            else if(DiscardList1.get(1).size()!=0)
            {
                structurepicked=DiscardList1.get(1);
                g.setColor(Color.yellow);
                g.drawRect(128, 199, 28, 42);
            }            
        }
        else if(selectedx1>=180 && selectedx1<=210 && selectedy1>=200 && selectedy1<=240&&playerplaying==1)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList1.get(2))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList1.get(2).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=2;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }                                                                   //DISCARD PILE 2
            }
            else if(DiscardList1.get(2).size()!=0)
            {
                structurepicked=DiscardList1.get(2);
                g.setColor(Color.yellow);
                g.drawRect(178, 199, 28, 42);
            }
            
        }
        else if(selectedx1>=230 && selectedx1<=260 && selectedy1>=200 && selectedy1<=240&&playerplaying==1)
        {
            if(structurepicked!=null&&structurepicked!=DiscardList1.get(3))
            {
                if(structurepicked instanceof HandCollection)
                {
                    DiscardList1.get(3).addCard(structurepicked.getCard(cardpicked));
                    structurepicked=null;
                    playerplaying=2;
                    cardpicked=0;
                    selectedx1=0;
                    DealHandCollection(dp1,hc1,hc2);
                }                                                                               //DISCARD PILE 3
            }
            else if(DiscardList1.get(3).size()!=0)
            {
                structurepicked=DiscardList1.get(3);
                g.setColor(Color.yellow);
                g.drawRect(228, 199, 28, 42);
            }
            
        } 
        //HAND 1,με τo Hand1, κάνω ακριβώς ότι κάνω και με το Hand 2 παραπάνω
        else if(selectedx1>=80 && selectedx1<=105 && selectedy1>=260 && selectedy1<=300)
        {
            if(structurepicked==null&&playerplaying==1)
            {
                structurepicked=hc1;
                cardpicked=1;
            }
            g.setColor(Color.yellow);
            g.drawRect(78, 259, 28, 42);
        }
        else if(selectedx1>=130 && selectedx1<=150 && selectedy1>=260 && selectedy1<=300)
        {
            if(structurepicked==null&&playerplaying==1)
            {
                structurepicked=hc1;
                cardpicked=2;
            }
            g.setColor(Color.yellow);
            g.drawRect(128, 259, 28, 42);
        }
        else if(selectedx1>=180 && selectedx1<=210 && selectedy1>=260 && selectedy1<=300)
        {
            if(structurepicked==null&&playerplaying==1)
            {
                structurepicked=hc1;
                cardpicked=3;
            }
            g.setColor(Color.yellow);
            g.drawRect(178, 259, 28, 42);
        }
        else if(selectedx1>=230 && selectedx1<=260 && selectedy1>=260 && selectedy1<=300)
        {
            if(structurepicked==null&&playerplaying==1)
            {
                structurepicked=hc1;
                cardpicked=4;
            }
            g.setColor(Color.yellow);
            g.drawRect(228, 259, 28, 42);
        }  
        else if(selectedx1>=280 && selectedx1<=310 && selectedy1>=260 && selectedy1<=300)
        {
            if(structurepicked==null&&playerplaying==1)
            {
                structurepicked=hc1;
                cardpicked=5;
            }
            g.setColor(Color.yellow);
            g.drawRect(278, 259, 28, 42);
        }
        else
        {
            structurepicked=null;
            cardpicked=0;
        }
        for(int i=0;i<hc2.getCardsNumber();i++)//Παρακάτω ζωγραφίζω αρχικά τις κάρτες του χεριού
        {
            if(hc2.getCardType(i).getValue()==0)
            {
                if(hc2.getCardType(i) instanceof SkipBoBaladeurSimple)//Αν ειναι Simple baladeur
                {//Ζωγραφίζω σχετικά χρώματα και σχετικό String
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 31}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 49}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20, 20, 27}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60, 60, 53}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20, 20, 24}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60, 60, 56}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20, 25, 40);
                    g.drawString("SBo", 81+i*50, 40);
                    g.drawString("Sim", 81+i*50, 50);
                }
                else if(hc2.getCardType(i) instanceof SkipBoBaladeurSuper)//Ακριβώς το ίδιο κάνω και για την Super
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 31}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 49}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20, 20, 27}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60, 60, 53}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20, 20, 24}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60, 60, 56}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20, 25, 40);
                    g.drawString("SBo", 81+i*50, 40);
                    g.drawString("Sup", 81+i*50, 50);
                }
                else if(hc2.getCardType(i) instanceof SkipBoEraser)//Ακριβώς το ίδιο κάνω και για την Eraser
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 31}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 49}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20, 20, 27}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60, 60, 53}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20, 20, 24}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60, 60, 56}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20, 25, 40);
                    g.drawString("SBo", 81+i*50, 40);
                    g.drawString(" Er", 81+i*50, 50);
                }
            }//Παρακάτω ζωγραφίζω αναλογα για το αν έχω αριθμο μικροτερο του 4, δηλαδη με μπλε χρώμα
            else if(hc2.getCardType(i).getValue()<=4)
            {
                g.setColor(Color.blue);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 35}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 45}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20, 25, 40);
                g.drawString(Integer.toString(hc2.getCardType(i).getValue()), 85+i*50, 45);//εμφανίζω το περιεχόμενο της κάρτας
            }//Παρακάτω ζωγραφίζω αναλογα για το αν έχω αριθμο μικροτερο του 8, δηλαδη με πράσινο
            else if(hc2.getCardType(i).getValue()<=8)
            {
                g.setColor(Color.green);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 35}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 45}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20, 25, 40);
                g.drawString(Integer.toString(hc2.getCardType(i).getValue()), 85+i*50, 45);//εμφανίζω το περιεχόμενο της κάρτας
            }
            else if(hc2.getCardType(i).getValue()<=12)
            {//Παρακάτω ζωγραφίζω αναλογα για το αν έχω αριθμο μικροτερο του 8, δηλαδη με κόκκινο
                g.setColor(Color.red);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20, 20, 35}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60, 60, 45}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20, 25, 40);
                g.drawString(Integer.toString(hc2.getCardType(i).getValue()), 85+i*50, 45);//εμφανίζω το περιεχόμενο της κάρτας
            }
        }//Παρακάτω, με ακριβώς τον ίδιο τρόπο όπως και με την HandCollection 2, ζωγραφίζω τις κάρτες μου
        //για τις άλλες λίστες, Discard 1,Discard 2, Stock 1, Stock 2, Building Pile, Hand 1
        for(int i=-1;i<4;i++)
        {
            g.drawString(Integer.toString(sp2.getSize()), 10, 105);
            distance=60;
            if(i==-1)
            {
                if(sp2.getTopCardValue()==0)
                {
                    if(sp2.getTopCardType() instanceof SkipBoBaladeurSimple)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sim", 81+i*50, 50+distance);
                    }
                    else if(sp2.getTopCardType() instanceof SkipBoBaladeurSuper)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sup", 81+i*50, 50+distance);
                    }
                    else if(sp2.getTopCardType() instanceof SkipBoEraser)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString(" Er", 81+i*50, 50+distance);
                    }
                }
                else if(sp2.getTopCardValue()<=4)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp2.getTopCardValue()), 85+i*50, 45+distance);
                }
                else if(sp2.getTopCardValue()<=8)
                {
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp2.getTopCardValue()), 85+i*50, 45+distance);
                }
                else if(sp2.getTopCardValue()<=12)
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp2.getTopCardValue()), 85+i*50, 45+distance);
                }
            }
            else
            {
                if(DiscardList2.get(i).size()==0)
                {
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("DP", 85+i*50, 45+distance);
                }
                else if(DiscardList2.get(i).getTopCardType().getValue()==0)
                {
                    if(DiscardList2.get(i).getTopCardType() instanceof SkipBoBaladeurSimple)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sim", 81+i*50, 50+distance);
                    }
                    else if(DiscardList2.get(i).getTopCardType()  instanceof SkipBoBaladeurSuper)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sup", 81+i*50, 50+distance);
                    }
                    else if(DiscardList2.get(i).getTopCardType()  instanceof SkipBoEraser)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString(" Er", 81+i*50, 50+distance);
                    }
                }
                else if(DiscardList2.get(i).getTopCardType().getValue()<=4)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList2.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
                else if(DiscardList2.get(i).getTopCardType().getValue()<=8)
                {
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList2.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
                else if(DiscardList2.get(i).getTopCardType().getValue()<=12)
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList2.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
            }     
        }
        g.drawString("Player playing:"+ playerplaying, 280, 165);
        g.drawString(player1, 25, 285);
        g.drawString(player2, 25, 45);
        for(int i=0;i<4;i++)
        {
            distance=120;
            if(BuildingList.get(i).returnSize()==0)
                {
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("BP", 85+i*50, 45+distance);
                }
                else if(BuildingList.get(i).getTopCardValue()==0)
                {
                    if(BuildingList.get(i).getTopCard() instanceof SkipBoBaladeurSimple)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sim", 81+i*50, 50+distance);
                    }
                    else if(BuildingList.get(i).getTopCard()  instanceof SkipBoBaladeurSuper)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sup", 81+i*50, 50+distance);
                    }
                    else if(BuildingList.get(i).getTopCard()  instanceof SkipBoEraser)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString(" Er", 81+i*50, 50+distance);
                    }
                }
                else if(BuildingList.get(i).getTopCard().getValue()<=4)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(BuildingList.get(i).getTopCard().getValue()), 85+i*50, 45+distance);
                }
                else if(BuildingList.get(i).getTopCard().getValue()<=8)
                {
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(BuildingList.get(i).getTopCard().getValue()), 85+i*50, 45+distance);
                }
                else if(BuildingList.get(i).getTopCard().getValue()<=12)
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(BuildingList.get(i).getTopCard().getValue()), 85+i*50, 45+distance);
                }
        }
        for(int i=-1;i<4;i++)
        {
            g.drawString(Integer.toString(sp2.getSize()), 10, 225);
            distance=180;
            if(i==-1)
            {
                if(sp1.getTopCardValue()==0)
                {
                    if(sp1.getTopCardType() instanceof SkipBoBaladeurSimple)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sim", 81+i*50, 50+distance);
                    }
                    else if(sp1.getTopCardType() instanceof SkipBoBaladeurSuper)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40);
                        g.drawString("Sup", 81+i*50, 50);
                    }
                    else if(sp1.getTopCardType() instanceof SkipBoEraser)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString(" Er", 81+i*50, 50+distance);
                    }
                }
                else if(sp1.getTopCardValue()<=4)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp1.getTopCardValue()), 85+i*50, 45+distance);
                }
                else if(sp1.getTopCardValue()<=8)
                {
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp1.getTopCardValue()), 85+i*50, 45+distance);
                }
                else if(sp1.getTopCardValue()<=12)
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(sp1.getTopCardValue()), 85+i*50, 45+distance);
                }
            }
            else
            {
                if(DiscardList1.get(i).size()==0)
                {
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("DP", 85+i*50, 45+distance);
                }
                else if(DiscardList1.get(i).getTopCardType().getValue()==0)
                {
                    if(DiscardList1.get(i).getTopCardType() instanceof SkipBoBaladeurSimple)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20+distance, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sim", 81+i*50, 50+distance);
                    }
                    else if(DiscardList1.get(i).getTopCardType()  instanceof SkipBoBaladeurSuper)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString("Sup", 81+i*50, 50+distance);
                    }
                    else if(DiscardList1.get(i).getTopCardType()  instanceof SkipBoEraser)
                    {
                        g.setColor(Color.blue);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                        g.setColor(Color.green);
                        g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                        g.setColor(Color.red);
                        g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                        g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                        g.setColor(Color.black);
                        g.drawRect(80+i*50, 20, 25, 40);
                        g.drawString("SBo", 81+i*50, 40+distance);
                        g.drawString(" Er", 81+i*50, 50+distance);
                    }
                }
                else if(DiscardList1.get(i).getTopCardType().getValue()<=4)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList1.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
                else if(DiscardList1.get(i).getTopCardType().getValue()<=8)
                {
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList1.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
                else if(DiscardList1.get(i).getTopCardType().getValue()<=12)
                {
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString(Integer.toString(DiscardList1.get(i).getTopCardType().getValue()), 85+i*50, 45+distance);
                }
            }
        }
        for(int i=0;i<hc1.getCardsNumber();i++)
        {
            distance=240;
            if(hc1.getCardType(i).getValue()==0)
            {
                if(hc1.getCardType(i) instanceof SkipBoBaladeurSimple)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("SBo", 81+i*50, 40+distance);
                    g.drawString("Sim", 81+i*50, 50+distance);
                }
                else if(hc1.getCardType(i) instanceof SkipBoBaladeurSuper)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("SBo", 81+i*50, 40+distance);
                    g.drawString("Sup", 81+i*50, 50+distance);
                }
                else if(hc1.getCardType(i) instanceof SkipBoEraser)
                {
                    g.setColor(Color.blue);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 31+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 49+distance}, 3);
                    g.setColor(Color.green);
                    g.fillPolygon(new int[] {80+i*50+17, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 27+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+8, 80+i*50+25}, new int[] {60+distance, 60+distance, 53+distance}, 3);
                    g.setColor(Color.red);
                    g.fillPolygon(new int[] {80+i*50+10, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 24+distance}, 3);
                    g.fillPolygon(new int[] {80+i*50+25, 80+i*50+16, 80+i*50+25}, new int[] {60+distance, 60+distance, 56+distance}, 3);
                    g.setColor(Color.black);
                    g.drawRect(80+i*50, 20+distance, 25, 40);
                    g.drawString("SBo", 81+i*50, 40+distance);
                    g.drawString(" Er", 81+i*50, 50+distance);
                }
            }
            else if(hc1.getCardType(i).getValue()<=4)
            {
                g.setColor(Color.blue);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20+distance, 25, 40);
                g.drawString(Integer.toString(hc1.getCardType(i).getValue()), 85+i*50, 45+distance);
            }
            else if(hc1.getCardType(i).getValue()<=8)
            {
                g.setColor(Color.green);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20+distance, 25, 40);
                g.drawString(Integer.toString(hc1.getCardType(i).getValue()), 85+i*50, 45+distance);
            }
            else if(hc1.getCardType(i).getValue()<=12)
            {
                g.setColor(Color.red);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50}, new int[] {20+distance, 20+distance, 35+distance}, 3);
                g.fillPolygon(new int[] {80+i*50+25, 80+i*50, 80+i*50+25}, new int[] {60+distance, 60+distance, 45+distance}, 3);
                g.setColor(Color.black);
                g.drawRect(80+i*50, 20+distance, 25, 40);
                g.drawString(Integer.toString(hc1.getCardType(i).getValue()), 85+i*50, 45+distance);
            }
        }//Τέλος όποτε τελειώνουν στο γυρο του παίκτη οι κάρτες, του μοιράζω
        if(playerplaying==1 && hc1.getCardsNumber()==0)
            DealHandCollection(dp1,hc1,hc2);
        if(playerplaying==2 && hc2.getCardsNumber()==0)
            DealHandCollection(dp1,hc1,hc2);
        repaint();
    }
    public void mouseClicked(MouseEvent e) {
    }
    public void mousePressed(MouseEvent e) {//Παρακάτω κρατάω σε μεταβλητές τις συντεταγμένες του click
        selectedx1 = e.getX();
        selectedy1 = e.getY();
    }
    public void mouseReleased(MouseEvent e) {   
    }
    @Override
    public void mouseEntered(MouseEvent e) {  
    }
    @Override
    public void mouseExited(MouseEvent e){    
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
}

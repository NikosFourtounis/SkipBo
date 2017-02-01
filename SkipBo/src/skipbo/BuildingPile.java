
package skipbo;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static skipbo.Main.keyboard;

public class BuildingPile extends Structure implements Pile
{
    public void printTopCard()//Απλό Print της πρώτης κάρτας
    {
        System.out.print(" ");
        if(list.size()==0)
        {
            System.out.print("-");
            return;
        }
        else
            System.out.print(" "+list.get(list.size()-1));
    }//Επιστροφή του αριθμού των καρτών
    public int returnSize()
    {
        return list.size();
    }//Επιστροφης του Value της κάρτας στην κορυφή
    public int getTopCardValue()
    {
        return list.get(list.size()-1).value;
    }
    public ArrayList<Card> AddCard(Card card)//Function για εισαγωγη καρτων
    {//Οπου επιστρέφω ενα ArrayList<Card> αμα γεμισει με 12 καρτες η λιστα ή πεσει Eraser
        ArrayList<Card> temp=null;
        if(card instanceof SimpleCard)//Κάνω if για απλές κάρτες
        {
            if(list.size()==0)
            {//Αν η λίστα είναι άδεια μπαίνει μόνο ο άσος
                if(card.getValue()==1)
                    list.add(card);
                else//αλλιώς μήνυμα λάθους
                    System.out.println("Invalid match!");
            }
            else
            {//αν η λιστα δεν ειναι αδεια τοτε αναλογα με το value της top καρτας, ελεγχο αν μπορω να βαλω την καρτα μου
                if(list.get(list.size()-1).getValue()==card.getValue()-1)//Πρεπει να ειναι +1 η καρτα που βαζω
                {
                   list.add(card);
                }
                else
                    System.out.println("Invalid match!");
            }
            if(list.size()==12)//Και αμα γεμισει η building pile μου την αδειάζω και την επιστρεφω, οπου στην main θα την βαλω στην draw pile 
            {
                temp=list;
                list.clear();
                return temp;
            }
            else
                return temp;
        }
        else if(card instanceof SkipBoBaladeurSimple)//Αν ειναι skipbo simple παλι
        {
            if(list.size()==0)
            {//Παρομοιως με παραπανω, αν ειναι αδεια, τοτε η skip bo παιρνει τιμη 1
                ((SkipBoBaladeurSimple) card).setValue(1);
                list.add(card);
            }
            else//Αλλιως παίρνει τιμη αναλογα με την τιμη της καρτας στην κορυφη
            {
                ((SkipBoBaladeurSimple) card).setValue(list.size()+1);
                list.add(card);
            }
                
            if(list.size()==12)
            {//Επισης αδειαζω την building pile αμα γεμισει
                temp=list;
                list.clear();
                return temp;
            }
            else
                return temp;
        }
        else if(card instanceof SkipBoBaladeurSuper)
        {//Ομοιως και η super baladeur οπως και η simple
            if(list.size()==0)
            {//ΜΕ μονη διαφορα, αν η στοιβα ειναι αδεια, τοτε η skipbosuper παιρνει οτι τιμη θελει ο χρηστης
                
                int answer1;
                answer1=Integer.parseInt(JOptionPane.showInputDialog("Δώσε νούμερο για το μπαλαντέρ:"));
                for(int i=0;i<answer1-1;i++)
                {
                    list.add(new SimpleCard(1));
                }
                ((SkipBoBaladeurSuper) card).setValue(answer1);
                list.add(card);
            }
            else
            {
                ((SkipBoBaladeurSuper) card).setValue(list.size()+1);
                list.add(card);
            }   
            if(list.size()==12)
            {
                temp=list;
                list.clear();
                return temp;
            }
            else
                return temp;
        }
        else if(card instanceof SkipBoEraser)
        {//Αν ο χρηστης ριξει eraser τοτε διαγραφω την στοιβα και την επιστρεφω
            temp=list;
            list.clear();
            return temp;
        }     
        return temp;
    }

    @Override
    public Card getTopCard()
    {//Επιστροφη της top καρτας,
        return list.get(list.size()-1);
    }

}

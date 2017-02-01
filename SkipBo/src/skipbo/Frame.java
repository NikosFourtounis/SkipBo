
package skipbo;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import static skipbo.Main.hc2;
public class Frame extends JFrame
{
    DrawingPanel panel;
    public Frame (HandCollection hc2,StockPile sp2,ArrayList<DiscardPile> DiscardList2,DrawPile dp1,ArrayList<BuildingPile> BuildingList,StockPile sp1,ArrayList<DiscardPile> DiscardList1,HandCollection hc1,String player1,String player2)
    {
        super("Skip-Bo");
        panel= new DrawingPanel(dp1,hc2,sp2,DiscardList2,BuildingList,sp1,DiscardList1,hc1,player1,player2);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,350);
        setVisible(true);
    }

    
}

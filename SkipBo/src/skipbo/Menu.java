
package skipbo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menu extends JFrame implements ActionListener
{
    private JPanel row1;
    private JLabel Label1;
    private JTextField Text1;
    private JPanel row2;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JPanel row3;
    private JLabel Label3;
    private JTextField Text2;
    private String player1;
    private String player2;
      public Menu()
      {
            super("Welcome to Ski-Bo");
            row1=new JPanel();
            Label1=new JLabel("Please enter player's name", JLabel.RIGHT);
            Text1= new JTextField(10);
            row2=new JPanel();
            Button1=new JButton("Play");
            Button2=new JButton("Help");
            Button3=new JButton("Exit");
            row3=new JPanel();
            Label3 =new JLabel("Powered by Μ.Π.Ε.Σ.", JLabel.RIGHT);
            Text2= new JTextField(10);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            Container pane = getContentPane();
            GridLayout layout=new GridLayout(3,1);
            setSize(400,350);
            pane.setLayout(layout);
            FlowLayout layout1 =new FlowLayout();
            row1.setLayout(layout1);
            row1.add(Label1);
            FlowLayout layout2 =new FlowLayout();
            row2.setLayout(layout2);
            row2.add(Text1);
            row2.add(Text2);
            FlowLayout layout3= new FlowLayout();
            row3.setLayout(layout3);
            row3.add(Button1);
            row3.add(Button2);
            row3.add(Button3);
            row3.add(Label3);
            pane.add(row1);
            pane.add(row2);
            pane.add(row3);
            setContentPane(pane);
            pack();
            Button1.addActionListener(this);
            Button2.addActionListener(this);
            Button3.addActionListener(this);
            player1="";
            player2="";
      }
      public String getplayer1()
      {
          return player1;
      }
      public String getplayer2()
      {
          return player2;
      }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source==Button1)
        {
            player1=Text1.getText();
            player2=Text2.getText();
            
        }
        if(source==Button2)
        {
            JOptionPane.showMessageDialog(rootPane,"For Help please contact the emails: \n icsd13195@aegean.gr \n nickfortune@windowslive.com");
        }
        if(source==Button3)
        {
            System.exit(0);
        }
        
    }
}

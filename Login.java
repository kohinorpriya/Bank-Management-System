import javax.swing.*;
import java.awt.*;

public class Login extends JFrame{

    Login(){
        //Add bank icon 2
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/bank logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel lable = new JLabel(i3);
        lable.setBounds(70,10,100,100);
        add(lable);

        //text part 4
        JLabel text = new JLabel("Welcome to Bank");
        add(text);
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Oswards", Font.BOLD, 38));

        //text part 5
        JLabel CardNo = new JLabel("Card No:");
        add(CardNo);
        CardNo.setBounds(120,150,400,40);
        CardNo.setFont(new Font("Raleway", Font.BOLD, 28));

        //text part 6
        JLabel Pin = new JLabel("PIN:");
        add(Pin);
        Pin.setBounds(120,220,400,40);
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));

        //Backround color 3
        getContentPane().setBackground(Color.yellow);


        //set title 1
        setTitle("Bank log in frame");
        setLayout(null);

        //set frame height weight
        setSize(800,480);

        //frame visible
        setVisible(true);

        //set where it shows
        setLocation(550,350);
    }
    public static void main(String[] args){
        new Login();
    }
}

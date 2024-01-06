import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.util.*;

public class Pinchange extends JFrame implements ActionListener {
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;


    Pinchange(String pinnumber){

        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);



        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 320,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 360,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330,360,180,25);
        image.add(repin);


        change = new JButton("BACK");
        change.setBounds(365,480,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("CHANGE");
        back.setBounds(365,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();


                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enter pin does not match");
                    return;
                }
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                }

                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                }

                Connect c = new Connect();
                String query1 = "'Update bank set pin -'"+rpin+"' where pin-' "+pinnumber+"'";
                String query2 = "'Update login set pin -'"+rpin+"' where pin-' "+pinnumber+"'";
                String query3 = "'Update signupthree set pin -'"+rpin+"' where pin-' "+pinnumber+"'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN change successfully");


                setVisible(false);
                new Transactons(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);

            }

        } else {
            setVisible(false);
            new Transactons(pinnumber).setVisible(true);
        }
    }

    public static void main(String [] args){
        new Pinchange("").setVisible(true);


    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactons extends JFrame implements ActionListener {

    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;

    String pinnumber;
    Transactons( String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16 ));
        image.add(text);


        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);


        withdraw = new JButton("Withdraw");
        withdraw.setBounds(335, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(335, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(335, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(335, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
            
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);

        }

    }

    public static void main(String [] args){
        new Transactons("");

    }
}

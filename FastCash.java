import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;

    String pinnumber;
    FastCash( String pinnumber){
        setLayout(null);
        this.pinnumber = pinnumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image/Atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Select withdraw amount");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16 ));
        image.add(text);


        deposit = new JButton("Tk 1000");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);


        withdraw = new JButton("TK 5000");
        withdraw.setBounds(335, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);


        fastcash = new JButton("Tk 10000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Tk 15000");
        ministatement.setBounds(335, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("TK 20000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);


        balanceenquiry = new JButton("TK 25000");
        balanceenquiry.setBounds(335, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Back");
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

            setVisible(false);
            new Transactons(pinnumber).setVisible(true);
        }

         else{
            String amount =((JButton)ae.getSource()).getText().substring(3); // TK r space bad porbe
            Connect c = new Connect();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin =  '"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance -=Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Tk" + amount + "Debited Successfully");


                setVisible(false);
                new Transactons(pinnumber).setVisible(true);

            }catch(Exception e){
                System.out.println(e);

            }


        }

    }

    public static void main(String [] args){
        new FastCash("");

    }
}

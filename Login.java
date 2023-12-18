import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener{
    JButton Login, Clear, Signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

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
        CardNo.setBounds(120,150,150,30);
        CardNo.setFont(new Font("Raleway", Font.BOLD, 28));

        // input field for card

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD , 14));
        add(cardTextField);

        //text part 6
        JLabel Pin = new JLabel("PIN:");
        add(Pin);
        Pin.setBounds(120,220,250,30);
        Pin.setFont(new Font("Raleway", Font.BOLD, 28));

        // input field for pin

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD , 14));
        add(pinTextField);

        Login = new JButton("Sign In");
        Login.setBounds(300,300,100,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Clear = new JButton("Clear");
        Clear.setBounds(430,300,100,30);
        Clear.setBackground(Color.BLACK);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);


        Signup = new JButton("Sign Up");
        Signup.setBounds(300,350,230,30);
        Signup.setBackground(Color.BLACK);
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        add(Signup);


        //Background color 3
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
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()== Login){

        } else if (ae.getSource() == Signup) {
            setVisible(false);
            new Signup().setVisible(true);
            
        }

    }
    public static void main(String[] args){
        new Login();
    }
}

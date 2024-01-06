import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan, nid,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    ButtonGroup maritalgroup;
    JComboBox religion, category, occupation, education, income;
    String formno;



    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Application Form - page 2");


        JLabel additionalDetails = new JLabel("Page 2: Additional Details" );
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);


        //for option
        JLabel name = new JLabel("Religion:" );
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);

        //for dropdown

        String valReligion[] = {"Hindu","Muslim", "Sikb", "Christians", "Other"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);



        JLabel fname = new JLabel("Category:" );
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);


        JLabel dob = new JLabel("Income:" );
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomcategory[] = {"Null" , "< 1,50,000" , "< 2,50,000" , "< 5,00,000", "Upto 10,00,000"};

        income = new JComboBox<>(incomcategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel gender = new JLabel("Educational" );
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);






        JLabel Email = new JLabel("Qualification:" );
        Email.setFont(new Font("Raleway", Font.BOLD, 20));
        Email.setBounds(100,315,200,30);
        add(Email);

        String educationVlues[] = {"SSC" , "HSC" , "Graduation" , "Post-Graduation", "Doctorate", "Others"};

        education = new JComboBox<>(educationVlues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

//        emailTextField = new JTextField();
//        emailTextField.setFont(new Font("Raleway", Font.BOLD, 20));
//        emailTextField.setBounds(300,315,400,30);
//        add(emailTextField);

        JLabel marital = new JLabel("Occupation:" );
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);


        String occupationvalue[] = {"Salaried" , "Self-Employed" , "Business" , "Student", "Retired", "Others"};

        occupation = new JComboBox<>(occupationvalue);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel address = new JLabel("Nationalitty:" );
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(300,440,400,30);
        add(pan);

        JLabel city = new JLabel("NID:" );
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);

        nid = new JTextField();
        nid.setFont(new Font("Raleway", Font.BOLD, 20));
        nid.setBounds(300,490,400,30);
        add(nid);

        JLabel state = new JLabel("Senior Citizen:" );
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,390,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,390,120,30);
        sno.setBackground(Color.WHITE);
        add(sno);


        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);


        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("Existing Account:" );
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,390,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,390,120,30);
        eno.setBackground(Color.WHITE);
        add(eno);


        maritalgroup = new ButtonGroup();
        maritalgroup.add(eyes);
        maritalgroup.add(eno);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formo ="";
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(sno.isSelected()) {
            seniorcitizen = "No";
        }

//        String email = emailTextField.getText();
//        , '"+email+"'
        String existingaccount = null;
        if(eyes.isSelected()){
            existingaccount = "Yes";
        } else if (eno.isSelected()){
            existingaccount = "No";
        }

        String span = pan.getText();
        String snid = nid.getText();


        try{

                Connect c = new Connect();
                String query = "insert into singuptwo values('"+formo +"', '"+sreligion+"' , '"+scategory+"' , '"+sincome+"' ,'"+seducation+"' ,'"+soccupation+"', '"+seniorcitizen+"' , '"+span+"' , '"+snid+"'  , '"+existingaccount+"')";
                c.s.executeUpdate(query);

                //signup three object



        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String [] args){
        new SignupTwo("");
    }

}

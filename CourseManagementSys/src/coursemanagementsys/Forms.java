package coursemanagementsys;



import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;




public class Forms  {
  
    static String current;
    boolean p;
    

    public JFrame loginForm  (){
        JFrame f = new JFrame("Login");
        
        
        JLabel loginLp = new JLabel("Login");
        loginLp.setFont(new Font("Lato",Font.BOLD,20));
        loginLp.setForeground(new Color(45, 52, 54));
        loginLp.setBounds(160,30,70,50);
        f.add(loginLp);
        
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 150, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);
        
        JLabel Login_asLp = new JLabel("Login as");
        Login_asLp.setFont(new Font("Lato",Font.BOLD,15));
        Login_asLp.setForeground(new Color(45, 52, 54));
        Login_asLp.setBounds(30,193,80,50);
        f.add(Login_asLp);
        
        String []LoginAs = {"Student","Instructor","Admin"};
        JComboBox LoginList = new JComboBox(LoginAs);
        LoginList.setSelectedIndex(0);
        LoginList.setBounds(140,207,200,25);
        LoginList.setBackground(Color.WHITE);
        LoginList.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(LoginList);
        
        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(52,73,94));
        loginBtn.setBounds(155,270,80,40);
        loginBtn.setForeground(Color.WHITE); 
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(loginBtn);
        
        
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{   
             Database database = new Database(); 
             Interfaces interfaces = new Interfaces(); 
             boolean checkUserType=false;
             
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String login_as = String.valueOf(LoginList.getSelectedItem());
             current = username;
           
             switch(login_as){
                 case "Student":
                     checkUserType = database.LoginAsStudent(username, password);
                     if(checkUserType)
                     {
                         
                        interfaces.StudentInterface();
                        usernameTextField.setText(null);
                        passwordTextField.setText(null);  
                     }
                     else
                     {
                        JOptionPane.showMessageDialog(null,"Incorrect Username or Password\ntipe: Make sure you selected the right user type","Got an exception!",JOptionPane.ERROR_MESSAGE);  
                        usernameTextField.setText(null);
                        passwordTextField.setText(null);                          
                     }    
                     break;
                 case "Instructor":
                    checkUserType = database.LoginAsInstructor(username, password);
                     if(checkUserType)
                     { 
                        interfaces.InstructorInterface();
                        usernameTextField.setText(null);
                        passwordTextField.setText(null); 
                        f.setVisible(false);
                     }
                     else
                     {
                        JOptionPane.showMessageDialog(null,"Incorrect Username or Password\ntipe: Make sure you selected the right user type","Got an exception!",JOptionPane.ERROR_MESSAGE); 
                        usernameTextField.setText(null);
                        passwordTextField.setText(null);
                     }
                      
                      
                     break;
                 case "Admin":
                     checkUserType = database.LoginAsAdmin(username, password);
                     if(checkUserType)
                     { 
                        interfaces.AdminInterface();
                        usernameTextField.setText(null);
                        passwordTextField.setText(null); 
                        f.setVisible(false);
                     }
                     else
                     {
                        JOptionPane.showMessageDialog(null,"Incorrect Username or Password\ntipe: Make sure you selected the right user type","Got an exception!",JOptionPane.ERROR_MESSAGE); 
                        usernameTextField.setText(null);
                        passwordTextField.setText(null);
                     }                     
                     break;
             }
            
                          }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }
             
             
            }
        });        
        
             
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 400);
        f.setResizable(false);
        f.setVisible(true); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(209, 216, 224));
        
        return f;
     }
    


    public JFrame signUpStudentForm  (){
        JFrame f = new JFrame("Student sign up");
        
        JLabel StudentSignUpLp = new JLabel("New Student");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(135,30,300,50);
        f.add(StudentSignUpLp);      
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);   
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54)); 
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);       
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);       
        
        JLabel majorLp = new JLabel("Major");
        majorLp.setFont(new Font("Lato",Font.BOLD,15));
        majorLp.setForeground(new Color(45, 52, 54)); 
        majorLp.setBounds(30,390,80,50);
        f.add(majorLp);       
        
        String []Major = {"CS","IS","CN"};
        JComboBox MajorList = new JComboBox(Major);
        MajorList.setBounds(140,405,200,25);
        MajorList.setSelectedItem(null);
        MajorList.setBackground(new Color(99, 110, 114));
        MajorList.setBorder(new LineBorder(new Color(99, 110, 114)));
        MajorList.setForeground(Color.WHITE);
        f.add(MajorList);       
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,480,100,50);
        submitBtn.setForeground(Color.WHITE); 
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               try{ 
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             int phone =  Integer.parseInt(phoneTextField.getText());
             String major = String.valueOf(MajorList.getSelectedItem());
             
             database.NewStudent(username, password, firstName, lastName, phone, email,major);
             f.setVisible(false);
                 }
              catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
                 }             
             
            }
        });        
        
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }
    

    
    public JFrame signUpInstructorForm  (){
        JFrame f = new JFrame("Instructor sign up");
        
        JLabel StudentSignUpLp = new JLabel("New Instructor");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(135,30,300,50);
        f.add(StudentSignUpLp);
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);   
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);       
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54)); 
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);      
        
        JLabel departmentLp = new JLabel("Department");
        departmentLp.setFont(new Font("Lato",Font.BOLD,15));
        departmentLp.setForeground(new Color(45, 52, 54));
        departmentLp.setBounds(30,390,90,50);
        f.add(departmentLp);      
        
        String []department = {"CS","IS","CN"};
        JComboBox departmentList = new JComboBox(department);
        departmentList.setBounds(140,405,200,25);
        departmentList.setBackground(new Color(99, 110, 114));
        departmentList.setBorder(new LineBorder(new Color(99, 110, 114)));
        departmentList.setSelectedItem(null);
        departmentList.setForeground(Color.WHITE);
        f.add(departmentList);   
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,480,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{  
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             String department = String.valueOf(departmentList.getSelectedItem());
             int phone =  Integer.parseInt(phoneTextField.getText());
             
             database.NewInstructor(username, password, firstName, lastName, phone, email,department);
             f.setVisible(false);
               }
              catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
               }             
            }
        });
        
        f.setLayout(null);
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }    

    
    public JFrame signUpAdminForm  (){
        JFrame f = new JFrame("Admin sign up");
        
        JLabel StudentSignUpLp = new JLabel("New Admin");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(135,30,300,50);
        f.add(StudentSignUpLp);      
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);    
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54)); 
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);     
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);     
               
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,430,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               try{ 
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             int phone =  Integer.parseInt(phoneTextField.getText());
             
             database.NewAdmin(username, password, firstName, lastName, phone, email);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });
 
        
        
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 550);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }   
    
    

    
    public JFrame signUpCourseForm  (){
        JFrame f = new JFrame("Course sign up");
        
        JLabel StudentSignUpLp = new JLabel("New Course");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54)); 
        StudentSignUpLp.setBounds(140,30,300,50);
        f.add(StudentSignUpLp);     
       
        JLabel usernameLp = new JLabel("Name");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField courseNameTextField = new JTextField(15);
        courseNameTextField.setBackground(new Color(236,240,241));
        courseNameTextField.setBounds(140, 105, 200, 25);
        courseNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(courseNameTextField);
 
        JLabel firstNameLp = new JLabel("Section");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,140,80,50);
        f.add(firstNameLp);
        
        String []section = {"1","2","3","4"};
        JComboBox sectionList = new JComboBox(section);
        sectionList.setBounds(140, 155, 200, 25);
        sectionList.setBackground(new Color(99, 110, 114));
        sectionList.setBorder(new LineBorder(new Color(99, 110, 114)));
        sectionList.setSelectedItem(null);
        sectionList.setForeground(Color.WHITE);
        f.add(sectionList);
        
        JLabel lastNameLp = new JLabel("Day");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,190,80,50);
        f.add(lastNameLp);
        
        String []days = {"Suday","Monday","Tuesday","Wednesday","Thursday"};
        JComboBox daysList = new JComboBox(days);
        daysList.setBounds(140, 205, 200, 25);
        daysList.setBackground(new Color(99, 110, 114));
        daysList.setBorder(new LineBorder(new Color(99, 110, 114)));
        daysList.setSelectedItem(null);
        daysList.setForeground(Color.WHITE);
        f.add(daysList);
        
        JLabel phoneLp = new JLabel("Time");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,240,80,50);
        f.add(phoneLp);
        
        String []time = {"91015","10301145","13001415","14301545","16001715"};
        JComboBox timeList = new JComboBox(time);
        timeList.setBounds(140, 255, 200, 25);
        timeList.setBackground(new Color(99, 110, 114));
        timeList.setBorder(new LineBorder(new Color(99, 110, 114)));
        timeList.setSelectedItem(null);
        timeList.setForeground(Color.WHITE);
        f.add(timeList);
        
        JLabel EmailLp = new JLabel("Instructor");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,290,80,50);
        f.add(EmailLp);
        
        Database d = new Database();
        JComboBox instructorsList = d.instructorList();
        instructorsList.setBounds(140, 305, 200, 25);
        instructorsList.setBackground(new Color(99, 110, 114));
        instructorsList.setBorder(new LineBorder(new Color(99, 110, 114)));
        instructorsList.setSelectedItem(null);
        instructorsList.setForeground(Color.WHITE);
        f.add(instructorsList);      
 
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(140,480,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
             submitBtn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
              try{   
             Database database = new Database();
             String name = courseNameTextField.getText(); 
             int section =Integer.parseInt( String.valueOf(sectionList.getSelectedItem()));
             String day = String.valueOf(daysList.getSelectedItem());
             String time = String.valueOf(timeList.getSelectedItem());
             String instructor = String.valueOf(instructorsList.getSelectedItem());
                
             database.NewCourse(name,section,day,time,instructor);
             f.setVisible(false);
             
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }
    

    
    public JFrame removeAdminForm(){
        JFrame f = new JFrame("Remove Admin");

        JLabel removeAdminLb = new JLabel("Remove Admin");
        removeAdminLb.setFont(new Font("Lato",Font.BOLD,20));
        removeAdminLb.setForeground(new Color(45, 52, 54));
        removeAdminLb.setBounds(118,20,150,50);
        f.add(removeAdminLb);
        
        JLabel adminIDLb = new JLabel("Admin ID");
        adminIDLb.setFont(new Font("Lato",Font.BOLD,15));
        adminIDLb.setForeground(new Color(45, 52, 54));
        adminIDLb.setBounds(157,80,75,50);
        f.add(adminIDLb);
        
        JTextField removeAdminTextField = new JTextField(15);
        removeAdminTextField.setBackground(new Color(236,240,241));
        removeAdminTextField.setBounds(90, 130, 200, 25);
        removeAdminTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(removeAdminTextField);
        
        JButton removeAdminBtn = new JButton("REMOVE");
        removeAdminBtn.setBounds(142, 180, 100,40);
        removeAdminBtn.setBackground(new Color(52,73,94));
        removeAdminBtn.setForeground(Color.WHITE);
        removeAdminBtn.setFocusPainted(false);
        removeAdminBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeAdminBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeAdminBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try{
             Database database = new Database();   
             int id =  Integer.parseInt(removeAdminTextField.getText());
             if(id != 1)                 
             database.removeAdmin(id);
             else
              JOptionPane.showMessageDialog(null,"You can't Delete This Admin","Error",JOptionPane.ERROR_MESSAGE);
             
                          }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }
            }
        });        
        f.add(removeAdminBtn);
        
        f.setLayout(null);
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }
    

    
    public JFrame removeInstructorForm(){
        JFrame f = new JFrame("Remove Instructor");

        JLabel removeInstructorLb = new JLabel("Remove Instructor");
        removeInstructorLb.setFont(new Font("Lato",Font.BOLD,20));
        removeInstructorLb.setForeground(new Color(45, 52, 54));
        removeInstructorLb.setBounds(118,20,200,50);
        f.add(removeInstructorLb);
        
        JLabel instructorIDLb = new JLabel("Instructor ID");
        instructorIDLb.setFont(new Font("Lato",Font.BOLD,15));
        instructorIDLb.setForeground(new Color(45, 52, 54));
        instructorIDLb.setBounds(157,80,150,50);
        f.add(instructorIDLb);
        
        JTextField removeInstructorTextField = new JTextField(15);
        removeInstructorTextField.setBackground(new Color(236,240,241));
        removeInstructorTextField.setBounds(90, 130, 200, 25);
        removeInstructorTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(removeInstructorTextField);
        
        JButton removeInstructorBtn = new JButton("REMOVE");
        removeInstructorBtn.setBounds(142, 180, 100,40);
        removeInstructorBtn.setBackground(new Color(52,73,94));
        removeInstructorBtn.setForeground(Color.WHITE);
        removeInstructorBtn.setFocusPainted(false);
        removeInstructorBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeInstructorBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeInstructorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               try{ 
             Database database = new Database();   
             int id =  Integer.parseInt(removeInstructorTextField.getText());
             
             database.removeInstructor(id);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        f.add(removeInstructorBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }    
    

    
    public JFrame removeStudentForm(){
        JFrame f = new JFrame("Remove Student");

        JLabel removeStudentLb = new JLabel("Remove Student");
        removeStudentLb.setFont(new Font("Lato",Font.BOLD,20));
        removeStudentLb.setForeground(new Color(45, 52, 54));
        removeStudentLb.setBounds(118,20,200,50);
        f.add(removeStudentLb);
        
        JLabel studentIDLb = new JLabel("Student ID");
        studentIDLb.setFont(new Font("Lato",Font.BOLD,15));
        studentIDLb.setForeground(new Color(45, 52, 54));
        studentIDLb.setBounds(157,80,150,50);
        f.add(studentIDLb);
        
        JTextField removeStudentTextField = new JTextField(15);
        removeStudentTextField.setBackground(new Color(236,240,241));
        removeStudentTextField.setBounds(90, 130, 200, 25);
        removeStudentTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(removeStudentTextField);
        
        JButton removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(142, 180, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{  
             Database database = new Database();   
             int id =  Integer.parseInt(removeStudentTextField.getText());
             
             database.removeStudent(id);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    } 
    
    
    public JFrame removeCourseForm(){
        JFrame f = new JFrame("Remove Course");

        JLabel removeStudentLb = new JLabel("Remove Course");
        removeStudentLb.setFont(new Font("Lato",Font.BOLD,20));
        removeStudentLb.setForeground(new Color(45, 52, 54));
        removeStudentLb.setBounds(118,20,200,50);
        f.add(removeStudentLb);
        
        JLabel studentIDLb = new JLabel("Course CRN");
        studentIDLb.setFont(new Font("Lato",Font.BOLD,15));
        studentIDLb.setForeground(new Color(45, 52, 54));
        studentIDLb.setBounds(157,80,150,50);
        f.add(studentIDLb);
        
        JTextField removeStudentTextField = new JTextField(15);
        removeStudentTextField.setBackground(new Color(236,240,241));
        removeStudentTextField.setBounds(90, 130, 200, 25);
        removeStudentTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(removeStudentTextField);
        
        JButton removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(142, 180, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int id =  Integer.parseInt(removeStudentTextField.getText());
             
             database.removeCourse(id);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }
    
    
public JFrame removeAssignmetForm(){
        JFrame f = new JFrame("Remove Assignmet");

        JLabel removeLb = new JLabel("Remove Assignmet");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(118,20,200,50);
        f.add(removeLb);
        
        JLabel numLb = new JLabel("Assignmet No.");
        numLb.setFont(new Font("Lato",Font.BOLD,15));
        numLb.setForeground(new Color(45, 52, 54));
        numLb.setBounds(157,80,150,50);
        f.add(numLb);
        
        JTextField removeTextField = new JTextField(15);
        removeTextField.setBackground(new Color(236,240,241));
        removeTextField.setBounds(90, 130, 200, 25);
        removeTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(removeTextField);
        
        JButton removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(142, 180, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int num =  Integer.parseInt(removeTextField.getText());
             
             database.removeAssignmet(num);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }

public JFrame removeMarkForm(){
        JFrame f = new JFrame("Remove Mark");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Remove Mark");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(118,20,200,50);
        f.add(removeLb);
        
        JLabel tLb = new JLabel("Select Assignment");
        tLb.setFont(new Font("Lato",Font.BOLD,15));
        tLb.setForeground(new Color(45, 52, 54));
        tLb.setBounds(157,80,150,50);
        f.add(tLb);
        
        JComboBox TTF = db.marksList();
        TTF.setBackground(new Color(52,73,94));
        TTF.setForeground(Color.WHITE);
        TTF.setBounds(90, 130, 200, 25);
        TTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TTF);
        
        JLabel numLb = new JLabel("Select Student");
        numLb.setFont(new Font("Lato",Font.BOLD,15));
        numLb.setForeground(new Color(45, 52, 54));
        numLb.setBounds(157,180,150,50);
        f.add(numLb);
        
        JComboBox TnamTF = db.StudentList();
        TnamTF.setBackground(new Color(52,73,94));
        TnamTF.setForeground(Color.WHITE);
        TnamTF.setBounds(90, 230, 200, 25);
        TnamTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TnamTF);
       
        
        
        JButton removeBtn = new JButton("REMOVE");
        removeBtn.setBounds(142, 280, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String TName =  String.valueOf(TTF.getSelectedItem());
             String SName =  String.valueOf(TnamTF.getSelectedItem());
             database.removeMark(TName, SName);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 400);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }


public JFrame addStudentCourse(){
        JFrame f = new JFrame("Add Course");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Add Course");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(140,20,200,50);
        f.add(removeLb);
        
        JLabel courseLp = new JLabel("Course Name :");
        courseLp.setFont(new Font("Lato",Font.BOLD,16));
        courseLp.setForeground(new Color(45, 52, 54));
        courseLp.setBounds(140,80,200,50);        
        f.add(courseLp);
        
        JComboBox courseList = db.courseListS();
        courseList.setBounds(10, 135, 370, 25);
        courseList.setBackground(new Color(52,73,94));
        courseList.setBorder(new LineBorder(new Color(99, 110, 114)));
        courseList.setSelectedItem(null);
        courseList.setForeground(Color.WHITE);
        f.add(courseList);
   
        
        JButton Btn = new JButton("ADD");
        Btn.setBounds(142, 180, 100,40);
        Btn.setBackground(new Color(52,73,94));
        Btn.setForeground(Color.WHITE);
        Btn.setFocusPainted(false);
        Btn.setFont(new Font("Lato",Font.BOLD,15));
        Btn.setBorder(new LineBorder(new Color(52,73,94)));
        Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{  
             Database database = new Database();
             String AName =  String.valueOf(courseList.getSelectedItem());
             if(database.CheckStudentCourseName(AName)){
                 if(database.CheckStudentCourseTime(AName)){
             database.NewStudentCourse(AName);
             f.setVisible(false);
                 }
             else
             JOptionPane.showMessageDialog(null,"you can't add this course","Got an exception!",JOptionPane.ERROR_MESSAGE); 
             }
   
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }
            }
        });        
        f.add(Btn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }

public JFrame removeStudentCourse(){
        JFrame f = new JFrame("Remove Course");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Remove Course");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(140,20,200,50);
        f.add(removeLb);
        
        JLabel courseLp = new JLabel("Course Name :");
        courseLp.setFont(new Font("Lato",Font.BOLD,16));
        courseLp.setForeground(new Color(45, 52, 54));
        courseLp.setBounds(140,80,200,50);        
        f.add(courseLp);
        
        JComboBox courseList = db.courseListS();
        courseList.setBounds(10, 135, 370, 25);
        courseList.setBackground(new Color(52,73,94));
        courseList.setBorder(new LineBorder(new Color(99, 110, 114)));
        courseList.setSelectedItem(null);
        courseList.setForeground(Color.WHITE);
        f.add(courseList);
   
        
        JButton Btn = new JButton("Remove");
        Btn.setBounds(142, 180, 100,40);
        Btn.setBackground(new Color(52,73,94));
        Btn.setForeground(Color.WHITE);
        Btn.setFocusPainted(false);
        Btn.setFont(new Font("Lato",Font.BOLD,15));
        Btn.setBorder(new LineBorder(new Color(52,73,94)));
        Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String AName =  String.valueOf(courseList.getSelectedItem());
             database.removeStudentCourse(AName);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }
                          
            }
        });        
        f.add(Btn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }



    public JFrame editAdminForm(){
        JFrame f = new JFrame("Edit Admin");
        
        JLabel StudentSignUpLp = new JLabel("Edit Admin");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(135,30,300,50);
        f.add(StudentSignUpLp);      
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54)); 
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);      
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);       
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);       
               
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,430,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{  
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             int phone =  Integer.parseInt(phoneTextField.getText());
             
             database.updateAdmin(username, password, firstName, lastName, phone, email);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }
                          
            }
        });
        
        
        
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 550);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;

}
    
    
    
    
    public JFrame editAdminFirstForm(){
        JFrame f = new JFrame("Edit Admin");

        JLabel editAdminLb = new JLabel("Edit Admin");
        editAdminLb.setFont(new Font("Lato",Font.BOLD,20));
        editAdminLb.setForeground(new Color(45, 52, 54)); 
        editAdminLb.setBounds(140,20,150,50);
        f.add(editAdminLb);
        
        JLabel adminIDLb = new JLabel("Admin ID");
        adminIDLb.setFont(new Font("Lato",Font.BOLD,15));
        adminIDLb.setForeground(new Color(45, 52, 54));
        adminIDLb.setBounds(157,80,75,50);
        f.add(adminIDLb);
        
        JTextField editAdminTextField = new JTextField(15);
        editAdminTextField.setBackground(new Color(236,240,241));
        editAdminTextField.setBounds(90, 130, 200, 25);
        editAdminTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(editAdminTextField);
        
        JButton editAdminBtn = new JButton("EDIT");
        editAdminBtn.setBounds(142, 180, 100,40);
        editAdminBtn.setBackground(new Color(52,73,94));
        editAdminBtn.setForeground(Color.WHITE);
        editAdminBtn.setFocusPainted(false);
        editAdminBtn.setFont(new Font("Lato",Font.BOLD,15));
        editAdminBtn.setBorder(new LineBorder(new Color(52,73,94)));
        editAdminBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int id =  Integer.parseInt(editAdminTextField.getText());
 
             if(id != 1){  
             if (database.CheckUpdateAdmin(id)){
             f.setVisible(false);
             editAdminForm();
             
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine ID","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
             else
             JOptionPane.showMessageDialog(null,"You can't change This Admin","Error",JOptionPane.ERROR_MESSAGE);
             
              }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }            
             
            }
        });        
        f.add(editAdminBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }
    
 
    
   public JFrame editInstructorForm  (){
        JFrame f = new JFrame("Edit Instructor");
        
        JLabel StudentSignUpLp = new JLabel("Edit Instructor");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(130,30,300,50);
        f.add(StudentSignUpLp);      
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);     
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);     
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);     
        
        JLabel departmentLp = new JLabel("Department");
        departmentLp.setFont(new Font("Lato",Font.BOLD,15));
        departmentLp.setForeground(new Color(45, 52, 54));
        departmentLp.setBounds(30,390,90,50);
        f.add(departmentLp);       
        
        String []department = {"CS","IS","CN"};
        JComboBox departmentList = new JComboBox(department);
        departmentList.setBounds(140,405,200,25);
        departmentList.setBackground(new Color(99, 110, 114));
        departmentList.setBorder(new LineBorder(new Color(99, 110, 114)));
        departmentList.setSelectedItem(null);
        departmentList.setForeground(Color.WHITE);
        f.add(departmentList);    
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,480,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             String department = String.valueOf(departmentList.getSelectedItem());
             int phone =  Integer.parseInt(phoneTextField.getText());
             
             database.updateInstructor(username, password, firstName, lastName, phone, email,department);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }     
    
   
   public JFrame editInstructorFirstForm(){
        JFrame f = new JFrame("Update Instructor");

        JLabel editInstructorLb = new JLabel("Update Instructor");
        editInstructorLb.setFont(new Font("Lato",Font.BOLD,20));
        editInstructorLb.setForeground(new Color(45, 52, 54));
        editInstructorLb.setBounds(118,20,200,50);
        f.add(editInstructorLb);
        
        JLabel instructorIDLb = new JLabel("Instructor ID");
        instructorIDLb.setFont(new Font("Lato",Font.BOLD,15));
        instructorIDLb.setForeground(new Color(45, 52, 54));
        instructorIDLb.setBounds(157,80,150,50);
        f.add(instructorIDLb);
        
        JTextField editInstructorTextField = new JTextField(15);
        editInstructorTextField.setBackground(new Color(236,240,241));
        editInstructorTextField.setBounds(90, 130, 200, 25);
        editInstructorTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(editInstructorTextField);
        
        JButton editInstructorBtn = new JButton("EDIT");
        editInstructorBtn.setBounds(142, 180, 100,40);
        editInstructorBtn.setBackground(new Color(52,73,94));
        editInstructorBtn.setForeground(Color.WHITE);
        editInstructorBtn.setFocusPainted(false);
        editInstructorBtn.setFont(new Font("Lato",Font.BOLD,15));
        editInstructorBtn.setBorder(new LineBorder(new Color(52,73,94)));
        editInstructorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
              try{  
             Database database = new Database();   
             int id =  Integer.parseInt(editInstructorTextField.getText());
             
             if (database.CheckUpdateInstructor(id)){
             f.setVisible(false);
             editInstructorForm();
             
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine ID","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(editInstructorBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }    
    
   
    public JFrame editStudentForm  (){
        JFrame f = new JFrame("Edit Student");
        
        JLabel StudentSignUpLp = new JLabel("Edit Student");
        StudentSignUpLp.setFont(new Font("Lato",Font.BOLD,20));
        StudentSignUpLp.setForeground(new Color(45, 52, 54));
        StudentSignUpLp.setBounds(140,30,300,50);
        f.add(StudentSignUpLp);     
       
        JLabel usernameLp = new JLabel("Username");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField usernameTextField = new JTextField(15);
        usernameTextField.setBackground(new Color(236,240,241));
        usernameTextField.setBounds(140, 105, 200, 25);
        usernameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(usernameTextField);
        
        JLabel passwordLp = new JLabel("Password");
        passwordLp.setFont(new Font("Lato",Font.BOLD,15));
        passwordLp.setForeground(new Color(45, 52, 54));
        passwordLp.setBounds(30,140,80,50);
        f.add(passwordLp);
        
        JPasswordField passwordTextField = new JPasswordField(15);
        passwordTextField.setBackground(new Color(236,240,241));
        passwordTextField.setBounds(140, 155, 200, 25);
        passwordTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(passwordTextField);      
        
        JLabel firstNameLp = new JLabel("First Name");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,190,80,50);
        f.add(firstNameLp);
        
        JTextField firstNameTextField = new JTextField(15);
        firstNameTextField.setBackground(new Color(236,240,241));
        firstNameTextField.setBounds(140, 205, 200, 25);
        firstNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(firstNameTextField);
        
        JLabel lastNameLp = new JLabel("Last name");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,240,80,50);
        f.add(lastNameLp);
        
        JTextField lastNameTextField = new JTextField(15);
        lastNameTextField.setBackground(new Color(236,240,241));
        lastNameTextField.setBounds(140, 255, 200, 25);
        lastNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(lastNameTextField);    
        
        JLabel phoneLp = new JLabel("Phone");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54));
        phoneLp.setBounds(30,290,80,50);
        f.add(phoneLp);
        
        JTextField phoneTextField = new JTextField(15);
        phoneTextField.setBackground(new Color(236,240,241));
        phoneTextField.setBounds(140, 305, 200, 25);
        phoneTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(phoneTextField);
        
        JLabel EmailLp = new JLabel("Email");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,340,80,50);
        f.add(EmailLp);
        
        JTextField emailTextField = new JTextField(15);
        emailTextField.setBackground(new Color(236,240,241));
        emailTextField.setBounds(140, 355, 200, 25);
        emailTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(emailTextField);      
        
        JLabel majorLp = new JLabel("Major");
        majorLp.setFont(new Font("Lato",Font.BOLD,15));
        majorLp.setForeground(new Color(45, 52, 54));
        majorLp.setBounds(30,390,80,50);
        f.add(majorLp);      
        
        String []Major = {"CS","IS","CN"};
        JComboBox MajorList = new JComboBox(Major);
        MajorList.setBounds(140,405,200,25);
        MajorList.setSelectedItem(null);
        MajorList.setBackground(new Color(99, 110, 114));
        MajorList.setBorder(new LineBorder(new Color(99, 110, 114)));
        MajorList.setForeground(Color.WHITE);
        f.add(MajorList);
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(145,480,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String username = usernameTextField.getText();
             String password = new String(passwordTextField.getPassword());
             String firstName = firstNameTextField.getText();
             String lastName = lastNameTextField.getText();
             String email = emailTextField.getText();
             int phone =  Integer.parseInt(phoneTextField.getText());
             String major = String.valueOf(MajorList.getSelectedItem());
             
             database.updateStudent(username, password, firstName, lastName, phone, email,major);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        
       
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     }       
   

 public JFrame editStudentFirstForm(){
        JFrame f = new JFrame("Edit Student");

        JLabel editStudentLb = new JLabel("Edit Student");
        editStudentLb.setFont(new Font("Lato",Font.BOLD,20));
        editStudentLb.setForeground(new Color(45, 52, 54));
        editStudentLb.setBounds(140,20,200,50);
        f.add(editStudentLb);
        
        JLabel studentIDLb = new JLabel("Student ID");
        studentIDLb.setFont(new Font("Lato",Font.BOLD,15));
        studentIDLb.setForeground(new Color(45, 52, 54));
        studentIDLb.setBounds(157,80,150,50);
        f.add(studentIDLb);
        
        JTextField editStudentTextField = new JTextField(15);
        editStudentTextField.setBackground(new Color(236,240,241));
        editStudentTextField.setBounds(90, 130, 200, 25);
        editStudentTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(editStudentTextField);
        
        JButton editBtn = new JButton("EDIT");
        editBtn.setBounds(142, 180, 100,40);
        editBtn.setBackground(new Color(52,73,94));
        editBtn.setForeground(Color.WHITE);
        editBtn.setFocusPainted(false);
        editBtn.setFont(new Font("Lato",Font.BOLD,15));
        editBtn.setBorder(new LineBorder(new Color(52,73,94)));
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int id =  Integer.parseInt(editStudentTextField.getText());
             
             if (database.CheckUpdateStudent(id)){
             f.setVisible(false);
             editStudentForm();
             
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine ID","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        f.add(editBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    } 


public JFrame updateCourseForm  (){
        JFrame f = new JFrame("Course Update");
        
        JLabel courseUpdateLp = new JLabel("Update Course");
        courseUpdateLp.setFont(new Font("Lato",Font.BOLD,20));
        courseUpdateLp.setForeground(new Color(45, 52, 54));
        courseUpdateLp.setBounds(140,30,300,50);
        f.add(courseUpdateLp);
       
        JLabel usernameLp = new JLabel("Name");
        usernameLp.setFont(new Font("Lato",Font.BOLD,15));
        usernameLp.setForeground(new Color(45, 52, 54));
        usernameLp.setBounds(30,90,80,50);
        f.add(usernameLp);
        
        JTextField courseNameTextField = new JTextField(15);
        courseNameTextField.setBackground(new Color(236,240,241));
        courseNameTextField.setBounds(140, 105, 200, 25);
        courseNameTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(courseNameTextField);
 
        JLabel firstNameLp = new JLabel("Section");
        firstNameLp.setFont(new Font("Lato",Font.BOLD,15));
        firstNameLp.setForeground(new Color(45, 52, 54));
        firstNameLp.setBounds(30,140,80,50);
        f.add(firstNameLp);
        
        String []section = {"1","2","3","4"};
        JComboBox sectionList = new JComboBox(section);
        sectionList.setBounds(140, 155, 200, 25);
        sectionList.setBackground(new Color(99, 110, 114));
        sectionList.setBorder(new LineBorder(new Color(99, 110, 114)));
        sectionList.setSelectedItem(null);
        sectionList.setForeground(Color.WHITE);
        f.add(sectionList);
        
        JLabel lastNameLp = new JLabel("Days");
        lastNameLp.setFont(new Font("Lato",Font.BOLD,15));
        lastNameLp.setForeground(new Color(45, 52, 54));
        lastNameLp.setBounds(30,190,80,50);
        f.add(lastNameLp);
        
        String []days = {"Suday","Monday","Tuesday","Wednesday","Thursday"};
        JComboBox daysList = new JComboBox(days);
        daysList.setBounds(140, 205, 200, 25);
        daysList.setBackground(new Color(99, 110, 114));
        daysList.setBorder(new LineBorder(new Color(99, 110, 114)));
        daysList.setSelectedItem(null);
        daysList.setForeground(Color.WHITE);
        f.add(daysList);
        
        JLabel phoneLp = new JLabel("Time");
        phoneLp.setFont(new Font("Lato",Font.BOLD,15));
        phoneLp.setForeground(new Color(45, 52, 54)); 
        phoneLp.setBounds(30,240,80,50);
        f.add(phoneLp);
        
        String []time = {"91015","10301145","13001415","14301545","16001715"};
        JComboBox timeList = new JComboBox(time);
        timeList.setBounds(140, 255, 200, 25);
        timeList.setBackground(new Color(99, 110, 114));
        timeList.setBorder(new LineBorder(new Color(99, 110, 114)));
        timeList.setSelectedItem(null);
        timeList.setForeground(Color.WHITE);
        f.add(timeList);
        
        JLabel EmailLp = new JLabel("Instructor");
        EmailLp.setFont(new Font("Lato",Font.BOLD,15));
        EmailLp.setForeground(new Color(45, 52, 54));
        EmailLp.setBounds(30,290,80,50);
        f.add(EmailLp);
        
        Database d = new Database();
        JComboBox instructorsList = d.instructorList();
        instructorsList.setBounds(140, 305, 200, 25);
        instructorsList.setBackground(new Color(99, 110, 114));
        instructorsList.setBorder(new LineBorder(new Color(99, 110, 114)));
        instructorsList.setSelectedItem(null);
        instructorsList.setForeground(Color.WHITE);
        f.add(instructorsList);      
        
        
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setBackground(new Color(52,73,94));
        submitBtn.setBounds(140,480,100,50);
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setFocusPainted(false);
        submitBtn.setFont(new Font("Lato",Font.BOLD,15));
        f.add(submitBtn);
             submitBtn.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent ae) {
             try{    
             Database database = new Database();
             String name = courseNameTextField.getText();
             int section =Integer.parseInt( String.valueOf(sectionList.getSelectedItem()));
             String day = String.valueOf(daysList.getSelectedItem());
             String time = String.valueOf(timeList.getSelectedItem());
             String instructor = String.valueOf(instructorsList.getSelectedItem());

     
             database.updateCourse(name,section,day,time,instructor);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
       return f;
     } 
 
 
 public JFrame editCourseFirstForm(){
        JFrame f = new JFrame("Edit Course");

        JLabel editCoursetLb = new JLabel("Edit Course");
        editCoursetLb.setFont(new Font("Lato",Font.BOLD,20));
        editCoursetLb.setForeground(new Color(45, 52, 54));
        editCoursetLb.setBounds(140,20,200,50);
        f.add(editCoursetLb);
        
        JLabel courseCrnLb = new JLabel("Course CRN");
         courseCrnLb.setFont(new Font("Lato",Font.BOLD,15));
        courseCrnLb.setForeground(new Color(45, 52, 54));
        courseCrnLb.setBounds(157,80,150,50);
        f.add(courseCrnLb);
        
        JTextField editCourseTextField = new JTextField(15);
        editCourseTextField.setBackground(new Color(236,240,241));
        editCourseTextField.setBounds(90, 130, 200, 25);
        editCourseTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(editCourseTextField);
        
        JButton editBtn = new JButton("EDIT");
        editBtn.setBounds(142, 180, 100,40);
        editBtn.setBackground(new Color(52,73,94));
        editBtn.setForeground(Color.WHITE);
        editBtn.setFocusPainted(false);
        editBtn.setFont(new Font("Lato",Font.BOLD,15));
        editBtn.setBorder(new LineBorder(new Color(52,73,94)));
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int crn =  Integer.parseInt(editCourseTextField.getText());
             
             if (database.CheckUpdateCourse(crn)){
             f.setVisible(false);
             updateCourseForm();
       
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine CRN","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        f.add(editBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }  
 


 
     public JFrame updateAssignmentForm(){
         Database database = new Database();
        JFrame frame = new JFrame();
        
        JLabel mainLp = new JLabel("Edit Assignment");
        mainLp.setFont(new Font("Lato",Font.BOLD,20));
        mainLp.setForeground(new Color(45, 52, 54));
        mainLp.setBounds(140,20,200,50);
        frame.add(mainLp);        
        
        JLabel nameLp = new JLabel("Assignment Name :");
        nameLp.setFont(new Font("Lato",Font.BOLD,15));
        nameLp.setForeground(new Color(45, 52, 54));
        nameLp.setBounds(20,70,200,50);
        frame.add(nameLp);
        
        JTextField nameTF = new JTextField(15);
        nameTF.setBackground(new Color(236,240,241));
        nameTF.setBounds(180, 85, 250, 25);
        nameTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        frame.add(nameTF);
        
        JLabel courseLp = new JLabel("Course Name :");
        courseLp.setFont(new Font("Lato",Font.BOLD,15));
        courseLp.setForeground(new Color(45, 52, 54));
        courseLp.setBounds(20,120,200,50);        
        frame.add(courseLp);
        
        JComboBox courseList = database.courseList();
        courseList.setBounds(180, 135, 250, 25);
        courseList.setBackground(new Color(52,73,94));
        courseList.setBorder(new LineBorder(new Color(99, 110, 114)));
        courseList.setSelectedItem(null);
        courseList.setForeground(Color.WHITE);
        frame.add(courseList); 
        
        JLabel sectionLp = new JLabel("Section Number :");
        sectionLp.setFont(new Font("Lato",Font.BOLD,15));
        sectionLp.setForeground(new Color(45, 52, 54));
        sectionLp.setBounds(20,170,200,50);        
        frame.add(sectionLp);        
    
        String []section = {"1","2","3","4",};
        JComboBox sectionList = new JComboBox(section);
        sectionList.setBounds(180, 185, 250, 25);
        sectionList.setBackground(new Color(99, 110, 114));
        sectionList.setBorder(new LineBorder(new Color(99, 110, 114)));
        sectionList.setSelectedItem(null);
        sectionList.setForeground(Color.WHITE);
        frame.add(sectionList);     
        
        JLabel markLp = new JLabel("Assignment Marks :");
        markLp.setFont(new Font("Lato",Font.BOLD,15));
        markLp.setForeground(new Color(45, 52, 54));
        markLp.setBounds(20,220,200,50);        
        frame.add(markLp);
        
        
        String []mark = {"1","2","3","4","5"};
        JComboBox markList = new JComboBox(mark);
        markList.setBounds(180, 235, 250, 25);
        markList.setBackground(new Color(52,73,94));
        markList.setBorder(new LineBorder(new Color(99, 110, 114)));
        markList.setSelectedItem(null);
        markList.setForeground(Color.WHITE);
        frame.add(markList);
        
        
        JLabel timeLp = new JLabel("Submitting Deadline :");
        timeLp.setFont(new Font("Lato",Font.BOLD,15));
        timeLp.setForeground(new Color(45, 52, 54));
        timeLp.setBounds(20,270,200,50);        
        frame.add(timeLp);        
        
        JDateChooser  calender = new JDateChooser ();
        calender.setBounds(180,285, 250,25);
        frame.add(calender);  
        
        JLabel disLp = new JLabel("Assignment Description :");
        disLp.setFont(new Font("Lato",Font.BOLD,15));
        disLp.setForeground(new Color(45, 52, 54));
        disLp.setBounds(20,320,200,50);        
        frame.add(disLp);
                
        JTextArea disArea = new JTextArea();
        disArea.setFont(new Font("Lato",Font.PLAIN,14));
        disArea.setLineWrap(true);
        disArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(disArea); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(20, 375, 410, 200);
        frame.add(scrollPane);
        
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(170, 600, 100,40);
        subBtn.setBackground(new Color(52,73,94));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        subBtn.setFont(new Font("Lato",Font.BOLD,15));
        subBtn.setBorder(new LineBorder(new Color(52,73,94)));
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String name = nameTF.getText();
             String course =  String.valueOf(courseList.getSelectedItem()); 
             String sec = String.valueOf(sectionList.getSelectedItem());
             int mark = Integer.parseInt( String.valueOf(markList.getSelectedItem()));
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String date = sdf.format(calender.getDate());
             String Des = disArea.getText();
             database.updateAssignmet(name, course, sec, mark, date, Des);
             frame.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
             
            }
        });        
        frame.add(subBtn);
        
        frame.setLayout(null);
        frame.setBounds(700, 350, 450, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(209, 216, 224));
        
        return frame;
     
     
     
     } 
 
 public JFrame editAssignmetFirstForm(){
        JFrame f = new JFrame("Edit Assignmet");

        JLabel editLb = new JLabel("Edit Assignmet");
        editLb.setFont(new Font("Lato",Font.BOLD,20));
        editLb.setForeground(new Color(45, 52, 54));
        editLb.setBounds(118,20,200,50);
        f.add(editLb);
        
        JLabel numLb = new JLabel("Assignmet No.");
        numLb.setFont(new Font("Lato",Font.BOLD,15));
        numLb.setForeground(new Color(45, 52, 54));
        numLb.setBounds(157,80,150,50);
        f.add(numLb);
        
        JTextField editTextField = new JTextField(15);
        editTextField.setBackground(new Color(236,240,241));
        editTextField.setBounds(90, 130, 200, 25);
        editTextField.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(editTextField);
        
        JButton editBtn = new JButton("EDIT");
        editBtn.setBounds(142, 180, 100,40);
        editBtn.setBackground(new Color(52,73,94));
        editBtn.setForeground(Color.WHITE);
        editBtn.setFocusPainted(false);
        editBtn.setFont(new Font("Lato",Font.BOLD,15));
        editBtn.setBorder(new LineBorder(new Color(52,73,94)));
        editBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             int num =  Integer.parseInt(editTextField.getText());
             
             if (database.CheckUpdateAssignmet(num)){
             f.setVisible(false);
             updateAssignmentForm();
             f.setVisible(false);
             
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine Assignmet","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
          
            }
        });        
        f.add(editBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    } 

 
   
    public JFrame addMark(int sec,int SNum,String Tname){
        JFrame f = new JFrame("New Marks");
        JPanel panel = new JPanel();
        Database db = new Database();
        int boundY = 20;
        
        panel.setPreferredSize(new Dimension(650, (SNum*50)+20 ));
        panel.setBackground(new Color(209, 216, 224));
        panel.setLayout(null);
        
        JLabel addMarkLb = new JLabel("New Marks");
        addMarkLb.setFont(new Font("Lato",Font.BOLD,20));
        addMarkLb.setForeground(new Color(45, 52, 54));
        addMarkLb.setBounds(280,20,150,50);
        f.add(addMarkLb);
        
        JLabel[] tableLb = new JLabel[SNum];
        JLabel[] markLb = new JLabel[SNum];
        JComboBox[] TnamTF = new JComboBox[SNum];
        JTextField[] markTF = new JTextField[SNum];
        
        for(int i = 0 ; i < SNum ; i++){
        tableLb[i] = new JLabel(i+1 +"- Student Name : ");
        tableLb[i].setFont(new Font("Lato",Font.BOLD,15));
        tableLb[i].setForeground(new Color(45, 52, 54));
        tableLb[i].setBounds(20,boundY,200,50);
        panel.add(tableLb[i]);  
        
        TnamTF[i] = db.StudentList();
        TnamTF[i].setBackground(new Color(52,73,94));
        TnamTF[i].setForeground(Color.WHITE);
        TnamTF[i].setBounds(165, boundY+15, 200, 25);
        TnamTF[i].setBorder(new LineBorder(new Color(178, 190, 195)));
        panel.add(TnamTF[i]);
        
        markLb[i] = new JLabel("Mark : ");
        markLb[i].setFont(new Font("Lato",Font.BOLD,15));
        markLb[i].setForeground(new Color(45, 52, 54));
        markLb[i].setBounds(370,boundY,200,50);
        panel.add(markLb[i]);
        
        markTF[i] = new JTextField(15);
        markTF[i].setBackground(new Color(236,240,241));
        markTF[i].setBounds(430, boundY+15, 200, 25);
        markTF[i].setBorder(new LineBorder(new Color(178, 190, 195)));
        panel.add(markTF[i]);        
        
        boundY += 50;
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 70, 680, 500);
        f.add(scrollPane);
        
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(280, 600, 100,40);
        subBtn.setBackground(new Color(52,73,94));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        subBtn.setFont(new Font("Lato",Font.BOLD,15));
        subBtn.setBorder(new LineBorder(new Color(52,73,94)));
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();
             String tableName = Tname;
             for(int i = 0;i<SNum;i++){
             String SName = String.valueOf(TnamTF[i].getSelectedItem());
             int mark = Integer.parseInt( String.valueOf(markTF[i].getText()));
             int section = sec;
             database.NewMark(tableName, SName, section, mark);
             f.setVisible(false);
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        f.add(subBtn);
        
        
        f.setLayout(null);
        f.setBounds(700, 350, 695, 700);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
        return f;
    }
    
 
    public JFrame addMarkFirst(){
        JFrame f = new JFrame("New Marks");

        JLabel addMarkLb = new JLabel("New Marks");
        addMarkLb.setFont(new Font("Lato",Font.BOLD,20));
        addMarkLb.setForeground(new Color(45, 52, 54));
        addMarkLb.setBounds(124,20,150,50);
        f.add(addMarkLb);
        
        JLabel tableLb = new JLabel("Table Name : ");
        tableLb.setFont(new Font("Lato",Font.BOLD,15));
        tableLb.setForeground(new Color(45, 52, 54));
        tableLb.setBounds(20,70,200,50);
        f.add(tableLb);        

        JTextField TnumTF = new JTextField(15);
        TnumTF.setBackground(new Color(236,240,241));
        TnumTF.setBounds(180, 85, 200, 25);
        TnumTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TnumTF);
        
        JLabel sectionLp = new JLabel("Section Number :");
        sectionLp.setFont(new Font("Lato",Font.BOLD,15));
        sectionLp.setForeground(new Color(45, 52, 54));
        sectionLp.setBounds(20,120,200,50);        
        f.add(sectionLp);        
    
        String []section = {"1","2","3","4"};
        JComboBox sectionList = new JComboBox(section);
        sectionList.setBounds(180, 135, 200, 25);
        sectionList.setBackground(new Color(99, 110, 114));
        sectionList.setBorder(new LineBorder(new Color(99, 110, 114)));
        sectionList.setSelectedItem(null);
        sectionList.setForeground(Color.WHITE);
        f.add(sectionList);        
        
        JLabel StNumLb = new JLabel("Number of Students : ");
        StNumLb.setFont(new Font("Lato",Font.BOLD,15));
        StNumLb.setForeground(new Color(45, 52, 54));
        StNumLb.setBounds(20,170,200,50);
        f.add(StNumLb);
        
        JTextField addTF = new JTextField(15);
        addTF.setBackground(new Color(236,240,241));
        addTF.setBounds(180, 185, 200, 25);
        addTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(addTF);
        
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(150, 240, 100,40);
        subBtn.setBackground(new Color(52,73,94));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        subBtn.setFont(new Font("Lato",Font.BOLD,15));
        subBtn.setBorder(new LineBorder(new Color(52,73,94)));
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();
             String tableName = TnumTF.getText();
             int sec = Integer.parseInt( String.valueOf(sectionList.getSelectedItem()));
             int SNum = Integer.parseInt(addTF.getText());      
             database.NewMarkT(tableName);
             addMark(sec,SNum,tableName);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(subBtn);
        
        f.setLayout(null);
        f.setBounds(700, 350, 400, 350);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }
    

     public JFrame newAssignmentForme(){
         Database database = new Database();
        JFrame frame = new JFrame();
        
        JLabel mainLp = new JLabel("New Assignment");
        mainLp.setFont(new Font("Lato",Font.BOLD,20));
        mainLp.setForeground(new Color(45, 52, 54));
        mainLp.setBounds(140,20,200,50);
        frame.add(mainLp);        
        
        JLabel nameLp = new JLabel("Assignment Name :");
        nameLp.setFont(new Font("Lato",Font.BOLD,15));
        nameLp.setForeground(new Color(45, 52, 54));
        nameLp.setBounds(20,70,200,50);
        frame.add(nameLp);
        
        JTextField nameTF = new JTextField(15);
        nameTF.setBackground(new Color(236,240,241));
        nameTF.setBounds(180, 85, 250, 25);
        nameTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        frame.add(nameTF);
        
        JLabel courseLp = new JLabel("Course Name :");
        courseLp.setFont(new Font("Lato",Font.BOLD,15));
        courseLp.setForeground(new Color(45, 52, 54));
        courseLp.setBounds(20,120,200,50);        
        frame.add(courseLp);
        
        JComboBox courseList = database.courseList();
        courseList.setBounds(180, 135, 250, 25);
        courseList.setBackground(new Color(52,73,94));
        courseList.setBorder(new LineBorder(new Color(99, 110, 114)));
        courseList.setSelectedItem(null);
        courseList.setForeground(Color.WHITE);
        frame.add(courseList); 
        
        JLabel sectionLp = new JLabel("Section Number :");
        sectionLp.setFont(new Font("Lato",Font.BOLD,15));
        sectionLp.setForeground(new Color(45, 52, 54));
        sectionLp.setBounds(20,170,200,50);        
        frame.add(sectionLp);        
    
        String []section = {"1","2","3","4"};
        JComboBox sectionList = new JComboBox(section);
        sectionList.setBounds(180, 185, 250, 25);
        sectionList.setBackground(new Color(99, 110, 114));
        sectionList.setBorder(new LineBorder(new Color(99, 110, 114)));
        sectionList.setSelectedItem(null);
        sectionList.setForeground(Color.WHITE);
        frame.add(sectionList);    
        
        JLabel markLp = new JLabel("Assignment Marks :");
        markLp.setFont(new Font("Lato",Font.BOLD,15));
        markLp.setForeground(new Color(45, 52, 54));
        markLp.setBounds(20,220,200,50);        
        frame.add(markLp);
        
        
        String []mark = {"1","2","3","4","5"};
        JComboBox markList = new JComboBox(mark);
        markList.setBounds(180, 235, 250, 25);
        markList.setBackground(new Color(52,73,94));
        markList.setBorder(new LineBorder(new Color(99, 110, 114)));
        markList.setSelectedItem(null);
        markList.setForeground(Color.WHITE);
        frame.add(markList);
        
        
        JLabel timeLp = new JLabel("Submitting Deadline :");
        timeLp.setFont(new Font("Lato",Font.BOLD,15));
        timeLp.setForeground(new Color(45, 52, 54));
        timeLp.setBounds(20,270,200,50);        
        frame.add(timeLp);        
        
        JDateChooser  calender = new JDateChooser ();
        calender.setBounds(180,285, 250,25);
        frame.add(calender);  
        
        JLabel disLp = new JLabel("Assignment Description :");
        disLp.setFont(new Font("Lato",Font.BOLD,15));
        disLp.setForeground(new Color(45, 52, 54));
        disLp.setBounds(20,320,200,50);        
        frame.add(disLp);
                
        JTextArea disArea = new JTextArea();
        disArea.setFont(new Font("Lato",Font.PLAIN,14));
        disArea.setLineWrap(true);
        disArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(disArea); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(20, 375, 410, 200);
        frame.add(scrollPane);
        
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(170, 600, 100,40);
        subBtn.setBackground(new Color(52,73,94));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        subBtn.setFont(new Font("Lato",Font.BOLD,15));
        subBtn.setBorder(new LineBorder(new Color(52,73,94)));
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String name = nameTF.getText();
             String course =  String.valueOf(courseList.getSelectedItem()); 
             String sec = String.valueOf(sectionList.getSelectedItem());
             int mark = Integer.parseInt( String.valueOf(markList.getSelectedItem()));
             SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             String date = sdf.format(calender.getDate());
             String Des = disArea.getText();
             database.NewAssignmet(name , course , sec , mark , date , Des);
             frame.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        frame.add(subBtn);
        
        frame.setLayout(null);
        frame.setBounds(700, 350, 450, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(209, 216, 224));
        
        return frame;
     
     
     
     }
 
     
    public JFrame DisplayMarkForm(){
        JFrame f = new JFrame("Display Marks");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Display Marks");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(118,20,200,50);
        f.add(removeLb);
        
        JLabel tLb = new JLabel("Select Marks Table");
        tLb.setFont(new Font("Lato",Font.BOLD,16));
        tLb.setForeground(new Color(45, 52, 54));
        tLb.setBounds(125,80,150,50);
        f.add(tLb);
        
        JComboBox TTF = db.marksList();
        TTF.setBackground(new Color(52,73,94));
        TTF.setForeground(Color.WHITE);
        TTF.setBounds(90, 130, 200, 25);
        TTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TTF);
           
        JButton removeBtn = new JButton("VIEW");
        removeBtn.setBounds(142, 180, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Tables table = new Tables();   
             String TName =  String.valueOf(TTF.getSelectedItem());
             table.DispalyMarkTable(TName);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }     
     

    public JFrame DisplayMarkFormS(){
        JFrame f = new JFrame("Display Marks");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Display Marks");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(118,20,200,50);
        f.add(removeLb);
        
        JLabel tLb = new JLabel("Select Marks Table");
        tLb.setFont(new Font("Lato",Font.BOLD,16));
        tLb.setForeground(new Color(45, 52, 54));
        tLb.setBounds(125,80,150,50);
        f.add(tLb);
        
        JComboBox TTF = db.marksList();
        TTF.setBackground(new Color(52,73,94));
        TTF.setForeground(Color.WHITE);
        TTF.setBounds(90, 130, 200, 25);
        TTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TTF);
           
        JButton removeBtn = new JButton("VIEW");
        removeBtn.setBounds(142, 180, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Tables table = new Tables();   
             String TName =  String.valueOf(TTF.getSelectedItem());
             table.DispalyMarkTableS(TName);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }    
    
    
    
public JFrame UpdateMark(){
        JFrame f = new JFrame("Update Mark");
        
        JLabel addMarkLb = new JLabel("Update Mark");
        addMarkLb.setFont(new Font("Lato",Font.BOLD,20));
        addMarkLb.setForeground(new Color(45, 52, 54));
        addMarkLb.setBounds(118,20,150,50);
        f.add(addMarkLb);
        
        JLabel markLb = new JLabel("Mark : ");
        markLb.setFont(new Font("Lato",Font.BOLD,15));
        markLb.setForeground(new Color(45, 52, 54));
        markLb.setBounds(157,80,200,50);
        f.add(markLb);
        
        JTextField markTF = new JTextField(15);
        markTF.setBackground(new Color(236,240,241));
        markTF.setBounds(90, 135, 200, 25);
        markTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(markTF);        
     
        JButton subBtn = new JButton("Submit");
        subBtn.setBounds(143, 190, 100,40);
        subBtn.setBackground(new Color(52,73,94));
        subBtn.setForeground(Color.WHITE);
        subBtn.setFocusPainted(false);
        subBtn.setFont(new Font("Lato",Font.BOLD,15));
        subBtn.setBorder(new LineBorder(new Color(52,73,94)));
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();
             int mark = Integer.parseInt(markTF.getText());
             database.updateMark(mark);
             f.setVisible(false);
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
            }
        });        
        f.add(subBtn);
        
        
        f.setLayout(null);
        f.setBounds(700, 350, 400, 300);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
        return f;
    }    

    
public JFrame updateMarkFormFirst(){
        JFrame f = new JFrame("Update Mark");
        Database db = new Database();
        
        JLabel removeLb = new JLabel("Update Mark");
        removeLb.setFont(new Font("Lato",Font.BOLD,20));
        removeLb.setForeground(new Color(45, 52, 54));
        removeLb.setBounds(125,20,200,50);
        f.add(removeLb);
        
        JLabel tLb = new JLabel("Select Marks Table");
        tLb.setFont(new Font("Lato",Font.BOLD,15));
        tLb.setForeground(new Color(45, 52, 54));
        tLb.setBounds(125,80,150,50);
        f.add(tLb);
        
        JComboBox TTF = db.marksList();
        TTF.setBackground(new Color(52,73,94));
        TTF.setForeground(Color.WHITE);
        TTF.setBounds(90, 130, 200, 25);
        TTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TTF);
        
        JLabel numLb = new JLabel("Select Student");
        numLb.setFont(new Font("Lato",Font.BOLD,15));
        numLb.setForeground(new Color(45, 52, 54));
        numLb.setBounds(125,180,150,50);
        f.add(numLb);
        
        JComboBox TnamTF = db.StudentList();
        TnamTF.setBackground(new Color(52,73,94));
        TnamTF.setForeground(Color.WHITE);
        TnamTF.setBounds(90, 230, 200, 25);
        TnamTF.setBorder(new LineBorder(new Color(178, 190, 195)));
        f.add(TnamTF);
       
        
        
        JButton removeBtn = new JButton("EDIT");
        removeBtn.setBounds(142, 280, 100,40);
        removeBtn.setBackground(new Color(52,73,94));
        removeBtn.setForeground(Color.WHITE);
        removeBtn.setFocusPainted(false);
        removeBtn.setFont(new Font("Lato",Font.BOLD,15));
        removeBtn.setBorder(new LineBorder(new Color(52,73,94)));
        removeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             try{   
             Database database = new Database();   
             String TName =  String.valueOf(TTF.getSelectedItem());
             String SName =  String.valueOf(TnamTF.getSelectedItem());
             
             if (database.checkUpdateMark(TName, SName)){
             f.setVisible(false);
             UpdateMark();
             
             }
             else{
             JOptionPane.showMessageDialog(null,"Couldn't fine Student","Erorr!",JOptionPane.ERROR_MESSAGE); 
             
             }
             }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"invalid input","Got an exception!",JOptionPane.ERROR_MESSAGE);  
             }             
             
            }
        });        
        f.add(removeBtn);
        
        f.setLayout(null); 
        f.setBounds(700, 350, 400, 400);
        f.setResizable(false);
        f.setVisible(true);
        f.getContentPane().setBackground(new Color(209, 216, 224));
    
        return f;
    }    
    
}




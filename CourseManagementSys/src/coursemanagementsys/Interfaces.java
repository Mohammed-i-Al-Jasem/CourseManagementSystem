package coursemanagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Interfaces {

int i =2;    

    public JFrame AdminInterface(){
        JFrame f = new JFrame("Admin Interface");
        Formating AdminPanel = new Formating();
        
        JButton []menuBtn = new JButton[6];
        JPanel MenuPanel = new JPanel();
        
        Formating style = new Formating();
        MenuPanel.setBounds(0,0,150,571);
        MenuPanel.setLayout(new GridLayout(6,1,0,0));
     
        JLayeredPane container = new JLayeredPane();
        container.setBounds(185,0,850,600);
         

        container.add(AdminPanel.ProfilePanel(),Integer.valueOf(1));
        
        menuBtn[0]= new JButton();
        menuBtn[0]= style.menuBtnStyle(menuBtn[0], "Main");
        menuBtn[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            container.add(AdminPanel.ProfilePanel(),Integer.valueOf(i));
             i++; 
            }
        }); 
        MenuPanel.add(menuBtn[0]);
        

        
        menuBtn[1]= new JButton();
        menuBtn[1]= style.menuBtnStyle(menuBtn[1], "Admin");
        menuBtn[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {      
            container.add(AdminPanel.adminPanel(),Integer.valueOf(i));
              i++;
            }
        });        
        MenuPanel.add(menuBtn[1]);
        
        menuBtn[2]= new JButton();
        menuBtn[2]= style.menuBtnStyle(menuBtn[2], "Instructor");
        menuBtn[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            container.add(AdminPanel.instructorPanel(),Integer.valueOf(i));
             i++; 
            }
        }); 
        MenuPanel.add(menuBtn[2]);
        
        menuBtn[3]= new JButton();
        menuBtn[3]= style.menuBtnStyle(menuBtn[3], "Student");
        menuBtn[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            container.add(AdminPanel.studentPanel(),Integer.valueOf(i));
             i++; 
            }
        });         
        MenuPanel.add(menuBtn[3]);
        
        menuBtn[4]= new JButton();
        menuBtn[4]= style.menuBtnStyle(menuBtn[4], "Course");
        menuBtn[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            container.add(AdminPanel.coursePanel(),Integer.valueOf(i));
             i++; 
            }
        }); 
        MenuPanel.add(menuBtn[4]);  
        
        menuBtn[5]= new JButton();
        menuBtn[5]= style.menuBtnStyle(menuBtn[5], "Logout");
        menuBtn[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            f.setVisible(false);
            Forms loginForm = new Forms();
            loginForm.loginForm();
              
            }
        }); 
        MenuPanel.add(menuBtn[5]);         
        
        for(int i = 0 ; i < menuBtn.length ; i++){
        int  z = i;    
        menuBtn[z].addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          menuBtn[z].setBackground(new Color(255,255,255));
          menuBtn[z].setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         menuBtn[z].setBackground(new Color(52,73,94));
         menuBtn[z].setForeground(new Color(255,255,255));
         }         
        
         });
        
        }
        
        
        
        MenuPanel.setBackground(new Color(44, 62, 80));       
  
        f.add(MenuPanel);

        
        f.add(container);
        f.setLayout(null); 
        f.setBounds(700, 350, 800, 600);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(new Color(209, 216, 224));       
        
    return f;
    }
    
    public JFrame InstructorInterface(){
    Forms form = new Forms();
    JFrame f = new JFrame();
    JPanel container = new JPanel();
    container.setBounds(0,0,850,600);
    container.setBackground(new Color(209, 216, 224));   
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(null);
    mainPanel.setBounds(0,0,850,600);
    mainPanel.setBackground(new Color(209, 216, 224));
    
    JPanel info = new JPanel();
    info.setBounds(25,20,750,150);
    info.setBackground(new Color(52,73,94));
    info.setLayout(null);
    
    JPanel infoPanel = new JPanel();
    infoPanel.setBounds(0, 0, 750, 30);
    infoPanel.setLayout(null);
    infoPanel.setBackground(new Color(75, 101, 132));
    JLabel infoLp = new JLabel("Personal Information");
    infoLp.setForeground(Color.WHITE);
    infoLp.setFont(new Font("Lato",Font.BOLD,25));
    infoLp.setBounds(250, 5, 250, 20);
    
       Database database = new Database();
        
        
        database.PrintInstructorInfo();
        
        JLabel Id = new JLabel("ID Number : " + Database.currentId);
        Id.setBounds(10,30,550,30);
        Id.setFont(new Font("Lato",Font.BOLD,15));
        Id.setForeground(Color.WHITE); 
        
        JLabel UName = new JLabel("Username : " + Database.currentUsername);
        UName.setBounds(350,30,550,30);
        UName.setFont(new Font("Lato",Font.BOLD,15));
        UName.setForeground(Color.WHITE); 
        
        JLabel FName = new JLabel("First Name : " + Database.currentFirstName);
        FName.setBounds(10,50,550,30);
        FName.setFont(new Font("Lato",Font.BOLD,15));
        FName.setForeground(Color.WHITE);
        
        JLabel LName = new JLabel("Last Name : " + Database.currentLastName);
        LName.setBounds(350,50,550,30);
        LName.setFont(new Font("Lato",Font.BOLD,15));
        LName.setForeground(Color.WHITE);

        JLabel LPhone = new JLabel("Phone Number : " + Database.currentPhone);
        LPhone.setBounds(10,70,550,30);
        LPhone.setFont(new Font("Lato",Font.BOLD,15));
        LPhone.setForeground(Color.WHITE);        

        JLabel LEmail = new JLabel("Email : " + Database.currentEmail);
        LEmail.setBounds(350,70,550,30);
        LEmail.setFont(new Font("Lato",Font.BOLD,15));
        LEmail.setForeground(Color.WHITE);

        JLabel LDp = new JLabel("Department : " + Database.currentDp);
        LDp.setBounds(10,90,550,30);
        LDp.setFont(new Font("Lato",Font.BOLD,15));
        LDp.setForeground(Color.WHITE);
        
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(255,255,255));
        logoutBtn.setForeground(new Color(52,73,94));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFont(new Font("Lato",Font.BOLD,16));
        logoutBtn.setBorder(new LineBorder(new Color(40,60,60)));
        logoutBtn.setBounds(350, 105, 90, 35);
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            f.setVisible(false);
            Forms loginForm = new Forms();
            loginForm.loginForm();
              
            }
        }); 
        
        infoPanel.add(infoLp);
        info.add(Id);
        info.add(UName);
        info.add(FName);
        info.add(LName);
        info.add(LPhone);
        info.add(LEmail); 
        info.add(LDp); 
        info.add(logoutBtn);
        
    info.add(infoPanel);
    
    JPanel assignment = new JPanel();
    assignment.setBounds(25,190,750,150);
    assignment.setBackground(new Color(75, 101, 132));
    assignment.setLayout(new GridLayout(5,1,0,0));
    
    String[] addButtonNames={"Add New Assignment","Remove Assignment","Edit Assignment","View Assignmet"};
    JButton[] addButton = new JButton[4];
    
    JLabel assignmentLp = new JLabel("                                            Assignment");
    assignmentLp.setForeground(Color.WHITE);
    assignmentLp.setFont(new Font("Lato",Font.BOLD,25));
    assignment.add(assignmentLp);
    
    for(int i = 0;i<addButton.length;i++){
    addButton[i]=new JButton(addButtonNames[i]);
     addButton[i].setBackground(new Color(52,73,94));
     addButton[i].setForeground(new Color(255,255,255));
     addButton[i].setFocusPainted(false);
     addButton[i].setFont(new Font("Lato",Font.BOLD,16));
     addButton[i].setBorder(new LineBorder(new Color(40,60,60)));
             int  z = i;    
     addButton[i].addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          addButton[z].setBackground(new Color(255,255,255));
          addButton[z].setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         addButton[z].setBackground(new Color(52,73,94));
         addButton[z].setForeground(new Color(255,255,255));
         }         
        
         });
         assignment.add(addButton[i]);
    }
    
        addButton[0].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.newAssignmentForme();
         }
        });
        
        addButton[1].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.removeAssignmetForm();
         }
        });
        
        addButton[2].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.editAssignmetFirstForm();
         }
        });
        
        addButton[3].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           
               JFrame frame = new JFrame();
               frame.add(new Tables().DispalyAssignmentTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
         }
        });
    
    JPanel mark = new JPanel();
    mark.setBounds(25,360,750,150);
    mark.setBackground(new Color(75, 101, 132));
    mark.setLayout(new GridLayout(5,1,0,0));
    
    String[] markButtonNames={"Add New Marks","Remove Mark","Edit Mark","View Mark"};
    JButton[] markButton = new JButton[4];
    
    JLabel markLp = new JLabel("                                                Marks");
    markLp.setForeground(Color.WHITE);
    markLp.setFont(new Font("Lato",Font.BOLD,25));
    mark.add(markLp);
    
    for(int i = 0;i<markButton.length;i++){
    markButton[i]=new JButton(markButtonNames[i]);
     markButton[i].setBackground(new Color(52,73,94));
     markButton[i].setForeground(new Color(255,255,255));
     markButton[i].setFocusPainted(false);
     markButton[i].setFont(new Font("Lato",Font.BOLD,16));
     markButton[i].setBorder(new LineBorder(new Color(40,60,60)));
             int  z = i;    
     markButton[i].addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          markButton[z].setBackground(new Color(255,255,255));
          markButton[z].setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         markButton[z].setBackground(new Color(52,73,94));
         markButton[z].setForeground(new Color(255,255,255));
         }         
        
         });
     mark.add(markButton[i]);
    } 
    
        markButton[0].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.addMarkFirst();
         }
        });
        
        markButton[1].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.removeMarkForm();
         }
        });
        
        markButton[2].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.updateMarkFormFirst();
         }
        });
        
        markButton[3].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
               Forms form = new Forms();
               form.DisplayMarkForm();
              
         }
        });    
    
    
    
    mainPanel.add(info);
    mainPanel.add(mark);
    mainPanel.add(assignment);
    
    f.add(mainPanel);
    f.setLayout(null); 
    f.setBounds(700, 350, 800, 600);
    f.setResizable(false);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setBackground(new Color(209, 216, 224));   
    return f;

    }
    
    
    
    
    public JFrame StudentInterface(){
    Forms form = new Forms();
    JFrame f = new JFrame();
    JPanel container = new JPanel();
    container.setBounds(0,0,850,600);
    container.setBackground(new Color(209, 216, 224));   
    
    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(null);
    mainPanel.setBounds(0,0,850,800);
    mainPanel.setBackground(new Color(209, 216, 224));
    
    JPanel info = new JPanel();
    info.setBounds(25,20,750,150);
    info.setBackground(new Color(52,73,94));
    info.setLayout(null);
    
    JPanel infoPanel = new JPanel();
    infoPanel.setBounds(0, 0, 750, 30);
    infoPanel.setLayout(null);
    infoPanel.setBackground(new Color(75, 101, 132));
    JLabel infoLp = new JLabel("Personal Information");
    infoLp.setForeground(Color.WHITE);
    infoLp.setFont(new Font("Lato",Font.BOLD,25));
    infoLp.setBounds(250, 5, 250, 20);
    
       Database database = new Database();
        
        
        database.PrintStudentInfo();
        
        JLabel Id = new JLabel("ID Number : " + Database.currentId);
        Id.setBounds(10,30,550,30);
        Id.setFont(new Font("Lato",Font.BOLD,15));
        Id.setForeground(Color.WHITE); 
        
        JLabel UName = new JLabel("Username : " + Database.currentUsername);
        UName.setBounds(350,30,550,30);
        UName.setFont(new Font("Lato",Font.BOLD,15));
        UName.setForeground(Color.WHITE); 
        
        JLabel FName = new JLabel("First Name : " + Database.currentFirstName);
        FName.setBounds(10,50,550,30);
        FName.setFont(new Font("Lato",Font.BOLD,15));
        FName.setForeground(Color.WHITE);
        
        JLabel LName = new JLabel("Last Name : " + Database.currentLastName);
        LName.setBounds(350,50,550,30);
        LName.setFont(new Font("Lato",Font.BOLD,15));
        LName.setForeground(Color.WHITE);

        JLabel LPhone = new JLabel("Phone Number : " + Database.currentPhone);
        LPhone.setBounds(10,70,550,30);
        LPhone.setFont(new Font("Lato",Font.BOLD,15));
        LPhone.setForeground(Color.WHITE);        

        JLabel LEmail = new JLabel("Email : " + Database.currentEmail);
        LEmail.setBounds(350,70,550,30);
        LEmail.setFont(new Font("Lato",Font.BOLD,15));
        LEmail.setForeground(Color.WHITE);

        JLabel LDp = new JLabel("Major : " + Database.currentDp);
        LDp.setBounds(10,90,550,30);
        LDp.setFont(new Font("Lato",Font.BOLD,15));
        LDp.setForeground(Color.WHITE);
        
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(255,255,255));
        logoutBtn.setForeground(new Color(52,73,94));
        logoutBtn.setFocusPainted(false);
        logoutBtn.setFont(new Font("Lato",Font.BOLD,16));
        logoutBtn.setBorder(new LineBorder(new Color(40,60,60)));
        logoutBtn.setBounds(350, 105, 90, 35);
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {        
            f.setVisible(false);
            Forms loginForm = new Forms();
            loginForm.loginForm();
              
            }
        }); 
        
        infoPanel.add(infoLp);
        info.add(Id);
        info.add(UName);
        info.add(FName);
        info.add(LName);
        info.add(LPhone);
        info.add(LEmail); 
        info.add(LDp); 
        info.add(logoutBtn);
        
    info.add(infoPanel);
    
    JPanel course = new JPanel();
    course.setBounds(25,190,750,150);
    course.setBackground(new Color(75, 101, 132));
    course.setLayout(new GridLayout(4,1,0,0));
    
    String[] addButtonNames={"Add New Course","Remove Course","View Courses"};
    JButton[] addButton = new JButton[3];
    
    JLabel courseLp = new JLabel("                                             Course");
    courseLp.setForeground(Color.WHITE);
    courseLp.setFont(new Font("Lato",Font.BOLD,25));
    course.add(courseLp);
    
    for(int i = 0;i<addButton.length;i++){
     addButton[i]=new JButton(addButtonNames[i]);
     addButton[i].setBackground(new Color(52,73,94));
     addButton[i].setForeground(new Color(255,255,255));
     addButton[i].setFocusPainted(false);
     addButton[i].setFont(new Font("Lato",Font.BOLD,16));
     addButton[i].setBorder(new LineBorder(new Color(40,60,60)));
             int  z = i;    
     addButton[i].addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          addButton[z].setBackground(new Color(255,255,255));
          addButton[z].setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         addButton[z].setBackground(new Color(52,73,94));
         addButton[z].setForeground(new Color(255,255,255));
         }         
        
         });
         course.add(addButton[i]);
    }
    
        addButton[0].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.addStudentCourse();
         }
        });
        
        addButton[1].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
           form.removeStudentCourse();
         }
        });
        
        addButton[2].addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
               JFrame frame = new JFrame();
               frame.add(new Tables().DispalyStudentCoursesTable());
               frame.setSize(500,500);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
         }
        });
        
    
    JPanel mark = new JPanel();
    mark.setBounds(25,360,750,100);
    mark.setBackground(new Color(75, 101, 132));
    mark.setLayout(new GridLayout(2,1,0,0));


    JLabel markLp = new JLabel("                                                Marks");
    markLp.setForeground(Color.WHITE);
    markLp.setFont(new Font("Lato",Font.BOLD,25));
    mark.add(markLp);
    
    
     JButton markButton=new JButton("View Mark");
     markButton.setBackground(new Color(52,73,94));
     markButton.setForeground(new Color(255,255,255));
     markButton.setFocusPainted(false);
     markButton.setFont(new Font("Lato",Font.BOLD,16));
     markButton.setBorder(new LineBorder(new Color(40,60,60)));
               
     markButton.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          markButton.setBackground(new Color(255,255,255));
          markButton.setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         markButton.setBackground(new Color(52,73,94));
         markButton.setForeground(new Color(255,255,255));
         }         
        
         });
     mark.add(markButton);
        
    
        markButton.addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
               Forms form = new Forms();
               form.DisplayMarkFormS();
         }
        });
        

    JPanel assignment = new JPanel();
    assignment.setBounds(25,500,750,100);
    assignment.setBackground(new Color(75, 101, 132));
    assignment.setLayout(new GridLayout(2,1,0,0));
    
    
    JLabel assignmentLp = new JLabel("                                            Assignmet");
    assignmentLp.setForeground(Color.WHITE);
    assignmentLp.setFont(new Font("Lato",Font.BOLD,25));
    assignment.add(assignmentLp);
    
    
     JButton Button=new JButton("View Assignment");
     Button.setBackground(new Color(52,73,94));
     Button.setForeground(new Color(255,255,255));
     Button.setFocusPainted(false);
     Button.setFont(new Font("Lato",Font.BOLD,16));
     Button.setBorder(new LineBorder(new Color(40,60,60)));  
     Button.addMouseListener(new MouseAdapter(){
          
          @Override
          public void mouseEntered(MouseEvent e) {  
          Button.setBackground(new Color(255,255,255));
          Button.setForeground(new Color(52,73,94));
         }
          @Override
         public void mouseExited(MouseEvent e){
         Button.setBackground(new Color(52,73,94));
         Button.setForeground(new Color(255,255,255));
         }         
        
         });
         assignment.add(Button);
    
    
        Button.addActionListener(new ActionListener() {
        @Override
          public void actionPerformed(ActionEvent ae) {
               JFrame frame = new JFrame();
               frame.add(new Tables().DispalyAssignmentTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
         }
        });
  
   
    
    
    
    mainPanel.add(info);
    mainPanel.add(mark);
    mainPanel.add(course);
    mainPanel.add(assignment);
    
    f.add(mainPanel);
    f.setLayout(null); 
    f.setBounds(700, 350, 800, 650);
    f.setResizable(false);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().setBackground(new Color(209, 216, 224));   
    return f;

    }    

 


    
}

package coursemanagementsys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;


public class Formating {

 
    
    
    
    public JButton menuBtnStyle(JButton menuBtn ,String btnName){
      
     menuBtn= new JButton(btnName);
     menuBtn.setBackground(new Color(52,73,94));
     menuBtn.setForeground(new Color(255,255,255));//75, 101, 132
     menuBtn.setFocusPainted(false);
     menuBtn.setFont(new Font("Lato",Font.BOLD,20));
     menuBtn.setBorder(new LineBorder(new Color(40,60,60)));
     
     return menuBtn;
    }

    public JButton panelBtnStyle(JButton Btn ,String btnName){
      
     Btn= new JButton(btnName);
     Btn.setBackground(Color.WHITE);
     Btn.setForeground(new Color(52,73,94));
     Btn.setFocusPainted(false);
     Btn.setFont(new Font("Lato",Font.BOLD,15));
     Btn.setBorder(new LineBorder(Color.WHITE));
     
     return Btn;
    }
    
    
    public JPanel adminPanel(){
        JPanel mainAdminPanel = new JPanel();
        mainAdminPanel.setBounds(0,0,800,580);
        mainAdminPanel.setLayout(null);
        mainAdminPanel.setBackground(new Color(209, 216, 224));
        
        JPanel addAdminPanel = new JPanel();
        addAdminPanel.setBounds(0,20,560,120);
        addAdminPanel.setBackground(new Color(52,73,94));
        addAdminPanel.setLayout(null);
        
        JLabel addNewAdminLb = new JLabel("Add New Admin");
        addNewAdminLb.setBounds(10,5,200,30);
        addNewAdminLb.setFont(new Font("Lato",Font.BOLD,18));
        addNewAdminLb.setForeground(Color.WHITE);
        JLabel paragraphNewAdminLb = new JLabel("By clicking on ADD you are going to regester a new Admin to the system");
        paragraphNewAdminLb.setBounds(10,40,550,30);
        paragraphNewAdminLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphNewAdminLb.setForeground(Color.WHITE);        
        JButton AddBtn = new JButton();
        AddBtn = panelBtnStyle(AddBtn ,"ADD");
        AddBtn.setBounds(10,80,50,30);
        
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms forme = new Forms();
             forme.signUpAdminForm();   
            }
        });
               
        JPanel removeAdminPanel = new JPanel();
        removeAdminPanel.setBounds(0,160,560,120);
        removeAdminPanel.setBackground(new Color(52,73,94));
        removeAdminPanel.setLayout(null);
        
        JLabel removeAdminLb = new JLabel("Remove Admin");
        removeAdminLb.setBounds(10,5,200,30);
        removeAdminLb.setFont(new Font("Lato",Font.BOLD,18));
        removeAdminLb.setForeground(Color.WHITE);
        JLabel paragraphRemoveLb = new JLabel("By clicking on REMOVE you are going to delete Admin from the system");
        paragraphRemoveLb.setBounds(10,40,550,30);
        paragraphRemoveLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphRemoveLb.setForeground(Color.WHITE);        
        JButton RemoveBtn = new JButton();
        RemoveBtn = panelBtnStyle(RemoveBtn ,"REMOVE");
        RemoveBtn.setBounds(10,80,90,30);
        
        RemoveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.removeAdminForm();
            }
        });
      
        
        JPanel editAdminPanel = new JPanel();
        editAdminPanel.setBounds(0,300,560,120);
        editAdminPanel.setBackground(new Color(52,73,94));
        editAdminPanel.setLayout(null);
        
        JLabel editAdminLb = new JLabel("Edit Admin");
        editAdminLb.setBounds(10,5,200,30);
        editAdminLb.setFont(new Font("Lato",Font.BOLD,18));
        editAdminLb.setForeground(Color.WHITE);
        JLabel paragraphEditLb = new JLabel("By clicking on EDIT you are going to edit an Admin");
        paragraphEditLb.setBounds(10,40,550,30);
        paragraphEditLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphEditLb.setForeground(Color.WHITE);        
        JButton EditBtn = new JButton();
        EditBtn = panelBtnStyle(EditBtn ,"EDIT");
        EditBtn.setBounds(10,80,60,30);
        
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.editAdminFirstForm();
            }
        });

        JPanel viewAdminPanel = new JPanel();
        viewAdminPanel.setBounds(0,440,560,120);
        viewAdminPanel.setBackground(new Color(52,73,94));
        viewAdminPanel.setLayout(null);        

        JLabel viewAdminLb = new JLabel("View Admins");
        viewAdminLb.setBounds(10,5,200,30);
        viewAdminLb.setFont(new Font("Lato",Font.BOLD,18));
        viewAdminLb.setForeground(Color.WHITE);
        JLabel paragraphViewLb = new JLabel("By clicking on VIEW you are going to display all Admins");
        paragraphViewLb.setBounds(10,40,550,30);
        paragraphViewLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphViewLb.setForeground(Color.WHITE);        
        JButton ViewBtn = new JButton();
        ViewBtn = panelBtnStyle(EditBtn ,"VIEW");
        ViewBtn.setBounds(10,80,60,30);
        
        ViewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame();
               frame.add(new Tables().DispalyAdminTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
                
                
            }
        });        
        

        viewAdminPanel.add(viewAdminLb);
        viewAdminPanel.add(paragraphViewLb);
        viewAdminPanel.add(ViewBtn);        
        
        
        editAdminPanel.add(editAdminLb);
        editAdminPanel.add(paragraphEditLb);
        editAdminPanel.add(EditBtn);        
        
        removeAdminPanel.add(removeAdminLb);
        removeAdminPanel.add(paragraphRemoveLb);
        removeAdminPanel.add(RemoveBtn);
        
        addAdminPanel.add(addNewAdminLb);
        addAdminPanel.add(paragraphNewAdminLb);
        addAdminPanel.add(AddBtn);
        
        
        mainAdminPanel.add(viewAdminPanel);
        mainAdminPanel.add(editAdminPanel); 
        mainAdminPanel.add(removeAdminPanel);
        mainAdminPanel.add(addAdminPanel);
        mainAdminPanel.setVisible(true);
        

        

   
        return mainAdminPanel;

    }
     

    public JPanel instructorPanel(){
        
        JPanel mainInstructorPanel = new JPanel();
        mainInstructorPanel.setBounds(0,0,800,580);
        mainInstructorPanel.setLayout(null);
        mainInstructorPanel.setBackground(new Color(209, 216, 224));
        
        JPanel addInstructorPanel = new JPanel();
        addInstructorPanel.setBounds(0,20,560,120);
        addInstructorPanel.setBackground(new Color(52,73,94));
        addInstructorPanel.setLayout(null);
        
        JLabel addNewInstructorLb = new JLabel("Add New Instructor");
        addNewInstructorLb.setBounds(10,5,200,30);
        addNewInstructorLb.setFont(new Font("Lato",Font.BOLD,18));
        addNewInstructorLb.setForeground(Color.WHITE);
        JLabel paragraphNewInstructorLb = new JLabel("By clicking on ADD you are going to regester a new Instructor to the system");
        paragraphNewInstructorLb.setBounds(10,40,550,30);
        paragraphNewInstructorLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphNewInstructorLb.setForeground(Color.WHITE);        
        JButton AddBtn = new JButton();
        AddBtn = panelBtnStyle(AddBtn ,"ADD");
        AddBtn.setBounds(10,80,50,30);
        
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms forme = new Forms();
             forme.signUpInstructorForm();
            }
        });
        
        JPanel removeInstructorPanel = new JPanel();
        removeInstructorPanel.setBounds(0,160,560,120);
        removeInstructorPanel.setBackground(new Color(52,73,94));
        removeInstructorPanel.setLayout(null);
        
        JLabel removeInstructorLb = new JLabel("Remove Instructor");
        removeInstructorLb.setBounds(10,5,200,30);
        removeInstructorLb.setFont(new Font("Lato",Font.BOLD,18));
        removeInstructorLb.setForeground(Color.WHITE);
        
        JLabel paragraphRemoveLb = new JLabel("By clicking on REMOVE you are going to delete Instructor from the system");
        paragraphRemoveLb.setBounds(10,40,550,30);
        paragraphRemoveLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphRemoveLb.setForeground(Color.WHITE);        
        JButton RemoveBtn = new JButton();
        
        RemoveBtn = panelBtnStyle(RemoveBtn ,"REMOVE");
        RemoveBtn.setBounds(10,80,90,30);
        
        RemoveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.removeInstructorForm();
            }
        });
        
        JPanel editInstructorPanel = new JPanel();
        editInstructorPanel.setBounds(0,300,560,120);
        editInstructorPanel.setBackground(new Color(52,73,94));
        editInstructorPanel.setLayout(null);
        
        JLabel editInstructorLb = new JLabel("Edit Instructor");
        editInstructorLb.setBounds(10,5,200,30);
        editInstructorLb.setFont(new Font("Lato",Font.BOLD,18));
        editInstructorLb.setForeground(Color.WHITE);
        JLabel paragraphEditLb = new JLabel("By clicking on EDIT you are going to edit an Instructor");
        paragraphEditLb.setBounds(10,40,550,30);
        paragraphEditLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphEditLb.setForeground(Color.WHITE);        
        JButton EditBtn = new JButton();
        EditBtn = panelBtnStyle(EditBtn ,"EDIT");
        EditBtn.setBounds(10,80,60,30);
        
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.editInstructorFirstForm();
            }
        });
        
        JPanel viewInstructorPanel = new JPanel();
        viewInstructorPanel.setBounds(0,440,560,120);
        viewInstructorPanel.setBackground(new Color(52,73,94));
        viewInstructorPanel.setLayout(null);        

        JLabel viewInstructorLb = new JLabel("View Instructors");
        viewInstructorLb.setBounds(10,5,200,30);
        viewInstructorLb.setFont(new Font("Lato",Font.BOLD,18));
        viewInstructorLb.setForeground(Color.WHITE);
        JLabel paragraphViewLb = new JLabel("By clicking on VIEW you are going to display all Instructors");
        paragraphViewLb.setBounds(10,40,550,30);
        paragraphViewLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphViewLb.setForeground(Color.WHITE);        
        JButton ViewBtn = new JButton();
        ViewBtn = panelBtnStyle(EditBtn ,"VIEW");
        ViewBtn.setBounds(10,80,60,30);
        
        ViewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame();
               frame.add(new Tables().DispalyInstructorTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }
        });        
        

        viewInstructorPanel.add(viewInstructorLb);
        viewInstructorPanel.add(paragraphViewLb);
        viewInstructorPanel.add(ViewBtn);
        
        
        editInstructorPanel.add(editInstructorLb);
        editInstructorPanel.add(paragraphEditLb);
        editInstructorPanel.add(EditBtn);         
        
        removeInstructorPanel.add(removeInstructorLb);
        removeInstructorPanel.add(paragraphRemoveLb);
        removeInstructorPanel.add(RemoveBtn);        
        
        addInstructorPanel.add(addNewInstructorLb);
        addInstructorPanel.add(paragraphNewInstructorLb);
        addInstructorPanel.add(AddBtn);
   
        mainInstructorPanel.add(viewInstructorPanel);
        mainInstructorPanel.add(editInstructorPanel);
        mainInstructorPanel.add(removeInstructorPanel);
        mainInstructorPanel.add(addInstructorPanel);
        mainInstructorPanel.setVisible(true);
        
        return mainInstructorPanel;

    }    
    
    public JPanel studentPanel(){
        
        JPanel mainInstructorPanel = new JPanel();
        mainInstructorPanel.setBounds(0,0,800,580);
        mainInstructorPanel.setLayout(null);
        mainInstructorPanel.setBackground(new Color(209, 216, 224));
        
        JPanel addStudentPanel = new JPanel();
        addStudentPanel.setBounds(0,20,560,120);
        addStudentPanel.setBackground(new Color(52,73,94));
        addStudentPanel.setLayout(null);
        
        JLabel addNewStudentLb = new JLabel("Add New Student");
        addNewStudentLb.setBounds(10,5,200,30);
        addNewStudentLb.setFont(new Font("Lato",Font.BOLD,18));
        addNewStudentLb.setForeground(Color.WHITE);
        JLabel paragraphNewStudentLb = new JLabel("By clicking on ADD you are going to regester a new Student to the system");
        paragraphNewStudentLb.setBounds(10,40,550,30);
        paragraphNewStudentLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphNewStudentLb.setForeground(Color.WHITE);        
        JButton AddBtn = new JButton();
        AddBtn = panelBtnStyle(AddBtn ,"ADD");
        AddBtn.setBounds(10,80,50,30);
        
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms forme = new Forms();
             forme.signUpStudentForm();
            }
        });
        
        JPanel removeStudentPanel = new JPanel();
        removeStudentPanel.setBounds(0,160,560,120);
        removeStudentPanel.setBackground(new Color(52,73,94));
        removeStudentPanel.setLayout(null);
        
        JLabel removeStudentLb = new JLabel("Remove Student");
        removeStudentLb.setBounds(10,5,200,30);
        removeStudentLb.setFont(new Font("Lato",Font.BOLD,18));
        removeStudentLb.setForeground(Color.WHITE);
        
        JLabel paragraphRemoveLb = new JLabel("By clicking on REMOVE you are going to delete Student from the system");
        paragraphRemoveLb.setBounds(10,40,550,30);
        paragraphRemoveLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphRemoveLb.setForeground(Color.WHITE);        
        JButton RemoveBtn = new JButton();
        
        RemoveBtn = panelBtnStyle(RemoveBtn ,"REMOVE");
        RemoveBtn.setBounds(10,80,90,30);
        
        RemoveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.removeStudentForm();
            }
        });

        JPanel editStudentPanel = new JPanel();
        editStudentPanel.setBounds(0,300,560,120);
        editStudentPanel.setBackground(new Color(52,73,94));
        editStudentPanel.setLayout(null);
        
        JLabel editStudentLb = new JLabel("Edit Student");
        editStudentLb.setBounds(10,5,200,30);
        editStudentLb.setFont(new Font("Lato",Font.BOLD,18));
        editStudentLb.setForeground(Color.WHITE);
        JLabel paragraphEditLb = new JLabel("By clicking on EDIT you are going to edit a Student");
        paragraphEditLb.setBounds(10,40,550,30);
        paragraphEditLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphEditLb.setForeground(Color.WHITE);        
        JButton EditBtn = new JButton();
        EditBtn = panelBtnStyle(EditBtn ,"EDIT");
        EditBtn.setBounds(10,80,60,30);
        
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.editStudentFirstForm();
            }
        });
 

        JPanel viewStudentPanel = new JPanel();
        viewStudentPanel.setBounds(0,440,560,120);
        viewStudentPanel.setBackground(new Color(52,73,94));
        viewStudentPanel.setLayout(null);        

        JLabel viewStudentLb = new JLabel("View Students");
        viewStudentLb.setBounds(10,5,200,30);
        viewStudentLb.setFont(new Font("Lato",Font.BOLD,18));
        viewStudentLb.setForeground(Color.WHITE);
        JLabel paragraphViewLb = new JLabel("By clicking on VIEW you are going to display all Students");
        paragraphViewLb.setBounds(10,40,550,30);
        paragraphViewLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphViewLb.setForeground(Color.WHITE);        
        JButton ViewBtn = new JButton();
        ViewBtn = panelBtnStyle(EditBtn ,"VIEW");
        ViewBtn.setBounds(10,80,60,30);
        
        ViewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               JFrame frame = new JFrame();
               frame.add(new Tables().DispalyStudentTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
            }
        });        
        

        viewStudentPanel.add(viewStudentLb);
        viewStudentPanel.add(paragraphViewLb);
        viewStudentPanel.add(ViewBtn);        
        
        editStudentPanel.add(editStudentLb);
        editStudentPanel.add(paragraphEditLb);
        editStudentPanel.add(EditBtn);          
        
        removeStudentPanel.add(removeStudentLb);
        removeStudentPanel.add(paragraphRemoveLb);
        removeStudentPanel.add(RemoveBtn);    
        
        addStudentPanel.add(addNewStudentLb);
        addStudentPanel.add(paragraphNewStudentLb);
        addStudentPanel.add(AddBtn);
   
        mainInstructorPanel.add(viewStudentPanel);
        mainInstructorPanel.add(editStudentPanel); 
        mainInstructorPanel.add(removeStudentPanel);
        mainInstructorPanel.add(addStudentPanel);
        mainInstructorPanel.setVisible(true);
        
        return mainInstructorPanel;

    }
    
    public JPanel coursePanel(){
        
        JPanel mainInstructorPanel = new JPanel();
        mainInstructorPanel.setBounds(0,0,800,580);
        mainInstructorPanel.setLayout(null);
        mainInstructorPanel.setBackground(new Color(209, 216, 224));
        
        JPanel addCoursePanel = new JPanel();
        addCoursePanel.setBounds(0,20,560,120);
        addCoursePanel.setBackground(new Color(52,73,94));
        addCoursePanel.setLayout(null);
        
        JLabel addNewCourseLb = new JLabel("Add New Course");
        addNewCourseLb.setBounds(10,5,200,30);
        addNewCourseLb.setFont(new Font("Lato",Font.BOLD,18));
        addNewCourseLb.setForeground(Color.WHITE);
        JLabel paragraphNewCourseLb = new JLabel("Click on ADD to insert new Course");
        paragraphNewCourseLb.setBounds(10,40,550,30);
        paragraphNewCourseLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphNewCourseLb.setForeground(Color.WHITE);        
        JButton AddBtn = new JButton();
        AddBtn = panelBtnStyle(AddBtn ,"ADD");
        AddBtn.setBounds(10,80,90,30);
        
        AddBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms forme = new Forms();
             forme.signUpCourseForm();
            }
        });
   
        
        JPanel removeCoursePanel = new JPanel();
        removeCoursePanel.setBounds(0,160,560,120);
        removeCoursePanel.setBackground(new Color(52,73,94));
        removeCoursePanel.setLayout(null);
        
        JLabel removeCourseLb = new JLabel("Remove Course");
        removeCourseLb.setBounds(10,5,200,30);
        removeCourseLb.setFont(new Font("Lato",Font.BOLD,18));
        removeCourseLb.setForeground(Color.WHITE);
        
        JLabel paragraphRemoveLb = new JLabel("Click on REMOVE to delete a Course");
        paragraphRemoveLb.setBounds(10,40,550,30);
        paragraphRemoveLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphRemoveLb.setForeground(Color.WHITE);        
        JButton RemoveBtn = new JButton();
        JButton RemoveBtn2 = new JButton();
        
        RemoveBtn = panelBtnStyle(RemoveBtn ,"REMOVE");
        RemoveBtn.setBounds(10,80,90,30);        
        RemoveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.removeCourseForm();
            }
        });
     
        
        JPanel editCoursePanel = new JPanel();
        editCoursePanel.setBounds(0,300,560,120);
        editCoursePanel.setBackground(new Color(52,73,94));
        editCoursePanel.setLayout(null);
        
        JLabel editCourseLb = new JLabel("Edit Course");
        editCourseLb.setBounds(10,5,200,30);
        editCourseLb.setFont(new Font("Lato",Font.BOLD,18));
        editCourseLb.setForeground(Color.WHITE);
        JLabel paragraphEditLb = new JLabel("Click on EDIT to upadare a Course");
        paragraphEditLb.setBounds(10,40,550,30);
        paragraphEditLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphEditLb.setForeground(Color.WHITE);        
        JButton EditBtn = new JButton();
        JButton EditBtn2 = new JButton();
        
        EditBtn = panelBtnStyle(EditBtn ,"EDIT");
        EditBtn.setBounds(10,80,90,30);
        
        EditBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
             Forms form = new Forms();
             form.editCourseFirstForm();
            }
        });
   
        
        JPanel viewCoursePanel = new JPanel();
        viewCoursePanel.setBounds(0,440,560,120);
        viewCoursePanel.setBackground(new Color(52,73,94));
        viewCoursePanel.setLayout(null);
 
        
        JLabel viewCourseLb = new JLabel("View Courses");
        viewCourseLb.setBounds(10,5,200,30);
        viewCourseLb.setFont(new Font("Lato",Font.BOLD,18));
        viewCourseLb.setForeground(Color.WHITE);
        JLabel paragraphViewLb = new JLabel("Click on VIEW to display all Courses");
        paragraphViewLb.setBounds(10,40,550,30);
        paragraphViewLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphViewLb.setForeground(Color.WHITE);        
        JButton ViewBtn = new JButton();
        
        ViewBtn = panelBtnStyle(EditBtn ,"VIEW");
        ViewBtn.setBounds(10,80,90,30);
        
        ViewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame frame = new JFrame();
               frame.add(new Tables().DispalyCourseTable());
               frame.setSize(1000,700);
               frame.setLocationRelativeTo(null);
               frame.setVisible(true);
               
            }
        });        
        
        
        viewCoursePanel.add(viewCourseLb);
        viewCoursePanel.add(paragraphViewLb);
        viewCoursePanel.add(ViewBtn);

        editCoursePanel.add(editCourseLb);
        editCoursePanel.add(paragraphEditLb);
        editCoursePanel.add(EditBtn);        

        
        removeCoursePanel.add(removeCourseLb);
        removeCoursePanel.add(paragraphRemoveLb);
        removeCoursePanel.add(RemoveBtn);    
        
        addCoursePanel.add(addNewCourseLb);
        addCoursePanel.add(paragraphNewCourseLb);
        addCoursePanel.add(AddBtn);        
        
        mainInstructorPanel.add(viewCoursePanel); 
        mainInstructorPanel.add(editCoursePanel);
        mainInstructorPanel.add(removeCoursePanel);
        mainInstructorPanel.add(addCoursePanel);
        mainInstructorPanel.setVisible(true);
        
        return mainInstructorPanel;

    }    
    
    
    public JPanel ProfilePanel (){
        Database database = new Database();
        
                
        JPanel mainProfilePanel = new JPanel();
        mainProfilePanel.setBounds(0,0,800,580);
        mainProfilePanel.setLayout(null);
        mainProfilePanel.setBackground(new Color(209, 216, 224));
        
        JPanel profileInfoPanel = new JPanel();
        profileInfoPanel.setBounds(0,10,560,150);
        profileInfoPanel.setBackground(new Color(52,73,94));
        profileInfoPanel.setLayout(null);
        
        JLabel profileInfoLb = new JLabel("Admin Information");
        profileInfoLb.setBounds(10,5,200,30);
        profileInfoLb.setFont(new Font("Lato",Font.BOLD,18));
        profileInfoLb.setForeground(Color.WHITE);
        
        database.PrintAdminInfo();
        
        JLabel Id = new JLabel("ID : " + Database.currentId);
        Id.setBounds(10,50,550,30);
        Id.setFont(new Font("Lato",Font.BOLD,15));
        Id.setForeground(Color.WHITE); 
        
        JLabel UName = new JLabel("Username : " + Database.currentUsername);
        UName.setBounds(10,70,550,30);
        UName.setFont(new Font("Lato",Font.BOLD,15));
        UName.setForeground(Color.WHITE); 
        
        JLabel FName = new JLabel("First Name : " + Database.currentFirstName);
        FName.setBounds(10,90,550,30);
        FName.setFont(new Font("Lato",Font.BOLD,15));
        FName.setForeground(Color.WHITE);
        
        JLabel LName = new JLabel("Last Name : " + Database.currentLastName);
        LName.setBounds(10,110,550,30);
        LName.setFont(new Font("Lato",Font.BOLD,15));
        LName.setForeground(Color.WHITE);
        
        
        profileInfoPanel.add(profileInfoLb);
        profileInfoPanel.add(Id);
        profileInfoPanel.add(UName);
        profileInfoPanel.add(FName);
        profileInfoPanel.add(LName);
        

        JPanel resetPanel = new JPanel();
        resetPanel.setBounds(0,180,560,120);
        resetPanel.setBackground(new Color(52,73,94));
        resetPanel.setLayout(null);
        
        JLabel resetLb = new JLabel("Reset Database");
        resetLb.setBounds(10,5,200,30);
        resetLb.setFont(new Font("Lato",Font.BOLD,18));
        resetLb.setForeground(Color.WHITE);
        
        JLabel paragraphLb = new JLabel("Click on RESET to reset the database");
        paragraphLb.setBounds(10,40,550,30);
        paragraphLb.setFont(new Font("Lato",Font.BOLD,15));
        paragraphLb.setForeground(Color.WHITE);        
        JButton resetBtn = new JButton();
        
        resetBtn = panelBtnStyle(resetBtn ,"RESET");
        resetBtn.setBounds(10,80,90,30);        
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Database database = new Database();
                if (JOptionPane.showConfirmDialog( null,"Are You Sure You Want To Reset The Database ?\nIf you clicked Yes The programe will be shutdown","Database Reset", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
                 {  
                     database.reset1();
                     database.reset2();
                     System.exit(0);
                }
            }
        });
        
        resetPanel.add(resetLb);
        resetPanel.add(paragraphLb);
        resetPanel.add(resetBtn);

        

        
        mainProfilePanel.add(profileInfoPanel);
        mainProfilePanel.add(resetPanel);
        
    
        return mainProfilePanel;
    }
  

}

package coursemanagementsys;


import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


public class Database {
    
    //=========================================================================================================================//
    //********** static var **********//
    //=========================================================================================================================//    
    static String currentFirstName;
    static String currentLastName;
    static int currentId;
    static String currentUsername;
    static int currentPhone;
    static String currentEmail;
    static String currentDp;
    
    
    
    
    
    static String STUDENTNAME;
    static String TABLENAME;
    static int ID;
    //=========================================================================================================================//
    
    //=========================================================================================================================//    
      

    
    //=========================================================================================================================//
    //********** LOGIN **********//
    //=========================================================================================================================//
    public boolean LoginAsAdmin(String username,String pass){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from admininfo where username = '"+username+"' and password = '"+pass+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }
    

    public boolean LoginAsInstructor(String username,String pass){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from instructorInfo where username = '"+username+"' and password = '"+pass+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    } 

    public boolean LoginAsStudent(String username,String pass){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from studentinfo where username = '"+username+"' and password = '"+pass+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }

    //=========================================================================================================================//
    
    //=========================================================================================================================//    



    //=========================================================================================================================//
    //********** Print The Info **********//
    //=========================================================================================================================//    
    
    public void PrintAdminInfo(){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = " select * from admininfo where Username = '"+Forms.current+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);
      
      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      {
          currentFirstName =result.getString("firstname");
          currentLastName = result.getString("lastname");
          currentId = result.getInt("adminId");
          currentUsername =  result.getString("username");
      }
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
  
    }


    public void PrintInstructorInfo(){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = " select * from instructorInfo where username = '"+Forms.current+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);
      
      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      {
          currentFirstName =result.getString("firstname");
          currentLastName = result.getString("lastname");
          currentId = result.getInt("instructorId");
          currentUsername =  result.getString("username");
          currentPhone = result.getInt("phone");
          currentEmail =  result.getString("email");
          currentDp =  result.getString("department");
          
      }
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
  
    }    

    public void PrintStudentInfo(){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = " select * from studentInfo where username = '"+Forms.current+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);
      
      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      {
          currentFirstName =result.getString("firstname");
          currentLastName = result.getString("lastname");
          currentId = result.getInt("studentId");
          currentUsername =  result.getString("username");
          currentPhone = result.getInt("phone");
          currentEmail =  result.getString("email");
          currentDp =  result.getString("major");
          
      }
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
  
    }  
    

    //=========================================================================================================================//
    
    //=========================================================================================================================//   
    
    

    
    //=========================================================================================================================//
    //********** Insert To The DataBase **********//
    //=========================================================================================================================//  


    public void NewAssignmet(String name,String courseName,String sec,int mark,String date,String des){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into assignmetInfo (name,course,section,mark,date,des,instructorId) "
              + "values ( '"+name+"', '"+courseName+"', '"+sec+"', "+mark+",'"+date+"','"+des+"', "+currentId+");";
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","New Assignmet",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    }    
    
    
    
    public void NewCourse(String name,int sec,String day,String time,String instructor){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into courseTInfo (name,section,day,time,instructor) "
              + "values ( '"+name+"', "+sec+", '"+day+"','"+time+"','"+instructor+"');";
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","New Course",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    }     


    
    public void NewStudent(String username,String pass,String firstName,String lastName,int phone,String email,String major){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into studentInfo (username,password,firstname,lastname,phone,email,major) "
              + "values ('"+username+"', '"+pass+"', '"+firstName+"', '"+lastName+"',"+phone+",'"+email+"','"+major+"');";
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","New Student",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    } 
    
    
    
    public void NewInstructor(String username,String pass,String firstName,String lastName,int phone,String email,String department){
              
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into instructorInfo (username,password,firstname,lastname,phone,email,department) "
              + "values ('"+username+"', '"+pass+"', '"+firstName+"' , '"+lastName+"' , "+phone+", '"+email+"' , '"+department+"');";
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","New Instructor",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
    
    }
    
    
    public void NewAdmin(String username,String pass,String firstName,String lastName,int phone,String email){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into adminInfo (username,password,firstname,lastname,phone,email) "
              + "values ('"+username+"', '"+pass+"', '"+firstName+"', '"+lastName+"',"+phone+",'"+email+"');";
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","New Admin",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    }    

        
    public void NewMarkT(String name){
               
          try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS "+name+" "+
                            "(num INTEGER auto_increment,"
                            +"studentname VARCHAR(255) NOT NULL ,"
                            +"section INTEGER  NOT NULL,"
                            +"mark INTEGER NOT NULL,"
                            +"instructorId INTEGER NOT NULL," 
                            +"PRIMARY KEY (num))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }     
    }
    
    
    public void NewMark(String tb,String name,int sec,int mark){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into "+tb+" (studentname,section,mark,instructorId) "
              + "values ('"+name+"', "+sec+", "+mark+", "+currentId+");";
  
       stmt.executeUpdate(query);
      
      
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    }
    
    
    
    public void NewStudentCourse(String name){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " insert into courseSInfo (name,studentID) "
              + "values ('"+name+"' , "+Database.currentId+" );";
  
       stmt.executeUpdate(query);
      
      
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    }     
    //=========================================================================================================================//
    
    //=========================================================================================================================//   
    
    
    //=========================================================================================================================//
    //********** Remove From The Database **********//
    //=========================================================================================================================//

    public void removeAdmin (int id){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from admininfo where adminId = "+id;
      stmt.executeUpdate(query);

      
      JOptionPane.showMessageDialog(null,"Done !!!","Admin Removed",JOptionPane.INFORMATION_MESSAGE);
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }    
    
    
    }

    
    public void removeInstructor (int id){

          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String qu = "delete from instructorInfo where instructorId = "+id;
      stmt.executeUpdate(qu);

      
      JOptionPane.showMessageDialog(null,"Done !!!","Instructor Removed",JOptionPane.INFORMATION_MESSAGE);
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }    

    }    
   
    public void removeStudent (int id){
        
         try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from studentinfo where studentId = "+id;
      stmt.executeUpdate(query);

      
      JOptionPane.showMessageDialog(null,"Done !!!","Student Removed",JOptionPane.INFORMATION_MESSAGE);
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
    
    }


    public void removeCourse (int crn){
        
         try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from courseTInfo where crn = "+crn;
      stmt.executeUpdate(query);

      
  
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
    
    } 
    


    public void removeStudentCourse (String name){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from courseSInfo where name = '"+name+"' and studentID = "+Database.currentId+" ";
      stmt.executeUpdate(query);

      
      JOptionPane.showMessageDialog(null,"Done !!!","Course Removed",JOptionPane.INFORMATION_MESSAGE);
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,"Could not find the course","Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }    
    
    
    }    
    
    public void removeAssignmet (int num){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from assignmetInfo where num = "+num+" and instructorId = " + currentId;
      stmt.executeUpdate(query);

      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }    
    
    
    }

    public void removeMark (String tableName,String SName){
        
        
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
      Statement stmt = con.createStatement();

      String query = "delete from "+tableName+" where studentname = '"+SName+"' ";
      stmt.executeUpdate(query);

      
      JOptionPane.showMessageDialog(null,"Done !!!","Mark Removed",JOptionPane.INFORMATION_MESSAGE);
      con.close();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }    

    }
    
    //=========================================================================================================================//

    //=========================================================================================================================//   
    
    
    //=========================================================================================================================//
    //********** Update **********//
    //=========================================================================================================================//
    
    public boolean CheckUpdateAdmin(int id){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from admininfo where adminId = "+id;

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      ID = id;
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }    
    
    public void updateAdmin(String username,String pass,String firstName,String lastName,int phone,String email){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query ="UPDATE adminInfo SET username = '"+username+"' , "
                + "password = '"+pass+"' ,"
                + "firstname = '"+firstName+"' ,"
                + "lastname = '"+lastName+"' ,"
                + "phone = "+phone+" ,"
                + "email = '"+email+"' "

                + "WHERE adminId = "+ID; 


       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","Edited",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    }    
    
    
    public boolean CheckUpdateInstructor(int id){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from instructorInfo where instructorId = "+id;

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      ID = id;
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }    
    
    
    
    public void updateInstructor(String username,String pass,String firstName,String lastName,int phone,String email,String department){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query ="UPDATE instructorInfo SET username = '"+username+"' , "
                + "password = '"+pass+"' ,"
                + "firstname = '"+firstName+"' ,"
                + "lastname = '"+lastName+"' ,"
                + "phone = "+phone+" ,"
                + "email = '"+email+"' ,"
                + "department = '"+department+"' "
                + "WHERE instructorId = "+ID; 

  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","Edited!!",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    }    


    
    public boolean CheckUpdateStudent(int id){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from studentInfo where studentId = "+id;

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      ID = id;
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }    
    
    
    
    public void updateStudent(String username,String pass,String firstName,String lastName,int phone,String email,String major){                      
                 
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      String query ="UPDATE studentInfo SET username = '"+username+"' , "
                + "password = '"+pass+"' ,"
                + "firstname = '"+firstName+"' ,"
                + "lastname = '"+lastName+"' ,"
                + "phone = "+phone+" ,"
                + "email = '"+email+"' ,"
                + "major = '"+major+"' "
                + "WHERE studentId = "+ID; 

  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","Edited!!",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
          
    } 


    public void updateCourse(String name,int sec,String day,String time,String instructor){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
      
            String query ="UPDATE courseTInfo SET  "
                + "name = '"+name+"' ,"
                + "section = '"+sec+"' ,"
                + "day = '"+day+"' ,"
                + "time = "+time+" ,"
                + "instructor = '"+instructor+"' "                 
                + "WHERE crn = "+ID; 
    
  
       stmt.executeUpdate(query);
      
      JOptionPane.showMessageDialog(null,"Done !!!","Course updated",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    } 
    
    public boolean CheckUpdateCourse(int crn){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from courseTInfo where crn = "+crn+"";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      ID = crn;
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    } 
   
    
    public boolean CheckUpdateAssignmet(int num){
        boolean check = false;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select * from assignmetInfo where num = "+num+" and instructorId = "+currentId;

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=true;
      ID = num;
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }  
    
    
    public void updateAssignmet(String name,String courseName,String sec,int mark,String date,String des){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      
      
                  String query ="UPDATE assignmetInfo SET  "
                + "name = '"+name+"' ,"
                + "course = '"+courseName+"' ,"          
                + "section = '"+sec+"' ,"
                + "mark = '"+mark+"' ,"
                + "date = "+date+" ,"
                + "des = '"+des+"' "                  
                + "WHERE num = "+ID; 


       stmt.executeUpdate(query);
      
         JOptionPane.showMessageDialog(null,"Done !!!","Assignment Updated",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    } 
    
    
    

    public boolean checkUpdateMark(String tb,String name){                      
          boolean check = false;       
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
      Statement stmt = con.createStatement();
      
      
      String query = " select * from "+tb+" where studentname = '"+name+"'";
             
  
       PreparedStatement preparedStmt = con.prepareStatement(query);
       ResultSet result;
       result = preparedStmt.executeQuery();
       if(result.next())
       check=true;
       STUDENTNAME = name;
       TABLENAME = tb;
       con.close();
      
      
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
      return check;    
    }     
    

    public void updateMark(int mark){
               
          try
    {
     

      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
      Statement stmt = con.createStatement();
      
      
                  String query ="UPDATE "+TABLENAME+" SET  "
                + "mark = "+mark+" "                 
                + "WHERE studentname = '"+STUDENTNAME+"' "; 

  
       stmt.executeUpdate(query);
      
         JOptionPane.showMessageDialog(null,"Done !!!","Mark Updated",JOptionPane.INFORMATION_MESSAGE);
      
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }
       
    }     
    
    //=========================================================================================================================//

    //=========================================================================================================================//
    
    
    
    //=========================================================================================================================//
    //********** Lists **********//
    //=========================================================================================================================//

    
    public JComboBox instructorList(){
       JComboBox cb = new JComboBox();
      
       int i=0;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select firstname, lastname from instructorInfo ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      while(result.next()){
      String s = result.getString("firstname");
      String s2 = result.getString("lastname"); 
      cb.addItem(s+" "+s2);
      }
      
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        return cb;
        
   
    }    


    public JComboBox courseList(){
       JComboBox cb = new JComboBox();
      
       
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select name from courseTInfo where instructor = '"+currentFirstName+" "+currentLastName+"' ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      while(result.next()){
      String s = result.getString("name");     
      cb.addItem(s);
      }
      
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        return cb;
        
   
    }

    
    
    public JComboBox courseListS(){
       JComboBox cb = new JComboBox();
      
       
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select name, section , day , time from courseTInfo ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      while(result.next()){
      String s1 = result.getString("name");
      int s2 = result.getInt("section");
      String s3 = result.getString("day");
      String s4 = result.getString("time");
      cb.addItem(s1+" SEC: "+s2+" DAY: "+s3+" TIME: "+s4);
      }
      
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        return cb;
        
   
    }    
    
    public JComboBox StudentList(){
       JComboBox cb = new JComboBox();
      
       
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String query = " select firstname, lastname, studentId from studentInfo ";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      while(result.next()){
      String s = result.getString("firstname");
      String s2 = result.getString("lastname"); 
      int id = result.getInt("studentId");
      cb.addItem(s+" "+s2+" "+id);
      }
      
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        return cb;
        
   
    }
    

    public JComboBox marksList(){
       JComboBox cb = new JComboBox();
      
       
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
      Statement stmt = con.createStatement();
      String query = " show tables ";

      
      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      while(result.next()){
      String s = result.getString(1);
      cb.addItem(s);
      }
      
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        return cb;
        
   
    }    
    
    //=========================================================================================================================//

    //=========================================================================================================================//    


    
    //=========================================================================================================================//
    //********** Other **********//
    //=========================================================================================================================//
    
    
    public boolean CheckStudentCourseName(String name){
        boolean check = true;
          try
    {
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String[] words = name.split(" ");
      String query = " select * from courseSInfo where name like '"+words[0]+"%'";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=false;
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }        

    public boolean CheckStudentCourseTime(String name){
        boolean check = true;
          try
    {
        
      Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
      Statement stmt = con.createStatement();
      String[] words = name.split(" ");
      String Word1= words[words.length-1];
      String Word2 = words[words.length-2];
      String Word3 = words[words.length-3];
      String query = " select * from courseSInfo where name like"
                   + " '%"+Word1+"%' and name like '%"+Word2+"%'  and name like '%"+Word3+"%'";

      PreparedStatement preparedStmt = con.prepareStatement(query);

      ResultSet result;
      result = preparedStmt.executeQuery();
      if(result.next())
      check=false;
      
      con.close();
    }
    catch (Exception e)
    {  
      JOptionPane.showMessageDialog(null,e.getMessage(),"Got an exception!",JOptionPane.ERROR_MESSAGE);  
    }        
        
      return check;  
    }

    public void reset1(){

        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "DROP ALL OBJECTS DELETE FILES ";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }
        }

    public void reset2(){

        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
             Statement stmt = con.createStatement();
             String sql = "DROP ALL OBJECTS DELETE FILES ";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }
        }

    //=========================================================================================================================//
    
    //=========================================================================================================================//    
    

    } 
    
    
    
   


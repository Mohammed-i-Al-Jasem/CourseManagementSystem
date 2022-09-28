package coursemanagementsys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CourseManagementSys {

    
    public static void main(String[] args) {
        
        
    //Admin Table >>>>>>>>>>>>>>>>>>>>   
        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS adminInfo"+
                            "(adminId INTEGER auto_increment,"
                            +"username VARCHAR(255) NOT NULL UNIQUE,"
                            +"password VARCHAR(255) NOT NULL,"
                            +"firstname VARCHAR(255) NOT NULL,"
                            +"lastname VARCHAR(255) NOT NULL,"
                            +"phone INTEGER NOT NULL UNIQUE,"
                            +"email VARCHAR(255) NOT NULL UNIQUE,"
                            +"PRIMARY KEY (adminId))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //First Admin If Not Exists >>>>>>>>>>>>>>>>>>>>   
        try
        {
            Database database = new Database();
            
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "select * from admininfo where adminId = 1";

             PreparedStatement preparedStmt = con.prepareStatement(sql);

             ResultSet result;
             result = preparedStmt.executeQuery();
             if(result.next())
                 con.close();
             else
              database.NewAdmin("admin","admin","Mohammed","MOHD",12345,"mohammed@kfu.edu.sa");
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    
    //Instructor Table >>>>>>>>>>>>>>>>>>>>>>>>>
        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS instructorInfo"+
                            "(instructorId INTEGER auto_increment,"
                            +"username VARCHAR(255) NOT NULL UNIQUE,"
                            +"password VARCHAR(255) NOT NULL,"
                            +"firstname VARCHAR(255) NOT NULL,"
                            +"lastname VARCHAR(255) NOT NULL,"
                            +"phone INTEGER NOT NULL UNIQUE,"
                            +"email VARCHAR(255) NOT NULL UNIQUE,"
                            +"department VARCHAR(255) NOT NULL,"
                            +"PRIMARY KEY (instructorId))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Student Table>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS studentInfo"+
                            "(studentId INTEGER auto_increment,"
                            +"username VARCHAR(255) NOT NULL UNIQUE,"
                            +"password VARCHAR(255) NOT NULL,"
                            +"firstname VARCHAR(255) NOT NULL,"
                            +"lastname VARCHAR(255) NOT NULL,"
                            +"phone INTEGER NOT NULL UNIQUE,"
                            +"email VARCHAR(255) NOT NULL UNIQUE,"
                            +"major VARCHAR(255) NOT NULL,"
                            +"PRIMARY KEY (studentId))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }        
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Course Theory Table>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS courseTInfo"+
                            "(crn INTEGER auto_increment,"
                            +"name VARCHAR(255) NOT NULL ,"
                            +"section INTEGER NOT NULL,"
                            +"day VARCHAR(255) NOT NULL,"
                            +"time VARCHAR(255) NOT NULL,"
                            +"instructor VARCHAR(255) NOT NULL,"
                            +"PRIMARY KEY (crn))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }     
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    //Assignment Table>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS assignmetInfo"+
                            "(num INTEGER auto_increment,"
                            +"name VARCHAR(255) NOT NULL ,"
                            +"course VARCHAR(255) NOT NULL ,"
                            +"section VARCHAR(255) NOT NULL,"
                            +"mark INTEGER NOT NULL,"
                            +"date DATE NOT NULL,"
                            +"des VARCHAR(max) NOT NULL," 
                            +"instructorId INTEGER NOT NULL," 
                            +"PRIMARY KEY (num))";
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }     
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //Student Courses Table>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        try
        {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
             String sql = "CREATE TABLE IF NOT EXISTS courseSInfo"+
                            "( name VARCHAR(255) NOT NULL ,"
                              + "studentID INTEGER NOT NULL )";
                           
                         
             stmt.executeUpdate(sql);
             
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        
        }     
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        Forms f = new Forms();
        f.loginForm();
        
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>    
       
    }
    
}

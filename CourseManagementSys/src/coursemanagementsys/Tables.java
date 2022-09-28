package coursemanagementsys;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Tables {
    
    DefaultTableModel model = new DefaultTableModel();
    JTable jtbl = new JTable(model);
    
    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(jtbl.getModel());

    private JTextField jtfFilter = new JTextField();
    
    
    
    public JPanel DispalyAdminTable(){
        JPanel cont = new JPanel();
        model.addColumn("Id");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("phone");
        model.addColumn("Email");
        
        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM adminInfo");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6),Rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });
        return cont;
    }
    
      public JPanel DispalyInstructorTable(){
        JPanel cont = new JPanel();
        model.addColumn("Id");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("phone");
        model.addColumn("Email");
        model.addColumn("Department");
        
        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM instructorInfo");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6),Rs.getString(7),Rs.getString(8)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });          

          return cont;
}  
   
      
public JPanel DispalyStudentTable(){
        JPanel cont = new JPanel();
        model.addColumn("Id");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("phone");
        model.addColumn("Email");
        model.addColumn("Major");
        
        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM studentInfo");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getInt(6),Rs.getString(7),Rs.getString(8)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });          

          return cont;
}        
    
      
      public JPanel DispalyCourseTable(){
        JPanel cont = new JPanel();
        model.addColumn("CRN");
        model.addColumn("Name");
        model.addColumn("Section");
        model.addColumn("Day");
        model.addColumn("Time");
        model.addColumn("Instructor");

        
        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM courseTInfo");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getInt(3),Rs.getString(4),Rs.getString(5),Rs.getString(6)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });          

          return cont;
}       
      


      public JPanel DispalyAssignmentTable(){
        JPanel cont = new JPanel();
        model.addColumn("Number");
        model.addColumn("Name");
        model.addColumn("Course");
        model.addColumn("Section");
        model.addColumn("Marks");
        model.addColumn("Deadline");
        model.addColumn("Discription");

        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM assignmetInfo where instructorId = "+Database.currentId);
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getInt(5),Rs.getString(6),Rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });          

          return cont;
}      


public JFrame DispalyMarkTable(String TName){
        JFrame frame = new JFrame();  
        JPanel cont = new JPanel();
        model.addColumn("No.");
        model.addColumn("Student");
        model.addColumn("Section");
        model.addColumn("Mark");


        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM "+TName+" "
                    + "where instructorId = "+Database.currentId+" or studentname = '"+Database.currentFirstName+" "+Database.currentLastName+" "+Database.currentId+"'");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getInt(3),Rs.getInt(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
      

        });    
        
        frame.add(cont);
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

          return frame;
}       

public JFrame DispalyMarkTableS(String TName){
        JFrame frame = new JFrame();  
        JPanel cont = new JPanel();
        model.addColumn("No.");
        model.addColumn("Student");
        model.addColumn("Section");
        model.addColumn("Mark");


        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabaseAssignment","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM "+TName+" "
                    + "where studentname = '"+Database.currentFirstName+" "+Database.currentLastName+" "+Database.currentId+"'");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getInt(3),Rs.getInt(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
      

        });    
        
        frame.add(cont);
        frame.setSize(1000,700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

          return frame;
}       

    public JPanel DispalyStudentCoursesTable(){
        JPanel cont = new JPanel();
        model.addColumn("Course");

        model.fireTableDataChanged();
        
        jtbl.setDefaultEditor(Object.class, null);
        
        try {
             Connection con = DriverManager.getConnection("jdbc:h2:"+"./Database/ProjectDatabase","root","root");
             Statement stmt = con.createStatement();
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM courseSInfo where studentID = "+Database.currentId);
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{ Rs.getString(1)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        jtbl.setRowSorter(rowSorter);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Search:"),
                BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);

        cont.setLayout(new BorderLayout());
        cont.add(panel, BorderLayout.SOUTH);
        JScrollPane scroll =new JScrollPane(jtbl); 
        scroll.getViewport().setBackground(new Color(165, 177, 194));
        cont.add(scroll, BorderLayout.CENTER);
       
        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
      

        });          

          return cont;
}       
      
}

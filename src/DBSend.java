import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vaibhav Biturwar
 */
public class DBSend {
        Statement stmt;
        Connection con;
        ResultSet res;
        
    public int entry(String s){
        try
        {
         String uid = "root";
         String pwd ="";
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",uid,pwd) ; 
         stmt= con.createStatement();
         
         SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");//dd/MM/yyyy
         Date now = new Date();
         String time = sdfDate.format(now);
         //System.out.println(time2);
         
         String query = "INSERT INTO park (no,time) VALUES('"+s+"','"+time+"') ";
         //System.out.println(query);
         stmt.executeUpdate(query);
        }
        catch(Exception e)
        {
        System.out.println("Error In connection" + e.getMessage());
        return 0;
        }
        return 1;  
    }
    
    public String[] exit(String s){
        try
        {
         String uid = "root";
         String pwd ="";
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",uid,pwd) ; 
         stmt= con.createStatement();
         String query = "SELECT * FROM park WHERE no like'"+s+"'";
         //System.out.println(query);
         res = stmt.executeQuery(query);
         res.next();
         int id = res.getInt("id");
         String no = res.getString("no");
         String in_time = res.getString("time");
         
         SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");//dd/MM/yyyy
         Date now = new Date();
         String out_time = sdfDate.format(now);
         
         SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
         Date date1 = format.parse(in_time);
         Date date2 = format.parse(out_time);
         long difference = date2.getTime() - date1.getTime();  
         difference  = difference/60000; 
         
         String values[] = new String[4];
         values[0] = no;
         values[1] = in_time;
         values[2] = out_time;
         values[3] = Double.toString(difference);
         
         query = "DELETE FROM park WHERE id = "+id+";";
         stmt.executeUpdate(query);
   
         return values;
        }
        catch(Exception e)
        {
            System.out.println("Error In connection" + e.getMessage());
            String values[] = new String[3];
            return values;
        }
        
    }
    
    
    public int instance()
    {
         try
        {
         String uid = "root";
         String pwd ="";
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",uid,pwd) ; 
         stmt= con.createStatement();
        
         String query = "SELECT count(*) FROM park";
         //System.out.println(query);
         res = stmt.executeQuery(query);
         res.next();
         int count = res.getInt("count(*)");
         return count;
         
        }
        catch(Exception e)
        {
            System.out.println("Error In connection" + e.getMessage());
            return 0;
        }
    }
    
    
    public String[][] garage()
    {
         DBSend sd = new DBSend();
         String values[][]= new String[sd.instance()][2];
         try
        {
         String uid = "root";
         String pwd ="";
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",uid,pwd) ; 
         stmt= con.createStatement();
   
         String query = "SELECT no , time FROM park";
         res = stmt.executeQuery(query);
         
         int i=0;
         while(res.next())
         {
             values[i][0] = res.getString("no");
             values[i][1] = res.getString("time");
             //System.out.println(values[1][i]);
             i++;
         }
         
         return values;
         
        }
        catch(Exception e)
        {
            System.out.println("Error In connection" + e.getMessage());
            return values;
        }
        
    
    }
    
    
    
    
    
 /*   

public static void main(String [] args) throws ParseException
{
    DBSend sd = new DBSend();
    
    
    String values[][] = sd.garage();
    for(String x[] : values)
    {
        for(String z : x)
        {
            System.out.print(z+"|");
        }
        System.out.println();
    }
    
    
    //int x = sd.entry("CG 04 DK 5432 ");
  
   
    String values[] =sd.exit("CG 04 MF 8502");
    for(String x : values)
    {
        System.out.println(x);
    }
   
   //System.out.println(sd.instance());
    
    

}
*/
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBSend {
        Statement stmt;
        ResultSet res;
		Connection con;
		final int total = 250;
        
    public int entry(String s){
        try
        {
         String uid = "root";
         String pwd ="root";
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
         String pwd ="root";
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
         values[3] = Integer.toString((int) difference);
         
         query = "DELETE FROM park WHERE id = "+id+";";
         int status = stmt.executeUpdate(query);
         if(status == 1)
        	 return values;
         else 
        	 return null;
        }
        catch(Exception e)
        {
            System.out.println("Error In connection" + e.getMessage());
            return null;
        }
        
    }
    
    
    public int instance()
    {
         try
        {
         String uid = "root";
         String pwd ="root";
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
//       System.out.println("from instance - " + instance());
         String values[][]= new String[instance()][3];
         try
        {
         String uid = "root";
         String pwd ="root";
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking",uid,pwd) ; 

         stmt= con.createStatement();
   
         String query = "SELECT * FROM park";
         res = stmt.executeQuery(query);
         
         int i=0;
         while(res.next())
         {
        	 values[i][0] = Integer.toString(res.getInt("id"));
             values[i][1] = res.getString("no");
             values[i][2] = res.getString("time");
//             System.out.println(values[i]);
             i++;
//             System.out.println("from garage - \n"+ values[i]);
         }
         return values;
         
        }
        catch(Exception e)
        {
            System.out.println("Error In connection" + e.getMessage());
            return values;
        }
        
    
    }
}
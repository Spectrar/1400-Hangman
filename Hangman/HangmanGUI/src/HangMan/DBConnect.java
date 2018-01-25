
package HangMan;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnect 
{
    public static String getPhrase(String category, String difficulty)
    {
        
        String phrase="";       
        try
        {
            String url = "jdbc:mysql://ec2-35-163-170-56.us-west-2.compute.amazonaws.com:3306/";
            String userName = "root";
            String password = "dbpass";
            String dbName = "Hangman";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnnDB = DriverManager.getConnection(url + dbName, userName, password);
            
            try
            {
                CallableStatement stmt = cnnDB.prepareCall("{CALL get_hangman_phrase(?,?)}");
                stmt.setString(1, category);
                stmt.setString(2, difficulty);
                
                ResultSet rs = stmt.executeQuery();
                
                while (rs.next()) 
                {
                    phrase = rs.getString("phrase");
                    break;
                }
                
            }
            catch(SQLException e)
            {
                System.out.printf("\n%s", e.getMessage());
            } 
            finally
            {
                try{ cnnDB.close(); } catch (Exception e){ /* */}
            }
        }  
        catch(Exception e)
        {
            System.out.printf("\n%s", e.getMessage());
           
        }
        
        return phrase;
    }
    
}
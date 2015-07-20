/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author NISCHAYG
 */
//STEP 1. Import required packages
import java.sql.*;
import java.io.*;
import java.lang.*;

public class gnischay2 {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/project";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   
   public gnischay2()
   {
       
   }
   static String msg1,msg2;
   public gnischay2(String a,String b)
   {
       msg1=a;
       msg2=b;
   }
   
   Connection conn = null;
   Statement stmt = null;
   BufferedWriter br=null;
   StringBuilder sb=null;
   ResultSet rs=null;
   public void main(String[] args)throws IOException {
   
   try{
      //STEP 2: Register JDBC driver
       initialise();
        br = new BufferedWriter(new FileWriter("instagram.csv"));
        sb = new StringBuilder();
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM insta ";
      ResultSet rs = stmt.executeQuery(sql);
     //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
          
         String username = rs.getString("username");
         int followers  = rs.getInt("followers");
          int following  = rs.getInt("following");
          int favourites  = rs.getInt("favourites");
          int time  = rs.getInt("time");
          int like  = rs.getInt("like");
          int comment  = rs.getInt("comment");
         
         //Display values
        
           System.out.print(username + " ");
           System.out.print(followers + " ");
           System.out.print(following + " ");
           System.out.print(favourites + " ");
           System.out.print(time + " ");
           System.out.print(like + " ");
           System.out.println(comment + " ");
           
             sb.append(username);
             sb.append(",");
             sb.append(followers);
             sb.append(",");
            sb.append(following);
             sb.append(",");
             sb.append(favourites);
             sb.append(",");
             sb.append(time);
             sb.append(",");
             sb.append(like);
             sb.append(",");
      
            sb.append(comment);
     
            sb.append("," + "\n");
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
        br.write(sb.toString());
        br.close();
   System.out.println("Goodbye!");
}//end main
   
   public void initialise(){
       try{
            Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
       }
       catch(ClassNotFoundException se){
        se.printStackTrace();   
       }
       catch(SQLException se){
        se.printStackTrace();   
       }
       }
   
   public void createDatabase(String d){
   	try{
      	int a=stmt.executeUpdate("CREATE DATABASE "+d);
	//stmt.executeQuery("create table students(name varchar(20),rollno)");
	}
	catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }
   }
   public void useDatabase(String d){
   	try{
      		rs=stmt.executeQuery("USE "+d);
      	}
      	catch(SQLException se){
      //Handle errors for JDBC
      		se.printStackTrace();
   	}
   }
   
   public void anyQuery(String q){
   	//String fields[]=new String[noOfFields];
   	//String q="CREATE TABLE ";
   	try{
   		rs=stmt.executeQuery(q);
   	}
   	catch(SQLException se){
      		//Handle errors for JDBC
      		se.printStackTrace();
  	 }
   	
   }
   
}//end JDBCExample
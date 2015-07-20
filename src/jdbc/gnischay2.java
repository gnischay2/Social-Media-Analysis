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
   }
   
   finally{
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
        
        
      //Facebook
        
        try{
      //STEP 2: Register JDBC driver
       initialise();
        br = new BufferedWriter(new FileWriter("facebook.csv"));
        sb = new StringBuilder();
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
        
        String sql1 = "SELECT * FROM facebook ";
      ResultSet rs1 = stmt.executeQuery(sql1);
     //STEP 5: Extract data from result set
      while(rs1.next()){
         //Retrieve by column name
          
         String username = rs1.getString("username");
         int friends  = rs1.getInt("friends");
          int post  = rs1.getInt("post");
          int time  = rs1.getInt("time");
          int like  = rs1.getInt("like");
          int comment  = rs1.getInt("comment");
          int share  = rs1.getInt("share");
         
         //Display values
        
           System.out.print(username + " ");
           System.out.print(friends + " ");
           System.out.print(post + " ");
           System.out.print(time + " ");
           System.out.print(like + " ");
           System.out.print(comment + " ");
           System.out.println(share + " ");
           
             sb.append(username);
             sb.append(",");
             sb.append(friends);
             sb.append(",");
             sb.append(post);
             sb.append(",");
             sb.append(time);
             sb.append(",");
             sb.append(like);
             sb.append(",");
             sb.append(comment);
             sb.append(",");
             sb.append(share);
     
            sb.append("," + "\n");
      }
      rs1.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   
   finally{
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
      
   //Twitter     
        
        try{
      //STEP 2: Register JDBC driver
       initialise();
        br = new BufferedWriter(new FileWriter("twitter.csv"));
        sb = new StringBuilder();
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
        
        String sql2 = "SELECT * FROM twitter ";
      ResultSet rs2 = stmt.executeQuery(sql2);
     //STEP 5: Extract data from result set
      while(rs2.next()){
         //Retrieve by column name
          
         String username = rs2.getString("username");
         int followers  = rs2.getInt("followers");
          int following  = rs2.getInt("following");
          int tweet_id  = rs2.getInt("tweet_id");
          int time  = rs2.getInt("time");
          int retweet  = rs2.getInt("retweet");
         
         //Display values
        
           System.out.print(username + " ");
           System.out.print(followers + " ");
           System.out.print(following + " ");
           System.out.print(tweet_id + " ");
           System.out.print(time + " ");
           System.out.print(retweet + " ");
           
             sb.append(username);
             sb.append(",");
             sb.append(followers);
             sb.append(",");
             sb.append(following);
             sb.append(",");
             sb.append(tweet_id);
             sb.append(",");
             sb.append(time);
             sb.append(",");
             sb.append(retweet);
            sb.append("," + "\n");
      }
      rs2.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }
   
   finally{
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
      
        
   //Remaining Code     
        
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
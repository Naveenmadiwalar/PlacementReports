/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import naveen.Details;

/**
 *
 * @author Sahil
 */
public class database {
    Connection con=null;
    
    public int connect() {
       ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            return 1;
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/pacement","root","");
        }catch(Exception e){
            return 1;
        }
        
        return 0;
    }
    
    public int insert(String str){
        Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            System.out.println(ex);
            return 1;
        }
        return 0;
    }
    
    
     public ResultSet select(String str){
         ResultSet rs = null;
        try {
            //String str="SELECT s.usn,s.name,s.branch,s.sem,c.cname,p.package FROM `student` s,`placed` p,`company` c where s.usn=p.usn and p.c_id=c.c_id";
             Statement stm=con.createStatement();
            rs=stm.executeQuery(str);
            
        } catch (SQLException ex) {
            System.out.println("There is no data in table");
        }
        
        return rs;        
    }
    
    
    public int update(String str){
         Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            return 1;
        }
        return 0;
    }
    
    public int delete(String str){
         Statement stm;
        try {
            stm = con.createStatement();
            stm.execute(str);
        } catch (SQLException ex) {
            return 1;
        }
        return 0;
    }
    
    public ObservableList<Details> display() throws SQLException{
         ResultSet rs = null;
        try {
            String str="SELECT s.usn,s.name,s.branch,s.sem,c.cname,p.package FROM `student` s,`placed` p,`company` c where s.usn=p.usn and p.c_id=c.c_id";
             Statement stm=con.createStatement();
            rs=stm.executeQuery(str);
            
        } catch (SQLException ex) {
            System.out.println("There is no data in table");
        }
        
        return convert(rs);
    }
    
   public  ObservableList<Details> convert(ResultSet rs) throws SQLException{
        ObservableList<Details> Data=  FXCollections.observableArrayList();
         while(rs.next()){
            Data.add(
            new Details(rs.getString("usn"),rs.getString("name"),rs.getString("branch"),rs.getString("cname"),rs.getInt("Package"),rs.getInt("sem"))); 
             System.out.printf("%10s %15s %10s %10s %5d %5d \n",rs.getString("usn"),rs.getString("name"),rs.getString("branch"),rs.getString("cname"),rs.getInt("Package"),rs.getInt("sem"));
         }
         
         return Data;
    }
    
   
  public void printData() throws SQLException{
      ResultSet rs = null;
        try {
            connect();
             Statement stm=con.createStatement();
            rs=stm.executeQuery("select *from student");
            
        } catch (SQLException ex) {
            System.out.println("There is no data in table");
        }
        
        while(rs.next()){
            System.out.printf("%10s \t %10s \n",rs.getString("USN"),rs.getString("name"));
        }
        
      
  }
    
    public void close() throws SQLException{
        con.close();
    }
 
}

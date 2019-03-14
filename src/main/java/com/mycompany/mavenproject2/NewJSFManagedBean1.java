/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable; 
import javax.annotation.PostConstruct;

/**
 *
 * @author hs0013281
 */
@ManagedBean
@SessionScoped
public class NewJSFManagedBean1 implements Serializable{

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    String userName = new String();
    String ActionValue;

    public String getActionValue() {
        return ActionValue;
    }

    public void setActionValue(String ActionValue) { 
        this.ActionValue = ActionValue;
    }
    
    public void NewJSFManagedBean1() {
        this.ActionValue = "False";
    }
    @PostConstruct
    public void init() {
    NewJSFManagedBean1 newJSFManagedBean= new NewJSFManagedBean1 ();
}
    public String getUserName() {
        return this.userName.trim();
    }
     
    public void setUserName(String userName) {
        this.userName = userName.trim();
    }
    
    public void buttonAction() {
        Connection conn = null;
        //String url = "jdbc:mysql://10.10.242.20:3306/world?autoReconnect=true&useSSL=false";
        String url = "jdbc:mysql://localhost:3306/whoami";
        String user = "root";
        //String pwd = "redhat";
        String pwd = "";
        String query = "insert into users(user_name,flag) values('"+userName+"','1');";
        System.out.println("Query  -- " + query);
        String username = "";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            ps = conn.prepareStatement(query);
            
             ps.executeUpdate();
             ActionValue= "True";
             
      
        } catch (Exception e) {
            System.out.println("Exception  -- " + e);
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
                query = null;              
                userName="";
                
            } catch (Exception ee) {
                
            } 
            
         }
    }
    
    
    public String getname() {
        Connection conn = null;
        //String url = "jdbc:mysql://10.10.242.20:3306/world?autoReconnect=true&useSSL=false";
         //String url = "jdbc:mysql://localhost:3306/whoami";
        String url = "jdbc:mysql://10.130.26.187:3306/whoami";
        String user = "root";
        //String pwd = "redhat";
        String pwd = "";
        String query = "select user_id, user_name, flag from users";
        String username = "";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pwd);
            ps = conn.prepareStatement(query);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                username = rs.getString(2);
            }
            System.out.println("username  -- " + username);
            //System.out.println("list val  -- " + list.get(0).toString());
        } catch (Exception e) {
            System.out.println("Exception  -- " + e);
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
                query = null;
            } catch (Exception ee) {
            } 
            return username;
         }
    }
   
}

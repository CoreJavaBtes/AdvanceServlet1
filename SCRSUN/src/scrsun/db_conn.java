package scrsun;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class db_conn {
	
	static Connection con=null;
	public static Connection db_Connections1() throws ClassNotFoundException, SQLException
	{ 

		 Class.forName("com.mysql.jdbc.Driver");
         
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/opam11","root","");
              
	  // Class.forName("com.ibm.db2.jcc.DB2Driver");
     //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:50000/DEM","db2admin","jatin");
    // System.out.print("connected");
  return con;
	
	}

}


/**
 *
 * @author Toshiba pc
 */

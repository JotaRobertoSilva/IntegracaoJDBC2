/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexao {   
   
   
    
    public static Connection abreConexao(){
  Connection con = null;
  if (con==null) {
   try {

    Class.forName("org.apache.derby.jdbc.ClientDataSource");
    con = DriverManager.getConnection
    ("jdbc:derby://localhost:1527/CADASTRO;SecurityMechanism=3",
            "app", // usuario
            "app"); // senha
   }catch (SQLException s){
    System.out.println("SQL Error: " + s.toString() + " "
      + s.getErrorCode() + " " + s.getSQLState());

   }catch (Exception e){
    System.out.println("Error: " + e.toString() + e.getMessage());
   }
  }
  return con;
 }
}




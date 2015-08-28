/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import bd.*;
import java.util.Scanner;
import bd.BdUsuario;
import java.sql.SQLException;

/**
 *
 * @author k026587
 */
public class testeTeste {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      
      BdUsuario bd = new BdUsuario();
      
      Scanner entrada = new Scanner(System.in);
      do {
      
      System.out.println("********** INFORME UMA OPÇÃO **********");      
      System.out.println("1 -  Inserir registro");
      System.out.println("2 -  Listar agenda");
      System.out.println("9 -  SAIR");
      System.out.print("Opção: ");
      int opcao = entrada.nextInt();

      if (opcao == 1) {
        bd.inserir();
        //instancia.listarPessoas();
      } else if (opcao == 2) {
        //instancia.incluirPessoa();
      } else if (opcao == 9) {
        System.exit(0);
      } else {
        System.out.println("OPÇÃO INVÁLIDA.");
      }

    } while (true);
            
     
        
    }
    
}

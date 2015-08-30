/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;


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
      System.out.println("1 - Inserir registro");
      System.out.println("2 - Listar agenda");
      System.out.println("3 - Deletar registro");
      System.out.println("4 - Editar ");
      System.out.println("9 - SAIR");
      System.out.print("Opção: ");
      int opcao = entrada.nextInt();

      if (opcao == 1) {
        bd.inserir();
      } else if (opcao == 2) {
        bd.read();
      } else if(opcao == 3) {
         System.out.print("Informe o ID: ");
                int id = entrada.nextInt();
                boolean consulta = bd.remover(id);                
                if (consulta==true) {                    
                    System.out.println("ID removido com sucesso!");
                }else{
                System.out.println("ID não localizado!");
                }
      } else if (opcao == 9) {
        System.exit(0);
      } else {
        System.out.println("OPÇÃO INVÁLIDA.");
      }

    } while (true);
            
     
        
    }
    
}

package bd;

import negocio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BdUsuario {

    public void inserir() {

        PreparedStatement stmt = null;
        Connection conn = null;
        
        
        /*
        String umNome;
        int umIdade;
        String umDepartamento;
        String umCidade;
        String umEstado;
*/
  
       Usuario user = new Usuario();
        
        Scanner input = new Scanner(System.in);

        System.out.print("Nome: ");
        user.setNome(input.nextLine());
        
        System.out.print("Departamento: ");
        user.setDepartamento(input.nextLine());
        
         System.out.print("Idade: ");
        user.setIdade(input.nextInt());

        System.out.print("Cidade: ");
        user.setCidade(input.nextLine());

        System.out.print("Estado: ");
        user.setEstado(input.nextLine());

        String sql = "INSERT INTO CADPESSOA(NOME,DEPARTAMENTO,IDADE,CIDADE,ESTADO) VALUES(?,?,?,?,?)";
        try {

            conn = Conexao.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getDepartamento());
            stmt.setInt(3, user.getIdade());
            stmt.setString(4, user.getCidade());
            stmt.setString(5, user.getEstado());
            stmt.executeUpdate();
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}

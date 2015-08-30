package bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.Usuario;

public class BdUsuario {

    public void inserir() {

        PreparedStatement stmt = null;
        Connection conn = null;

        Usuario user = new Usuario();

        Scanner input = new Scanner(System.in);

        System.out.print("Nome: ");
        user.setNome(input.nextLine());

        System.out.print("Departamento: ");
        user.setDepartamento(input.nextLine());

        System.out.print("Idade: ");
        user.setIdade(input.nextInt());
        input.nextLine();

        System.out.print("Cidade: ");
        user.setCidade(input.nextLine());
        System.out.println("");

        String sql = "INSERT INTO CADPESSOA(NOME,DEPARTAMENTO,IDADE,CIDADE) VALUES(?,?,?,?)";

        try {

            conn = Conexao.abreConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getDepartamento());
            stmt.setInt(3, user.getIdade());
            stmt.setString(4, user.getCidade());
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

    public void read() {

        //PreparedStatement stmt = null;
        Statement stmt = null;
        Connection conn = null;
        Usuario user = new Usuario();

        String sql = "SELECT IDNOME,NOME,IDADE,DEPARTAMENTO,CIDADE FROM CADPESSOA";

        try {
            conn = Conexao.abreConexao();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                user.setIdnome(rs.getInt("IDNOME"));
                user.setNome(rs.getString("NOME"));
                user.setIdade(rs.getInt("IDADE"));
                user.setDepartamento(rs.getString("DEPARTAMENTO"));
                user.setCidade(rs.getString("CIDADE"));

                System.out.print(user.getIdnome() + " ; ");
                System.out.print(user.getNome() + " ; ");
                System.out.print(user.getIdade() + " ; ");
                System.out.print(user.getDepartamento() + " ; ");
                System.out.print(user.getCidade());
                System.out.println("");
            }

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

    public boolean remover(int id) {

        Statement stmt = null;
        Connection conn = null;
        Scanner input = new Scanner(System.in);
        Usuario funcionario = new Usuario();

        String sql = "SELECT IDNOME FROM CADPESSOA WHERE IDNOME = " + id;

        try {

            conn = Conexao.abreConexao();
            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                if (id == rs.getInt("IDNOME")) {

                    sql = "DELETE FROM CADPESSOA WHERE IDNOME = " + id;
                    stmt.executeUpdate(sql);
                    return true;
                }

            }

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

        return false;
    }

}

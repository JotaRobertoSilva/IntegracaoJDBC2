/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import bd.Conexao;
import java.sql.Connection;

/**
 *
 * @author k026587
 */
public class testeCon {
    
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        
        Connection conn = Conexao.abreConexao();
//Connection conn = conexao.abreConexao();
    }
    
}

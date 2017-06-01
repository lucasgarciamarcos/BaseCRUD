/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Bean.Cliente;
import Model.Conexao;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author 16000002533
 */
public class Control {

    private Vector lista = new Vector();
    Conexao con = new Conexao();

    public Vector listar() throws Exception {
        Vector vec = con.listarDB();
        return vec;
    }

    public void remover(Cliente cliente) throws SQLException {
        con.excluirDB(cliente);
    }

    public void adicionar(Cliente cliente) throws SQLException {
        con.inserirDB(cliente);
    }

    public void alterar(Cliente cliente) throws SQLException {
        con.alterarDB(cliente);
    }
}

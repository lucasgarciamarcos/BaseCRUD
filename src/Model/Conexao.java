/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author 16000002533
 */
public class Conexao {

    public boolean inserirDB (Cliente cliente) throws SQLException{
        String sql= "INSERT INTO clientes(nome, email, telefone, data) VALUES(?, ?, ?, ?)";
        Connection con= DBF.getConnection();
        try{
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getData());
            int row = ptm.executeUpdate();
            if(row== 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBF.releseadConnection();
        }
        return false;    
    }

    public boolean alterarDB(Cliente cliente) throws SQLException{
        String sql= "UPDATE clientes SET nome= ?, email= ?, telefone= ?, data= ? WHERE codigo= ?";
        Connection con = DBF.getConnection();
        try{
            PreparedStatement ptm = con.prepareStatement(sql);
            ptm.setString(1, cliente.getNome());
            ptm.setString(2, cliente.getEmail());
            ptm.setString(3, cliente.getTelefone());
            ptm.setString(4, cliente.getData());
            ptm.setInt(5, (cliente.getCodigo()));
            int row= ptm.executeUpdate();
            if(row== 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBF.releseadConnection();
        }
        return false;
    }

    public boolean excluirDB(Cliente cliente) throws SQLException{
        String sql= "DELETE FROM clientes WHERE codigo= ?";
        Connection con = DBF.getConnection();
        try{
            PreparedStatement ptm= con.prepareStatement(sql);
            ptm.setInt(1,(cliente.getCodigo()));
            int row= ptm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBF.releseadConnection();
        }
        return false;
    }    
    
    public Vector listarDB() throws Exception{
        Vector clientes = new Vector();
        String sql = "SELECT * FROM clientes";
        Connection con = DBF.getConnection();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                Cliente c = new Cliente();
                c.setCodigo(rs.getInt("codigo"));
                c.setNome(rs.getString("nome"));
                c.setEmail(rs.getString("email"));
                c.setTelefone(rs.getString("telefone"));
                c.setData(rs.getString("data"));
                clientes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBF.releseadConnection();
        }
        return clientes;
        }    
    }

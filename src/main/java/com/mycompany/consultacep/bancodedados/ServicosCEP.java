/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultacep.bancodedados;

import com.mycompany.consultacep.CEP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author janio.silva
 */
public class ServicosCEP {
    
    public ModeloCEP consultaPorCEP(String CEP) throws SQLException{
        ModeloCEP retorno=new ModeloCEP();
        Connection c=Conexao.obterConexao();
        String SQL="SELECT * FROM CONSULTACEP.address_searchs WHERE postal_code = ?";
        PreparedStatement p = c.prepareStatement(SQL);
        p.setString(1, CEP);
        ResultSet r = p.executeQuery();
        if(r.next()){
            retorno.setCity_id(r.getString("city_id"));
            retorno.setDdd(r.getString("ddd"));
            retorno.setEndereco(r.getString("address"));
            retorno.setId(r.getString("id"));
            retorno.setPostal_code(r.getString("postal_code"));
        }else{
            return null;
        }
        c.close();
        return retorno;
    }
    
    public ModeloCidade nomeCidade(String id) throws SQLException{
        ModeloCidade retorno = new ModeloCidade();
        Connection c=Conexao.obterConexao();
        String SQL="SELECT * FROM CONSULTACEP.cities WHERE id = "+ id;
        PreparedStatement p = c.prepareStatement(SQL);
        ResultSet r = p.executeQuery();
        if(r.next()){
            retorno.setId(r.getString("id"));
            retorno.setState_id(r.getString("state_id"));
            retorno.setName(r.getString("name"));
            retorno.setSlug(r.getString("Slug"));
        }else{
            return null;
        }
        c.close();
        return retorno;
    }
    
    public String nomeEstado(String id) throws SQLException{
        String nome = "";
        ModeloCEP retorno=new ModeloCEP();
        Connection c=Conexao.obterConexao();
        String SQL="SELECT * FROM CONSULTACEP.states WHERE id = " + id;
        PreparedStatement p = c.prepareStatement(SQL);
        ResultSet r = p.executeQuery();
        if(r.next()){
            nome = r.getString("name");
        }else{
            return null;
        }
        c.close();
        return nome;
    }
    
}

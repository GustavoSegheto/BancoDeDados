/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consultacep.bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author janio.silva
 */
public class Conexao {

    public static Connection obterConexao() throws SQLException{
        String d="jdbc:postgresql://10.90.24.54/aula";
        String u="aula",senha="aula";
        return DriverManager.getConnection(d, u, senha);
    }
    
}

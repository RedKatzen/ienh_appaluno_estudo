package br.com.ienh.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection obterConexao() throws Exception {
        String url = "jdbc:mysql://localhost:3306/sisienh23?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Connection conn = null;
        // Carrega o driver do MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Estabelece conexão com o banco
        conn = DriverManager.getConnection(url, usuario, senha);

        return conn;
    }
}

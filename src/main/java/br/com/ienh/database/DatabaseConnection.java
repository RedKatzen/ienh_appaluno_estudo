package br.com.ienh.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private Connection conn;
    private static DatabaseConnection db;

    private DatabaseConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/sisienh23?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        // Carrega o driver do MySQL
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Estabelece conexão com o banco
        conn = DriverManager.getConnection(url, usuario, senha);
    }

    public static DatabaseConnection getDatabaseConnection() throws Exception{
        if(db == null) db = new DatabaseConnection();
        return db;
    }

    public Connection getConnection(){
        return conn;
    }
}

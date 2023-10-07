package br.com.ienh.database.operations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import br.com.ienh.database.DatabaseConnection;

public class OperacoesProfessor {

    public static void consultaProfessores() throws Exception {
        String sqlConsulta = "SELECT * FROM professor";
        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        // Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = conn.createStatement();
        // Executa a consulta SQL
        ResultSet rs = stmt.executeQuery(sqlConsulta);
        // Itera sobre os resultados e imprime no console
        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            double peso = rs.getDouble("peso");
            int altura = rs.getInt("altura");

            System.out.println(id + " - " + nome + " - " + peso + " - " + altura);
        }
    }

    public static void insereProfessor() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o nome do professor: ");
        String nome = scan.nextLine();
        System.out.print("Informe o peso do professor: ");
        double peso = scan.nextDouble();
        System.out.print("Informe a altura do professor: ");
        int altura = scan.nextInt();

        String sqlUpdate = "INSERT INTO professor (nome, peso, altura, active)" +
                "VALUES ('" + nome + "', " + peso + ", " + altura + ", 1);";

        Connection conn = DatabaseConnection.getDatabaseConnection().getConnection();
        // Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = conn.createStatement();
        // Executa a consulta SQL
        int linhasAfetadas = stmt.executeUpdate(sqlUpdate);
        if (linhasAfetadas == 1) {
            System.out.println("Dados do professor inseridos com sucesso.");
        } else {
            System.out.println("Falha ao inserir os dados do professor.");
        }

        scan.close();
    }
}

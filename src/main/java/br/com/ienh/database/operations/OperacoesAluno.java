package br.com.ienh.database.operations;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import br.com.ienh.database.DatabaseConnection;

public class OperacoesAluno {

    public static void consultaAlunos() throws Exception {
        String sqlConsulta = "SELECT * FROM aluno";
        // Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = DatabaseConnection.obterConexao().createStatement();
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

    public static void insereAluno() throws Exception{
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o nome do aluno: ");
        String nome = scan.nextLine();
        System.out.print("Informe o peso do aluno: ");
        double peso = scan.nextDouble();
        System.out.print("Informe a altura do aluno: ");
        int altura = scan.nextInt();

        String sqlUpdate = "INSERT INTO aluno (nome, peso, altura, active)" +
                "VALUES ('" + nome + "', " + peso + ", " + altura + ", 1);";

        // Cria um objeto Statement (comando) para enviar consultas ao banco
        Statement stmt = DatabaseConnection.obterConexao().createStatement();
        // Executa a consulta SQL
        int linhasAfetadas = stmt.executeUpdate(sqlUpdate);
        if (linhasAfetadas == 1) {
            System.out.println("Dados do aluno inseridos com sucesso.");
        } else {
            System.out.println("Falha ao inserir os dados do aluno.");
        }

        scan.close();
    }
}

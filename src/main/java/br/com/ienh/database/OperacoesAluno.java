package br.com.ienh.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class OperacoesAluno {

    public static void consultaAlunos() {
        String url = "jdbc:mysql://localhost:3306/sisienh23?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Connection conn = null;

        String sqlConsulta = "SELECT * FROM aluno";
        
        try{
    // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
    // Estabelece conexão com o banco
            conn = DriverManager.getConnection(url, usuario, senha);
    // Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
    // Executa a consulta SQL
            ResultSet rs = stmt.executeQuery(sqlConsulta);
    // Itera sobre os resultados e imprime no console
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double peso = rs.getDouble("peso");
                int altura = rs.getInt("altura");
                
                System.out.println(id + " - " + nome + " - " + peso + " - " + altura); 
            }
        }catch(Exception e){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(e.getMessage());
        }
    }

    public static void insereAluno(){
        String url = "jdbc:mysql://localhost:3306/sisienh23?serverTimezone=UTC";
        String usuario = "root";
        String senha = "ienh";

        Connection conn = null;

        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o nome do aluno: ");
        String nome = scan.nextLine();
        System.out.print("Informe o peso do aluno: ");
        double peso = scan.nextDouble();
        System.out.print("Informe a altura do aluno: ");
        int altura = scan.nextInt();

        String sqlUpdate = "INSERT INTO aluno (nome, peso, altura, active)" +
                                    "VALUES ('"+ nome +"', "+ peso +", "+ altura +", 1);"; 

        try{
    // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
    // Estabelece conexão com o banco
            conn = DriverManager.getConnection(url, usuario, senha);
    // Cria um objeto Statement (comando) para enviar consultas ao banco
            Statement stmt = conn.createStatement();
    // Executa a consulta SQL
            int linhasAfetadas = stmt.executeUpdate(sqlUpdate);
            if(linhasAfetadas == 1){
                System.out.println("Dados do aluno inseridos com sucesso.");
            } else {
                System.out.println("Falha ao inserir os dados do aluno.");
            }

            scan.close();
        }catch(Exception e){
            System.out.println("Deu ruim!! Fale com o administrador!");
            System.out.println(e.getMessage());
        }
    }
}

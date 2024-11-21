package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import metodos.*;

public class Main {

    public static void main(String[] args) {
        // Informações para conexão ao banco de dados
        String url = "jdbc:mysql://localhost:3306/abstrata";
        String user = "root";
        String password = "1910Mune*";

        // Tentando funcionalidades
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Cria as tabelas no banco de dados
            DatabaseUtils.criarTabelas(conn);

            // Criando os produtos
            Produto produto1 = new Alimento("Bolacha", 1.99, 3.40, "2024-12-19", "Panco, Doces");
            Produto produto2 = new Vestuario("Camisa", 50.00, 100.00, "G", "Branca", "Algodão");

            // Inserindo produtos no banco
            produto1.salvar(conn);
            produto2.salvar(conn);

            // Exibindo mensagem de sucesso
            System.out.println("Produto(s) adicionado(s) ao Banco de Dados.");

            // Consulta
            produto1.consultar(conn, 1);
            produto2.consultar(conn, 2);

            // Atualizando um produto
            produto1.setPrecoVenda(4.75);
            produto1.atualizar(conn, 1);

            // Deletando um produto
            produto2.deletar(conn, 2);

        } catch (SQLException e) {
            System.err.println("Erro de SQL: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

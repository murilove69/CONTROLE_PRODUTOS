package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
    public static void criarTabelas(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            // Cria a tabela para alimentos
            String tabelaAlimentos = """
                CREATE TABLE IF NOT EXISTS produtos_alimenticios (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(255) NOT NULL,
                    preco_custo DOUBLE NOT NULL,
                    preco_venda DOUBLE NOT NULL,
                    data_validade DATE NOT NULL,
                    informacoes_nutricionais TEXT
                );
            """;

            // Cria a tabela para vestuários
            String tabelaVestuarios = """
                CREATE TABLE IF NOT EXISTS produtos_vestuario (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    nome VARCHAR(255) NOT NULL,
                    preco_custo DOUBLE NOT NULL,
                    preco_venda DOUBLE NOT NULL,
                    tamanho VARCHAR(10),
                    cor VARCHAR(50),
                    material VARCHAR(100)
                );
            """;

            // Executa as criações
            stmt.execute(tabelaAlimentos);
            stmt.execute(tabelaVestuarios);
        }
    }
}

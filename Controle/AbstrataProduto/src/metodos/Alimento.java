package metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
//Importando todos estes métodos para a "formatação" em um banco de dados

public class Alimento extends Produto {
    private String validade;
    private String nutri;

    // adicionando os atributos necessários para esta classe, juntamente com os da classe anterior
    public Alimento(String nome, double precoCusto, double precoVenda, String string, String nutri) {
        super(nome, precoCusto, precoVenda);
        this.validade = string;
        this.nutri = nutri;
    }

    // Métodos de banco de dados
    @Override
    public void salvar(Connection conn) throws SQLException {
        String query = "INSERT INTO produtos_alimenticios (nome, preco_custo, preco_venda, data_validade, informacoes_nutricionais) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setDate(4, java.sql.Date.valueOf(validade)); 
            stmt.setString(5, nutri);
            stmt.executeUpdate();
        }
    }
  //Utilizando o @Override para fazer a mostragem de forma independente e diferente das outras classes

    @Override
    public void deletar(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM produtos_alimenticios WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
  //Aqui a legenda segue o mesmo conceito da acima, visto que tem o mesmo intuito

    @Override
    public void atualizar(Connection conn, int id) throws SQLException {
        String query = "UPDATE produtos_alimenticios SET nome = ?, preco_custo = ?, preco_venda = ?, data_validade = ?, informacoes_nutricionais = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setDate(4, java.sql.Date.valueOf(validade)); 
            stmt.setString(5, nutri);
            stmt.setInt(6, id);
            stmt.executeUpdate();
        }
    }
}

package metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Importando todos estes métodos para a "formatação" em um banco de dados

public class Vestuario extends Produto {
    private String tamanho;
    private String cor;
    private String material;

    //Criando todos os atributos e utilizando o super para chamar os da classe Produto
    public Vestuario(String nome, double precoCusto, double precoVenda, String tamanho, String cor, String material) {
        super(nome, precoCusto, precoVenda);
        this.tamanho = tamanho;
        this.cor = cor;
        this.material = material;
    }

    // Métodos de banco de dados 
    @Override
    public void salvar(Connection conn) throws SQLException {
        String query = "INSERT INTO produtos_vestuario (nome, preco_custo, preco_venda, tamanho, cor, material) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, tamanho);
            stmt.setString(5, cor);
            stmt.setString(6, material);
            stmt.executeUpdate();
        }
    }
//Utilizando o @Override para fazer a mostragem de forma independente e diferente das outras classes
    @Override
    public void deletar(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM produtos_vestuario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
//Aqui a legenda segue o mesmo conceito da acima, visto que tem o mesmo intuito
    @Override
    public void atualizar(Connection conn, int id) throws SQLException {
        String query = "UPDATE produtos_vestuario SET nome = ?, preco_custo = ?, preco_venda = ?, tamanho = ?, cor = ?, material = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setString(4, tamanho);
            stmt.setString(5, cor);
            stmt.setString(6, material);
            stmt.setInt(7, id);
            stmt.executeUpdate();
        }
    }
}

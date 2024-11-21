package metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Importando todos estes métodos para a "formatação" em um banco de dados

public class Produto {
    protected String nome;
    protected double precoCusto;
    protected double precoVenda;

    // Criando os atributos que serão inseridos nas duas SubClasses
    public Produto(String nome, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Método do lucro
    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    // Métodos de banco de dados
    public void salvar(Connection conn) throws SQLException {
        String query = "INSERT INTO produtos (nome, preco_custo, preco_venda) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.executeUpdate();
        }
    }
//Utilizando o void deletar para remover um registro do banco de dados com base no id de um produto.
    public void deletar(Connection conn, int id) throws SQLException {
        String query = "DELETE FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
//E este para atualizar
    public void atualizar(Connection conn, int id) throws SQLException {
        String query = "UPDATE produtos SET nome = ?, preco_custo = ?, venda = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setDouble(2, precoCusto);
            stmt.setDouble(3, precoVenda);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }
//Fornecer funcionalidades que permitem modificar o preço de venda de um produto e consultar seus dados no banco de dados, respectivamente.
	public void setPrecoVenda(double d) {
		
	}

	public void consultar(Connection conn, int i) {
		
	}
}

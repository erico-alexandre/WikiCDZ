
package dao;

import db.Conexao;
import model.Personagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonagemDAO {

	public List<Personagem> listarPorClasse(String classe) {

		List<Personagem> personagens = new ArrayList<>();

		String sql = """

				SELECT id, nome, constelacao, classe,
					   idade, descricao, caminho_imagem
				FROM personagens
				WHERE classe = ?
				ORDER BY nome
				""";

		try (Connection conexao = Conexao.conectar();
			PreparedStatement stmt =
					conexao.prepareStatement(sql)) {

			stmt.setString(1, classe);

			try (ResultSet resultado = stmt.executeQuery()) {

				while (resultado.next()) {

					int id = resultado.getInt("id");
					String nome = resultado.getString("nome");
					String constelacao = 
							resultado.getString("constelacao");
					String classePersonagem = 
							resultado.getString("classe");

					int idade = resultado.getInt("idade");

					if (resultado.wasNull()) {
							idade = 0;
						}


					String descricao = 
							resultado.getString("descricao");

					String caminhoImagem = 
							resultado.getString("caminho_imagem");

					Personagem personagem = new Personagem(
							id,
							nome,
							constelacao,
							classePersonagem,
							idade,
							descricao,
							caminhoImagem
					);

					personagens.add(personagem);

				}
			}

		} catch (SQLException e) {
			System.out.println(
					"Erro ao consultar personagem no banco.");
			e.printStackTrace();
		}

		return personagens;
	}
}
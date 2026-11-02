
package db;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {

        try (Connection conexao = Conexao.conectar()) {

            System.out.println("Conexão com MySQL realizada!");
            System.out.println("Banco: " +
                    conexao.getCatalog());

        } catch (SQLException e) {

            System.out.println("Erro ao conectar ao MySQL:");
            e.printStackTrace();

        }
    }
}

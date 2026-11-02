package app;


import java.util.Scanner;
import java.util.List;
import model.Personagem;
import dao.PersonagemDAO;

public class cdzWiki {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PersonagemDAO personagemDAO = new PersonagemDAO();

        int opcao;

        do {

    // ========== Switch principal

            System.out.println("\n====== Wiki Cavaleiros do Zodiaco ======");

            System.out.println("\nEscolha:");
            System.out.println("1. Cavaleiros de Bronze.");
            System.out.println("2. Cavaleiros de Prata");
            System.out.println("3. Cavaleiros de Ouro");
            System.out.println("0. Sair");

            System.out.print("\nDigite uma opção: ");
            opcao = scanner.nextInt();

    // ========== Switch Bronze

            switch (opcao) {

                case 1:
                    menuCategoria(scanner, personagemDAO, "Bronze");
                    break;

                case 2:
                    menuCategoria(scanner, personagemDAO, "Prata");
                    break;

                case 3:
                    menuCategoria(scanner, personagemDAO, "Ouro");
                    break;

                case 0:
                    System.out.println("\nSaindo da Wiki...");
                    break;

                default:
                    System.out.println("\nOpção inválida!");

            }

        } while (opcao !=0);

        scanner.close();

    }

    // Método para exibir os personagens de cada categoria
    public static void menuCategoria(
            Scanner scanner,
            PersonagemDAO personagemDAO,
            String classe) {

        int opcao;

        do {

            // Método para buscar os personagens no banco
            List<Personagem> personagens = 
                    personagemDAO.listarPorClasse(classe);

            System.out.println("\n=== Cavaleiros de " + classe + " ===");

            // Exibe os personagens encontrados
            for (int i = 0; i < personagens.size(); i++) {
                System.out.println((i + 1) + ". "
                        + personagens.get(i).getNome());
            }

            System.out.println("0. Voltar ao menu anterior");

            System.out.print("\nEscolha um cavaleiro: ");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                break;
            }

            if (opcao >= 1 && opcao <= personagens.size()) {

                // Obtem o personagem selecionado
                Personagem personagem = personagens.get(opcao - 1);

                // Exibe a ficha completa
                personagem.exibirFicha();

            } else {

                System.out.println("\nOpção inválida!");
            }

        } while (true);
    }
}


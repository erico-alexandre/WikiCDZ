package model;

public class Personagem {

	private int id;
	private String nome;
	private String constelacao;
	private String classe;
	private int idade;
	private String descricao;
	private String caminhoImagem;


	// Construtor
	public Personagem(int id, String nome,
						String constelacao, String classe,
						int idade, String descricao,
						String caminhoImagem) {


		this.id = id;
		this.nome = nome;
		this.constelacao = constelacao;
		this.classe = classe;
		this.idade = idade;
		this.descricao = descricao;
		this.caminhoImagem = caminhoImagem;

	}


	// Getters

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getConstelacao() {
		return constelacao;
	}

	public String getClasse() {
		return classe;
	}

	public int getIdade() {
		return idade;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCaminhoImagem() {
		return caminhoImagem;
	}

	// Exibir ficha
	public void exibirFicha() {

		System.out.println("\n==============================");
		System.out.println("          " + nome);
		System.out.println("\n==============================");

		System.out.println("Constelaçao: " + constelacao);
		System.out.println("Classe: " + classe);
		System.out.println("Idade: " + idade);
		System.out.println("Descrição: " + descricao);

		System.out.println("\n==============================");


	}

}
	

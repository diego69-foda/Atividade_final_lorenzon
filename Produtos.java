import java.io.Serializable;

import exceptions.ValidationException;

/**
 * Representa um produto no e-commerce.
 * Implementa Serializable para que os objetos possam ser persistidos em
 * arquivo.
 */
public class Produtos implements Entidade {

    // Garante que a versão da classe seja consistente durante a serialização
    private static final long serialVersionUID = 1L;

    private String id; // Adicionado para conformidade com Entidade
    private String nome;
    private String tipo; // Ex: "Camiseta", "Calça", "Acessório"
    private double preco;

    // Construtor para inicializar um produto com seus dados essenciais
    public Produtos(String nome, String tipo, double preco) {
        this.nome = nome;
        this.id = nome; // Usando o nome como ID simplificado
        this.tipo = tipo;
        this.preco = preco;
    }

    // Métodos "get" para permitir que outras classes acessem os dados de forma
    // controlada
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void validar() throws ValidationException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidationException("O nome do produto não pode ser vazio.");
        }
        if (preco <= 0) {
            throw new ValidationException("O preço do produto deve ser positivo.");
        }
    }

    /**
     * Sobrescreve o método toString para fornecer uma representação textual do
     * produto.
     * Útil para exibir o produto na tela.
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - R$ %.2f", nome, tipo, preco);
    }
}
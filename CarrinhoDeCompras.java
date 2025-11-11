import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utilitarios.Teclado2;

public class CarrinhoDeCompras implements Serializable {
    private static final long serialVersionUID = 1L;

    private Clientes cliente;
    private List<Produtos> itens;
    private double total;

    public CarrinhoDeCompras(Clientes cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adicionarProduto(Produtos produto) {
        this.itens.add(produto);
        this.total += produto.getPreco();
        System.out.println("'" + produto.getNome() + "' adicionado ao carrinho.");
    }

    public void verItens() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }

        System.out.println("--- ITENS NO CARRINHO DE " + cliente.getNome().toUpperCase() + " ---");
        for (Produtos item : itens) {
            System.out.println("- " + item);
        }
        System.out.println("------------------------------------");
        System.out.printf("Total: R$ %.2f\n", getTotal());
        System.out.println("------------------------------------");
        System.out.println("1 - Remover Produto");
        System.out.println("2 - Limpar Carrinho");

        int opcao = Teclado2.read("Escolha uma opção: ", Integer.class);

        switch (opcao) {
            case 1:
                removerProdutoInterativo();
                break;
            case 2:
                limparCarrinho(); // Corrigido para chamar o método sem argumentos
                break;
        
            default:
                break;
        }
    }

    public void limparCarrinho() {
        this.itens.clear();
        this.total = 0.0;
        System.out.println("Carrinho limpo com sucesso.");
    }
    
    public void removerProduto(Produtos produto) {
        if (this.itens.remove(produto)) {
            this.total -= produto.getPreco();
            System.out.println("'" + produto.getNome() + "' removido do carrinho.");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    }

    public void removerProdutoInterativo() {
        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio. Não há produtos para remover.");
            return;
        }
        System.out.println("--- REMOVER PRODUTO DO CARRINHO ---");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println((i + 1) + " - " + itens.get(i).getNome());
        }
        int indice = Teclado2.read("Digite o número do produto a ser removido: ", Integer.class);
        if (indice > 0 && indice <= itens.size()) {
            Produtos produtoParaRemover = itens.get(indice - 1);
            removerProduto(produtoParaRemover);
        } else {
            System.out.println("Número de produto inválido.");
        }
    }

    public double getTotal() {
        return total;
    }

    public List<Produtos> getItens() {
        return itens;
    }
}
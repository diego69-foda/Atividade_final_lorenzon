import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    }

    public double getTotal() {
        return total;
    }

    public List<Produtos> getItens() {
        return itens;
    }
}
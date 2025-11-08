import java.io.Serializable;
import java.util.List;

public class Pedidos implements Entidade {
    private static final long serialVersionUID = 1L;

    private static int contadorId = 0;
    private String id;
    private Clientes cliente;
    private List<Produtos> produtos;
    private double valorTotal;

    public Pedidos(Clientes cliente, List<Produtos> produtos, double valorTotal) {
        this.id = String.valueOf(++contadorId);
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    @Override
    public String getId() {
        return id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    @Override
    public void validar() {
        // Validação pode ser adicionada se necessário
    }

    @Override
    public String toString() {
        return String.format("Pedido #%s | Cliente: %s | Itens: %d | Total: R$ %.2f",
                id, cliente.getNome(), produtos.size(), valorTotal);
    }
}
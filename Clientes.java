package Atividade_final_lorenzon;
public class Clientes {
    String nome;
    int idade;
    String cpf;

    public Pedidos fazerPedido(Produtos produto, Descontos desconto) {
        Pedidos pedido = new Pedidos();
        pedido.cliente = this;
        pedido.produto = produto;
        pedido.desconto = desconto;
        return pedido;
    }
}

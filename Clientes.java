package Atividade_final_lorenzon;
import java.io.*;
import java.util.*;
public class Clientes {
    String nome;
    int senha;
    String email;

    public Pedidos fazerPedido(Produtos produto, Descontos desconto) {
        Pedidos pedido = new Pedidos();
        pedido.cliente = this;
        pedido.produto = produto;
        pedido.desconto = desconto;
        return pedido;
    }
}

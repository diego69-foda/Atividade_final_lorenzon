package Atividade_final_lorenzon;
import java.io.*;
import java.util.*;

import utilitarios.Teclado2;

public class app {
    public static void main(String[] args) {
        String seTemConta = Teclado2.read("Já tem conta? ",String.class);
        console.out.println("informações de login");
        Clientes cliente = new Clientes();
        String nome = Teclado2.read("nome ou email: ",String.class);
        int senha = Teclado2.read("senha: ",int.class);
        
        Teclado2.read("gostaria de fazer um pedido?",String.class);

    }
}

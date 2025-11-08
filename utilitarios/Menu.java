package utilitarios;

import java.util.ArrayList;


public class Menu {
    private String titulo;
    private ArrayList<String> opcoesMenu;

    public Menu(String titulo, ArrayList<String> opcoesMenu) {
        this.titulo = titulo;
        this.opcoesMenu = opcoesMenu;
    }

    public int exibir() {
        Video.limparTela();
        Video.cabecalho(titulo);
        System.out.println();

        for (int i = 0; i < opcoesMenu.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, opcoesMenu.get(i));
        }
        System.out.println();

        int opcaoEscolhida;
        do {            
            opcaoEscolhida = Teclado2.read("Qual a sua opção: ", Integer.class); 
            if (opcaoEscolhida < 1 || opcaoEscolhida > opcoesMenu.size()) {
                Video.mensagemAlerta("Opção inválida, tente novamente!");            }
        } while (opcaoEscolhida < 1 || opcaoEscolhida > opcoesMenu.size());

        return opcaoEscolhida;
    }
}


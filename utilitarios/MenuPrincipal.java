package utilitarios;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuPrincipal {

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Pessoas");
        opcoes.add("Constratos");
        opcoes.add("Sair");
        Menu menu = new Menu("Menu Principal", opcoes);
        return menu.exibir();
    }
}


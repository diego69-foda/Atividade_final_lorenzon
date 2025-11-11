import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import utilitarios.Teclado2;
import utilitarios.Video;

public class App {

    private static final String CLIENTES_FILE = "clientes.ser";
    private static final String PRODUTOS_FILE = "produtos.ser";
    private static final String PEDIDOS_FILE = "pedidos.ser";

    private static Repositorio<Clientes> repoClientes = new Repositorio<>(CLIENTES_FILE);
    private static Repositorio<Produtos> repoProdutos = new Repositorio<>(PRODUTOS_FILE);
    private static Repositorio<Pedidos> repoPedidos = new Repositorio<>(PEDIDOS_FILE);

    public static void main(String[] args) {
        carregarProdutosIniciais(); 

        while (true) {
            Video.limparTela();
            exibirMenuPrincipal();
            int opcao = Teclado2.read("Escolha uma opção: ", Integer.class);

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    realizarLogin();
                    break;
                case 3:
                    verProdutos(null); // Visitante não tem carrinho
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Teclado2.read("Pressione Enter para continuar...", String.class);
                    break;
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("===================================");
        System.out.println("  E-COMMERCE DE ROUPAS DO LORENZON ");
        System.out.println("===================================");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Fazer Login");
        System.out.println("3 - Ver Produtos (Acesso Visitante)");
        System.out.println("-----------------------------------");
        System.out.println("0 - Sair");
        System.out.println("===================================");
    }

    private static void cadastrarCliente() {
        Video.limparTela();
        System.out.println("--- CADASTRO DE NOVO CLIENTE ---");

        String nome = Teclado2.read("Digite seu nome: ", String.class);
        String email = Teclado2.read("Digite seu email: ", String.class);
        String senha = Teclado2.read("Crie uma senha: ", String.class);

        if (repoClientes.buscarPorId(email).isPresent()) {
            System.out.println("\nErro: Este email já está cadastrado.");
        } else {
            try {
                Clientes novoCliente = new Clientes(nome, email, senha);
                novoCliente.validar(); 
                repoClientes.adicionar(novoCliente);
                System.out.println("\nCliente '" + nome + "' cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println("\nErro no cadastro: " + e.getMessage());
            }
        }

        Teclado2.read("Pressione Enter para voltar ao menu...", String.class);
    }

    private static void realizarLogin() {
        Video.limparTela();
        System.out.println("--- LOGIN DE CLIENTE ---");

        String email = Teclado2.read("Email: ", String.class);
        String senha = Teclado2.read("Senha: ", String.class);

        Optional<Clientes> clienteOpt = repoClientes.buscarPorId(email);

        if (clienteOpt.isPresent() && clienteOpt.get().getSenha().equals(senha)) {
            System.out.println("\nLogin bem-sucedido! Bem-vindo(a), " + clienteOpt.get().getNome() + "!");
            Teclado2.read("\nPressione Enter para acessar o menu do cliente...", String.class);
            menuClienteLogado(clienteOpt.get());
            return;
        }

        System.out.println("\nEmail ou senha incorretos.");
        Teclado2.read("Pressione Enter para voltar ao menu principal...", String.class);
    }

    private static void menuClienteLogado(Clientes cliente) {
        CarrinhoDeCompras carrinho = cliente.getCarrinho();

        while (true) {
            Video.limparTela();
            System.out.println("===================================");
            System.out.println("        MENU DO CLIENTE            ");
            System.out.println("===================================");
            System.out.println("1 - Ver Produtos");
            System.out.println("2 - Adicionar produto ao carrinho");
            System.out.println("3 - Ver Carrinho");
            System.out.println("4 - Finalizar Compra");
            System.out.println("5 - Ver Meus Pedidos");
            System.out.println("-----------------------------------");
            System.out.println("0 - Logout");
            System.out.println("===================================");

            int opcao = Teclado2.read("Escolha uma opção: ", Integer.class);

            switch (opcao) {
                case 1:
                    verProdutos(carrinho);
                    break;
                case 2:
                    adicionarProdutoAoCarrinho(carrinho);
                    break;
                case 3:
                    verCarrinho(carrinho);
                    break;
                case 4:
                    finalizarCompra(cliente, carrinho);
                    break;
                case 5:
                    verMeusPedidos(cliente);
                    break;
                case 0:
                    System.out.println("Fazendo logout...");
                    repoClientes.remover(cliente); 
                    repoClientes.adicionar(cliente); 
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Teclado2.read("Pressione Enter para continuar...", String.class);
                    break;
            }
        }
    }

    private static void verProdutos(CarrinhoDeCompras carrinho) {
        Video.limparTela();
        System.out.println("--- NOSSO CATÁLOGO DE PRODUTOS ---");
        List<Produtos> produtos = repoProdutos.listar();
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i));
        }
        System.out.println("------------------------------------");
        Teclado2.read("Pressione Enter para voltar...", String.class);
    }

    private static void adicionarProdutoAoCarrinho(CarrinhoDeCompras carrinho) {
        if (carrinho == null) {
            System.out.println("Acesso de visitante não permite adicionar produtos ao carrinho.");
            Teclado2.read("Pressione Enter para voltar...", String.class);
            return;
        }

        verProdutos(carrinho);
        List<Produtos> produtos = repoProdutos.listar();
        int indice = Teclado2.read("Digite o número do produto que deseja adicionar: ", Integer.class);

        if (indice > 0 && indice <= produtos.size()) {
            Produtos produtoEscolhido = produtos.get(indice - 1);
            carrinho.adicionarProduto(produtoEscolhido);
        } else {
            System.out.println("Número de produto inválido.");
        }

        Teclado2.read("Pressione Enter para continuar...", String.class);
    }

    private static void verCarrinho(CarrinhoDeCompras carrinho) {
        Video.limparTela();
        carrinho.verItens();
        Teclado2.read("Pressione Enter para voltar...", String.class);
    }

    private static void finalizarCompra(Clientes cliente, CarrinhoDeCompras carrinho) {
        Video.limparTela();
        if (carrinho.getItens().isEmpty()) {
            System.out.println("Seu carrinho está vazio. Adicione produtos antes de finalizar a compra.");
            Teclado2.read("Pressione Enter para voltar...", String.class);
            return;
        }

        System.out.println("--- FINALIZANDO COMPRA ---");
        carrinho.verItens();
        String confirmacao = Teclado2.read("Confirmar compra? (S/N): ", String.class);

        if (confirmacao.equalsIgnoreCase("S")) {
            // Cria um novo pedido
            Pedidos novoPedido = new Pedidos(cliente, new ArrayList<>(carrinho.getItens()), carrinho.getTotal());
            repoPedidos.adicionar(novoPedido);

            // Limpa o carrinho do cliente
            carrinho.getItens().clear(); // Esvazia a lista de itens

            System.out.println("\nCompra finalizada com sucesso! Pedido #" + novoPedido.getId() + " registrado.");
        } else {
            System.out.println("\nCompra cancelada.");
        }
        Teclado2.read("Pressione Enter para voltar ao menu...", String.class);
    }

    private static void verMeusPedidos(Clientes cliente) {
        Video.limparTela();
        System.out.println("--- MEUS PEDIDOS ---");
        List<Pedidos> todosPedidos = repoPedidos.listar();
        boolean encontrouPedido = false;

        for (Pedidos pedido : todosPedidos) {
            if (pedido.getCliente().getId().equals(cliente.getId())) {
                System.out.println(pedido); // Usa o toString() de Pedidos
                encontrouPedido = true;
            }
        }

        if (!encontrouPedido) {
            System.out.println("Você ainda não fez nenhum pedido.");
        }

        System.out.println("----------------------");
        Teclado2.read("Pressione Enter para voltar...", String.class);
    }

    private static void carregarProdutosIniciais() {
        // Apenas para exemplo, cria uma lista de produtos em memória.
        // Só adiciona se o repositório estiver vazio.
        if (repoProdutos.listar().isEmpty()) {
            repoProdutos.adicionar(new Produtos("Camiseta Básica", "Camiseta", 49.90));
            repoProdutos.adicionar(new Produtos("Calça Jeans", "Calça", 119.90));
            repoProdutos.adicionar(new Produtos("Boné", "Acessório", 35.00));
            repoProdutos.adicionar(new Produtos("Moletom", "Agasalho", 159.90));
        }
    }
}

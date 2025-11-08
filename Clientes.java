import java.io.Serializable;

import exceptions.ValidationException;

public class Clientes implements Entidade {
    private static final long serialVersionUID = 1L;

    private String nome;
    private String email;
    private String senha;
    private CarrinhoDeCompras carrinho;

    public Clientes(String nome, String email, String senha) {
        this.carrinho = new CarrinhoDeCompras(this);
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    @Override
    public String getId() {
        return this.email; // O email será o identificador único do cliente
    }

    @Override
    public void validar() throws ValidationException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidationException("O nome do cliente não pode ser vazio.");
        }
        if (email == null || !email.contains("@")) {
            throw new ValidationException("Email inválido.");
        }
        if (senha == null || senha.length() < 4) {
            throw new ValidationException("A senha deve ter pelo menos 4 caracteres.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome='" + nome + '\'' + ", email='" + email + '\'' + '}';
    }
}

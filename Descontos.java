import java.io.Serializable;

public class Descontos implements Entidade {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private double percentual;
    private boolean ativo;

    public Descontos(String codigo, double percentual) {
        this.codigo = codigo;
        this.percentual = percentual;
        this.ativo = true; // Um desconto começa ativo por padrão
    }

    @Override
    public String getId() {
        return codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPercentual() {
        return percentual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

import java.io.Serializable;

import exceptions.ValidationException;

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

    @Override
    public void validar() throws ValidationException {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new ValidationException("O código do desconto não pode ser vazio.");
        }
        if (percentual <= 0 || percentual > 100) {
            throw new ValidationException("O percentual de desconto deve ser entre 0 e 100.");
        }
    }
}

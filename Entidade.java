import java.io.Serializable;

import exceptions.ValidationException;

/**
 * Interface que garante que a entidade pode ser identificada e validada.
 */
public interface Entidade extends Serializable {
    String getId();

    void validar() throws ValidationException;
}
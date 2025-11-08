import java.util.*;
import java.io.*;

/**
 * Repositório genérico para persistência simples em arquivo via serialização.
 */
public class Repositorio<T extends Entidade> {
    private final List<T> itens = new ArrayList<>();
    private final String arquivo;

    public Repositorio(String arquivo) {
        this.arquivo = arquivo;
        carregar();
    }

    public void adicionar(T item) {
        itens.add(item);
        salvar();
    }

    public void remover(T item) {
        itens.remove(item);
        salvar();
    }

    public Optional<T> buscarPorId(String id) {
        return itens.stream().filter(i -> i.getId().equals(id)).findFirst();
    }

    public List<T> listar() {
        return Collections.unmodifiableList(itens);
    }

    @SuppressWarnings("unchecked")
    private void carregar() {
        File f = new File(arquivo);
        if (!f.exists())
            return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                itens.clear();
                itens.addAll((List<T>) obj);
            }
        } catch (Exception e) {
            System.err.println("Falha ao carregar repositório: " + e.getMessage());
        }
    }

    private void salvar() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(new ArrayList<>(itens));
        } catch (IOException e) {
            System.err.println("Falha ao salvar repositório: " + e.getMessage());
        }
    }
}
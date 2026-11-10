import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {
    private No raiz;
    private List<Integer> caminhoUltimaBusca = new ArrayList<>();

    public No getRaiz() {
        return raiz;
    }

    public boolean inserir(Object objeto) {
        if (!(objeto instanceof Cliente)) {
            return false;
        }
        Cliente novo = (Cliente) objeto;

        if (raiz == null) {
            raiz = new No(novo);
            return true;
        }

        No atual = raiz;
        while (true) {
            Cliente clienteAtual = (Cliente) atual.getDado();

            if (novo.getId() == clienteAtual.getId()) {
                return false;
            }

            if (novo.getId() < clienteAtual.getId()) {
                if (atual.getEsquerda() == null) {
                    atual.setEsquerda(new No(novo));
                    return true;
                }
                atual = atual.getEsquerda();
            } else {
                if (atual.getDireita() == null) {
                    atual.setDireita(new No(novo));
                    return true;
                }
                atual = atual.getDireita();
            }
        }
    }

    public Object buscar(int id) {
        caminhoUltimaBusca = new ArrayList<>();
        No atual = raiz;

        while (atual != null) {
            Cliente c = (Cliente) atual.getDado();
            caminhoUltimaBusca.add(c.getId());

            if (id == c.getId()) {
                return c;
            }
            atual = (id < c.getId()) ? atual.getEsquerda() : atual.getDireita();
        }
        return null;
    }

    public List<Integer> getCaminhoUltimaBusca() {
        return caminhoUltimaBusca;
    }

    public void imprimir() {
        imprimir(raiz, 0);
    }

    private void imprimir(No no, int nivel) {
        if (no == null) return;
        imprimir(no.getDireita(), nivel + 1);
        System.out.println("    ".repeat(nivel) + ((Cliente) no.getDado()).getId());
        imprimir(no.getEsquerda(), nivel + 1);
    }
}

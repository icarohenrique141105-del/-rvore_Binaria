public class No {
    private Object dado;
    private No esquerda;
    private No direita;

    public No(Object dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public Object getDado() {
        return dado;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}

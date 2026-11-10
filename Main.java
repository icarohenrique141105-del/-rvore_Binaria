import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(8, "Ana", "ana@example.com"),
            new Cliente(4, "Bruno", "bruno@example.com"),
            new Cliente(12, "Carla", "carla@example.com"),
            new Cliente(2, "Diego", "diego@example.com"),
            new Cliente(6, "Elisa", "elisa@example.com"),
            new Cliente(10, "Felipe", "felipe@example.com"),
            new Cliente(14, "Gabriela", "gabriela@example.com"),
            new Cliente(1, "Hugo", "hugo@example.com"),
            new Cliente(3, "Isabela", "isabela@example.com"),
            new Cliente(5, "Joao", "joao@example.com"),
            new Cliente(7, "Karen", "karen@example.com"),
            new Cliente(9, "Lucas", "lucas@example.com"),
            new Cliente(11, "Mariana", "mariana@example.com"),
            new Cliente(13, "Nicolas", "nicolas@example.com"),
            new Cliente(15, "Olivia", "olivia@example.com")
        };

        // Árvore principal: inserção na ordem do array
        ArvoreBinaria arvore = new ArvoreBinaria();
        for (Cliente c : clientes) {
            arvore.inserir(c);
        }

        // ===== Testes pedidos na entrega =====
        System.out.println("===== Testes de busca =====");
        int[] idsTeste = {8, 11, 20};
        for (int id : idsTeste) {
            buscarEExibir(arvore, id);
            System.out.println();
        }

        System.out.println("===== Teste de ID duplicado =====");
        boolean resultado = arvore.inserir(new Cliente(8, "Duplicado", "dup@example.com"));
        System.out.println("Inserir cliente com ID 8 (já cadastrado): " + resultado);
        System.out.println();


        System.out.println("===== Análise =====");
        Cliente raiz = (Cliente) arvore.getRaiz().getDado();
        System.out.println("Cliente na raiz: " + raiz.getId() + " - " + raiz.getNome());
        System.out.println();
        System.out.println("Árvore após as inserções (raiz à esquerda):");
        arvore.imprimir();
        System.out.println();


        ArvoreBinaria arvoreCrescente = new ArvoreBinaria();
        for (int id = 1; id <= 15; id++) {
            for (Cliente c : clientes) {
                if (c.getId() == id) {
                    arvoreCrescente.inserir(c);
                }
            }
        }
        System.out.println("Árvore com inserção em ordem crescente (raiz à esquerda):");
        arvoreCrescente.imprimir();
        System.out.println();

        arvore.buscar(15);
        int visitadosA = arvore.getCaminhoUltimaBusca().size();
        arvoreCrescente.buscar(15);
        int visitadosB = arvoreCrescente.getCaminhoUltimaBusca().size();
        System.out.println("Busca pelo ID 15 -> árvore original: " + visitadosA + " nós visitados");
        System.out.println("Busca pelo ID 15 -> árvore crescente: " + visitadosB + " nós visitados");
        System.out.println();


        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do cliente: ");
        int id = sc.nextInt();
        buscarEExibir(arvore, id);
        sc.close();
    }

    private static void buscarEExibir(ArvoreBinaria arvore, int id) {
        Object encontrado = arvore.buscar(id);
        System.out.println("Busca pelo ID " + id);
        System.out.println("IDs visitados: " + arvore.getCaminhoUltimaBusca());
        if (encontrado != null) {
            System.out.println("Cliente encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}

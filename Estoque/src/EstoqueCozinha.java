import java.util.*;
import static javax.swing.JOptionPane.*;
import java.util.HashMap;
import java.util.Map;
import Classes.*; 
import java.util.Scanner;

public class estoqueCozinha {
    private Map<String, Integer> estoque;
    private Map<String, Integer> adicoesPendentes;
    private Map<String, Integer> atualizacoesPendentes;

    public estoqueCozinha() {
        estoque = new HashMap<>();
        adicoesPendentes = new HashMap<>();
        atualizacoesPendentes = new HashMap<>();
    }

    public void adicionarIngrediente(String ingrediente, int quantidade) {
        int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
        int quantidadePendente = adicoesPendentes.getOrDefault(ingrediente, 0);
        int novaQuantidade = quantidadeAtual + quantidade + quantidadePendente;
        adicoesPendentes.put(ingrediente, novaQuantidade);
    }

    public void atualizarQuantidade(String ingrediente, int novaQuantidade) {
        int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
        atualizacoesPendentes.put(ingrediente, novaQuantidade);
    }

    public void aplicarAlteracoesPendentes() {
        for (String ingrediente : adicoesPendentes.keySet()) {
            int quantidadePendente = adicoesPendentes.get(ingrediente);
            int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
            estoque.put(ingrediente, quantidadeAtual + quantidadePendente);
            System.out.println("Ingrediente adicionado ao estoque: " + ingrediente);
        }

        for (String ingrediente : atualizacoesPendentes.keySet()) {
            int novaQuantidade = atualizacoesPendentes.get(ingrediente);
            estoque.put(ingrediente, novaQuantidade);
            System.out.println("Quantidade atualizada do ingrediente: " + ingrediente);
        }

        adicoesPendentes.clear();
        atualizacoesPendentes.clear();
    }

    public boolean verificarDisponibilidade(String ingrediente, int quantidadeRequerida) {
        int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
        int quantidadePendente = adicoesPendentes.getOrDefault(ingrediente, 0);
        if (quantidadeAtual + quantidadePendente >= quantidadeRequerida) {
            System.out.println("Ingrediente disponível em quantidade suficiente: " + ingrediente);
            return true;
        } else {
            System.out.println("Ingrediente indisponível em quantidade suficiente: " + ingrediente);
            return false;
        }
    }

    public static void main(String[] args) {
        estoqueCozinha estoque = new estoqueCozinha();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----- Menu -----");
            System.out.println("1. Adicionar ingrediente");
            System.out.println("2. Verificar disponibilidade de um ingrediente");
            System.out.println("3. Atualizar quantidade de um ingrediente");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            if (opcao == 1) {
                System.out.print("Digite o nome do ingrediente: ");
                String ingrediente = scanner.nextLine();
                System.out.print("Digite a quantidade a ser adicionada: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                estoque.adicionarIngrediente(ingrediente, quantidade);
                System.out.println("Ingrediente adicionado com sucesso!");


            } else if (opcao == 2) {
                System.out.print("Digite o nome do ingrediente: ");
                String ingrediente = scanner.nextLine();
                System.out.print("Digite a quantidade requerida: ");
                int quantidadeRequerida = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                estoque.verificarDisponibilidade(ingrediente, quantidadeRequerida);
                
            } else if (opcao == 3) {
                System.out.print("Digite o nome do ingrediente: ");
                String ingrediente = scanner.nextLine();
                System.out.print("Digite a nova quantidade: ");
                int novaQuantidade = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner
                estoque.atualizarQuantidade(ingrediente, novaQuantidade);
                System.out.println("Quantidade atualizada com sucesso!");
            } else if (opcao == 4) {
                break;
            } else {
                System.out.println("Opção inválida. Digite novamente.");
            }

            System.out.println();
        }

        estoque.aplicarAlteracoesPendentes();
        scanner.close();
    }
}
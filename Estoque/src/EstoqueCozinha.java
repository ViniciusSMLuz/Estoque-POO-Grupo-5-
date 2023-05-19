import javax.swing.JOptionPane;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import Classes.*; 
import java.util.Scanner;

public class EstoqueCozinha {
    private Map<String, Integer> estoque;
    private Map<String, Integer> adicoesPendentes;
    private Map<String, Integer> atualizacoesPendentes;

    public EstoqueCozinha() {
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
        EstoqueCozinha estoque = new EstoqueCozinha();

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(null,
                    "----- Menu -----\n" +
                    "1. Adicionar ingredientes\n" +
                    "2. Verificar a disponibilidade de um ingrediente\n" +
                    "3. Atualizar a quantidade de um ingrediente\n" +
                    "4. Sair\n\n" +
                    "Escolha uma opção:");

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                opcao = 0;
            }

            if (opcao == 1) {
                String ingrediente = JOptionPane.showInputDialog("Digite o nome do ingrediente:");
                String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade a ser adicionada:");
                int quantidade = Integer.parseInt(quantidadeStr);
                estoque.adicionarIngrediente(ingrediente, quantidade);
                JOptionPane.showMessageDialog(null, "Ingrediente foi adicionado com sucesso!");
            } else if (opcao == 2) {
                String ingrediente = JOptionPane.showInputDialog("Digite o nome do ingrediente:");
                String quantidadeStr = JOptionPane.showInputDialog("Digite a quantidade requerida:");
                int quantidadeRequerida = Integer.parseInt(quantidadeStr);
                estoque.verificarDisponibilidade(ingrediente, quantidadeRequerida);
            } else if (opcao == 3) {
                String ingrediente = JOptionPane.showInputDialog("Digite o nome do ingrediente:");
                String novaQuantidadeStr = JOptionPane.showInputDialog("Digite a nova quantidade:");
                int novaQuantidade = Integer.parseInt(novaQuantidadeStr);
                estoque.atualizarQuantidade(ingrediente, novaQuantidade);
                JOptionPane.showMessageDialog(null, "Quantidade atualizada com sucesso!");
            } else if (opcao == 4) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Opção inválida, digite novamente!");
            }
        }

        estoque.aplicarAlteracoesPendentes();
    }
}
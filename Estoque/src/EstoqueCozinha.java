import java.util.*;
import static javax.swing.JOptionPane.*;
import java.util.HashMap;
import java.util.Map;
import Classes.*; 

    public class estoqueCozinha {
        private Map<String, Integer> estoque;
    
        public estoqueCozinha() {
            estoque = new HashMap<>();
        }
    
        public void adicionarIngrediente(String ingrediente, int quantidade) {
            int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
            estoque.put(ingrediente, quantidadeAtual + quantidade);
            System.out.println("Ingrediente adicionado ao estoque: " + ingrediente);
        }
    
        public void atualizarQuantidade(String ingrediente, int novaQuantidade) {
            estoque.put(ingrediente, novaQuantidade);
            System.out.println("Quantidade do ingrediente atualizada: " + ingrediente);
        }
    
        public boolean verificarDisponibilidade(String ingrediente, int quantidadeRequerida) {
            int quantidadeAtual = estoque.getOrDefault(ingrediente, 0);
            if (quantidadeAtual >= quantidadeRequerida) {
                System.out.println("Ingrediente disponível em quantidade suficiente para o pedido: " + ingrediente);
                return true;
            } else {
                System.out.println("Ingrediente indisponível em quantidade suficiente para o pedido: " + ingrediente);
                return false;
            }
        }
    
        public static void main(String[] args) {
            estoqueCozinha estoque = new estoqueCozinha();
            
            // Adicionar ingredientes no estoque

            estoque.adicionarIngrediente("Sal", 500);
            estoque.adicionarIngrediente("Açúcar", 1000);
            estoque.adicionarIngrediente("Farinha", 2000);
            
            // Verificar a disponibilidade dos ingredientes

            estoque.verificarDisponibilidade("Sal", 200);
            estoque.verificarDisponibilidade("Açúcar", 1500);
            estoque.verificarDisponibilidade("Farinha", 3000);
            
            // Atualizar a quantidade de ingredientes

            estoque.atualizarQuantidade("Sal", 300);
            estoque.atualizarQuantidade("Açúcar", 500);
            estoque.atualizarQuantidade("Farinha", 1500);
            
            // Verificar a disponibilidade após atualização

            estoque.verificarDisponibilidade("Sal", 200);
            estoque.verificarDisponibilidade("Açúcar", 1500);
            estoque.verificarDisponibilidade("Farinha", 3000);
        }
    }

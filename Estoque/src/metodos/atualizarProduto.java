package metodos;

import Classes.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class atualizarProduto {

    public static void atualizar(ArrayList<Produto> estoque) {
        boolean produtoEncontrado = false;
        String nomeProduto = showInputDialog(null, "Digite o nome do Produto a ser atualizado", "ATUALIZAÇÃO",
                INFORMATION_MESSAGE);

        for (Produto produto : estoque) {
            if (produto.getNomeProduto().equals(nomeProduto)) {
                int novaQuantidade = parseInt(showInputDialog(null, "Digite a nova quantidade disponível no estoque",
                        "Atualização", INFORMATION_MESSAGE));
                produto.setQuantidadeProduto(novaQuantidade);
                showMessageDialog(null, "Quantidade do produto atualizada com sucesso!", "Atualização",
                        INFORMATION_MESSAGE);
                produtoEncontrado = true;
                break;
            }
        }

        if (!produtoEncontrado) {
            showMessageDialog(null, "Produto não encontrado!", "Atualização", ERROR_MESSAGE);
        } else if (estoque.isEmpty()) {
            showMessageDialog(null, "Estoque vazio!", "Atualização", ERROR_MESSAGE);
        }
    }
}
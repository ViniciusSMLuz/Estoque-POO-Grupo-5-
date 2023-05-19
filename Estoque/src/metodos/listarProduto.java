package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import java.util.ArrayList;

//import src.EstoquePOOGrupo5.estoqueCozinha;

public class listarProduto {

    public void listar(ArrayList<Produto> listaProd) {
        StringBuffer produto = new StringBuffer();
        for (Produto estoque : listaProd) {
            if (estoque instanceof Produto) {
                produto.append(estoque.toString());
            } else {

            }
        }
        if (produto.length() > 0) {
            showConfirmDialog(null, "Listando ingredientes do estoque\n" + produto.toString(), "Lista de ingredientes", DEFAULT_OPTION, INFORMATION_MESSAGE);
        } else {
            showConfirmDialog(null, "Não há ingredientes", "Erro!", DEFAULT_OPTION, ERROR_MESSAGE);
        }

    }

    
}

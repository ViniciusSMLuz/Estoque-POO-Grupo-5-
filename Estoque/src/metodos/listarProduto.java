package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import java.util.ArrayList;

//import src.EstoquePOOGrupo5.estoqueCozinha;

public class listarProduto {

    public static void listar(ArrayList<Produto> estoque) {
        if(estoque.isEmpty()){
            showConfirmDialog(null, "Não há ingredientes", "Erro!", DEFAULT_OPTION, ERROR_MESSAGE);
        }else{
             StringBuffer listaProduto = new StringBuffer();
                for (Produto produto : estoque) {
                    listaProduto.append(produto);
                    listaProduto.append("\n");
                }

                showConfirmDialog(null, "LISTA DE PRODUTOS\n" + listaProduto.toString(), "ESTOQUE",INFORMATION_MESSAGE);
        }
        
    }

    
}

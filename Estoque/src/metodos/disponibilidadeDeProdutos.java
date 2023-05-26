package metodos;

import Classes.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

public class disponibilidadeDeProdutos {

    public static void atualizar(ArrayList<Produto> estoque, ArrayList<PratoMenu> menu) {
        boolean produtoEncontrado = false;
        StringBuffer aux = new StringBuffer("");
            if(!menu.isEmpty()){
                for(PratoMenu pratos : menu){
                    aux.append((menu.indexOf(pratos)+1)+"º "+ pratos.getNomePratoMenu());
                    aux.append("\n");
                }
                String nomeProduto = showInputDialog(null,"Qual prato deseja verificar a disponibilidade?\n" + aux, "DISPONIBILIDADE DE INGREDIENTES",INFORMATION_MESSAGE);
            }else{
                showInputDialog(null,"Não há pratos registrados", "DISPONIBILIDADE DE INGREDIENTES",ERROR_MESSAGE);
                return;
            }
        
    }
}
package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class deletarProduto {

    public static void deletar(ArrayList<Produto> estoque){
        
        String i = showInputDialog("Insira o nome do produto a ser removido");

        for(Produto produto: estoque){

            
            if(produto.getNomeProduto().equalsIgnoreCase(i)){
                int escolha = JOptionPane.showConfirmDialog(null, "Produto encontrado! \nTem certeza que gostaria de remover esse produto: " + produto.getNomeProduto(),"Obliteração"  , YES_NO_OPTION);
                if (escolha == YES_OPTION) {
                    estoque.remove(produto); 
                    JOptionPane.showMessageDialog(null, "Produto Excluido com sucesso!", "Confirmação de Exclusão", INFORMATION_MESSAGE);
                    return;
                }else if (escolha == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Cancelando a Exclusão", "Confirmação de Exclusão", INFORMATION_MESSAGE);
                    return;
                } else if (escolha == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Operação encerrada sem escolha! Retornando ao menu", "Confirmação de Exclusão", INFORMATION_MESSAGE);
                    return;
                }


            }
       
    }
    
}
}
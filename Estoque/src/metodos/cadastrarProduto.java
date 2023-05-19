package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class cadastrarProduto {
      
    public Produto cadastrar(ArrayList<Produto> estoque){
        Produto produto = new Produto();
        boolean teste = false;
            while(teste == false){
                produto.setNomeProduto(showInputDialog(null, "Digite o nome do Produto a ser cadastrado", "CADASTRO", INFORMATION_MESSAGE));
                    if(!estoque.isEmpty()){
                        for(Produto produtoTeste : estoque){
                            if(produtoTeste.getNomeProduto().equals(produto.getNomeProduto())){
                                showMessageDialog(null, "Produto já Cadastrado!", "Cadastro", ERROR_MESSAGE);
                                teste = false;
                            }
                        }
                    }else{
                        teste = true;
                    }
                teste = true;
            }

            teste = false;
            while(teste == false){
                try {
                    produto.setQuantidadeProduto(parseInt(showInputDialog(null, "Digite a quantidade disponível no estoque", "Cadastro", INFORMATION_MESSAGE)));
                } catch (Exception e) {
                    showMessageDialog(null, "ERRO: " + e + "\nTente o processo novamente", "Cadastro", ERROR_MESSAGE);            
                }
                teste = true;
            }
        return produto;
    }

}

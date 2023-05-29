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
                PratoMenu pratoBusca = new PratoMenu();
                boolean teste = false;


                while(produtoEncontrado == false){
                produtoEncontrado = true;
                pratoBusca.setNomePratoMenu(showInputDialog(null,"Qual prato deseja verificar a disponibilidade?\n" + aux, "DISPONIBILIDADE DE INGREDIENTES",INFORMATION_MESSAGE));
                    for(PratoMenu cardapio : menu){
                        if(pratoBusca.getNomePratoMenu().equalsIgnoreCase(cardapio.getNomePratoMenu())){
                            double[]qntEstoque = new double[cardapio.getTamanhoIngredientesPratoMenu()]; 
                            int i = 0;
                            teste = true;
                            for(Produto ingrediente : cardapio.getIngredientesPratoMenu()){
                                for(Produto produto : estoque){
                                    if(ingrediente.getNomeProduto().equals(produto.getNomeProduto())){
                                        if((produto.getQuantidadeProduto() - ingrediente.getQuantidadePratoProduto() >= 0)){
                                            qntEstoque[i] = produto.getQuantidadeProduto() - ingrediente.getQuantidadePratoProduto();
                                            i++;
                                        }else{
                                            qntEstoque[i] = produto.getQuantidadeProduto() - ingrediente.getQuantidadePratoProduto();
                                            teste = false;
                                            i++;
                                        }
                                    }
                                }
                            }
                            if(teste == false){
                                String aux2 = "Quantidade indisponível para o prato " + pratoBusca.getNomePratoMenu() + "\nOs ingredientes faltando são: \n";
                                    for(int j = 0; j < qntEstoque.length; j++){
                                        if(qntEstoque[j] < 0){
                                            aux2 += cardapio.getIngredientesPratoMenu().get(j).getNomeProduto() + "\n";
                                        }
                                    }
                                showMessageDialog(null, aux2,"Disponibilidade de Produto", ERROR_MESSAGE);
                            }else{
                                String aux2 = "";
                                aux2 += "Quantidade disponível para o prato " + pratoBusca.getNomePratoMenu() + "\nCaso o prato seja feito ainda terá em estoque: ";
                                    for(int j = 0; j < qntEstoque.length; j++){
                                        aux2 += cardapio.getIngredientesPratoMenu().get(j).getNomeProduto() + ": " + qntEstoque[j] + "\n";
                                    }
                                showMessageDialog(null, aux2,"Disponibilidade de Produto", INFORMATION_MESSAGE);
                            }
                        }
                    }
                }
        }else{
            showInputDialog(null,"Não há pratos registrados", "DISPONIBILIDADE DE INGREDIENTES",ERROR_MESSAGE);
            return;
        }
        
    }
}
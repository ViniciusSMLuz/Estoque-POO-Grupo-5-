package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class cadastrarPratoMenu {
    public void cadastrar (ArrayList<Produto>estoque, ArrayList<PratoMenu>menu){
        PratoMenu novoPrato = new PratoMenu();
        boolean teste = false;
        while(teste == false){
            teste = true;
            novoPrato.setNomePratoMenu(showInputDialog(null, "Digite o nome do Prato a ser cadastrado", "CADASTRO", QUESTION_MESSAGE));
                for(PratoMenu cardapio : menu){
                    if(novoPrato.getNomePratoMenu().equalsIgnoreCase(cardapio.getNomePratoMenu())){
                        showMessageDialog(null, "Prato já cadastrado! Digite um nome válido", "Cadastro", ERROR_MESSAGE);
                        teste = false;
                        break;
                    }
                }
        }
        novoPrato.setDescricaoPratoMenu(showInputDialog(null, "Digite a descrição do Prato: " + novoPrato.getNomePratoMenu(), "CADASTRO", QUESTION_MESSAGE));
        teste = false;
        while(teste == false){
            Produto produtoTeste = new Produto();
            produtoTeste.setNomeProduto(showInputDialog(null, "Digite o ingrediente utilizado", "CADASTRO", QUESTION_MESSAGE));
            boolean testeBusca = false;  
                for(Produto produto : estoque){
                    if(produtoTeste.getNomeProduto().equalsIgnoreCase(produto.getNomeProduto())){
                        Produto ingredientePrato = new Produto();
                        ingredientePrato.setNomeProduto(produto.getNomeProduto());
                        ingredientePrato.setUnidadeDeMedida(produto.getUnidadeDeMedida());
                        ingredientePrato.setQuantidadePratoProduto(parseDouble(showInputDialog(null, "Informe a quantidade utilizada no prato(Unidade de medida: " + ingredientePrato.getUnidadeDeMedida() + ")", "CADASTRO",QUESTION_MESSAGE)));
                        novoPrato.setIngredientesPratoMenu(ingredientePrato);
                        testeBusca = true;
                    }
                }
                if(testeBusca == false){
                    int t = parseInt(showInputDialog(null, "Ingrediente não incontrado! Deseja cadastrá-lo?\n1 - Sim | 2 - Não", "CADASTRO", QUESTION_MESSAGE));
                        if(t == 1){
                            cadastrarProduto cp = new cadastrarProduto();
                            cp.cadastrar(estoque);
                            for(Produto produto : estoque){
                                if(produtoTeste.getNomeProduto().equalsIgnoreCase(produto.getNomeProduto())){
                                    Produto ingredientePrato = new Produto();
                                    ingredientePrato.setNomeProduto(produto.getNomeProduto());
                                    ingredientePrato.setUnidadeDeMedida(produto.getUnidadeDeMedida());
                                    ingredientePrato.setQuantidadePratoProduto(parseDouble(showInputDialog(null, "Informe a quantidade utilizada no prato(Unidade de medida: " + ingredientePrato.getUnidadeDeMedida() + ")", "CADASTRO",QUESTION_MESSAGE)));
                                    novoPrato.setIngredientesPratoMenu(ingredientePrato);
                                }
                            }
                        }
                }
                int t = parseInt(showInputDialog(null, "Deseja Cadastrar mais um ingrediente??\n1 - Sim | 2 - Não", "CADASTRO", QUESTION_MESSAGE));
                if(t == 1){
                    teste = false;
                }else{
                    teste = true;
                }
        }   
        novoPrato.setPrecoPratoMenu(parseDouble(showInputDialog(null, "Digite o Valor do Prato","CADASTRO",QUESTION_MESSAGE)));
        menu.add(novoPrato);
        showMessageDialog(null, "Prato Cadastrado com sucesso","CADASTRO", INFORMATION_MESSAGE);
    }
}

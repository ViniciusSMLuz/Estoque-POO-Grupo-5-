package metodos;
import Classes.*;
import static javax.swing.JOptionPane.*;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.MenuBarBorder;

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
            teste = true;
            String busca = showInputDialog(null, "Digite o ingrediente utilizado", "CADASTRO", QUESTION_MESSAGE);
                for(Produto produto : estoque){
                    if(busca.equals(produto.getNomeProduto())){
                        Produto ingredientePrato = new Produto();
                        ingredientePrato.setNomeProduto(produto.getNomeProduto());
                        ingredientePrato.setUnidadeDeMedida(produto.getUnidadeDeMedida());
                        ingredientePrato.setQuantidadePratoProduto(parseDouble(showInputDialog(null, "Informe a quantidade utilizada no prato", "CADASTRO",QUESTION_MESSAGE)));
                        novoPrato.setIngredientesPratoMenu(ingredientePrato);
                    }
                }
        }

    }
}

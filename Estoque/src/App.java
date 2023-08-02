import static javax.swing.JOptionPane.*;
import java.util.ArrayList;
import java.util.Scanner;
import Classes.*;
import metodos.*;


public class App { 
    ArrayList <Produto> estoque = new ArrayList<>();
    ArrayList <PratoMenu> menu = new ArrayList<>();
    
    public void Menu(){
        Scanner teclado = new Scanner(System.in);
        cadastrarProduto cp = new cadastrarProduto();
        cadastrarPratoMenu cpm = new cadastrarPratoMenu();

        int menu = -1;
        while(menu != 0){
            String menuInput = showInputDialog("1 - Menu Prato\n2 - Menu Estoque\n0 - Sair");
            menu = Integer.parseInt(menuInput);
            
            if(menu == 1){
                int subMenu = -1;
                while(subMenu != 0){
                    String subMenuInput = showInputDialog("1 - Cadastrar\n2 - Listar\n0 - Sair");
                    subMenu = Integer.parseInt(subMenuInput);
                        if(subMenu == 1){
                            cpm.cadastrar(estoque, this.menu);
                        }else if(subMenu == 2){
                            for(PratoMenu prato : this.menu){
                                showMessageDialog(null, prato, "Aviso", INFORMATION_MESSAGE);
                            }
                        }else if(subMenu == 3){
                            disponibilidadeDeProdutos.atualizar(estoque, this.menu);
                        }
                    
                }

            }else if(menu == 2){
                int subMenu = -1;
                while(subMenu != 0){
                    String subMenuInput = showInputDialog("1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Deletar\n0 - Sair");
                    subMenu = Integer.parseInt(subMenuInput);
                        if(subMenu == 1){
                            cp.cadastrar(estoque);
                        }else if (subMenu == 2){
                             listarProduto.listar(estoque);
                        }else if(subMenu == 3){
                            atualizarProduto.atualizar(estoque);
                        }else if(subMenu == 4){
                            deletarProduto.deletar(estoque);
                        } 
                }

            }else if (menu == 0){
                showMessageDialog(null, "Operação Encerrada", "Aviso", INFORMATION_MESSAGE);
            
            }else if(menu < 0 || menu > 3){
                showMessageDialog(null, "Entrada Inválida", "Aviso", INFORMATION_MESSAGE);
            }
        }

            
            

    }
}

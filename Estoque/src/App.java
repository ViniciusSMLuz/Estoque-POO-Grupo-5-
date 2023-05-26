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
            System.out.println("1 - Menu Prato\n2 - Menu Estoque");
            menu = teclado.nextInt();
            
            if(menu == 1){
                int subMenu = -1;
                while(subMenu != 0){
                    System.out.println(("1 - cadastra\n2 - listar\n0 - sair"));
                    subMenu = teclado.nextInt();
                        if(subMenu == 1){
                            cpm.cadastrar(estoque, this.menu);
                        }else if(subMenu == 2){
                            for(PratoMenu prato : this.menu){
                                System.out.println(prato);
                            }
                        }
                    
                }

            }else if(menu == 2){
                int subMenu = -1;
                while(subMenu != 0){
                    System.out.println(("1 - cadastra\n2 - listar\n3 - atualizar\n4 - deletar\n0 - sair"));
                    subMenu = teclado.nextInt();
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
                System.out.println("Operação Encerrada!");
            
            }else if(menu < 0 || menu > 3){
                System.out.println("Entrada Inválida");
            }
        }

            
            

    }
}

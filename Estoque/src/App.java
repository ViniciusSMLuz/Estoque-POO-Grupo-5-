import java.util.ArrayList;
import java.util.Scanner;
import Classes.*;
import metodos.*;


public class App { 
    ArrayList <Produto> estoque = new ArrayList<>();
    
    public void Menu(){
        Scanner teclado = new Scanner(System.in);
        int menu = -1;
            while(menu != 0){
                System.out.println(("1 - cadastra\n2 - listar\n3 - atualizar\n4 - deletar\n0 - sair"));
                menu = teclado.nextInt();
                    if(menu == 1){
                        estoque.add(cadastrarProduto.cadastrar(estoque));
                    }else if (menu == 2){
                         listarProduto.listar(estoque);
                    }else if(menu == 3){
                        atualizarProduto.atualizar(estoque);
                    }else if(menu == 4){
                        deletarProduto.deletar(estoque);
                    }
                   
            } 
            

    }
}

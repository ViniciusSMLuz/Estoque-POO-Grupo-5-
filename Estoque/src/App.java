import java.util.ArrayList;
import java.util.Scanner;
import Classes.*;
import metodos.*;


public class App { 
    ArrayList <Produto> estoque = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ArrayList <Produto> estoque = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int menu = 0;
            while(menu != 1){
                System.out.println(("1 - sair\n2 - listar"));
                menu = teclado.nextInt();
                    if(menu == 2){
                        listarProduto.listar(estoque);
                    }else if (menu != 1){
                         estoque.add(cadastrarProduto.cadastrar(estoque));
                    }else if(menu == 3){

                    }
                   
            } 
            

    }
}

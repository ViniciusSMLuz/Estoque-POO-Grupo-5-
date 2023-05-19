import java.util.ArrayList;
import java.util.Scanner;
import Classes.*;
import metodos.*;


public class App { 
    ArrayList <Produto> estoque = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        ArrayList <Produto> estoque = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int menu;
            while(menu != 1){
                System.out.println(("1 - sair\n2 - listar"););
                menu = teclado.nextInt();
                    if(menu == 2){
                        System.out.println(estoque);
                    }else{
                         estoque.add(cadastrarProduto.cadastrar(estoque));
                    }
                   
            } 
            

    }
}

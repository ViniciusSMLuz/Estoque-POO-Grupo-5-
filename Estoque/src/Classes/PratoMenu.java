package Classes;
import java.util.ArrayList;

public class PratoMenu {
    
    private String idPratoMenu;
    private String nomePratoMenu;
    private String descricaoPratoMenu;
    private ArrayList<Produto> ingredientesPratoMenu = new ArrayList<>();
    private double precoPratoMenu;


    public String getIdPratoMenu() {
        return idPratoMenu;
    }

    public String getNomePratoMenu() {
        return nomePratoMenu;
    }

    public String getDescricaoPratoMenu() {
        return descricaoPratoMenu;
    }

    public ArrayList<Produto> getIngredientesPratoMenu() {
        return ingredientesPratoMenu;
    }

    public double getPrecoPratoMenu() {
        return precoPratoMenu;
    }

    public void setIdPratoMenu(String idPratoMenu) {
        this.idPratoMenu = idPratoMenu;
    }

    public void setNomePratoMenu(String nomePratoMenu) {
        this.nomePratoMenu = nomePratoMenu;
    }

    public void setDescricaoPratoMenu(String descricaoPratoMenu) {
        this.descricaoPratoMenu = descricaoPratoMenu;
    }

    public void setIngredientesPratoMenu(Produto produto) {
        ingredientesPratoMenu.add(produto);
    }

    public void setPrecoPratoMenu(double precoPratoMenu) {
        this.precoPratoMenu = precoPratoMenu;
    }

    
    public void removeIngredientesPratoMenu(Produto produto) {
        ingredientesPratoMenu.remove(produto); 
    
    }



}

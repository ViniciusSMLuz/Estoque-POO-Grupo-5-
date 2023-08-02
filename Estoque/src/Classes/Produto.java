package Classes;
import java.util.UUID;

public class Produto {
    private String idProduto;
    private String nomeProduto;
    private String unidadeDeMedida;
    private double quantidadeProduto;
    private double quantidadePratoProduto;

    public Produto(){
        idProduto = UUID.randomUUID().toString();
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public double getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public String getUnidadeDeMedida() {
        return unidadeDeMedida;
    }

    public double getQuantidadePratoProduto() {
        return quantidadePratoProduto;
    }

    public void setUnidadeDeMedida(String unidadeDeMedida) {
        this.unidadeDeMedida = unidadeDeMedida;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidadeProduto(Double quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public void setQuantidadePratoProduto(double quantidadePratoProduto) {
        this.quantidadePratoProduto = quantidadePratoProduto;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Nome do Produto: " + getNomeProduto() +"\n";
        aux += "Unidade de Medida: " + getUnidadeDeMedida() +"\n";
        aux += "Quantidade disponível: " + getQuantidadeProduto() + " " + getUnidadeDeMedida() + "\n";    
        return aux;
    }

}

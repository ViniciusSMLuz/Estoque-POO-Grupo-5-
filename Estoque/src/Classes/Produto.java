package Classes;
import java.util.UUID;

public class Produto {
    private String idProduto;
    private String nomeProduto;
    private int quantidadeProduto;

    public Produto(){
        idProduto = UUID.randomUUID().toString();
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

}

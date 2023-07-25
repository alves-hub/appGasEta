package devandroid.alves.appgaseta.applistacurso.model;

public class Combustivel {
    private String nomeCombustivel;
    private Double precoCombustivel;
    private String recomendacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id;

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustive) {
        this. nomeCombustivel  = nomeCombustive;
    }

    public Double getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(Double precoCombustivel) {
        this.precoCombustivel = precoCombustivel;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }
}


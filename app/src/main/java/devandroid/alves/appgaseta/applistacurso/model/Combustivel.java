package devandroid.alves.appgaseta.applistacurso.model;

import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import javax.xml.transform.Source;

public class Combustivel {
    private String nomeCombustivel;
    private Double precoCombustivel;
    private String recomendacao;

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
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

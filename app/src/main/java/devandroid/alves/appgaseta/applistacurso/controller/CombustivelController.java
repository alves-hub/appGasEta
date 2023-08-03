package devandroid.alves.appgaseta.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.List;

import devandroid.alves.appgaseta.applistacurso.database.GasEtaDB;
import devandroid.alves.appgaseta.applistacurso.model.Combustivel;
import devandroid.alves.appgaseta.applistacurso.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    // declarar objeto do Shared
    SharedPreferences preferences;

    // objeto para edicao
    SharedPreferences.Editor listaGasEta;

    //nome para arquivo
    public static final String NAME_PREFERENCES = "pref_listaGasEta";

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        super(gasEtaActivity);

        preferences = gasEtaActivity.getSharedPreferences(NAME_PREFERENCES, 0);
        listaGasEta = preferences.edit();
    }

    public void salvar(Combustivel combustivel){
        ContentValues dados = new ContentValues();

        Log.d("MVC Controller","Controller iniciado..." + combustivel.toString());

        // inserindo dados na lista preference
        listaGasEta.putString("Combustivel", combustivel.getNomeCombustivel());
        listaGasEta.putString ("PreçoCombustivel", String.valueOf(combustivel.getPrecoCombustivel()));
        listaGasEta.putString("Recomendacao",  combustivel.getRecomendacao());
        listaGasEta.apply();

        // Salvando na base de dados
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel",dados);

    }

    public List<Combustivel> getListaDeDados(){
        return listarDados();
    }

    public void alterarDados(Combustivel combustivel){
        ContentValues dados = new ContentValues();

        dados.put("id", combustivel.getId());
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        //PASSANDO NOME DA TABELA E OS DADOS COLETADOS NO GET PARA METODO DO BANCO DE DADOS GasEtaDB
        alterarObjeto("Combustivel",dados);
    }

    public void deletarObject(int id) {
        deletarObject("Combustivel", id);

    }
}

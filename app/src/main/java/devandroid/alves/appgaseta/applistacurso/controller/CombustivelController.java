package devandroid.alves.appgaseta.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import devandroid.alves.appgaseta.applistacurso.database.GasEtaDB;
import devandroid.alves.appgaseta.applistacurso.model.Combustivel;
import devandroid.alves.appgaseta.applistacurso.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    Combustivel combustivel;

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

    public void Salvar(Combustivel combustivel){
        Log.d("MVC Controller","Controller iniciado..." + combustivel.toString());

        // inserindo dados na lista
        listaGasEta.putString("Combustivel", combustivel.getNomeCombustivel());
        listaGasEta.putString ("PreçoCombustivel", String.valueOf(combustivel.getPrecoCombustivel()));
        listaGasEta.putString("Recomendacao",  combustivel.getRecomendacao());
        listaGasEta.apply();

       // instaciando objeto
        ContentValues dados = new ContentValues();
        // Pegando valores para salvar na base de dados
        dados.put("nomeCombustivel", combustivel.getNomeCombustivel());
        dados.put("precoCombustivel", combustivel.getPrecoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        salvarObjeto("Combustivel",dados);

    }
}

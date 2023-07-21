package devandroid.alves.appgaseta.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import devandroid.alves.appgaseta.applistacurso.model.Combustivel;
import devandroid.alves.appgaseta.applistacurso.view.GasEtaActivity;

public class CombustivelController {

    Combustivel combustivel;

    // declarar objeto do Shared
    SharedPreferences preferences;

    // objeto para edicao
    SharedPreferences.Editor listaGasEta;

    //nome para arquivo
    public static final String NAME_PREFERENCES = "pref_listaGasEta";

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        preferences = gasEtaActivity.getSharedPreferences(NAME_PREFERENCES, 0);
        listaGasEta = preferences.edit();
    }

    public void salvar(Combustivel combustivel){
        Log.d("MVC Controller","Controller iniciado..." + combustivel.toString());

        // inserindo dados na lista
        listaGasEta.putString("Combustivel", combustivel.getNomeCombustivel());
        listaGasEta.putString ("PreçoCombustivel", String.valueOf(combustivel.getPrecoCombustivel()));
        listaGasEta.putString("Recomendacao",  combustivel.getRecomendacao());
        listaGasEta.apply();
    }
}

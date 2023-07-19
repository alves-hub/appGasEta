package devandroid.alves.appgaseta.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.alves.appgaseta.applistacurso.model.Combustivel;
import devandroid.alves.appgaseta.applistacurso.view.GasEtaActivity;

public class GasEtaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaGasEta;
    public static final String NAME_PREFERENCES = "jf_lista";

    public GasEtaController(GasEtaActivity GasEtaActivity) {

        preferences = GasEtaActivity.getSharedPreferences(NAME_PREFERENCES, 0);
        listaGasEta = preferences.edit();
    }

    public GasEtaController() {}

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC CONTROLLER","Controller iniciado...");
        return super.toString();
    }


}

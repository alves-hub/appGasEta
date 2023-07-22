package devandroid.alves.appgaseta.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.alves.appgaseta.applistacurso.model.Pessoa;

public class pessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NAME_PREFERENCES = "pref_listaVip";

    public pessoaController(MainActivity mainActivity) {
        //Estancia objeto SharedPreferences passando nome criado e 0 = leitura e escrita.
        preferences = mainActivity.getSharedPreferences(NAME_PREFERENCES, 0);

        //Criando arquivo tendo nome da lista "listaVip e associa ao arquivo no caso "preferences"
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {

        Log.d("MVC Controller", "Controller iniciado...");
        return super.toString();
    }

    public void Salvar(Pessoa pessoa) {
        Log.d("MVC Controller", "Controller iniciado..." + pessoa.toString());

        //associando  dados a lista
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("Sobrenome", pessoa.getSobreNome());
        listaVip.putString("CursoDesejado", pessoa.getCursoDesejado());
        listaVip.putString("Numtelefone", pessoa.getNumeroTelefone());

        //salvando no arquivo
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("Sobrenome", ""));
        pessoa.setCursoDesejado(preferences.getString("CursoDesejado", ""));
        pessoa.setNumeroTelefone(preferences.getString("Numtelefone", ""));

        return pessoa;
    }

    public void limpar() {
        listaVip.clear();
        listaVip.apply();
    }
}

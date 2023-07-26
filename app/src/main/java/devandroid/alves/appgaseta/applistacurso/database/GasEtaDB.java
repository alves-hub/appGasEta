package devandroid.alves.appgaseta.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import devandroid.alves.appgaseta.applistacurso.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT,  " +
                "nomeCombustivel TEXT, " +
                "precoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {

        db.insert(tabela, null, dados);

    }

    public List<Combustivel> listarDados() {

        // criando objeto lista
        List<Combustivel> lista = new ArrayList<>();

        // representa registro que esta salvo da tabela banco de dados
        Combustivel registro;

        String querySQL = "SELECT * FROM COMBUSTIVEL";

        cursor = db.rawQuery(querySQL,null);

        // condicao ao movendo curso topo da lista
        if (cursor.moveToFirst()){

            // laco primeiro pega registro da tabela respeitando
            // colunas e em seguida mover para proxima linha da tabela.
            //TODO contar registro SQL
            do {
                registro = new Combustivel();
                registro.setId(cursor.getInt(0));
                registro.setNomeCombustivel(cursor.getString(1));
                registro.setPrecoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                //adicionando  dados na lista registro
                lista.add(registro);

            }while (cursor.moveToNext());

        }else{

        }
        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados){

        //ID do registro a ser alterado (PK)
        // update TABLE set campo = novo dado WHERE id =?

        int id = dados.getAsInteger("id");

        //Alterando o dado na base de dados identificando pelo id
        db.update(tabela,dados,"id=?",
                new String[]{Integer.toString(id)});
    }

}


// Crias metodos para implementar CRUD
// C = Create criar o banco de dados e as tabelas
// Create database nome_banco_de_dados.db (SQL)
// 1 - Nome do banco de Dados
// 2 - Versão do Banco de Dados


// Create table (SQL)

// R = retrieve recuperar os dados salvos da tabela
// Select * from table (SQL)

// U = Update
// update from table (SQL)

// D = delete
// delete * from  table (SQL)



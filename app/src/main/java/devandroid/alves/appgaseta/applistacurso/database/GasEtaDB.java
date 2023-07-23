package devandroid.alves.appgaseta.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela,null, dados);
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

}

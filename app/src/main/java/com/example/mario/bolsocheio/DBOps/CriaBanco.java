package com.example.mario.bolsocheio.DBOps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by allanromanato on 5/27/15.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco1.db";
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    public static final int VERSAO = 2;

    public CriaBanco(Context context){


        super(context, NOME_BANCO,null,VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("ENTROU ENTROU ENTROU", "CRIA BANCO");

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + EDITORA + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //db.execSQL("DROP TABLE IF EXISTS" + TABELA); veificar o erro no exists
        db.execSQL("DROP TABLE IF EXISTS '" + TABELA + "'");
        onCreate(db);
    }
}

//package com.example.mario.bolsocheio.DBOps;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
///**
// * Created by allanromanato on 5/27/15.
// */
//public class CriaBanco extends SQLiteOpenHelper {
//
//    public static final String NOME_BANCO = "banco1.db";
//    public static final String TABELA = "livros";
//    public static final String ID = "_id";
//    public static final String TITULO = "titulo";
//    public static final String AUTOR = "autor";
//    public static final String EDITORA = "editora";
//    public static final int VERSAO = 2;
//
//    public CriaBanco(Context context){
//
//
//        super(context, NOME_BANCO,null,VERSAO);
//
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//
//        Log.d("ENTROU ENTROU ENTROU", "CRIA BANCO");
//
//        String sql = "CREATE TABLE "+TABELA+"("
//                + ID + " integer primary key autoincrement,"
//                + TITULO + " text,"
//                + AUTOR + " text,"
//                + EDITORA + " text"
//                +")";
//        db.execSQL(sql);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        //db.execSQL("DROP TABLE IF EXISTS" + TABELA); veificar o erro no exists
//        db.execSQL("DROP TABLE IF EXISTS '" + TABELA + "'");
//        onCreate(db);
//    }
//}

package com.example.mario.bolsocheio.DBOps;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by allanromanato on 5/27/15.
 */
public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "postos.db";
    public static final String TABELA = "dados";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String BRAND = "brand";
    public static final String SUB_DATE = "submission_date";
    public static final String LAT = "latitude";
    public static final String LONG = "longitude";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String COUNTRY = "country";
    public static final int VERSAO = 2;

    public CriaBanco(Context context){


        super(context, NOME_BANCO,null,VERSAO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("ENTROU ENTROU ENTROU", "CRIA BANCO");

        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + NAME + " text,"
                + PRICE + " text,"
                + BRAND + " text,"
                + SUB_DATE + " text,"
                + LAT + " text,"
                + LONG + " text,"
                + CITY + " text,"
                + STATE + " text,"
                + COUNTRY + " text"
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

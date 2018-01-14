package com.example.mario.bolsocheio.DBOps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by mario on 13/01/18.
 */

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){

        banco = new CriaBanco(context);
    }

    public String insereDado(String name, String price, String brand, String date,
                             String latitude, String longitude, String city,
                             String state, String country){
        ContentValues valores;
        long resultado;

        Log.d("DATABASE SQLite     ",name);
        Log.d("DATABASE SQLite     ",price);
        Log.d("DATABASE SQLite     ",brand);
        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriaBanco.NAME, name);
        valores.put(CriaBanco.PRICE, price);
        valores.put(CriaBanco.BRAND, brand);
        valores.put(CriaBanco.SUB_DATE, date);
        valores.put(CriaBanco.LAT, latitude);
        valores.put(CriaBanco.LONG, longitude);
        valores.put(CriaBanco.CITY, city);
        valores.put(CriaBanco.STATE, state);
        valores.put(CriaBanco.COUNTRY, country);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NAME};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id){
        Cursor cursor;
        String[] campos =  {banco.ID,banco.NAME,banco.PRICE,banco.BRAND};
        String where = CriaBanco.ID + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(int id, String name, String price, String brand, String date,
                               String latitude, String longitude, String city,
                               String state, String country){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.NAME, name);
        valores.put(CriaBanco.PRICE, price);
        valores.put(CriaBanco.BRAND, brand);
        valores.put(CriaBanco.SUB_DATE, date);
        valores.put(CriaBanco.LAT, latitude);
        valores.put(CriaBanco.LONG, longitude);
        valores.put(CriaBanco.CITY, city);
        valores.put(CriaBanco.STATE, state);
        valores.put(CriaBanco.COUNTRY, country);

        db.update(CriaBanco.TABELA,valores,where,null);
        db.close();
    }


}
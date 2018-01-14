package com.example.mario.bolsocheio.DBOps;

/**
 * Created by mario on 13/01/18.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mario.bolsocheio.R;
//TODO corrigir

public class Alterar extends Activity {
    EditText name;
    EditText price;
    EditText brand;
    EditText sub_date;
    EditText Lat;
    EditText Long;
    EditText city;
    EditText state;
    EditText country;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_edit);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        name = (EditText)findViewById(R.id.editText4);
        price = (EditText)findViewById(R.id.editText5);
        brand = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        //TODO alterar para os valores corretos e add todos os outros param
        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
//        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
//        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AUTOR)));
//        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.EDITORA)));

        //TODO corrigir aqui
//        alterar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                crud.alteraRegistro(Integer.parseInt(codigo),
//                        livro.getText().toString(),autor.getText().toString(),
//                        editora.getText().toString());
//                Intent intent = new Intent(Alterar.this,Consulta.class);
//                startActivity(intent);
//                finish();
//            }
//        });

    }
}
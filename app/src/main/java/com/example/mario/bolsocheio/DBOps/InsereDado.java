package com.example.mario.bolsocheio.DBOps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mario.bolsocheio.R;

/**
 * Created by mario on 13/01/18.
 */
public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_insert);

        Button botao = (Button)findViewById(R.id.button);

        //TODO correct this
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText name = (EditText)findViewById(R.id.editText_name);
                EditText price = (EditText)findViewById((R.id.editText_price));
                EditText brand = (EditText)findViewById(R.id.editText_data);
                EditText sub_date = (EditText)findViewById(R.id.editText_data);
                EditText latitude = (EditText)findViewById(R.id.editText_lat);
                EditText longitude = (EditText)findViewById(R.id.editText_long);
                EditText city = (EditText)findViewById(R.id.editText_city);
                EditText state = (EditText)findViewById(R.id.editText_city);
                EditText country = (EditText)findViewById(R.id.editText_city);

                String nameString = name.getText().toString();
                String priceString = price.getText().toString();
                String brandString = brand.getText().toString();
                String subDateString = sub_date.getText().toString();
                String latString = latitude.getText().toString();
                String longString = longitude.getText().toString();
                String cityString = city.getText().toString();
                String stateString = state.getText().toString();
                String countryString = country.getText().toString();

                String resultado;

                resultado = crud.insereDado(nameString,priceString,brandString,subDateString,
                        latString,longString,cityString,stateString,countryString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}

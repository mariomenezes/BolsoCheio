package com.example.mario.bolsocheio.MyVehicles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mario.bolsocheio.R;

/**
 * Created by mario on 14/01/18.
 */

public class InsertVehicle extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intentLocal = getIntent();
        String firstKeyName = intentLocal.getStringExtra("VALOR");

        // deve haver um textview no xml com id textView2
        //TextView t2 = (TextView) findViewById(R.id.textView2);
        //t2.setText(firstKeyName);
    }

    public void goBack(View v){
        // método que nos manda de volta à activity principal

        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULTADO","TEXTO DE RETORNO");
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}

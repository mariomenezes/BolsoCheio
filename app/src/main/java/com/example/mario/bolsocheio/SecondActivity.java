package com.example.mario.bolsocheio;

/**
 * Created by mario on 08/01/18.
 */

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intentLocal = getIntent();
        String firstKeyName = intentLocal.getStringExtra("VALOR");

        // deve haver um textview no xml com id textView2
        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(firstKeyName);
    }

    public void goBack(View v){
        // método que nos manda de volta à activity principal

        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULTADO","TEXTO DE RETORNO");
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}

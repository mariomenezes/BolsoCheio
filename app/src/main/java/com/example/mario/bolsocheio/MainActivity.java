package com.example.mario.bolsocheio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mario.bolsocheio.DBOps.Alterar;
import com.example.mario.bolsocheio.DBOps.BancoController;
import com.example.mario.bolsocheio.DBOps.Consulta;
import com.example.mario.bolsocheio.DBOps.CriaBanco;
import com.example.mario.bolsocheio.DBOps.InsereDado;
import com.example.mario.bolsocheio.GasStation.FindGasStation;
import com.example.mario.bolsocheio.GasStation.MainFilterGasStation;
import com.example.mario.bolsocheio.GasStationFragment.MainGasStationFragment;
import com.example.mario.bolsocheio.MyVehicles.InsertVehicle;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static final int CHAMADA = 1;
    //String className =  this.getLocalClassName();


    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Altered by me
        //Intent intent = getIntent();
        ///

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Call GPS class
        GPSLocationTracker gps = new GPSLocationTracker (this);
        double latitude = gps.getLatitude();
        double longitude= gps.getLongitude();

        Log.d(TAG, String.valueOf(latitude));
        Log.d(TAG, String.valueOf(longitude));

        //CriaBanco banco = new CriaBanco(this);

        BancoController banco = new BancoController(this);

        //banco.insereDado

        //InsereDado inseredado = new InsereDado();
    }

    //modified by me
    public void openActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("VALOR", "UM TEXTO");
        startActivityForResult(intent, CHAMADA);
    }

    public void openMaps(View v){
        Intent intent = new Intent(this, Maps.class);
        intent.putExtra("MAPS", "OPEN");
        startActivityForResult(intent, CHAMADA);
    }

    public void openDB(View v){
        Intent intent = new Intent (this, InsereDado.class);
        intent.putExtra("DB", "OPEN");
        startActivityForResult(intent, CHAMADA);
    }

    public void consultaDB(View v){
        Intent intent = new Intent(this, Consulta.class);
        intent.putExtra("DB","Consulta");
        startActivityForResult(intent, CHAMADA);
    }

    public void alterarDB(View v){
        Intent intent = new Intent(this, Alterar.class);
        intent.putExtra("DB","Alterar");
        startActivityForResult(intent, CHAMADA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CHAMADA) {
            if (resultCode == RESULT_OK) {
                //TODO verificar se será útil para algo na frente
                // deve haver um textview no xml com id textView1
                //TextView t1 = (TextView) findViewById(R.id.textView1);
                //t1.setText(data.getStringExtra("RESULTADO"));
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.postos_nav) {
            Intent intent = new Intent(this, MainGasStationFragment.class);
            intent.putExtra("GAS SATATION", "OPEN");
            startActivityForResult(intent, CHAMADA);

        } else if (id == R.id.mapas_nav) {
            Intent intent = new Intent(this, Maps.class);
            intent.putExtra("MAPS", "OPEN");
            startActivityForResult(intent, CHAMADA);

        } else if (id == R.id.estatistica_nav) {

        } else if (id == R.id.meus_veiculos_nav) {

        } else if (id == R.id.custos_nav) {

        } else if (id == R.id.meus_veiculos_nav) {
            Intent intent = new Intent(this, InsertVehicle.class);
            intent.putExtra("VEHICLES", "OPEN");
            startActivityForResult(intent, CHAMADA);

        } else if (id == R.id.registros_despesas_nav){

        } else if (id == R.id.perfil_nav){

        } else if (id == R.id.compartilhar_nav){

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

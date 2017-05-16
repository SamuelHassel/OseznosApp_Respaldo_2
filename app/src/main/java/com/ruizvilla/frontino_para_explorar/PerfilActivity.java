package com.ruizvilla.frontino_para_explorar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class PerfilActivity extends AppCompatActivity {
    Intent intent;
    TextView tUsername, tCorreo;
    String username,correo;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //Accediendo al archivo de preferencias
        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

 /*       Bundle extras = getIntent().getExtras(); // Extrae cosas desde el inten en login, tambien se copia en el perfil
        username = extras.getString("username",username);//
        correo = extras.getString("correo", correo);

        tUsername = (TextView) findViewById(R.id.tUsername);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        // Y cuando yo llame mi perfil mande estos dos datos

        //llenando las cajas de texto
        tUsername.setText(username);
        tCorreo.setText(correo);*/

    }

   ///Esta parte es** la que relaciona un activity con el menu OVERFLOW
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.mCerrar:
                //Ejecucion de reseteo
                editor.putInt("login",-1);
                editor.commit();
                intent = new Intent(PerfilActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.mPrincipal:
                intent = new Intent (PerfilActivity.this, DrawerActivity.class);
                // No se porque para volver a principal tiene que estar los putExtra
                /*intent.putExtra("username", username);
                intent.putExtra("correo", correo);*/
                startActivity(intent);
               // Toast.makeText(this, "pues el boton funciona....", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
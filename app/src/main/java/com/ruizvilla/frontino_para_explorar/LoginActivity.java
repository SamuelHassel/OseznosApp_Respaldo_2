
package com.ruizvilla.frontino_para_explorar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, ePassword;
    TextView tRegistrarse;
    Button bIniciar;
    Intent intent;
    String username="", password="", correo="";
    //Capacidad de captura
    SharedPreferences prefs;
    //Capacidad de edicion
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Hasta aqui puedo capturarlas
        prefs = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        editor = prefs.edit();
        // El almacenamiento se realiza abajo

       // Carga de preferencias
        username = prefs.getString("nombre","");
        password = prefs.getString("pass","");
        correo = prefs.getString("mail","");
//Pero si ya hay almacenamiento se ejecuta el sigueinte


        Toast.makeText(getApplicationContext(), String.valueOf(prefs.getInt("login",-1)),  Toast.LENGTH_SHORT).show();
        if(prefs.getInt("login", -1)==1){
            //Entonces hay logueado, entonces proceda a Inten
           // Toast.makeText(getApplicationContext(), "ENTRO COMO SI ESTUVIERA LOGUEADO", Toast.LENGTH_SHORT).show();
            intent = new Intent (LoginActivity.this, DrawerActivity.class);
            intent.putExtra("username", username);// Esto se copia igual en un case de el MAIN
            intent.putExtra("correo", correo);
            startActivity(intent);
            finish();
        }


        eUsername = (EditText) findViewById(R.id.eUsername);
        ePassword = (EditText) findViewById(R.id.ePassword);
        tRegistrarse = (TextView) findViewById(R.id.tRegistrarse);
        bIniciar = (Button) findViewById(R.id.bIniciar);

        bIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Validan que los dos campos esten diligenciados

                //Validar los datos digitados con los del registro
                if (eUsername.getText().toString().equals(username) && ePassword.getText().toString().equals(password)){

                  // Para indicar a preferencias que si hay alguien logueado
                   editor.putInt("login",1);
                    editor.commit();


                    intent = new Intent (LoginActivity.this, DrawerActivity.class);
                    intent.putExtra("username", username);// Esto se copia igual en un case de el MAIN
                    intent.putExtra("correo", correo);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent (LoginActivity.this, RegistroActivity.class);
                //Esto parece ser lo que hace que registro activity no tenga un intent de regreso aca
                startActivityForResult(intent, 1234);

            }
        });
    }

    //metodos de override Ctrl + O (no es un cero)

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1234 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            correo = data.getExtras().getString("correo");

            //En una variable llamada nombre almacenara la anterior var username
            editor.putString("nombre", username);
            editor.putString("pss", password);
            editor.putString("mail", correo);
            //Obligatoriamente hay que hacer este commit
            editor.commit();

        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Registro cancelado", Toast.LENGTH_SHORT).show();
        }


    }
}
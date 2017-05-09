
package com.ruizvilla.frontino_para_explorar;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, ePassword;
    TextView tRegistrarse;
    Button bIniciar;
    Intent intent;
    String username="", password="", correo="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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
                    intent = new Intent (LoginActivity.this, DrawerActivity.class);
                    //intent.putExtra("username", username);// Esto se copia igual en un case de el MAIN
                    //intent.putExtra("correo", correo);
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
        }
        if (requestCode==1234 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Registro cancelado", Toast.LENGTH_SHORT).show();
        }


    }
}
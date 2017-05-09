package com.ruizvilla.frontino_para_explorar;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    EditText eRegUsername, eRegPassword, eRegRepPassword, eRegCorreo;
    Button bRegistrarse, bCancelar;
    String username, password, repPassword, correo;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        eRegUsername = (EditText) findViewById(R.id.eRegUsername);
        eRegPassword = (EditText) findViewById(R.id.eRegPassword);
        eRegRepPassword = (EditText) findViewById(R.id.eRegRepPassword);
        eRegCorreo = (EditText) findViewById(R.id.eRegCorreo);
        bRegistrarse = (Button) findViewById(R.id.bRegistrarse);
        bCancelar = (Button) findViewById(R.id.bCancelar);

        bRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // validar que todos los campos esten llenos

                username = eRegUsername.getText().toString();
                password = eRegPassword.getText().toString();
                repPassword = eRegRepPassword.getText().toString();
                correo = eRegCorreo.getText().toString();

                //validar que el password y repPassword sean iguales

                intent = new Intent();
                intent.putExtra("username", username);
                intent.putExtra("password", password);
                intent.putExtra("correo",correo);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}

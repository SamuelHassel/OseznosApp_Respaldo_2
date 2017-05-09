package com.ruizvilla.frontino_para_explorar;



//ASI ERA
/*import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Contenedor_Fragmentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenedor__fragmentos);
    }
}*/

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Contenedor_Fragmentos extends AppCompatActivity {

    FragmentManager fm;
    FragmentTransaction ft;
    SitioDos p2;
    SitioUno p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        p1 = new SitioUno();
        ft.add(android.R.id.content, p1).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ft = fm.beginTransaction();
        if (id == R.id.mFrag1){
            p1 = new SitioUno();
            ft.replace(android.R.id.content, p1).commit();
        } else {
            p2 = new SitioDos();
            ft.replace(android.R.id.content, p2).commit();
        }
        return super.onOptionsItemSelected(item);
    }
}




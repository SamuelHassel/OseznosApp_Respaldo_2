package com.ruizvilla.frontino_para_explorar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;
    //Para preferencias
    SharedPreferences prefs;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Accediendo al archivo de preferencias
        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

            switch (id){
                case R.id.mCerrar:
                    //Ejecucion de reseteo
                    editor.putInt("login",-1);
                    editor.commit();
                    intent = new Intent(DrawerActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.mSitios:
                    intent = new Intent (DrawerActivity.this, SitiosActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.mBares:
                    intent = new Intent (DrawerActivity.this, Bares.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.mHoteles:
                    intent = new Intent (DrawerActivity.this, Hoteles.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.mMiPerfil:
                    intent = new Intent (DrawerActivity.this, PerfilActivity.class);
//                intent.putExtra("username", username);
//                intent.putExtra("correo", correo);
                    startActivity(intent);
                    break;
            }
            return super.onOptionsItemSelected(item); //
        }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            intent = new Intent (DrawerActivity.this, ListaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            intent = new Intent (DrawerActivity.this, ListaActivity_2.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            intent = new Intent (DrawerActivity.this, ListaActivity_2.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            intent = new Intent (DrawerActivity.this, ListaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {
            intent = new Intent (DrawerActivity.this, ListaActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_send) {
            intent = new Intent (DrawerActivity.this, ListaActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}

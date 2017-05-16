package com.ruizvilla.frontino_para_explorar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {
// Nuevo adapador



    Intent intent;
    ListView listView;
    //Para preferencias
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    //// Este ListViwe se invoca luego abajo en A) se implementa


    ////// B)  Se crea un onjeto que contiene la siguiente info
    //String[] data = new String[]{"Casa vieja", "Chaquenoda", "La casona"};
    //La anterior lista se comenta para tomar la info desde la clase Lista enttrada

    //G) Se crea el objeto instancia de la clase Lista de entrada como privado par ala clase Lista Activity como un arreglo de arreglos
    // Osea, es un arreglo generico del tipo "datos" la palabra "datos" la tengo en duda, que contiene varios arreglos del tipo Lista de entrada
    private Lista_Entrada[] datos = new Lista_Entrada[]{
            // Esto es un arreglos con indices desde cero
            // Estos son objetos del tipo lista de entrada y en el orden de construccion alli
            // asi se programo su nomenclatura: public Lista_Entrada(int idImagen, String nombre, String descrip, String direct) {
            //Al parecer es congfuso porque la clase, el objeto y el nombre del metodo constructor es el mismo
            new Lista_Entrada(R.drawable.oso_1, "Vereda San Lazaro", "Zona de avistamientos", "Zona de apreciación"),
            new Lista_Entrada(R.drawable.oso_2, "Alto de Musinga", "Hábitat nativo", "Zona de precaución"),
            new Lista_Entrada(R.drawable.oso_3, "Vereda Nore", "Zona de avistamientos", "Zona de apreciación"),
            new Lista_Entrada(R.drawable.oso_4, "Vereda El cerro", "Zona de avistamientos", "Zona de apreciación"),
            new Lista_Entrada(R.drawable.oso_5, "Corregimiento Nutibara", "Zona de avistamientos", "Zona de apreciación"),
            new Lista_Entrada(R.drawable.oso_6, "Alto de Ponton", "Hábitat nativo", "Zona de precaución")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        //Accediendo al archivo de preferencias
        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        //// A) aca se relacional el objeto ListView con el xml
        // Ojo la palabra data aca la puse como datos y es el argumento que se ve abajo
        listView = (ListView) findViewById(R.id.lista);

        //_________________________________
        //// C) Igual que en parquesAvtivity que usamos adaptatores para los TABS para colocar encima los TAPS entonces aca tambien definimos
        // ///un adapter para adaptar contenido de unso String al ListView
        //////parametros siguientes: contexto de la app, tipo de adaptador (simple, predefinido), luego los datos que es "datos"

        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, datos);

        // Hasta el paso C se logra una lista en cuyos renglones aparecen los String cargados por C desde el "datos" defimnido en B
        //// El adaptador anterior se modifico para poder recibir datos


        Adapter adapter = new Adapter(this, datos);
        listView.setAdapter(adapter); // y esta eea lo que lo conecta

        ///PROGRAMANDO LOS LISTENER PARA LA LISTA
// J) Al dar clic en un item se imprime por la linea toast comentada la posicion del elemento pulsado, con el metodo comentado abajo
        // que tiene un switch se puede generar ordenes de navegacion al tocar items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // Esto de abajo es la implementacion y se hizo automaticamente
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Ojo con eso del contexto, ojo que para imprimir el in se pasa a entero
                // acceso a un dato relacionado con la psocion pulsada
                //String opcion =  ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

                //Toast.makeText(getApplicationContext(), String.valueOf(position),Toast.LENGTH_SHORT).show();

                //Toast.makeText(getApplicationContext(), opcion ,Toast.LENGTH_SHORT).show();



  // Para que los botones envien a lugares
      switch (position){
          // No me deja ir a los activity main
          case 0:
              intent = new Intent (ListaActivity.this, MapsActivity.class );
              startActivity(intent);
              finish();
              break;
          case 1:
              intent = new Intent (ListaActivity.this, DrawerActivity.class );
              startActivity(intent);
              finish();
              break;
          case 2:
              intent = new Intent (ListaActivity.this, PerfilActivity.class );
              startActivity(intent);
              finish();
              break;
          case 3:
              intent = new Intent (ListaActivity.this, MapsActivity.class );
              startActivity(intent);
              finish();
              break;
                }



                //____________________________________________________fin del switch
            }
        });
    }
 //NECESITO TOMAR ESTA INFORMACION Y ADAPTARLA CON UN ADAPTADOR ENTONCES SE CREARA CLASE ADAPADOR


    // H) heredado del tipo de dato ArrayAdapter del tipo Lista de entrada, dice error damos onclick para que se cree constructor

    class  Adapter extends  ArrayAdapter<Lista_Entrada>{
       //H_1 ) Este es el constructor que se crea por el bombillito, se modifica pasandole el contexto de la applic y el listado de datos, en super
        // OJOOOO en el argumento de super se indica DONDE SE VA A PONER LA ADAPTACION
        public Adapter(@NonNull Context context, Lista_Entrada[] datos){
            super(context, R.layout.list_item, datos); // Super es el colocador
            // Esta es la primera parte del constructor y donde se indica donde quedaran los dartos
            // list_item ES EL XML QUE CONTIENE EL ITEM PLANTILLA
        }

        //______________________________________________________________________________________
// I) Con Control + o  esque saco estos metodos o codigos el metodo GETVIEW permite tener acceso a la VISTA, por medio de este es que coloca
        // esa info a cada uno de los Lis_Item, por eso se requieren Id en todos los elementos que componen el List_Item para ser accesada
        @NonNull
        @Override
        // es un metodo de android obtiene las posiciones de lista de entrada, mire que esta dentro de Adapter
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            //aca se relaciona la List_item,osea trayendo la vista y cargando una isntancia de el en "item"
            // item es una instancia del List_item.xml por tal debe invocarse con el nombre en fidView
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item,null);

            // Se relaciona cada elemento de la instancia de List_item con su dato en "datos"

            //I_1) se esta trabajando con una instancia de List_item lalmada item, a esta se le esta asignando coordinadamente la info
            // almacenada en "datos"  por medio de posiciones coordiandas por el acutal metodo getView
            // Se invoca cada Wizard del list_item, entonces es decir, lo que halla en tNombre del onjeto relacional (List_item
            // seteele luego lo el argumento (lo que halla en la position tal de el arreglo datos cargado a travez del getter que se
            // encarga del elemento Nombre en Lista_entrada

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direcc = (TextView) item.findViewById(R.id.tDirec);
            direcc.setText(datos[position].getDirect());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            //En lista de entrada se usaron getters que retornaran la ide de los alementos
            // En Item se carga una instancia
            // get wiew contiene una posicion para cargar la info

            return item;
        }
    }

//___________________________________________
///Esta parte es** la que relaciona un activity con el menu OVERFLOW
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_perfil, menu);
    // Pueden compartir un mismo menu para varias cosas, y se invoca desde aca
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
                intent = new Intent(ListaActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.mPrincipal:
                intent = new Intent (ListaActivity.this, DrawerActivity.class);
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




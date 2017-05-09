package com.ruizvilla.frontino_para_explorar;

/**
 * Created by Usuario on 05/04/2017.
 */

/**E) Se crea esta clase para que gestione mas tipos de datos a vincular con el el Item_list, se definen entonces privadamente los tipos de atributo
 *  como por buena practica son privados para poder acceder estos datos dede Lista_activity.java se hara a través de los metodos getter y setter
 * estos metodos se generan automaticamente con click derecho generar getter und setter, setter obtiene, setter configura el valor
 */

public class Lista_Entrada {
    private  int idImagen; // Porque los ID son enteros
    private  String nombre, descrip, direct;

    // Contrustucores que asignen valores

    //F) se crea constructor por cliock derecho generar poara variables seleccionadas, el constructor es la utlilizacion o creacion
    // del objeto de la clase Lista_Entrada la cual solo estaba abstraida pero no se habia hecho objeto
    public Lista_Entrada(int idImagen, String nombre, String descrip, String direct) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.direct = direct;
    }

    // Por ser una clase, entonces al estar privados necesitamos unsar gettres y setter
    //se generaron automaticamente por click derecho generate
    public int getIdImagen() {
        return idImagen;
    }
    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    // getter y setter para los String...

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}

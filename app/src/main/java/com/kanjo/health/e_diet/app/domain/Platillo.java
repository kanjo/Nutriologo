package com.kanjo.health.e_diet.app.domain;

/**
 * Created by JARP on 5/14/14.
 */
public class Platillo {

    public Platillo(String descripcion, String receta)
    {
        this.descripcion=descripcion;
        this.receta=receta;
    }


    public String descripcion;
    public String receta;
}

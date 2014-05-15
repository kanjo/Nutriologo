package com.kanjo.health.e_diet.app.domain;

/**
 * Created by JARP on 5/14/14.
 */
public class AlimentoPorcion {

    public AlimentoPorcion(String descripcion,String medida, int porcion)
    {
        this.descripcion=descripcion;
        this.tipoMedida=medida;
        this.porcion = porcion;

    }
    public String descripcion;

    //La porcion se va a manejar como
    //una unidad de 1000 ejemplos :
    // una 1 taza = 1000 , 2 piezas = 2000,
    // 3/4 taza = 750 etc...

    public int porcion;
    public String tipoMedida;
}

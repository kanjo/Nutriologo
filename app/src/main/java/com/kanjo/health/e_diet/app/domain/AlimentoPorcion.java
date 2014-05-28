package com.kanjo.health.e_diet.app.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JARP on 5/14/14.
 */
public class AlimentoPorcion implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(descripcion);
        parcel.writeString(tipoMedida);
        parcel.writeInt(porcion);
    }
    public static final Parcelable.Creator<AlimentoPorcion> CREATOR =  new Parcelable.Creator<AlimentoPorcion>() {

        @Override
        public AlimentoPorcion createFromParcel(Parcel parcel) {
            return new AlimentoPorcion(parcel);
        }

        @Override
        public AlimentoPorcion[] newArray(int i) {
            return new AlimentoPorcion[0];
        }
    };

    private AlimentoPorcion(Parcel in )
    {
        descripcion = in.readString();
        tipoMedida= in.readString();
        porcion = in.readInt();
    }


}

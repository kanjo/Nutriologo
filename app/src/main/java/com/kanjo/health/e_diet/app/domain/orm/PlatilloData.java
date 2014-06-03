package com.kanjo.health.e_diet.app.domain.orm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JARP on 6/3/14.
 */
public class PlatilloData implements Parcelable {

    public int KEY_ID;
    public int idPlatillo ;
    public String Descripcion ;
    public String Ingredientes ;
    public String Preparacion ;
    public int idGrupoPlatillo ;

    public PlatilloData(int KEY_ID, int idPlatillo, String descripcion, String ingredientes, String preparacion, int idGrupoPlatillo) {
        this.KEY_ID = KEY_ID;
        this.idPlatillo = idPlatillo;
        Descripcion = descripcion;
        Ingredientes = ingredientes;
        Preparacion = preparacion;
        this.idGrupoPlatillo = idGrupoPlatillo;
    }

    public PlatilloData(int idPlatillo, String descripcion, String ingredientes, String preparacion, int idGrupoPlatillo) {
        this.idPlatillo = idPlatillo;
        Descripcion = descripcion;
        Ingredientes = ingredientes;
        Preparacion = preparacion;
        this.idGrupoPlatillo = idGrupoPlatillo;
    }

    /**
     * Used for writing a copy of this object to a Parcel, do not manually call.
     */
    public static final Parcelable.Creator<PlatilloData> CREATOR = new Parcelable.Creator<PlatilloData>() {
        public PlatilloData createFromParcel(Parcel in) {
            return new PlatilloData(in);
        }

        public PlatilloData[] newArray(int size) {
            return new PlatilloData[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(KEY_ID);
        parcel.writeInt(idPlatillo);
        parcel.writeString(Descripcion);
        parcel.writeString(Ingredientes);
        parcel.writeString(Preparacion);
        parcel.writeInt(idGrupoPlatillo);

    }

    private PlatilloData(Parcel in )
    {
        KEY_ID = in.readInt();
        idPlatillo = in.readInt();
        Descripcion= in.readString();
        Ingredientes= in.readString();
        Preparacion= in.readString();
        idGrupoPlatillo = in.readInt();
    }

}

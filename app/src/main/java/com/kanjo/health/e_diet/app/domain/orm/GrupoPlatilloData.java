package com.kanjo.health.e_diet.app.domain.orm;

import android.os.Parcel;
import android.os.Parcelable;

import com.kanjo.health.e_diet.app.domain.GroupAlimento;

/**
 * Created by JARP on 6/3/14.
 */
public class GrupoPlatilloData implements Parcelable {

    public int KEY_ID;
    public int idGrupoPlatillo ;
    public String Descripcion ;

    public GrupoPlatilloData(int KEY_ID, int idGrupoPlatillo, String descripcion) {
        this.KEY_ID = KEY_ID;
        this.idGrupoPlatillo = idGrupoPlatillo;
        Descripcion = descripcion;
    }

    public GrupoPlatilloData(int idGrupoPlatillo, String descripcion) {
        this.idGrupoPlatillo = idGrupoPlatillo;
        Descripcion = descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    /**
     * Used for writing a copy of this object to a Parcel, do not manually call.
     */
    public static final Parcelable.Creator<GrupoPlatilloData> CREATOR = new Parcelable.Creator<GrupoPlatilloData>() {
        public GrupoPlatilloData createFromParcel(Parcel in) {
            return new GrupoPlatilloData(in);
        }

        public GrupoPlatilloData[] newArray(int size) {
            return new GrupoPlatilloData[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(KEY_ID);
        parcel.writeInt(idGrupoPlatillo);
        parcel.writeString(Descripcion);

    }

    private GrupoPlatilloData(Parcel in )
    {
        KEY_ID= in.readInt();
        idGrupoPlatillo= in.readInt();
        Descripcion= in.readString();

    }
}


package com.kanjo.health.e_diet.app.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

/**
 * Created by JARP on 5/25/14.
 */
public class Horario implements Parcelable {

    public String DESCRIPTION;
    public int DRAWABLE;
    public Date DateTimeHorario = new Date();
    public List<GroupAlimento> ListGroupAlimentos;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(DESCRIPTION);
        parcel.writeInt(DRAWABLE);
        parcel.writeLong(DateTimeHorario.getTime());
        parcel.writeList(ListGroupAlimentos);

    }

    public static final Parcelable.Creator<Horario> CREATOR
            = new Parcelable.Creator<Horario>() {
        public Horario createFromParcel(Parcel in) {
            return new Horario(in);
        }

        public Horario[] newArray(int size) {
            return new Horario[size];
        }
    };

    private Horario(Parcel in)
    {
        DESCRIPTION = in.readString();
        DRAWABLE= in.readInt();
        DateTimeHorario = new Date(in.readLong());
        ListGroupAlimentos = in.readArrayList(GroupAlimento.class.getClassLoader());
    }

    public Horario(String Description,java.util.Date dateTimeHorario, List<GroupAlimento> GrupoAlimentos )
    {
        this.DESCRIPTION= Description;
        this.DateTimeHorario = dateTimeHorario;
        this.ListGroupAlimentos = GrupoAlimentos;
    }

    public Horario(){}

}

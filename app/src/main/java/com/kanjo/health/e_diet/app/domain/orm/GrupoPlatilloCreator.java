package com.kanjo.health.e_diet.app.domain.orm;

import android.content.ContentValues;
import android.database.Cursor;

import com.kanjo.health.e_diet.app.profile.eDietSchema;

import java.util.ArrayList;

/**
 * Created by JARP on 6/3/14.
 */
public class GrupoPlatilloCreator {

    public static ContentValues getCVfromUser(final GrupoPlatilloData data){

        ContentValues mContentValues = new ContentValues();
        mContentValues.put(eDietSchema.GrupoAlimentos.Cols.GRUPO_ALIMENTO_ID,data.idGrupoPlatillo);
        mContentValues.put(eDietSchema.GrupoAlimentos.Cols.DESCRIPCION,data.Descripcion);
        return mContentValues;
    }

    public static ArrayList<GrupoPlatilloData> getGrupoPlatilloDataArrayListFromCursor(Cursor cursor)
    {
        ArrayList<GrupoPlatilloData> grupoPlatilloDatas = new ArrayList<GrupoPlatilloData>();

        if(cursor!=null)
        {
            if(cursor.moveToFirst())
            {
                do {
                    grupoPlatilloDatas.add(getGrupoPlatilloDataFromCursor(cursor));
                }while(cursor.moveToNext()==true);
            }
        }
        return grupoPlatilloDatas;
    }

    public static GrupoPlatilloData getGrupoPlatilloDataFromCursor(Cursor cursor) {
        int ID = cursor.getInt(cursor.getColumnIndex(eDietSchema.GrupoAlimentos.Cols.ID));
        int grupoAlimentoID = cursor.getInt(cursor.getColumnIndex(eDietSchema.GrupoAlimentos.Cols.GRUPO_ALIMENTO_ID));
        String descripcion = cursor.getString(cursor.getColumnIndex(eDietSchema.GrupoAlimentos.Cols.DESCRIPCION));
        return  new GrupoPlatilloData(ID,grupoAlimentoID,descripcion);
    }
}

package com.kanjo.health.e_diet.app.domain.orm;

import android.content.ContentValues;
import android.database.Cursor;

import com.kanjo.health.e_diet.app.domain.Platillo;
import com.kanjo.health.e_diet.app.profile.eDietSchema;

import java.util.ArrayList;

/**
 * Created by JARP on 6/3/14.
 */
public class PlatilloCreator {

    public static ContentValues getCVfromPlatillo(final PlatilloData data)
    {
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(eDietSchema.Platillo.Cols.GRUPO_PLATILLO_ID,data.idGrupoPlatillo);
        mContentValues.put(eDietSchema.Platillo.Cols.PREPARACION,data.Preparacion);
        mContentValues.put(eDietSchema.Platillo.Cols.INGREDIENTES,data.Ingredientes);
        mContentValues.put(eDietSchema.Platillo.Cols.DESCRIPCION,data.Descripcion);
        mContentValues.put(eDietSchema.Platillo.Cols.PLATILLO_ID,data.idPlatillo);

        return  mContentValues;
    }

    public static ArrayList<PlatilloData> getPlatilloDataArrayListFromCursor(Cursor cursor)
    {
        ArrayList<PlatilloData> platilloDatas = new ArrayList<PlatilloData>();
        if(cursor!=null)
        {
            if(cursor.moveToFirst())
            {
                do {
                    platilloDatas.add(getPlatilloDataFromCursor(cursor));
                }while(cursor.moveToNext()==true);
            }
        }
        return  platilloDatas;
    }

    public static PlatilloData getPlatilloDataFromCursor(Cursor cursor)
    {

        int KEY_ID = cursor.getInt(cursor.getColumnIndex(eDietSchema.Platillo.Cols.ID));
        int idPlatillo  = cursor.getInt(cursor.getColumnIndex(eDietSchema.Platillo.Cols.PLATILLO_ID));
        String Descripcion = cursor.getString(cursor.getColumnIndex(eDietSchema.Platillo.Cols.DESCRIPCION));
        String Ingredientes = cursor.getString(cursor.getColumnIndex(eDietSchema.Platillo.Cols.INGREDIENTES));
        String Preparacion = cursor.getString(cursor.getColumnIndex(eDietSchema.Platillo.Cols.PREPARACION));
        int idGrupoPlatillo= cursor.getInt(cursor.getColumnIndex(eDietSchema.Platillo.Cols.GRUPO_PLATILLO_ID));

        return new PlatilloData(KEY_ID,idPlatillo,Descripcion,Ingredientes,Preparacion,idGrupoPlatillo);

    }

    /*

    }

    public static UserData getUserDataFromCursor(Cursor cursor)
    {
        int userid= cursor.getInt(cursor.getColumnIndex(eDietSchema.User.Cols.USER_ID));
        String name = cursor.getString(cursor.getColumnIndex(eDietSchema.User.Cols.NAME));
        String mail = cursor.getString(cursor.getColumnIndex(eDietSchema.User.Cols.MAIL));
        Date creationDate = new Date(cursor.getLong(cursor.getColumnIndex(eDietSchema.User.Cols.CREATION_DATE)));
        UserData userData = new UserData(userid,name,mail,creationDate);
        return  userData;

    }*/
}

package com.kanjo.health.e_diet.app.domain.orm;

import android.content.ContentValues;
import android.database.Cursor;

import com.kanjo.health.e_diet.app.profile.eDietSchema;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by JARP on 5/31/14.
 */
public class UserCreator {

    public static ContentValues getCVfromUser(final UserData data)
    {
        ContentValues mContentValues = new ContentValues();
        mContentValues.put(eDietSchema.User.Cols.USER_ID,data.userid);
        mContentValues.put(eDietSchema.User.Cols.MAIL,data.mail);
        mContentValues.put(eDietSchema.User.Cols.CREATION_DATE,data.creationDate.getTime());
        mContentValues.put(eDietSchema.User.Cols.NAME,data.name);
        return  mContentValues;
    }

    public static ArrayList<UserData> getUserDataArrayListFromCursor(Cursor cursor)
    {
        ArrayList<UserData> mUserDatas= new ArrayList<UserData>();
        if(cursor!=null)
        {
            if(cursor.moveToFirst())
            {
                do {
                    mUserDatas.add(getUserDataFromCursor(cursor));
                }while(cursor.moveToNext()==true);
            }
        }

        return  mUserDatas;
    }

    public static UserData getUserDataFromCursor(Cursor cursor)
    {
        int id = cursor.getInt(cursor.getColumnIndex(eDietSchema.User.Cols.ID));
        int userid= cursor.getInt(cursor.getColumnIndex(eDietSchema.User.Cols.USER_ID));
        String name = cursor.getString(cursor.getColumnIndex(eDietSchema.User.Cols.NAME));
        String mail = cursor.getString(cursor.getColumnIndex(eDietSchema.User.Cols.MAIL));
        Date creationDate = new Date(cursor.getLong(cursor.getColumnIndex(eDietSchema.User.Cols.CREATION_DATE)));
        UserData userData = new UserData(id,userid,name,mail,creationDate);
        return  userData;

    }

}

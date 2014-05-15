package com.kanjo.health.e_diet.app.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JARP on 5/14/14.
 */
public class GroupAlimento implements Parcelable
{
    public int quantity;
    public String description;
    public AlimentoType alimentoType;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(quantity);
        parcel.writeString(description);
        parcel.writeString(alimentoType==null?"":alimentoType.name());

    }

    public static final Parcelable.Creator<GroupAlimento> CREATOR =  new Parcelable.Creator<GroupAlimento>() {

        public GroupAlimento createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return null;
        }

        @Override
        public GroupAlimento createFromParcel(Parcel parcel) {
            return null;
        }

        @Override
        public GroupAlimento[] newArray(int i) {
            return new GroupAlimento[0];
        }
    };

    private GroupAlimento(Parcel in)
    {

    }

    public GroupAlimento()
    {

    }



}
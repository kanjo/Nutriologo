package com.kanjo.health.e_diet.app.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JARP on 5/14/14.
 */
public class GroupAlimento extends BaseGroupFood implements Parcelable
{
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mQuantity);
        parcel.writeString(mDescription);
        parcel.writeString(mAlimentoType==null?"":mAlimentoType.name());
        parcel.writeList(mListGroupAliment);



    }

    public static final Parcelable.Creator<GroupAlimento> CREATOR =  new Parcelable.Creator<GroupAlimento>() {

        @Override
        public GroupAlimento createFromParcel(Parcel parcel) {
            return new GroupAlimento(parcel);
        }

        @Override
        public GroupAlimento[] newArray(int i) {
            return new GroupAlimento[0];
        }
    };

    private GroupAlimento(Parcel in)
    {
        mQuantity = in.readInt();
        mDescription = in.readString();
        mAlimentoType = AlimentoType.valueOf( in.readString() );
        mListGroupAliment = ( mAlimentoType == AlimentoType.PLATILLO ) ?
                            in.readArrayList(GroupPlatillo.class.getClassLoader()):
                            in.readArrayList(GroupAlimentoPorcion.class.getClassLoader());
    }

    public GroupAlimento()
    {

    }



}
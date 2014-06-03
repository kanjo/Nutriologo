package com.kanjo.health.e_diet.app.domain.orm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * Created by JARP on 5/31/14.
 */
public class UserData implements Parcelable {

    public int KEY_ID;
    public int userid;
    public String name ;
    public String mail ;
    public Date creationDate ;


    /**
     Constructor WITH _id, this creates a new object for use when pulling
     * already existing objects' information from the ContentProvider
     *
     * @param KEY_ID
     * @param userid
     * @param name
     * @param mail
     * @param creationDate
     */
    public UserData(int KEY_ID, int userid, String name, String mail, Date creationDate) {
        this.KEY_ID = KEY_ID;
        this.userid = userid;
        this.name = name;
        this.mail = mail;
        this.creationDate = creationDate;
    }


    /**
     * Constructor WITHOUT _id, this creates a new object for insertion into the
     * ContentProvider
     *
     * @param userid
     * @param name
     * @param mail
     * @param creationDate
     */
    public UserData(int userid, String name, String mail, Date creationDate) {
        this.userid = userid;
        this.name = name;
        this.mail = mail;
        this.creationDate = creationDate;
    }


    /**
     * Used for writing a copy of this object to a Parcel, do not manually call.
     */
    public static final Parcelable.Creator<UserData> CREATOR = new Parcelable.Creator<UserData>() {
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(KEY_ID);
        parcel.writeInt(userid);
        parcel.writeString(name);
        parcel.writeString(mail);
        parcel.writeLong(creationDate.getTime());

    }


    private UserData(Parcel in ) {
        this.KEY_ID = in.readInt();
        this.userid = in.readInt();
        this.name = in.readString();
        this.mail = in.readString();
        this.creationDate = new Date(in.readLong());
    }


}

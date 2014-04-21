package com.kanjo.health.e_diet.app.domain;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.util.ArrayMap;

import com.kanjo.health.e_diet.app.R;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JARP on 4/22/24.
 */
public  class HorariosFactory {


    public class Horario implements Serializable
    {
        public String DESCRIPTION;
        public Uri mImageFile ;
        public int DRAWABLE;
        public List<GroupAlimentosFactory.GroupAlimento> ListGroupAlimentos;
    }

    public class DESAYUNO extends Horario implements Serializable {

        public DESAYUNO()
        {
            this.DESCRIPTION = "Desayuno";
            this.mImageFile = getUriFromFile(R.drawable.ic_eggs_basket);
            this.DRAWABLE =R.drawable.ic_eggs_basket2;
        }

        @Override
        public String toString()
        {
            return "Este es el" +  this.DESCRIPTION ;
        }
    }

    public class COLACION extends Horario implements Serializable {
        public COLACION()
        {
            this.DESCRIPTION = "Colación";
            this.mImageFile= getUriFromFile(R.drawable.ic_bunch_ingredients2);
            this.DRAWABLE = R.drawable.ic_bunch_ingredients2;
        }

        @Override
        public String toString()
        {
            return "Este es el" +  this.DESCRIPTION ;
        }

    }

    public class COMIDA extends Horario implements Serializable {

        public COMIDA()
        {
            this.DESCRIPTION = "Comida";
            this.mImageFile = getUriFromFile(R.drawable.ic_vegetarian_food2);
            this.DRAWABLE =R.drawable.ic_vegetarian_food2;
        }

        @Override
        public String toString()
        {
            return "Este es el" +  this.DESCRIPTION ;
        }


    }

    public class CENA extends Horario implements Serializable{

        public CENA()
        {
            this.DESCRIPTION = "Cena";
            this.mImageFile= getUriFromFile(R.drawable.ic_wheat2);
            this.DRAWABLE = R.drawable.ic_wheat2;
        }

        @Override
        public String toString()
        {
            return "Este es el" +  this.DESCRIPTION ;
        }

    }

    private static File getDrawableFile(int type)
    {
        return new File("android.resource://com.kanjo.health.e_diet/"+type);
    }

    private static Uri getUriFromFile(int type)
    {
        return Uri.fromFile(getDrawableFile(type));
    }

    private static Drawable getDrawable(int type)
    {
        return Resources.getSystem().getDrawable(type);
    }

}

package com.kanjo.health.e_diet.app.UI;

/**
 * Created by JARP on 4/19/14.
 */
public class ExpandablePlatilloItem extends ExpandableBaseItem {

    private String mReceta;

    public ExpandablePlatilloItem(String title, int imageResource, int collapsedHeight, String receta) {
        super(title, imageResource, collapsedHeight);
        mReceta = receta;
    }

    public String getReceta() {
        return mReceta;
    }

    public void setReceta(String receta) {mReceta = receta;}

}

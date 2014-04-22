package com.kanjo.health.e_diet.app.UI;

/**
 * Created by JARP on 4/18/14.
 */
public class ExpandableAlimentoItem extends ExpandableBaseItem{

    private String mQuantity;

    private String mTipoMedida;

    public ExpandableAlimentoItem(String title, String quantity, String tipoMedida,
                                  int imageResource, int collapsedHeight)
    {
        super(title,imageResource,collapsedHeight);
        setExpanded(false);
        mQuantity=quantity;
        mTipoMedida = tipoMedida;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String quantity) {
        mQuantity = quantity;
    }

    public String getTipoMedida() {
        return mTipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        mTipoMedida= tipoMedida;
    }


}

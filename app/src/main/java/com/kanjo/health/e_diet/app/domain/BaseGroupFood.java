package com.kanjo.health.e_diet.app.domain;

import java.util.List;

/**
 * Created by JARP on 5/27/14.
 */
public abstract class BaseGroupFood<E> {

    public List<E> mListGroupAliment;
    public int mQuantity;
    public String mDescription;
    public AlimentoType mAlimentoType;

}

package com.kanjo.health.e_diet.app.profile;

import android.support.v4.util.ArrayMap;

import com.kanjo.health.e_diet.app.domain.GroupAlimentosFactory;
import com.kanjo.health.e_diet.app.domain.HorariosFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by JARP on 4/13/14.
 *
 * Sets the quantity and the relation of nutritional facts
 */
public class DietProfileManager {


    public  HorariosFactory.DESAYUNO desayuno;
    HorariosFactory.COLACION medioDia;
    HorariosFactory.COMIDA comida;
    HorariosFactory.COLACION mediaTarde;
    HorariosFactory.CENA cena;

    public Map<String,HorariosFactory.Horario> mHorariosMap;

    GroupAlimentosFactory factoryGrupoAlimentos = new GroupAlimentosFactory();

    HorariosFactory horariosFactory;

    public void createDiet()
    {
        mHorariosMap = new ArrayMap<String, HorariosFactory.Horario>();

        horariosFactory = new HorariosFactory();
        createDesayuno();

    }

    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createDesayuno()
    {
        desayuno = horariosFactory.new DESAYUNO();

        desayuno.ListGroupAlimentos = new ArrayList<GroupAlimentosFactory.GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.quantity =1;
        desayuno.ListGroupAlimentos.add(mVerduras);

        /*Frutas*/
        GroupAlimentosFactory.FRUTAS mFrutas= factoryGrupoAlimentos. new FRUTAS();
        mFrutas.quantity=1;
        desayuno.ListGroupAlimentos.add(mFrutas);

        /*Cereales*/
        GroupAlimentosFactory.CerealesConGrasa mCereales= factoryGrupoAlimentos. new CerealesConGrasa();
        mCereales.quantity=1;
        desayuno.ListGroupAlimentos.add(mCereales);

        /*POA bajo aporte en grasa*/
        GroupAlimentosFactory.POABajoAporteGrasa mPOA = factoryGrupoAlimentos. new POABajoAporteGrasa();
        mPOA.quantity = 2;
        desayuno.ListGroupAlimentos.add(mPOA);


        /*Aceites con Proteina*/
        GroupAlimentosFactory.AceitesConProteina mAceitesConProteina = factoryGrupoAlimentos. new AceitesConProteina();
        mAceitesConProteina.quantity = 1;
        desayuno.ListGroupAlimentos.add(mAceitesConProteina);

        /*Aceites sin Proteina*/
        GroupAlimentosFactory.AceitesSinProteina mAceitesSinProteina = factoryGrupoAlimentos.new AceitesSinProteina();
        mAceitesSinProteina.quantity = 1;
        desayuno.ListGroupAlimentos.add(mAceitesSinProteina);

        /*
            Agregamos al map el desyuno
         */
        mHorariosMap.put(desayuno.DESCRIPTION,desayuno);

    }





}



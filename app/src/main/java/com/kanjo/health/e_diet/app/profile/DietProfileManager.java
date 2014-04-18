package com.kanjo.health.e_diet.app.profile;

import android.support.v4.util.ArrayMap;

import com.kanjo.health.e_diet.app.domain.GroupAlimentosFactory;
import com.kanjo.health.e_diet.app.domain.HorariosFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by JARP on 4/13/14.
 *
 * Sets the quantity and the relation of nutritional facts
 */
public class DietProfileManager {


    HorariosFactory.DESAYUNO desayuno;
    HorariosFactory.COLACION medioDia;
    HorariosFactory.COMIDA comida;
    HorariosFactory.COLACION mediaTarde;
    HorariosFactory.CENA cena;

    public Map<String,HorariosFactory.Horario> mHorariosMap;

    public List<HorariosFactory.Horario> mHorarioList;

    GroupAlimentosFactory factoryGrupoAlimentos = new GroupAlimentosFactory();

    HorariosFactory horariosFactory;

    public void createDietHorarios()
    {
        mHorariosMap = new ArrayMap<String, HorariosFactory.Horario>();

        horariosFactory = new HorariosFactory();

        mHorarioList = new ArrayList<HorariosFactory.Horario>();

        createDesayuno();

        createColacionMedioDia();

        createComida();

        createColacionMediaTarde();

        createCena();

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
        mHorarioList.add(desayuno);

    }


    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createColacionMedioDia()
    {

        medioDia = horariosFactory. new COLACION();

        medioDia.ListGroupAlimentos = new ArrayList<GroupAlimentosFactory.GroupAlimento>();

        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.quantity =1;
        medioDia.ListGroupAlimentos.add(mVerduras);

        /*
            Agregamos al map el desyuno
         */
        mHorariosMap.put(medioDia.DESCRIPTION,medioDia);
        mHorarioList.add(medioDia);

    }

    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createComida()
    {

        comida = horariosFactory. new COMIDA();

        comida.ListGroupAlimentos = new ArrayList<GroupAlimentosFactory.GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.quantity =2;
        comida.ListGroupAlimentos.add(mVerduras);

        /*TODO: Revisar Entradas*/
        /*GroupAlimentosFactory.Entradas mEntradas= factoryGrupoAlimentos. new Entradas();
        mVerduras.quantity =2;
        comida.ListGroupAlimentos.add(mVerduras);*/

        /*POA Muy Bajo Aporte de grasa*/
        GroupAlimentosFactory.POAMuyBajoAporteDeGrasa mPOA = factoryGrupoAlimentos.new POAMuyBajoAporteDeGrasa();
        mPOA.quantity=2;
        comida.ListGroupAlimentos.add(mPOA);

        /*AceitesSinProteina*/
        GroupAlimentosFactory.AceitesSinProteina mAceitesSinProteina = factoryGrupoAlimentos. new AceitesSinProteina();
        mAceitesSinProteina.quantity = 1;
        comida.ListGroupAlimentos.add(mAceitesSinProteina);

        /*
            Agregamos al map comida
         */
        mHorariosMap.put(comida.DESCRIPTION,comida);
        mHorarioList.add(comida);

    }

    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createColacionMediaTarde() {

        mediaTarde = horariosFactory. new COLACION();

        mediaTarde.ListGroupAlimentos = new ArrayList<GroupAlimentosFactory.GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.quantity =1;
        mediaTarde.ListGroupAlimentos.add(mVerduras);

        /*
            Agregamos al map colación media tarde
         */
        mHorariosMap.put(mediaTarde.DESCRIPTION,mediaTarde);
        mHorarioList.add(mediaTarde);

    }


    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createCena() {

        cena = horariosFactory.new CENA();
        cena.ListGroupAlimentos = new ArrayList<GroupAlimentosFactory.GroupAlimento>();

        /*Leche*/
        GroupAlimentosFactory.Leche mLeche = factoryGrupoAlimentos. new Leche();
        mLeche.quantity = 1;
        cena.ListGroupAlimentos.add(mLeche);

        /*AceitesConProteina*/
        GroupAlimentosFactory.AceitesConProteina mAceitesConProteina = factoryGrupoAlimentos. new AceitesConProteina();
        mAceitesConProteina.quantity = 1;
        cena.ListGroupAlimentos.add(mAceitesConProteina);

        /*
            Agregamos al map la cena
         */
        mHorariosMap.put(cena.DESCRIPTION,cena);
        mHorarioList.add(cena);

    }


}



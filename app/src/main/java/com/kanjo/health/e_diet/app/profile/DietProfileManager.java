package com.kanjo.health.e_diet.app.profile;

import android.support.v4.util.ArrayMap;

import com.kanjo.health.e_diet.app.core.IDietaBuilder;
import com.kanjo.health.e_diet.app.domain.GroupAlimento;
import com.kanjo.health.e_diet.app.domain.GroupAlimentosFactory;
import com.kanjo.health.e_diet.app.domain.Horario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/**
 * Created by JARP on 4/13/14.
 *
 * Sets the mQuantity and the relation of nutritional facts
 */
public class DietProfileManager implements IDietaBuilder {

    public DietProfileManager()
    {
        createDietHorarios();
    }


    Horario desayuno;
    Horario medioDia;
    Horario comida;
    Horario mediaTarde;
    Horario cena;

    private Map<String,Horario> mHorariosMap;

    private List<Horario> mHorarioList;

    GroupAlimentosFactory factoryGrupoAlimentos = new GroupAlimentosFactory();


    private void createDietHorarios()
    {
        mHorariosMap = new ArrayMap<String, Horario>();

        mHorarioList = new ArrayList<Horario>();

        createDesayuno();

        createColacionMedioDia();

        createComida();

        createColacionMediaTarde();

        createCena();

    }



    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createDesayuno()
    {
        desayuno = new Horario();

        desayuno.DateTimeHorario = new java.util.Date();

        GregorianCalendar c = new GregorianCalendar(2000,02,02,8,00,00);
        desayuno.DateTimeHorario = c.getGregorianChange();

        desayuno.ListGroupAlimentos = new ArrayList<GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.mQuantity =1;
        desayuno.ListGroupAlimentos.add(mVerduras);

        /*Frutas*/
        GroupAlimentosFactory.FRUTAS mFrutas= factoryGrupoAlimentos. new FRUTAS();
        mFrutas.mQuantity=1;
        desayuno.ListGroupAlimentos.add(mFrutas);

        /*Cereales*/
        GroupAlimentosFactory.CerealesConGrasa mCereales= factoryGrupoAlimentos. new CerealesConGrasa();
        mCereales.mQuantity=1;
        desayuno.ListGroupAlimentos.add(mCereales);

        /*POA bajo aporte en grasa*/
        GroupAlimentosFactory.POABajoAporteGrasa mPOA = factoryGrupoAlimentos. new POABajoAporteGrasa();
        mPOA.mQuantity = 2;
        desayuno.ListGroupAlimentos.add(mPOA);


        /*Aceites con Proteina*/
        GroupAlimentosFactory.AceitesConProteina mAceitesConProteina = factoryGrupoAlimentos. new AceitesConProteina();
        mAceitesConProteina.mQuantity = 1;
        desayuno.ListGroupAlimentos.add(mAceitesConProteina);

        /*Aceites sin Proteina*/
        GroupAlimentosFactory.AceitesSinProteina mAceitesSinProteina = factoryGrupoAlimentos.new AceitesSinProteina();
        mAceitesSinProteina.mQuantity = 1;
        desayuno.ListGroupAlimentos.add(mAceitesSinProteina);

        /*
            Agregamos al map el desyuno
         */

        desayuno.DESCRIPTION="Desayuno";
        mHorariosMap.put(desayuno.DESCRIPTION,desayuno);
        mHorarioList.add(desayuno);

    }


    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createColacionMedioDia()
    {

        medioDia = new Horario();
        medioDia.DESCRIPTION= "Colación";
        GregorianCalendar c = new GregorianCalendar(2000,02,02,11,00,00);
        medioDia.DateTimeHorario = c.getGregorianChange();

        medioDia.ListGroupAlimentos = new ArrayList<GroupAlimento>();

        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.mQuantity =1;
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

        comida = new Horario();
        comida.DESCRIPTION="Comida";
        GregorianCalendar c = new GregorianCalendar(2000,02,02,14,00,00);
        comida.DateTimeHorario = c.getGregorianChange();

        comida.ListGroupAlimentos = new ArrayList<GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.mQuantity =2;
        comida.ListGroupAlimentos.add(mVerduras);

        /*TODO: Revisar Entradas*/
        /*GroupAlimentosFactory.Entradas mEntradas= factoryGrupoAlimentos. new Entradas();
        mVerduras.mQuantity =2;
        comida.ListGroupAlimentos.add(mVerduras);*/

        /*POA Muy Bajo Aporte de grasa*/
        GroupAlimentosFactory.POAMuyBajoAporteDeGrasa mPOA = factoryGrupoAlimentos.new POAMuyBajoAporteDeGrasa();
        mPOA.mQuantity=2;
        comida.ListGroupAlimentos.add(mPOA);

        /*AceitesSinProteina*/
        GroupAlimentosFactory.AceitesSinProteina mAceitesSinProteina = factoryGrupoAlimentos. new AceitesSinProteina();
        mAceitesSinProteina.mQuantity = 1;
        comida.ListGroupAlimentos.add(mAceitesSinProteina);

        /*
            Agregamos al map comida
         */
        mHorariosMap.put(comida.DESCRIPTION,comida);
        mHorarioList.add(comida);

    }

    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createColacionMediaTarde() {

        mediaTarde = new Horario();
        mediaTarde.DESCRIPTION = "Colación";

        GregorianCalendar c = new GregorianCalendar(2000,02,02,19,00,00);
        mediaTarde.DateTimeHorario = c.getGregorianChange();

        mediaTarde.ListGroupAlimentos = new ArrayList<GroupAlimento>();

        /*Verduras*/
        GroupAlimentosFactory.VERDURAS mVerduras= factoryGrupoAlimentos. new VERDURAS();
        mVerduras.mQuantity =1;
        mediaTarde.ListGroupAlimentos.add(mVerduras);

        /*
            Agregamos al map colación media tarde
         */
        mHorariosMap.put(mediaTarde.DESCRIPTION,mediaTarde);
        mHorarioList.add(mediaTarde);

    }


    //TODO: Definir cuando se agregan verduras, ensaladas etc.. en base a un profile
    private void createCena() {

        cena = new Horario();
        cena.DESCRIPTION="Cena";
        cena.ListGroupAlimentos = new ArrayList<GroupAlimento>();

        /*Leche*/
        GroupAlimentosFactory.Leche mLeche = factoryGrupoAlimentos. new Leche();
        mLeche.mQuantity = 1;
        cena.ListGroupAlimentos.add(mLeche);

        /*AceitesConProteina*/
        GroupAlimentosFactory.AceitesConProteina mAceitesConProteina = factoryGrupoAlimentos. new AceitesConProteina();
        mAceitesConProteina.mQuantity = 1;
        cena.ListGroupAlimentos.add(mAceitesConProteina);

        /*
            Agregamos al map la cena
         */
        mHorariosMap.put(cena.DESCRIPTION,cena);
        mHorarioList.add(cena);

    }



    @Override
    public Horario getHorario(int i) {
        if(mHorarioList==null || mHorarioList.size()==0)
            return null;
        return  mHorarioList.get(i);
    }

    @Override
    public List<Horario> getAllHorarios() {
        if(mHorarioList==null || mHorarioList.size()==0)
            return null;
        return  mHorarioList;
    }

}



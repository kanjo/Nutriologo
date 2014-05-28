package com.kanjo.health.e_diet.app.core;

import com.kanjo.health.e_diet.app.domain.GroupAlimento;
import com.kanjo.health.e_diet.app.domain.Horario;

import java.util.List;

/**
 * Created by JARP on 5/26/14.
 */
public interface IDietaBuilder {


    Horario getHorario(int i );

    List<Horario> getAllHorarios() ;


}

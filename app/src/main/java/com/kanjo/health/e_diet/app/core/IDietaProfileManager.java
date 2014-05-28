package com.kanjo.health.e_diet.app.core;

import com.kanjo.health.e_diet.app.domain.Horario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARP on 5/26/14.
 */
public interface IDietaProfileManager {

    Horario GetHorario(int i);

    int getNumberHorario();

}



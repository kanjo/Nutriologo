package com.kanjo.health.e_diet.app.UI.Fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

import android.widget.ListAdapter;

import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.UI.AdapterGroupAlimentos;
import com.kanjo.health.e_diet.app.domain.HorariosFactory;


/**
 * Created by JARP on 4/15/14.
 */

public class HorarioGroupAlimentosFragment extends Fragment implements AbsListView.OnItemClickListener
{
    private final static String PARAM_HORARIO="Horario" ;

    private String mHorarioSelected ;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;

    //Horario : Desayuno, Comida, Cena , Colación
    HorariosFactory.Horario mHorario;

    public static HorarioGroupAlimentosFragment newInstance(String param1, HorariosFactory.Horario horario) {
        HorarioGroupAlimentosFragment fragment = new HorarioGroupAlimentosFragment();
        Bundle args = new Bundle();
        //args.putString(,param1);
        args.putSerializable(PARAM_HORARIO,horario);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
             //mHorarioSelected= getArguments().getString(PARAM_HORARIO);
             mHorario = (HorariosFactory.Horario)getArguments().getSerializable(PARAM_HORARIO);
        }

        mAdapter = new AdapterGroupAlimentos(getActivity(),R.layout.group_alimento_item,mHorario);

        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_horariogroup_alimentoslist, container, false);


        // Set the adapter
        mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        mListView.setTextFilterEnabled(true);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB)
        {
            if(NavUtils.getParentActivityIntent(getActivity())!=null)
            {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        FragmentManager f = this.getFragmentManager();
        //Create the new fragment with the specify aliment of group
        if(f!=null)
            f.beginTransaction().
                    replace(R.id.container,
                            AlimentosListFragment.newInstance("","",mHorario.ListGroupAlimentos.get(i))).
                    addToBackStack("GrupoAlimento").
                    commit();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home :
                if(NavUtils.getParentActivityIntent(getActivity())!=null)
                    NavUtils.navigateUpFromSameTask(getActivity());
                return  true;
            default:
                return  super.onOptionsItemSelected(item);

        }
    }
}

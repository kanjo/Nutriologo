package com.kanjo.health.e_diet.app.UI.Fragments;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;

import android.widget.ListAdapter;

import com.kanjo.health.e_diet.app.AlimentosListActivity;
import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.UI.AdapterGroupAlimentos;
import com.kanjo.health.e_diet.app.domain.GroupAlimento;
import com.kanjo.health.e_diet.app.domain.Horario;

/**
 * Created by JARP on 4/15/14.
 */

public class HorarioGroupAlimentosFragment extends Fragment implements AbsListView.OnItemClickListener
{
    private final static String PARAM_HORARIO="Horario" ;

    private String mHorarioSelected ;

    public final static String PARAM_GROUP_ALIMENTO = "GROUP_ALIMENTO";

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
    Horario mHorario;

    public static HorarioGroupAlimentosFragment newInstance(String param1, Horario horario) {
        HorarioGroupAlimentosFragment fragment = new HorarioGroupAlimentosFragment();
        Bundle args = new Bundle();
        args.putParcelable(PARAM_HORARIO,horario);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
             mHorario = getArguments().getParcelable(PARAM_HORARIO);
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

        Intent intentAlimentosListActivity = new Intent(getActivity(), AlimentosListActivity.class);

        GroupAlimento a = mHorario.ListGroupAlimentos.get(i);

        intentAlimentosListActivity.putExtra(HorarioGroupAlimentosFragment.PARAM_GROUP_ALIMENTO,a);

        startActivity(intentAlimentosListActivity);

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

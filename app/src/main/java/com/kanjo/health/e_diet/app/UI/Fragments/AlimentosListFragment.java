package com.kanjo.health.e_diet.app.UI.Fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.UI.AdapterAlimentoList;
import com.kanjo.health.e_diet.app.UI.AdapterBaseListAlimentos;
import com.kanjo.health.e_diet.app.UI.AdapterPlatilloList;
import com.kanjo.health.e_diet.app.UI.ExpandableAlimentoItem;
import com.kanjo.health.e_diet.app.UI.ExpandableBaseItem;
import com.kanjo.health.e_diet.app.UI.ExpandablePlatilloItem;
import com.kanjo.health.e_diet.app.UI.ExpandingListViewAlimentos;
import com.kanjo.health.e_diet.app.domain.GroupAlimentosFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AlimentosListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AlimentosListFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class AlimentosListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "GROUP_ALIMENTO";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private final int CELL_DEFAULT_HEIGHT = 200;

    private List<ExpandableBaseItem> mData ;

    private AdapterBaseListAlimentos mAdapter;

    private OnFragmentInteractionListener mListener;

    private GroupAlimentosFactory.GroupAlimento mGroupAlimento;

    private ExpandingListViewAlimentos mListView ;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlimentosListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlimentosListFragment newInstance(String param1, String param2,
                                                    GroupAlimentosFactory.GroupAlimento grupoAlimento) {
        AlimentosListFragment fragment = new AlimentosListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putSerializable(ARG_PARAM3, grupoAlimento);
        fragment.setArguments(args);
        return fragment;
    }
    public AlimentosListFragment() {
        // Required empty public constructor
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mGroupAlimento = (GroupAlimentosFactory.GroupAlimento) getArguments().getSerializable(ARG_PARAM3);

        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListView.setAdapter(mAdapter);
        mListView.setDivider(null);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_alimentos_list, container, false);
        mListView = (ExpandingListViewAlimentos) v.findViewById(R.id.list_view_alimentos);
        setExpandableItems();
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.HONEYCOMB)
        {
            if(NavUtils.getParentActivityIntent(getActivity())!=null)
            {
                getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
        return v;
    }

    private void setExpandableItems ()
    {
        mData = new ArrayList<ExpandableBaseItem>();

        if(mGroupAlimento.alimentoType == GroupAlimentosFactory.AlimentoType.ALIMENTO_PORCION) {
            GroupAlimentosFactory.GroupAlimentoPorcion alimentoList =
                    (GroupAlimentosFactory.GroupAlimentoPorcion) mGroupAlimento;
            for ( GroupAlimentosFactory.AlimentoPorcion item : alimentoList.listAlimentoPorcion)
                mData.add(
                            new ExpandableAlimentoItem(item.descripcion,
                                                       String.valueOf(item.porcion),
                                                       item.tipoMedida,
                                                       R.drawable.test_guacamole_salad,
                                                       CELL_DEFAULT_HEIGHT));
            mAdapter = new AdapterAlimentoList(getActivity(),mData);

        }
        else {
            GroupAlimentosFactory.GroupPlatillo platilloList =
                    (GroupAlimentosFactory.GroupPlatillo) mGroupAlimento;
            for(GroupAlimentosFactory.Platillo item : platilloList.listPlatillo)
                mData.add(
                            new ExpandablePlatilloItem(item.descripcion,
                                                       R.drawable.test_guacamole_salad,
                                                       CELL_DEFAULT_HEIGHT,
                                                       item.receta));

            mAdapter= new AdapterPlatilloList(getActivity(),mData);
        }



    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            //mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
        mGroupAlimento = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //public void onFragmentInteraction(Uri uri);
    }


}

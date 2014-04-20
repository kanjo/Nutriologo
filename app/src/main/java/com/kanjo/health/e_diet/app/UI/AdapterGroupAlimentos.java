package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.domain.HorariosFactory;


/**
 * Created by JARP on 4/9/14.
 */
//TODO: para efectos de DEMO solo se va a presentar el del desayuno
public class AdapterGroupAlimentos extends ArrayAdapter<HorariosFactory.Horario> {

    Context mContext;

    HorariosFactory.Horario mHorario;

    public AdapterGroupAlimentos(Context context, int resource, HorariosFactory.Horario horario) {

        super(context, R.layout.horario_item);
        mContext = context;
        mHorario  = horario;
    }


    @Override
    public int getCount() {
        return mHorario.ListGroupAlimentos.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mHorarioView  = convertView;

        if(mHorarioView==null)
        {

            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            mHorarioView = inflater.inflate(R.layout.group_alimento_item,parent,false);

            ViewHolder mViewHolder = new ViewHolder();

            mViewHolder.mTitle =(TextView) mHorarioView.findViewById(R.id.titleGroupAlimento);

            mViewHolder.mQuantity =(TextView) mHorarioView.findViewById(R.id.titleQuantity);

            mViewHolder.mTitle.setText(mHorario.ListGroupAlimentos.get(position).description);

            mViewHolder.mQuantity.setText(String.valueOf(mHorario.ListGroupAlimentos.get(position).quantity));

            mHorarioView.setTag(mViewHolder);
        }

        ViewHolder holder = (ViewHolder) mHorarioView.getTag();

        holder.mTitle.setText(mHorario.ListGroupAlimentos.get(position).description);

        holder.mQuantity.setText("1");

        return mHorarioView;
    }



    private static class ViewHolder
    {
        public TextView mTitle;
        public TextView mQuantity;

    }

}

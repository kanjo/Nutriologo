package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanjo.health.e_diet.app.R;
import com.kanjo.health.e_diet.app.domain.HorariosFactory;

import java.util.List;


/**
 * Created by JARP on 4/9/14.
 */
public class AdapterHorarios extends ArrayAdapter<HorariosFactory.Horario> {

    Context mContext;

    List<HorariosFactory.Horario>mHorarios;

    public AdapterHorarios(Context context, int resource, List<HorariosFactory.Horario> horarios) {
        super(context, R.layout.horario_item,horarios);

        mHorarios = horarios;

        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mHorarioView  = convertView;

        if(mHorarioView==null)
        {

            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            mHorarioView = inflater.inflate(R.layout.horario_item,parent,false);

            ViewHolder mViewHolder = new ViewHolder();

            mViewHolder.mTitle =(TextView) mHorarioView.findViewById(R.id.titleHorario);

            mViewHolder.mTitle.setText(mHorarios.get(position).DESCRIPTION);

            mViewHolder.mImage = (ImageView) mHorarioView.findViewById(R.id.imgHorario);

            mViewHolder.mImage.setImageResource(mHorarios.get(position).DRAWABLE);

            mHorarioView.setTag(mViewHolder);
        }

        ViewHolder holder = (ViewHolder) mHorarioView.getTag();

        holder.mTitle.setText(mHorarios.get(position).DESCRIPTION);

        holder.mImage.setImageResource(mHorarios.get(position).DRAWABLE);

        return mHorarioView;
    }



    private static class ViewHolder
    {
        public TextView mTitle;
        public ImageView mImage;

    }

}

package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kanjo.health.e_diet.app.R;

import java.util.List;


/**
 * Created by JARP on 4/9/14.
 */
public class AdapterHorarios extends ArrayAdapter<String> {

    Context mContext;

    List<String>mHorarios;

    public AdapterHorarios(Context context, int resource, List<String> horarios) {
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

            mViewHolder.mTitle.setText(mHorarios.get(position));

            //TODO:Falta agregar la imagen

            mHorarioView.setTag(mViewHolder);
        }

        ViewHolder holder = (ViewHolder) mHorarioView.getTag();

        holder.mTitle.setText(mHorarios.get(position));

        return mHorarioView;
    }



    private static class ViewHolder
    {
        public TextView mTitle;
        public ImageView mImageTitle;

    }

}

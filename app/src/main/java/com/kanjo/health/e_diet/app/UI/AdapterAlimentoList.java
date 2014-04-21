package com.kanjo.health.e_diet.app.UI;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.kanjo.health.e_diet.app.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARP on 4/19/14.
 */
public class AdapterAlimentoList extends AdapterBaseListAlimentos {




    public AdapterAlimentoList(Context context,  List<ExpandableBaseItem> items) {
        super(context, R.layout.item_alimento,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ExpandableAlimentoItem item = (ExpandableAlimentoItem)listExpandableBaseItems.get(position);

        if(convertView == null) {
            LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            convertView = inflater.inflate(mLayout, parent, false);
        }

        LinearLayout linearLayout = (LinearLayout)(convertView.findViewById(
                R.id.item_linear_layout));
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams
                (AbsListView.LayoutParams.MATCH_PARENT, item.getCollapsedHeight());
        linearLayout.setLayoutParams(linearLayoutParams);

        //TODO :implement ImageView
        ImageView imgView = (ImageView)convertView.findViewById(R.id.image_view);
        TextView titleView = (TextView)convertView.findViewById(R.id.title_view);
        TextView qtyView = (TextView)convertView.findViewById(R.id.qty_title);

        titleView.setText(item.getTitle());

        qtyView.setText(item.getQuantity());

        convertView.setLayoutParams(new ListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.WRAP_CONTENT));

        ExpandingLayout expandingLayout = (ExpandingLayout)convertView.findViewById(R.id
                .expanding_layout);
        expandingLayout.setExpandedHeight(item.getExpandedHeight());
        expandingLayout.setSizeChangedListener(item);

        if (!item.isExpanded()) {
            expandingLayout.setVisibility(View.GONE);
        } else {
            expandingLayout.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    private static class Holder
    {
        TextView mTitle;
        TextView mQuantity;
        ImageView mImage;


    }

}

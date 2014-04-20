package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.kanjo.health.e_diet.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARP on 4/19/14.
 */
public class AdapterAlimentoList extends AdapterBaseListAlimentos {


    ExpandableAlimentoItem item;

    public AdapterAlimentoList(Context context,  List<ExpandableBaseItem> items) {
        super(context, R.layout.item_alimento,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        item = (ExpandableAlimentoItem)listExpandableBaseItems.get(position);
        return super.getView(position, convertView, parent);
    }
}

package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.kanjo.health.e_diet.app.R;

import java.util.List;

/**
 * Created by JARP on 4/19/14.
 */
public class AdapterPlatilloList extends AdapterBaseListAlimentos {

    ExpandablePlatilloItem item;

    public AdapterPlatilloList(Context context,  List<ExpandableBaseItem> items) {
        super(context, R.layout.item_platillo,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        item = (ExpandablePlatilloItem)listExpandableBaseItems.get(position);
        return super.getView(position, convertView, parent);
    }
}

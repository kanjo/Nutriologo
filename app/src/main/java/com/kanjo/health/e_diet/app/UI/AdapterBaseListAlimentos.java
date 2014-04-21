package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by JARP on 4/19/14.
 */
public class AdapterBaseListAlimentos extends ArrayAdapter <ExpandableBaseItem>{

    List<ExpandableBaseItem> listExpandableBaseItems;

    int mLayout;

    public AdapterBaseListAlimentos(Context context, int resource, List<ExpandableBaseItem> items) {
        super(context, resource);
        listExpandableBaseItems = items;
        mLayout = resource;
    }


    @Override
    public int getCount() {
        return listExpandableBaseItems.size();
    }
}

package com.kanjo.health.e_diet.app.UI;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JARP on 4/18/14.
 */
public class ExpandingListViewAlimentos extends ListView {

    private boolean mShouldRemoveObserver = false;

    private List<View> mViewsToDraw = new ArrayList<View>();

    private int[] mTranslate;


    public ExpandingListViewAlimentos(Context context) {
        super(context);
        init();
    }

    public ExpandingListViewAlimentos(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ExpandingListViewAlimentos(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init()
    {
        setOnItemClickListener(mItemOnClickListener);
    }


    /*
    * Listen for item clicks and expands or collapses the selected view
    * depending on its current state
    * */
    private OnItemClickListener mItemOnClickListener = new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    };


}

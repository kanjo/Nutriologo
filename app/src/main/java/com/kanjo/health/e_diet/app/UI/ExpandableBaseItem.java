package com.kanjo.health.e_diet.app.UI;

/**
 * Created by JARP on 4/19/14.
 */
public class ExpandableBaseItem implements OnSizeChangedListener {

    private String mTitle ;

    private int mImageResource;

    private int mCollapsedHeight;

    private int mExpandedHeight;

    private boolean mIsExpanded;

    public ExpandableBaseItem(String title, int imageResource, int collapsedHeight)
    {
        mTitle=title;
        mImageResource = imageResource;
        mCollapsedHeight= collapsedHeight;
        mExpandedHeight= -1;
        mIsExpanded=false;

    }


    public int getExpandedHeight() {
        return mExpandedHeight;
    }

    public void setExpandedHeight(int expandedHeight) {
        mExpandedHeight = expandedHeight;
    }

    public boolean isExpanded() {
        return mIsExpanded;
    }

    public void setExpanded(boolean isExpanded) {
        mIsExpanded = isExpanded;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getImgResource() {
        return mImageResource;
    }

    public int getCollapsedHeight() {
        return mCollapsedHeight;
    }

    public void setCollapsedHeight(int collapsedHeight) {
        mCollapsedHeight = collapsedHeight;
    }


    @Override
    public void onSizeChanged(int newHeight) {

    }
}

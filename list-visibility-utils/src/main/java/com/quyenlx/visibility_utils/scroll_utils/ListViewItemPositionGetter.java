package com.quyenlx.visibility_utils.scroll_utils;

import android.view.View;
import android.widget.ListView;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class ListViewItemPositionGetter implements ItemsPositionGetter{

    private final ListView mListView;

    public ListViewItemPositionGetter(ListView listView) {
        mListView = listView;
    }

    @Override
    public View getChildAt(int position) {
        return mListView.getChildAt(position);
    }

    @Override
    public int indexOfChild(View view) {
        return mListView.indexOfChild(view);
    }

    @Override
    public int getChildCount() {
        return mListView.getChildCount();
    }

    @Override
    public int getLastVisiblePosition() {
        return mListView.getLastVisiblePosition();
    }

    @Override
    public int getFirstVisiblePosition() {
        return mListView.getFirstVisiblePosition();
    }
}

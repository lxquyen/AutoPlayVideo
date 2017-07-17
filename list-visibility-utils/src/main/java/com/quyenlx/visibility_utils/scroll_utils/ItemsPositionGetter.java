package com.quyenlx.visibility_utils.scroll_utils;

import android.view.View;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public interface ItemsPositionGetter {
    View getChildAt(int position);

    int indexOfChild(View view);

    int getChildCount();

    int getLastVisiblePosition();

    int getFirstVisiblePosition();
}

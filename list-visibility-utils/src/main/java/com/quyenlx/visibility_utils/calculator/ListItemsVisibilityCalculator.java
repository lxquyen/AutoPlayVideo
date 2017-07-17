package com.quyenlx.visibility_utils.calculator;

import com.quyenlx.visibility_utils.scroll_utils.ItemsPositionGetter;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public interface ListItemsVisibilityCalculator {
    void onScrollStateIdle(ItemsPositionGetter itemsPositionGetter, int firstVisiblePosition, int lastVisiblePosition);
    void onScroll(ItemsPositionGetter itemsPositionGetter, int firstVisibleItem, int visibleItemCount, int scrollState);
}

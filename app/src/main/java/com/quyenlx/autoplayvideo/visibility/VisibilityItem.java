package com.quyenlx.autoplayvideo.visibility;

import android.graphics.Rect;
import android.view.View;

import com.quyenlx.autoplayvideo.R;
import com.quyenlx.visibility_utils.items.ListItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class VisibilityItem implements ListItem {
    private final String mTitle;
    private final Rect mCurrentViewRect = new Rect();

    public VisibilityItem(String mTitle) {
        this.mTitle = mTitle;
    }


    @Override
    public int getVisibilityPercents(View view) {
        int percents = 100;
        view.getLocalVisibleRect(mCurrentViewRect);
        int height = view.getHeight();

        if (viewIsPartiallyHiddenTop()) {
            percents = (height - mCurrentViewRect.top) * 100 / height;
        } else if (viewIsPartiallyHiddenBottom(height)) {
            percents = mCurrentViewRect.bottom * 100 / height;
        }
        return percents;
    }

    @Override
    public void setActive(View newActiveView, int newActiveViewPosition) {
        final View whiteView = newActiveView.findViewById(R.id.white_view);
        // animate alpha to show that active view has changed
        whiteView
                .animate()
                .alpha(1f)
                .setDuration(500)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        // animate alpha back
                        whiteView
                                .animate()
                                .alpha(0f)
                                .setDuration(500)
                                .start();
                    }
                }).start();
    }

    @Override
    public void deactivate(View currentView, int position) {
    }

    private boolean viewIsPartiallyHiddenTop() {
        return mCurrentViewRect.top > 0;
    }

    private boolean viewIsPartiallyHiddenBottom(int height) {
        return mCurrentViewRect.bottom > 0 && mCurrentViewRect.bottom < height;
    }

    public static List<VisibilityItem> getList() {
        List<VisibilityItem> mList = new ArrayList<>(Arrays.asList(
                new VisibilityItem("1"),
                new VisibilityItem("2"),
                new VisibilityItem("3"),
                new VisibilityItem("4"),
                new VisibilityItem("5"),
                new VisibilityItem("6"),
                new VisibilityItem("7"),
                new VisibilityItem("8"),
                new VisibilityItem("9"),
                new VisibilityItem("10")));
        return mList;
    }
}

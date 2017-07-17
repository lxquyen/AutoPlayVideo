package com.quyenlx.autoplayvideo.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quyenlx.autoplayvideo.R;
import com.quyenlx.video.JCVideoPlayer;
import com.quyenlx.visibility_utils.calculator.DefaultSingleItemCalculatorCallback;
import com.quyenlx.visibility_utils.calculator.ListItemsVisibilityCalculator;
import com.quyenlx.visibility_utils.calculator.SingleListViewItemActiveCalculator;
import com.quyenlx.visibility_utils.scroll_utils.ItemsPositionGetter;
import com.quyenlx.visibility_utils.scroll_utils.RecyclerViewItemPositionGetter;

import java.util.List;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class VideoFragment extends Fragment {
    private View rootView;
    RecyclerView recyclerView;
    RecyclerViewVideoAdapter adapterVideoList;
    private LinearLayoutManager manager;
    private List<VideoItem> mList;


    private ListItemsVisibilityCalculator calculator;
    private ItemsPositionGetter mItemsPositionGetter;
    private int mScrollState;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_video, container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = rootView.findViewById(R.id.recyclerview);

        mList = VideoItem.getData();

        calculator = new SingleListViewItemActiveCalculator(
                new DefaultSingleItemCalculatorCallback(), mList);

        adapterVideoList = new RecyclerViewVideoAdapter(getContext(), mList);

        manager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterVideoList);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int scrollState) {
                mScrollState = scrollState;
                if (scrollState == RecyclerView.SCROLL_STATE_IDLE && !mList.isEmpty()) {

                    calculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            manager.findFirstVisibleItemPosition(),
                            manager.findLastVisibleItemPosition());
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!mList.isEmpty()) {
                    calculator.onScroll(
                            mItemsPositionGetter,
                            manager.findFirstVisibleItemPosition(),
                            manager.findLastVisibleItemPosition() - manager.findFirstVisibleItemPosition() + 1,
                            mScrollState);
                }
            }
        });
        adapterVideoList.notifyDataSetChanged();
        mItemsPositionGetter = new RecyclerViewItemPositionGetter(manager, recyclerView);

    }

    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mList.isEmpty() && calculator != null) {
            // need to call this method from list view handler in order to have filled list

            recyclerView.post(new Runnable() {
                @Override
                public void run() {

                    calculator.onScrollStateIdle(
                            mItemsPositionGetter,
                            manager.findFirstVisibleItemPosition(),
                            manager.findLastVisibleItemPosition());

                }
            });
        }
    }
}

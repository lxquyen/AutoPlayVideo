package com.quyenlx.autoplayvideo.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.quyenlx.autoplayvideo.R;
import com.quyenlx.video.JCVideoPlayer;
import com.quyenlx.video.JCVideoPlayerStandard;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class RecyclerViewVideoAdapter extends RecyclerView.Adapter<RecyclerViewVideoAdapter.MyViewHolder> {

    private Context context;
    public static final String TAG = "RecyclerViewVideoAdapter";
    private final List<VideoItem> mList;

    public RecyclerViewVideoAdapter(Context context, List<VideoItem> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                context).inflate(R.layout.item_videoview, parent,
                false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = view.getResources().getDisplayMetrics().widthPixels;
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.jcVideoPlayer.setUp(mList.get(position).getVideoUrl(),
                JCVideoPlayer.SCREEN_LAYOUT_LIST, "Hihi");
        Picasso.with(holder.jcVideoPlayer.getContext())
                .load(mList.get(position).getThumbUrl())
                .into(holder.jcVideoPlayer.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        JCVideoPlayerStandard jcVideoPlayer;

        public MyViewHolder(View itemView) {
            super(itemView);
            jcVideoPlayer = itemView.findViewById(R.id.videoplayer);
        }

    }

}

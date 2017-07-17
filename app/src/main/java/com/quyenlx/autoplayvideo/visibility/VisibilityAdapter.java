package com.quyenlx.autoplayvideo.visibility;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quyenlx.autoplayvideo.R;

import java.util.List;

/**
 * Created by QuyenLx on 7/17/2017.
 */

public class VisibilityAdapter extends RecyclerView.Adapter<VisibilityAdapter.ViewHolder> {
    private final List<VisibilityItem> mList;

    public VisibilityAdapter(List<VisibilityItem> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visibility, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = view.getResources().getDisplayMetrics().widthPixels;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView positionView;

        public ViewHolder(View itemView) {
            super(itemView);
            positionView = itemView.findViewById(R.id.position);
        }

        public void bind(int position) {
            int color = itemView.getResources().getColor(android.R.color.holo_blue_dark);
            positionView.setText("Position " + position);
            itemView.setBackgroundColor(color);
        }
    }
}

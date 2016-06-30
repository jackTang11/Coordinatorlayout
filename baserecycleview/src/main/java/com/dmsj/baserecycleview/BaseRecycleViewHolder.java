package com.dmsj.baserecycleview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by jack_tang on 16/6/30.
 */
public class BaseRecycleViewHolder extends RecyclerView.ViewHolder {


    private SparseArray mViews = null;
    private View mItemView = null;

    public BaseRecycleViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray();
        mItemView = itemView;
    }

    public View getContentView(){
        return mItemView;
    }


    public <T extends View> T getView(int viewId) {
       View view = (View) mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }




}

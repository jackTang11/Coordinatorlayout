package com.dmsj.baserecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack_tang on 16/6/30.
 */
public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseRecycleViewHolder> {

    private List mData = new ArrayList();
    private int mLayoutResId;
    private View mContentView;
    private LayoutInflater mLayoutInflater;

    public BaseRecycleAdapter(int layoutResId, List<T> data) {
        this.mData = data == null ? new ArrayList<T>() : data;
        if (layoutResId != 0) {
            this.mLayoutResId = layoutResId;
        }
    }

    public BaseRecycleAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public BaseRecycleAdapter(List<T> data) {
        this(0, data);
    }

    public BaseRecycleAdapter(View contentView, List<T> data) {
        this(0, data);
        mContentView = contentView;
    }


    public void addData(List<T> data) {
        if (data != null)
            mData.addAll(data);
        notifyDataSetChanged();
    }

    public void addData(T data) {
        if (data != null)
            mData.add(data);
        notifyDataSetChanged();
    }


    public void onBounData(List<T> data) {
        mData.clear();
        if (data != null)
            mData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mLayoutInflater = LayoutInflater.from(parent.getContext());
        return onCreateDefViewHolder(parent, viewType);
    }

    protected BaseRecycleViewHolder onCreateDefViewHolder(ViewGroup parent, int viewType) {
        return createBaseViewHolder(parent, mLayoutResId);
    }

    protected BaseRecycleViewHolder createBaseViewHolder(ViewGroup parent, int layoutResId) {
        if (mContentView == null) {
            return new BaseRecycleViewHolder(getItemView(layoutResId, parent));
        }
        return new BaseRecycleViewHolder(mContentView);
    }

    @Override
    public void onBindViewHolder(BaseRecycleViewHolder holder, final int position) {
        getView(holder, position, (T) mData.get(position));
        holder.getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListern(view,position, (T) mData.get(position));
            }
        });
    }


    public void onItemClickListern(View v, int position, T item){};


    protected View getItemView(int layoutResId, ViewGroup parent) {
        return mLayoutInflater.inflate(layoutResId, null);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    protected abstract void getView(BaseRecycleViewHolder helper, int position, T item);



}

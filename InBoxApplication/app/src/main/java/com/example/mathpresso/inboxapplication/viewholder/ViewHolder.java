package com.example.mathpresso.inboxapplication.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mathpresso on 2016-10-14.
 */
public abstract class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
    }
    abstract public void bind(Object item);
}

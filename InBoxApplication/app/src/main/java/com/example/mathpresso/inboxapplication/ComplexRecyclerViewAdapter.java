package com.example.mathpresso.inboxapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mathpresso.inboxapplication.model.CategoryScore;
import com.example.mathpresso.inboxapplication.model.MonthScore;
import com.example.mathpresso.inboxapplication.model.RelativeScore;
import com.example.mathpresso.inboxapplication.model.TotalScore;
import com.example.mathpresso.inboxapplication.viewholder.ViewHolder;

import java.util.List;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class ComplexRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    // The mItems to display in your RecyclerView
    private List<Object> mItems;
    private Context mContext;

    public final static int TOTAL_SCORE = 0, CATEGORY_SCORE = 1 ,MONTH_SCORE = 2,RELATIVE_SCORE = 3;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ComplexRecyclerViewAdapter(List<Object> mItems, Context context) {
        super();
        this.mItems = mItems;
        mContext = context;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof TotalScore) {
            return TOTAL_SCORE;
        } else if (mItems.get(position) instanceof CategoryScore) {
            return CATEGORY_SCORE;
        } else if (mItems.get(position) instanceof MonthScore) {
            return MONTH_SCORE;
        } else if (mItems.get(position) instanceof RelativeScore){
            return RELATIVE_SCORE;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        int resId = InboxViewHolderFactory.getItemLayoutId(viewType);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(resId,viewGroup,false);
        ViewHolder viewHolder = InboxViewHolderFactory.getViewHolder(viewType,view,mContext);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        //More to come
        ((ViewHolder)viewHolder).bind(mItems.get(position));
    }


}
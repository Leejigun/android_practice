package com.example.mathpresso.inboxapplication;

import android.content.Context;
import android.view.View;

import com.example.mathpresso.inboxapplication.viewholder.CategoryScoreViewHolder;
import com.example.mathpresso.inboxapplication.viewholder.DefaultScoreViewHolder;
import com.example.mathpresso.inboxapplication.viewholder.MonthScoreViewHolder;
import com.example.mathpresso.inboxapplication.viewholder.RelativeScoreViewHolder;
import com.example.mathpresso.inboxapplication.viewholder.TotalScoreViewHolder;
import com.example.mathpresso.inboxapplication.viewholder.ViewHolder;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class InboxViewHolderFactory{
    public static int getItemLayoutId(int type){
        int resId;
        switch (type){
            case ComplexRecyclerViewAdapter.TOTAL_SCORE:
                resId = R.layout.item_totalscore;
                break;
            case ComplexRecyclerViewAdapter.CATEGORY_SCORE:
                resId = R.layout.item_categoryscore;
                break;
            case ComplexRecyclerViewAdapter.MONTH_SCORE:
                resId = R.layout.item_monthscore;
                break;
            case ComplexRecyclerViewAdapter.RELATIVE_SCORE:
                resId = R.layout.item_relativescore;
                break;
            default:
                resId = -1;
        }
        return resId;
    }
    public static ViewHolder getViewHolder (int type, View itemView, Context context){
        ViewHolder viewHolder;
        switch (type){
            case ComplexRecyclerViewAdapter.TOTAL_SCORE:
                viewHolder = new TotalScoreViewHolder(itemView, context);
                break;
            case ComplexRecyclerViewAdapter.CATEGORY_SCORE:
                viewHolder = new CategoryScoreViewHolder(itemView,context);
                break;
            case ComplexRecyclerViewAdapter.MONTH_SCORE:
                viewHolder = new MonthScoreViewHolder(itemView,context);
                break;
            case ComplexRecyclerViewAdapter.RELATIVE_SCORE:
                viewHolder = new RelativeScoreViewHolder(itemView);
                break;
            default:
                viewHolder = new DefaultScoreViewHolder(itemView);
        }
        return viewHolder;
    }
}

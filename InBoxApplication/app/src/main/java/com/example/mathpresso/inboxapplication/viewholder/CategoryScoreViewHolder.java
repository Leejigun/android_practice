package com.example.mathpresso.inboxapplication.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.mathpresso.inboxapplication.NewActivity;
import com.example.mathpresso.inboxapplication.R;
import com.example.mathpresso.inboxapplication.model.CategoryScore;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mathpresso on 2016-10-14.
 */
public  class CategoryScoreViewHolder extends ViewHolder{
    @Bind(R.id.btnClick)
    Button btnClick;
    Context context;

    public CategoryScoreViewHolder(View itemView,Context context) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.context = context;
    }

    public void bind(Object item){
        CategoryScore categoryScore = (CategoryScore)item;
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NewActivity.class);
                ((Activity)context).startActivity(intent);
            }
        });

    }
}

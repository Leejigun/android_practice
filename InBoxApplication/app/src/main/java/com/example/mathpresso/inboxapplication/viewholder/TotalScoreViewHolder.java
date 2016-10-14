package com.example.mathpresso.inboxapplication.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.mathpresso.inboxapplication.R;
import com.example.mathpresso.inboxapplication.model.TotalScore;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class TotalScoreViewHolder extends ViewHolder {
    @Bind(R.id.txtvTotalScore)
    TextView txtvTotalScore;

    Context context;
    public TotalScoreViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(Object item){
        TotalScore totalScore = (TotalScore)item;
        txtvTotalScore.setText(String.valueOf((totalScore.getMyScore())));
    }
}

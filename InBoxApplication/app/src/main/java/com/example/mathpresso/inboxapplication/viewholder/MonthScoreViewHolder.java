package com.example.mathpresso.inboxapplication.viewholder;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mathpresso.inboxapplication.PagerFragment;
import com.example.mathpresso.inboxapplication.R;
import com.example.mathpresso.inboxapplication.model.MonthScore;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mathpresso on 2016-10-14.
 */
public  class MonthScoreViewHolder extends ViewHolder {
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.indicator)
    CirclePageIndicator indicator;

    Context context;
    PagerAdapter adapter;

    public MonthScoreViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.context = context;
    }

    public void bind(Object item){
        MonthScore monthScore = (MonthScore)item;
        adapter = new ScreenSlidePagerAdapter(((AppCompatActivity)context).getSupportFragmentManager(),monthScore.getScores());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);


    }
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        ArrayList<Integer> monthScore;
        public ScreenSlidePagerAdapter(FragmentManager fm,ArrayList<Integer> monthScore) {
            super(fm);
            this.monthScore = monthScore;
        }

        @Override
        public Fragment getItem(int position) {

            return PagerFragment.newInstance(monthScore.get(position));
        }

        @Override
        public int getCount() {
            return monthScore.size();
        }
    }

}

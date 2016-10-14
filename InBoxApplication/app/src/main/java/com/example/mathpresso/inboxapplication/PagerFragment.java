package com.example.mathpresso.inboxapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mathpresso on 2016-10-14.
 */
public class PagerFragment extends Fragment{
    @Bind(R.id.txtvScore)
    TextView txtvScore;
    int score;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_frag,container,false);
        ButterKnife.bind(this,view);
        score = getArguments().getInt("score");
        txtvScore.setText(String.valueOf(score));

        return view;
    }
    public static final Fragment newInstance(int score){
        PagerFragment pagerFragment = new PagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("score",score);
        pagerFragment.setArguments(bundle);
        return pagerFragment;
    }
}

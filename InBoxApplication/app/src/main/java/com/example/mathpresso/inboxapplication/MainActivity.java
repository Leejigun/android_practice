package com.example.mathpresso.inboxapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mathpresso.inboxapplication.model.CategoryScore;
import com.example.mathpresso.inboxapplication.model.MonthScore;
import com.example.mathpresso.inboxapplication.model.RelativeScore;
import com.example.mathpresso.inboxapplication.model.TotalScore;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    ComplexRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Object> list = new ArrayList<>();
        list.add(new TotalScore(1000,355));
        list.add(new CategoryScore(377,150,244,244,381,444));
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(300);
        scores.add(400);
        scores.add(500);
        scores.add(420);

        list.add(new MonthScore((scores)));
        list.add(new RelativeScore(60));

        mAdapter = new ComplexRecyclerViewAdapter(list,this);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

package com.ed.will.willlearn.RecyclerviewCardview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ed.will.willlearn.R;

import java.util.ArrayList;

/**
 * Created by will on 18-2-28.
 * RecyclerView 和 CardView的简单使用
 */

public class RcyclerviewAndCardviewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManger;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);


        initData();
        initView();
    }



    private void initData() {
        mLayoutManger=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mAdapter=new MyAdapter(getData());
    }

    private void initView() {
        mRecyclerView=findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }

    public ArrayList<String> getData() {
        ArrayList<String> data=new ArrayList<>();
        String temp=" item";
        for (int i=0;i<20;i++){
            data.add(i+temp);
        }
        return data;
    }



}

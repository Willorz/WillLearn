package com.ed.will.willlearn.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ed.will.willlearn.R;
import com.ed.will.willlearn.RecyclerviewCardview.RcyclerviewAndCardviewActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button recyclervcardvUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    private void initEvent() {
        recyclervcardvUse.setOnClickListener(this);
    }

    private void initView() {
        recyclervcardvUse=findViewById(R.id.btn_rcvcdv);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_rcvcdv:
                startAct(MainActivity.this,RcyclerviewAndCardviewActivity.class);
                Toast.makeText(this,"shengxiao",Toast.LENGTH_LONG).show();
                break;

        }
    }

    public void startAct(Context context,Class cla){
        Intent intent=new Intent(context,cla);
        startActivity(intent);

    }
}
package com.ed.will.willlearn.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ed.will.willlearn.R;
import com.ed.will.willlearn.recyclerviewcardview.RcyclerviewAndCardviewActivity;
import com.ed.will.willlearn.webview.WebViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button recyclervcardvUse,webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    private void initEvent() {
        recyclervcardvUse.setOnClickListener(this);
        webView.setOnClickListener(this);
    }

    private void initView() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        recyclervcardvUse=findViewById(R.id.btn_rcvcdv);
        webView=findViewById(R.id.btn_webview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_rcvcdv:
                startAct(MainActivity.this,RcyclerviewAndCardviewActivity.class);
                Toast.makeText(this,"shengxiao",Toast.LENGTH_LONG).show();
                break;

            case R.id.btn_webview:
                startAct(this, WebViewActivity.class);
                break;

        }
    }

    public void startAct(Context context,Class cla){
        Intent intent=new Intent(context,cla);
        startActivity(intent);

    }
}

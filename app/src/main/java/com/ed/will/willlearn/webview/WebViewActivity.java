package com.ed.will.willlearn.webview;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ed.will.willlearn.R;

/**
 * Created by will on 18-3-1.
 */

public class WebViewActivity extends AppCompatActivity {

    WebView mWebView;
    WebSettings mWebSettings;
    TextView mTitle,beginLoading,loading,endLoading;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        initView();
        initEvent();
    }


    private void initView() {
        mWebView=findViewById(R.id.wbv_webview_content);
        mTitle=findViewById(R.id.txv_webview_title);
        beginLoading=findViewById(R.id.txv_webview_beginLoading);
        loading=findViewById(R.id.txv_webview_loading);
        endLoading=findViewById(R.id.txv_webview_endLoading);

    }

    private void initEvent() {

        //
        mWebSettings=mWebView.getSettings();
        mWebView.loadUrl("http://www.baidu.com/");

        //设置不用系统浏览器打开，直接显示在当前WebView
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWebView.setWebChromeClient(new WebChromeClient(){

            //设置网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("标题在这里");
                mTitle.setText(title);
            }

            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress<100){
                    String progress=newProgress+"%";
                    loading.setText(progress);
                }else if(newProgress==100){
                    String progress=newProgress+"%";
                    loading.setText(progress);
                }
            }
        });

        //设置WebViewClient类
        mWebView.setWebViewClient(new WebViewClient(){
            //设置加载前的函数

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载了");
                beginLoading.setText("开始加载了");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                endLoading.setText("结束加载了");
            }
        });

    }

    //点击返回上一页而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode,event);

    }

    //销毁WebView


    @Override
    protected void onDestroy() {
        if(mWebView!=null){
            mWebView.loadDataWithBaseURL(null,"","text/html","utf-8",null);
            mWebView.clearHistory();

            ((ViewGroup)mWebView.getParent()).removeView(mWebView);
            mWebView.destroy();
            mWebView=null;
        }
        super.onDestroy();
    }
}

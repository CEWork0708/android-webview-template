package com.cework.android_webview_template;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.cework.android_webview_template.define.Constants;
import com.cework.android_webview_template.tool.Factory;
import com.cework.android_webview_template.tool.JavaScriptInterface;
import com.cework.android_webview_template.tool.Model;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = Constants.SERVER_URL;

    private ValueCallback<Uri> mUploadMessage;
    public ValueCallback<Uri[]> uploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 1;
    JavaScriptInterface controlJavaScriptInterface;
    private Factory factory = Factory.getInstance();
    private Model controlModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createObj();
    }


    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient = new WebViewClient() {

    };

    private void createObj() {
        controlModel = factory.createModel(this);
        initWebView();
        initJavaScriptInterface();
        controlModel.setJavaScriptInterface(controlJavaScriptInterface);
    }

    private void initJavaScriptInterface(){
        controlJavaScriptInterface = factory.createJavaScriptInterface(this,webView,controlModel);
        webView.addJavascriptInterface(controlJavaScriptInterface, Constants.ANDROID_PARAMETER_FOR_JAVASCRIPT);
    }

    private void initWebView(){
        webView = findViewById(R.id.webview);
        webView.setWebViewClient(webViewClient);
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.loadUrl(Constants.DEMO_WEB_URL);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description,String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                webView.loadUrl(Constants.NETWORK_ERROR_WEB_URL);
            }

        });



        webSettings.setDisplayZoomControls(false);

//        controlModel.autoLogin();

        //webViewLoadUrl("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjYzZTY0ZjM5ZWJmMjAzMDAxZjZiMjAyMCIsInJvbGVzIjpbNCwzXSwiZXhwaXJlZCI6MzAwMDAwLCJpYXQiOiIyMDIzLTA0LTEyVDEyOjI2OjAzLjM5N1oifQ.HOY-UqcgVqffEwPBBWcG5DycWWI-Ul40B7AoFFuhFOg");
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("ansen", "是否有上一个页面:" + webView.canGoBack());
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
            webView.goBack(); // goBack()表示返回webView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
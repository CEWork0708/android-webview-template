package com.cework.android_webview_template.tool;

import android.app.Activity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.cework.android_webview_template.MainActivity;
import com.cework.android_webview_template.define.Constants;

public class JavaScriptInterface {
    private final String TAG = "JavaScriptInterface";
    private WebView controlWebView;
    private Model controlModel;
    private MainActivity controlActivity;

    public JavaScriptInterface(MainActivity activity ,WebView webView, Model model
    ){
        controlWebView = webView;
        controlModel = model;
        controlActivity = activity;
    }

    @JavascriptInterface
    public void backPage() {
        Log.d(TAG, "  backPage   " );
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.goBack();
            }
        });
    }

    @JavascriptInterface
    public void showRewardedAd() {
        Log.d(TAG, "showRewardedAd");
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlActivity.showRewardedAd();
            }
        });
    }

    @JavascriptInterface
    public void showInterstitialAd() {
        Log.d(TAG, "showInterstitialAd");
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlActivity.showInterstitialAd();
            }
        });
    }


}

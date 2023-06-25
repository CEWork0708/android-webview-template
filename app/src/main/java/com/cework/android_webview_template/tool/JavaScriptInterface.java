package com.cework.android_webview_template.tool;

import android.app.Activity;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.cework.android_webview_template.define.Constants;

public class JavaScriptInterface {
    private final String TAG = "JavaScriptInterface";
    private WebView controlWebView;
    private Model controlModel;
    private Activity controlActivity;

    public JavaScriptInterface(Activity activity ,WebView webView, Model model
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
    public void restartApp() {
        Log.d(TAG, "  restartApp   " );
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.SERVER_URL);
            }
        });
    }

    @JavascriptInterface
    public void loadUrl(final String url) {
        Log.d(TAG, "  loadUrl  url " +url);
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.SERVER_URL + url);
            }
        });
    }

    @JavascriptInterface
    public void showInternelErrorPage() {
        Log.d(TAG, "showInternelErrorPage");
        controlActivity.runOnUiThread(new Runnable() {
            //  @Override
            public void run() {
                controlWebView.loadUrl(Constants.NETWORK_ERROR_WEB_URL);
            }
        });
    }


}

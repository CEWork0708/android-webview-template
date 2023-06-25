package com.cework.android_webview_template.tool;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.icu.text.LocaleDisplayNames;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.cework.android_webview_template.define.Constants;
import com.cework.android_webview_template.tool.Factory;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Chris.Wu on 2016/10/20.
 */
public class Model {
    Factory factory = Factory.getInstance();
    Activity controlActivity;
    Application controlApplication;
    Context controlContext;
    JavaScriptInterface controlJavaScriptInterface;

    public Model() {
        controlActivity = null;
        controlApplication = null;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Activity activity) {
        controlActivity = activity;
        controlContext = null;
        controlApplication = null;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Application application) {
        controlActivity = null;
        controlContext = null;
        controlApplication = application;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Context context) {
        controlActivity = null;
        controlApplication = null;
        controlContext = context;
        controlJavaScriptInterface = null;
        createObj();
    }

    public Model(Activity activity, JavaScriptInterface javaScriptInterface) {
        controlActivity = activity;
        controlContext = null;
        controlApplication = null;
        controlJavaScriptInterface = javaScriptInterface;
        createObj();
    }

    public void setJavaScriptInterface(JavaScriptInterface javaScriptInterface){
        controlJavaScriptInterface = javaScriptInterface;
    }

    private void createObj() {
    }

    public JSONObject getJsonObject(String JSONString) {
        JSONObject jsonObject = null;
        try {
            if (JSONString.indexOf(Constants.OPEN_BRACE) >= 0) {
                JSONString = JSONString.substring(JSONString.indexOf(Constants.OPEN_BRACE), JSONString.lastIndexOf(Constants.CLOSE_BRACE) + 1);
            }
            jsonObject = new JSONObject(JSONString);
        } catch (JSONException e) {
        }
        return jsonObject;
    }

}

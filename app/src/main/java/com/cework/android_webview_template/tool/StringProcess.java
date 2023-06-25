package com.cework.android_webview_template.tool;

import com.cework.android_webview_template.define.Constants;


import org.json.JSONObject;

public class StringProcess {


    // getJavascriptFunctionString
    public static String getJavascriptFunctionString(String arg, String functionName) {
        String result = Constants.JAVASCRIPT + ":" + functionName + "('" + arg + "')";
        return result;
    }

    public static String getJavascriptFunctionSetAccountPasswordUrlString(String account, String password) {
        String arg = account + "','" + password;
        return getJavascriptFunctionString(arg, Constants.SET_ACCOUNT_PASSWORD_JAVASCRIPT);
    }

    public static String getReserveHouseUrl(String reserveHouseId) {
        return Constants.SERVER_URL + "/21/" + reserveHouseId;
    }

    public static String getCookieTokenRow(String token) {
        return "x-token="+token;
    }

}

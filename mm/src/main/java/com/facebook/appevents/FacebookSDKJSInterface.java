package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookSDKJSInterface {
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String PROTOCOL = "fbmq-0.1";
    public static final String TAG = FacebookSDKJSInterface.class.getSimpleName();
    private Context context;

    static {
        AppMethodBeat.i(17423);
        AppMethodBeat.o(17423);
    }

    public FacebookSDKJSInterface(Context context2) {
        this.context = context2;
    }

    private static Bundle jsonToBundle(JSONObject jSONObject) {
        AppMethodBeat.i(17420);
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        AppMethodBeat.o(17420);
        return bundle;
    }

    private static Bundle jsonStringToBundle(String str) {
        AppMethodBeat.i(17421);
        try {
            Bundle jsonToBundle = jsonToBundle(new JSONObject(str));
            AppMethodBeat.o(17421);
            return jsonToBundle;
        } catch (JSONException e2) {
            Bundle bundle = new Bundle();
            AppMethodBeat.o(17421);
            return bundle;
        }
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        AppMethodBeat.i(17422);
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            AppMethodBeat.o(17422);
            return;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.context);
        Bundle jsonStringToBundle = jsonStringToBundle(str3);
        jsonStringToBundle.putString(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
        newLogger.logEvent(str2, jsonStringToBundle);
        AppMethodBeat.o(17422);
    }

    @JavascriptInterface
    public String getProtocol() {
        return PROTOCOL;
    }
}

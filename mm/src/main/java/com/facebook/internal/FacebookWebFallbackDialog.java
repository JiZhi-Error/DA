package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookWebFallbackDialog extends WebDialog {
    private static final int OS_BACK_BUTTON_RESPONSE_TIMEOUT_MILLISECONDS = 1500;
    private static final String TAG = FacebookWebFallbackDialog.class.getName();
    private boolean waitingForDialogToClose;

    static /* synthetic */ void access$001(FacebookWebFallbackDialog facebookWebFallbackDialog) {
        AppMethodBeat.i(7669);
        super.cancel();
        AppMethodBeat.o(7669);
    }

    static {
        AppMethodBeat.i(7670);
        AppMethodBeat.o(7670);
    }

    public static FacebookWebFallbackDialog newInstance(Context context, String str, String str2) {
        AppMethodBeat.i(7665);
        WebDialog.initDefaultTheme(context);
        FacebookWebFallbackDialog facebookWebFallbackDialog = new FacebookWebFallbackDialog(context, str, str2);
        AppMethodBeat.o(7665);
        return facebookWebFallbackDialog;
    }

    private FacebookWebFallbackDialog(Context context, String str, String str2) {
        super(context, str);
        AppMethodBeat.i(7666);
        setExpectedRedirectUrl(str2);
        AppMethodBeat.o(7666);
    }

    /* access modifiers changed from: protected */
    @Override // com.facebook.internal.WebDialog
    public Bundle parseResponseUri(String str) {
        AppMethodBeat.i(7667);
        Bundle parseUrlQueryString = Utility.parseUrlQueryString(Uri.parse(str).getQuery());
        String string = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_BRIDGE_ARGS);
        if (!Utility.isNullOrEmpty(string)) {
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_BRIDGE_ARGS, BundleJSONConverter.convertToBundle(new JSONObject(string)));
            } catch (JSONException e2) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e2);
            }
        }
        String string2 = parseUrlQueryString.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        parseUrlQueryString.remove(ServerProtocol.FALLBACK_DIALOG_PARAM_METHOD_RESULTS);
        if (!Utility.isNullOrEmpty(string2)) {
            if (Utility.isNullOrEmpty(string2)) {
                string2 = "{}";
            }
            try {
                parseUrlQueryString.putBundle(NativeProtocol.EXTRA_PROTOCOL_METHOD_RESULTS, BundleJSONConverter.convertToBundle(new JSONObject(string2)));
            } catch (JSONException e3) {
                Utility.logd(TAG, "Unable to parse bridge_args JSON", e3);
            }
        }
        parseUrlQueryString.remove("version");
        parseUrlQueryString.putInt(NativeProtocol.EXTRA_PROTOCOL_VERSION, NativeProtocol.getLatestKnownVersion());
        AppMethodBeat.o(7667);
        return parseUrlQueryString;
    }

    @Override // com.facebook.internal.WebDialog
    public void cancel() {
        AppMethodBeat.i(7668);
        WebView webView = getWebView();
        if (!isPageFinished() || isListenerCalled() || webView == null || !webView.isShown()) {
            super.cancel();
            AppMethodBeat.o(7668);
        } else if (this.waitingForDialogToClose) {
            AppMethodBeat.o(7668);
        } else {
            this.waitingForDialogToClose = true;
            webView.loadUrl("javascript:".concat(String.valueOf("(function() {  var event = document.createEvent('Event');  event.initEvent('fbPlatformDialogMustClose',true,true);  document.dispatchEvent(event);})();")));
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* class com.facebook.internal.FacebookWebFallbackDialog.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(7664);
                    FacebookWebFallbackDialog.access$001(FacebookWebFallbackDialog.this);
                    AppMethodBeat.o(7664);
                }
            }, 1500);
            AppMethodBeat.o(7668);
        }
    }
}

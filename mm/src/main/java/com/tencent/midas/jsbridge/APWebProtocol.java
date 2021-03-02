package com.tencent.midas.jsbridge;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JsResult;
import android.webkit.WebView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginUtils;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class APWebProtocol {
    public static String URL_KEY_HEAD_CONTROL = "midasheader";
    public static String URL_KEY_HEAD_TITLE = "midastitle";
    public static String WEBACTION_CLOSE = "closeWeb";
    public static String WEBACTION_GETCGIEXTEND = "getCgiExtend";
    public static String WEBACTION_HEAD = "setHead";

    protected static boolean hookH5Method(Activity activity, WebView webView, String str, String str2, JsResult jsResult, IAPWebViewCallback iAPWebViewCallback) {
        AppMethodBeat.i(192817);
        if (TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/?")) {
            AppMethodBeat.o(192817);
            return false;
        }
        iAPWebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        AppMethodBeat.o(192817);
        return true;
    }

    protected static boolean hookH5Method(Activity activity, com.tencent.smtt.sdk.WebView webView, String str, String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult, IAPX5WebViewCallback iAPX5WebViewCallback) {
        AppMethodBeat.i(192818);
        if (TextUtils.isEmpty(str2) || !str2.startsWith("http://unipay.sdk.android/?")) {
            AppMethodBeat.o(192818);
            return false;
        }
        iAPX5WebViewCallback.WebChromeClientJsAlert(webView, str, str2, jsResult);
        AppMethodBeat.o(192818);
        return true;
    }

    protected static void AnalyzeWebEntry(Activity activity, Object obj, IAPWebPage iAPWebPage, String str) {
        AppMethodBeat.i(192819);
        HashMap<String, String> url2Map = APPluginUtils.url2Map(str);
        url2Map.get("page");
        String str2 = url2Map.get(NativeProtocol.WEB_DIALOG_ACTION);
        url2Map.get("saveNumber");
        url2Map.get("saveType");
        String str3 = url2Map.get("callback");
        if (WEBACTION_GETCGIEXTEND.equals(str2)) {
            String reserv = APPluginDataInterface.singleton().getReserv();
            APLog.d("APWebResultPage", "sendCgiExtends() callback=" + str3 + ", extendStr=" + reserv);
            if (!TextUtils.isEmpty(reserv)) {
                try {
                    reserv = URLEncoder.encode(reserv, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (Exception e2) {
                }
            }
            H5CallBack(obj, str3, reserv);
            AppMethodBeat.o(192819);
        } else if (WEBACTION_CLOSE.equals(str2)) {
            APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), APPluginReportManager.MIDASPLUGIN_WEBPAGE_WEBCLOSE, "", "");
            APMidasResponse aPMidasResponse = new APMidasResponse();
            aPMidasResponse.resultCode = 100;
            aPMidasResponse.resultMsg = "关闭";
            APMidasPayHelper.midasCallBack(aPMidasResponse);
            if (activity != null) {
                activity.finish();
            }
            AppMethodBeat.o(192819);
        } else {
            if (WEBACTION_HEAD.equals(str2)) {
                try {
                    iAPWebPage.initHead(activity, url2Map.get(URL_KEY_HEAD_CONTROL), url2Map.get(URL_KEY_HEAD_TITLE));
                    AppMethodBeat.o(192819);
                    return;
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.o(192819);
        }
    }

    public static void H5CallBack(Object obj, String str, String str2) {
        String format;
        boolean z = false;
        AppMethodBeat.i(192820);
        try {
            Object nextValue = new JSONTokener(str2).nextValue();
            if (nextValue != null) {
                if (nextValue instanceof JSONObject) {
                    z = true;
                } else if (nextValue instanceof JSONArray) {
                    z = true;
                }
            }
        } catch (Exception | JSONException e2) {
        }
        if (z) {
            try {
                format = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](%s);", str, str, str2);
            } catch (Exception e3) {
                APLog.d("H5CallBack", "H5CallBack() ex = " + e3.toString());
                AppMethodBeat.o(192820);
                return;
            }
        } else {
            format = String.format("typeof window[\"%s\"]==='function' && window[\"%s\"](\"%s\");", str, str, str2);
        }
        APLog.i("callback", str);
        APLog.i("cb", format);
        if (obj instanceof WebView) {
            ((WebView) obj).loadUrl("javascript:".concat(String.valueOf(format)));
            AppMethodBeat.o(192820);
            return;
        }
        if (obj instanceof com.tencent.smtt.sdk.WebView) {
            ((com.tencent.smtt.sdk.WebView) obj).loadUrl("javascript:".concat(String.valueOf(format)));
        }
        AppMethodBeat.o(192820);
    }
}

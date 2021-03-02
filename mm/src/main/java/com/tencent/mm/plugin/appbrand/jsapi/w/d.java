package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(107801);
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("value");
        Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", optString, optString2);
        if (Util.isNullOrNil(optString) || Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(107801);
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > 1024) {
            Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(107801);
        } else {
            String appId = fVar.getAppId();
            if (TextUtils.isEmpty(appId)) {
                Log.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                fVar.i(i2, h("fail", null));
                AppMethodBeat.o(107801);
                return;
            }
            Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", appId);
            int i3 = 0;
            if (NetStatusUtil.isConnected(fVar.getContext())) {
                if (NetStatusUtil.isWifi(fVar.getContext())) {
                    i3 = 1;
                } else if (NetStatusUtil.is5G(fVar.getContext())) {
                    i3 = 5;
                } else if (NetStatusUtil.is4G(fVar.getContext())) {
                    i3 = 4;
                } else if (NetStatusUtil.is3G(fVar.getContext())) {
                    i3 = 3;
                } else if (NetStatusUtil.is2G(fVar.getContext())) {
                    i3 = 2;
                }
                Log.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", Integer.valueOf(i3));
            }
            long nowSecond = Util.nowSecond();
            Log.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", Long.valueOf(nowSecond), 13579, appId, Integer.valueOf(i3), "", "", "", optString, optString2);
            String str = "";
            String str2 = "";
            String str3 = "";
            String str4 = "";
            try {
                str = URLEncoder.encode(Util.nullAsNil(""), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                str2 = URLEncoder.encode("", MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                str3 = URLEncoder.encode(optString, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                str4 = URLEncoder.encode(optString2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiReportAction", e2, "", new Object[0]);
            }
            h.INSTANCE.a(13579, appId, Integer.valueOf(i3), str, str2, "", str3, str4, Long.valueOf(nowSecond), Long.valueOf(nowSecond));
            fVar.i(i2, h("ok", null));
            AppMethodBeat.o(107801);
        }
    }
}

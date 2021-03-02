package com.tencent.mm.plugin.lite.jsapi.a;

import android.content.Intent;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, JSONObject jSONObject) {
        int i2;
        AppMethodBeat.i(198845);
        if (!jSONObject.has("url")) {
            this.yEn.aCS("url is required");
            AppMethodBeat.o(198845);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = null;
        boolean z = true;
        Intent intent = new Intent();
        try {
            String string = jSONObject.getString("url");
            if (!string.startsWith("http")) {
                sb.append(HttpWrapperBase.PROTOCAL_HTTP);
            }
            sb.append(string);
            if (jSONObject.has("customizeStatusBarColor")) {
                i2 = jSONObject.getInt("customizeStatusBarColor");
            } else {
                i2 = 0;
            }
            if (jSONObject.has("statusBarStyle")) {
                str2 = jSONObject.getString("statusBarStyle");
            }
            if (jSONObject.has("appendDeviceInfo")) {
                z = jSONObject.getBoolean("appendDeviceInfo");
            }
            intent.putExtra("nextAnimIn", aU(jSONObject));
            intent.putExtra("currentAnimOut", aV(jSONObject));
            if (z) {
                if (sb.toString().contains("?")) {
                    sb.append("&");
                } else {
                    sb.append("?");
                }
                try {
                    sb.append("deviceName=").append(q.encode(d.DEVICE_NAME, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e2) {
                }
                sb.append("&imei=");
                try {
                    sb.append("&deviceBrand=").append(q.encode(Build.BRAND, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e3) {
                }
                try {
                    sb.append("&deviceModel=").append(q.encode(Build.MODEL, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e4) {
                }
                sb.append("&from=").append("liteApp#".concat(String.valueOf(str)));
                StringBuilder append = sb.append("&uin=");
                g.aAf();
                append.append(a.ayV());
                sb.append("&version=").append(d.KyO);
                try {
                    sb.append("&lang=").append(q.encode(LocaleUtil.getApplicationLanguage(), MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e5) {
                }
                try {
                    sb.append("&ostype=").append(q.encode(d.KyK, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (Exception e6) {
                }
                sb.append("&timeZone=").append(Util.getTimeZoneOffset());
            }
            intent.putExtra("rawUrl", sb.toString());
            intent.putExtra("convertActivityFromTranslucent", false);
            intent.putExtra("customize_status_bar_color", i2);
            intent.putExtra("status_bar_style", str2);
            intent.putExtra("prePublishId", "liteApp#1#1");
            intent.putExtra("KPublisherId", "liteApp#1#1");
            intent.addFlags(268435456);
            c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(198845);
        } catch (JSONException e7) {
            Log.printErrStackTrace("LiteAppJsApiStartWebview", e7, "parse json", new Object[0]);
            this.yEn.aCS("exception");
            AppMethodBeat.o(198845);
        }
    }
}

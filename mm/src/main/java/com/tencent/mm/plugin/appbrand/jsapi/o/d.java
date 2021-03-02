package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 615;
    public static final String NAME = "checkNetworkAPIURL";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        boolean b2;
        int i3;
        AppMethodBeat.i(144185);
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data nil", null));
            Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "data is null");
            AppMethodBeat.o(144185);
            return;
        }
        HashMap hashMap = new HashMap();
        String optString = jSONObject.optString(ProviderConstants.API_PATH, "");
        String optString2 = jSONObject.optString("url", "");
        if (Util.isNullOrNil(optString) || Util.isNullOrNil(optString2)) {
            Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "invalid api:%s,url:%s", optString, optString2);
            hashMap.put("isValid", Boolean.FALSE);
            fVar.i(i2, n("fail:api or url invalid", hashMap));
            AppMethodBeat.o(144185);
            return;
        }
        a aVar = (a) fVar.av(a.class);
        if (optString.equalsIgnoreCase(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            b2 = j.b(aVar.cyT, optString2, false);
        } else if (optString.equalsIgnoreCase("websocket")) {
            b2 = j.b(aVar.cyU, optString2, aVar.cyP);
        } else if (optString.equalsIgnoreCase("downloadFile")) {
            b2 = j.b(aVar.cyW, optString2, false);
        } else if (optString.equalsIgnoreCase("uploadFile")) {
            b2 = j.b(aVar.cyV, optString2, false);
        } else if (optString.equalsIgnoreCase("udp")) {
            b2 = j.b(aVar.cyX, optString2, false);
        } else {
            Log.w("MicroMsg.JsApiCheckNetworkAPIURL", "hy: unknown api: %s", optString);
            hashMap.put("isValid", Boolean.FALSE);
            fVar.i(i2, n("fail:unknow api", hashMap));
            AppMethodBeat.o(144185);
            return;
        }
        String str = j.adc(optString2).get("host");
        if (!Util.isNullOrNil(str)) {
            Log.i("MicroMsg.JsApiCheckNetworkAPIURL", "ipHost:%s", str);
            i3 = j.adf(str);
        } else {
            i3 = 0;
        }
        Log.i("MicroMsg.JsApiCheckNetworkAPIURL", "checkRet:%b,ipCheckRet:%d,api:%s,url:%s", Boolean.valueOf(b2), Integer.valueOf(i3), optString, optString2);
        if (b2) {
            hashMap.put("isInDomainList", Boolean.TRUE);
        } else {
            hashMap.put("isInDomainList", Boolean.FALSE);
        }
        switch (i3) {
            case 0:
                hashMap.put("isInLAN", Boolean.FALSE);
                hashMap.put("isLocalHost", Boolean.FALSE);
                break;
            case 1:
                hashMap.put("isInLAN", Boolean.TRUE);
                hashMap.put("isLocalHost", Boolean.TRUE);
                break;
            case 2:
                hashMap.put("isInLAN", Boolean.TRUE);
                hashMap.put("isLocalHost", Boolean.FALSE);
                break;
        }
        fVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(144185);
    }
}

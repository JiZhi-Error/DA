package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;
import org.json.JSONObject;

public class cl extends d<k> {
    public static final int CTRL_INDEX = 406;
    public static final String NAME = "private_openUrl";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        Intent putExtra;
        String str;
        AppMethodBeat.i(45618);
        k kVar2 = kVar;
        String optString = jSONObject.optString("url");
        if (Util.isNullOrNil(optString)) {
            a(kVar2, i2, "fail");
            AppMethodBeat.o(45618);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("isNativeStyle", false);
        if (optBoolean) {
            putExtra = new Intent().putExtra("rawUrl", optString).putExtra(AppBrandProcessProxyUI.lwe, optString).putExtra("open_custom_style_url", optBoolean).putExtra("forceHideShare", true).putExtra("status_bar_style", "black");
        } else {
            putExtra = new Intent().putExtra("rawUrl", optString).putExtra(AppBrandProcessProxyUI.lwe, optString);
        }
        putExtra.putExtra("ad_info", jSONObject.optString("adInfo"));
        if (kVar2.getRuntime() instanceof q) {
            q qVar = (q) kVar2.getRuntime();
            String optString2 = jSONObject.optString("adUxInfo", null);
            if (TextUtils.isEmpty(optString2)) {
                if (qVar.bsC().ldQ != null) {
                    str = qVar.bsC().ldQ.getString("adUxInfo");
                } else {
                    str = optString2;
                }
                a.x("AppBrandRuntime", "private_openUrl", str, "wechatTransitExtraData");
            } else {
                a.x("AppBrandRuntime", "private_openUrl", optString2, "data");
                str = optString2;
            }
            putExtra.putExtra(e.p.OzI, str);
        }
        a(kVar2.getContext(), putExtra, kVar2, i2);
        AppMethodBeat.o(45618);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, Intent intent, k kVar, int i2) {
        AppMethodBeat.i(226682);
        if (context != null) {
            c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            a(kVar, i2, "ok");
            AppMethodBeat.o(226682);
            return;
        }
        a(kVar, i2, "fail");
        AppMethodBeat.o(226682);
    }

    private void a(k kVar, int i2, String str) {
        AppMethodBeat.i(45617);
        Log.e("MicroMsg.JsApiPrivateOpenUrl", "switchCallback msg:%s", str);
        if (kVar != null) {
            kVar.i(i2, h(str, null));
        }
        AppMethodBeat.o(45617);
    }
}

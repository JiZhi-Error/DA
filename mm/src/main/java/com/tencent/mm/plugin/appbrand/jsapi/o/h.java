package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends d<s> {
    public static final int CTRL_INDEX = 507;
    public static final String NAME = "secureTunnel";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        String str;
        Intent intent;
        Bundle extras;
        AppMethodBeat.i(46650);
        final s sVar2 = sVar;
        Log.i("MicroMsg.JsApiSecureTunnel", "start secureTunnel");
        final AnonymousClass1 r5 = new b.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.o.h.AnonymousClass1 */

            @Override // com.tencent.mm.pluginsdk.wallet.b.a
            public final void onSuccess(String str) {
                AppMethodBeat.i(46647);
                Log.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback success: %s", str);
                HashMap hashMap = new HashMap();
                hashMap.put("respbuf", str);
                sVar2.i(i2, h.this.n("ok", hashMap));
                AppMethodBeat.o(46647);
            }

            @Override // com.tencent.mm.pluginsdk.wallet.b.a
            public final void aas(String str) {
                AppMethodBeat.i(46648);
                Log.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", str);
                sVar2.i(i2, h.this.n("fail", hashMap));
                AppMethodBeat.o(46648);
            }
        };
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView != null) {
            str = currentPageView.lBI;
        } else {
            str = null;
        }
        String appId = sVar2.getAppId();
        int i3 = 1000;
        String str2 = "";
        int i4 = 0;
        Activity ay = sVar2.ay(Activity.class);
        if (!(ay == null || (intent = ay.getIntent()) == null || (extras = intent.getExtras()) == null)) {
            Object obj = extras.get("key_appbrand_stat_object");
            if (obj instanceof AppBrandStatObject) {
                i3 = ((AppBrandStatObject) obj).scene;
            }
            Object obj2 = extras.get("key_appbrand_init_config");
            if (obj2 instanceof AppBrandInitConfigWC) {
                AppBrandInitConfigWC appBrandInitConfigWC = (AppBrandInitConfigWC) obj2;
                str2 = appBrandInitConfigWC.username;
                i4 = appBrandInitConfigWC.appVersion;
            }
        }
        try {
            String string = jSONObject.getString("type");
            if (Util.isNullOrNil(string)) {
                Log.e("MicroMsg.JsApiSecureTunnel", "securetunnel type nil");
                sVar2.i(i2, h("fail", null));
                AppMethodBeat.o(46650);
                return;
            }
            String string2 = jSONObject.getString("reqbuf");
            if (Util.isNullOrNil(string2)) {
                Log.e("MicroMsg.JsApiSecureTunnel", "securetunnel reqbuf nil");
                sVar2.i(i2, h("fail", null));
                AppMethodBeat.o(46650);
                return;
            }
            String string3 = jSONObject.getString("cmd");
            if (Util.isNullOrNil(string3)) {
                Log.e("MicroMsg.JsApiSecureTunnel", "securetunnel cmd nil");
                sVar2.i(i2, h("fail", null));
                AppMethodBeat.o(46650);
            } else if (string.equals("wxpay")) {
                Log.i("MicroMsg.JsApiSecureTunnel", "secureTunnel doscene");
                d.a aVar = new d.a();
                aVar.iLN = new dtf();
                aVar.iLO = new dtg();
                aVar.uri = "/cgi-bin/mmpay-bin/securetunnel";
                aVar.funcId = 2632;
                if (jSONObject.has("timeout")) {
                    aVar.timeout = jSONObject.getInt("timeout");
                }
                com.tencent.mm.ak.d aXF = aVar.aXF();
                dtf dtf = (dtf) aXF.iLK.iLR;
                dtf.MVs = string2;
                dtf.Lmp = string3;
                dtf.url = str;
                dtf.dNI = appId;
                dtf.scene = i3;
                dtf.source = 1;
                dtf.KZR = str2;
                dtf.KXD = i4;
                IPCRunCgi.a(aXF, new IPCRunCgi.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.o.h.AnonymousClass2 */

                    @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                    public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                        AppMethodBeat.i(46649);
                        Log.i("MicroMsg.JsApiSecureTunnel", "onGYNetEnd errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
                        if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                            Log.i("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi success");
                            r5.onSuccess(((dtg) dVar.iLL.iLR).MVt);
                            AppMethodBeat.o(46649);
                            return;
                        }
                        Log.e("MicroMsg.JsApiSecureTunnel", "secureTunnel cgi failed");
                        r5.aas(str);
                        AppMethodBeat.o(46649);
                    }
                });
                AppMethodBeat.o(46650);
            } else {
                Log.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail: invalid type");
                HashMap hashMap = new HashMap();
                hashMap.put("err_desc", "invalid type");
                sVar2.i(i2, n("fail", hashMap));
                AppMethodBeat.o(46650);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiSecureTunnel", "mini app securetunnel parameter error");
            sVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46650);
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class cj extends d<k> {
    public static final int CTRL_INDEX = 829;
    public static final String NAME = "phoneBindCardVerifySms";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226681);
        final k kVar2 = kVar;
        if (AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext) == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiPhoneBindCardVerifySms", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(226681);
            return;
        }
        Log.i("MicroMsg.JsApiPhoneBindCardVerifySms", "get data: %s", jSONObject.toString());
        Bundle bundle = new Bundle();
        bundle.putString("app_id", kVar2.getAppId());
        bundle.putString("nonce_str", jSONObject.optString("noncestr"));
        bundle.putString("timeStamp", jSONObject.optString(AppMeasurement.Param.TIMESTAMP));
        bundle.putString("package", jSONObject.optString("package"));
        bundle.putString("signType", jSONObject.optString("signtype"));
        bundle.putString("paySign", jSONObject.optString("paysign"));
        bundle.putString("sessionid", jSONObject.optString("sessionid"));
        bundle.putString("jsapiName", NAME);
        bundle.putInt("jsapi_type", 1);
        h.a(MainProcessIPCService.dkO, bundle, IPCInvoke_KindaJSInvoke.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.cj.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(226680);
                Bundle bundle2 = bundle;
                String string = bundle2.getString("ret", "fail");
                string.equals("ok");
                kVar2.i(i2, cj.this.h(string, null));
                if (bundle2.getInt("closeWindow", 0) == 1) {
                    kVar2.getRuntime().close();
                }
                AppMethodBeat.o(226680);
            }
        });
        AppMethodBeat.o(226681);
    }
}

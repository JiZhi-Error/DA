package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import com.tencent.kinda.framework.jsapi.IPCInvoke_KindaJSInvoke;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class bo extends d<k> {
    public static final int CTRL_INDEX = 868;
    public static final String NAME = "requestQueryCashier";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226669);
        final k kVar2 = kVar;
        if (AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext) == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiKindaRequestQueryCashier", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(226669);
            return;
        }
        Log.i("MicroMsg.JsApiKindaRequestQueryCashier", "get data: %s", jSONObject.toString());
        Bundle bundle = new Bundle();
        bundle.putString("jsApiScene", "1");
        bundle.putString("notifyType", NAME);
        bundle.putString("appId", kVar2.getAppId());
        bundle.putString("nonceStr", jSONObject.optString("nonceStr"));
        bundle.putString("timeStamp", jSONObject.optString("timeStamp"));
        bundle.putString("package", jSONObject.optString("package"));
        bundle.putString("paySign", jSONObject.optString("paySign"));
        bundle.putString("signType", jSONObject.optString("signType"));
        bundle.putString("jsapiName", NAME);
        bundle.putInt("jsapi_type", 1);
        h.a(MainProcessIPCService.dkO, bundle, IPCInvoke_KindaJSInvoke.class, new d<Bundle>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bo.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(Bundle bundle) {
                AppMethodBeat.i(226668);
                Bundle bundle2 = bundle;
                String string = bundle2.getString("ret", "fail");
                Log.i("MicroMsg.JsApiKindaRequestQueryCashier", "callback ret is：%s", string);
                kVar2.i(i2, bo.this.h(string, null));
                if (bundle2.getInt("closeWindow", 0) == 1) {
                    kVar2.getRuntime().close();
                }
                AppMethodBeat.o(226668);
            }
        });
        AppMethodBeat.o(226669);
    }
}

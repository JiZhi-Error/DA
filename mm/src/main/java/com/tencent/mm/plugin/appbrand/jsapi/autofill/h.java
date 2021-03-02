package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.dqo;
import com.tencent.mm.protocal.protobuf.dqp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class h extends d<ac> {
    public static final int CTRL_INDEX = 205;
    public static final String NAME = "setUserAutoFillData";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147162);
        final ac acVar2 = acVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData data is invalid");
            acVar2.i(i2, h("fail:data is invalid", null));
            AppMethodBeat.o(147162);
            return;
        }
        String optString = jSONObject.optString("dataList");
        String appId = acVar2.getAppId();
        int optInt = jSONObject.optInt("clientVersion", 0);
        Log.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData appId:%s, clientVersion:%s, dataList:%s", appId, Integer.valueOf(optInt), optString);
        dqo dqo = new dqo();
        dqo.dNI = appId;
        dqo.McH = optString;
        dqo.source = 1;
        dqo.KFC = optInt;
        ((c) acVar2.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo", dqo, dqp.class).c(new a<Object, dqp>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.h.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(dqp dqp) {
                AppMethodBeat.i(147161);
                dqp dqp2 = dqp;
                if (dqp2 == null) {
                    Log.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, null response");
                    acVar2.i(i2, h.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147161);
                } else if (dqp2.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData SaveUserAutoFillInfo cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(dqp2.BaseResponse.Ret), dqp2.BaseResponse.ErrMsg);
                    acVar2.i(i2, h.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147161);
                } else {
                    Log.i("MicroMsg.JsApiSetUserAutoFillData", "setUserAutoFillData success");
                    acVar2.i(i2, h.this.h("ok", null));
                    AppMethodBeat.o(147161);
                }
                return null;
            }
        });
        AppMethodBeat.o(147162);
    }
}

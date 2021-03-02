package com.tencent.mm.plugin.appbrand.jsapi.autofill;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.c.a;
import org.json.JSONObject;

public final class b extends d<ac> {
    public static final int CTRL_INDEX = 206;
    public static final String NAME = "deleteUserAutoFillData";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ac acVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147151);
        final ac acVar2 = acVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData data is invalid");
            acVar2.i(i2, h("fail:data is invalid", null));
            AppMethodBeat.o(147151);
            return;
        }
        String optString = jSONObject.optString("groupKey");
        int optInt = jSONObject.optInt("groupId", 0);
        if (TextUtils.isEmpty(optString)) {
            Log.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData groupKey is invalid");
            acVar2.i(i2, h("fail:groupKey is invalid", null));
            AppMethodBeat.o(147151);
            return;
        }
        String appId = acVar2.getAppId();
        int optInt2 = jSONObject.optInt("clientVersion", 0);
        Log.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData appId:%s, clientVersion:%s, groupId:%d, groupKey:%s", appId, Integer.valueOf(optInt2), Integer.valueOf(optInt), optString);
        agv agv = new agv();
        agv.Lqy = optString;
        agv.dNI = appId;
        agv.Lqz = optInt;
        agv.source = 1;
        agv.KFC = optInt2;
        ((c) acVar2.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo", agv, agw.class).c(new a<Object, agw>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.autofill.b.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(agw agw) {
                AppMethodBeat.i(147150);
                agw agw2 = agw;
                if (agw2 == null) {
                    Log.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, null response");
                    acVar2.i(i2, b.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147150);
                } else if (agw2.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(agw2.BaseResponse.Ret), agw2.BaseResponse.ErrMsg);
                    acVar2.i(i2, b.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147150);
                } else {
                    Log.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
                    acVar2.i(i2, b.this.h("ok", null));
                    AppMethodBeat.o(147150);
                }
                return null;
            }
        });
        AppMethodBeat.o(147151);
    }
}

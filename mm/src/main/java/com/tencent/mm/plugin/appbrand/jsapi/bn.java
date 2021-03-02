package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.networking.c;
import com.tencent.mm.protocal.protobuf.fce;
import com.tencent.mm.protocal.protobuf.fcf;
import com.tencent.mm.protocal.protobuf.hj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class bn extends d {
    public static final int CTRL_INDEX = 236;
    public static final String NAME = "getSetting";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(147138);
        fce fce = new fce();
        fce.appId = fVar.getAppId();
        ((c) fVar.M(c.class)).a("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", fce, fcf.class).c(new a<Object, fcf>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bn.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Object call(fcf fcf) {
                AppMethodBeat.i(147137);
                Object a2 = a(fcf);
                AppMethodBeat.o(147137);
                return a2;
            }

            private Object a(fcf fcf) {
                AppMethodBeat.i(147136);
                if (fcf == null) {
                    Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, null response");
                    fVar.i(i2, bn.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147136);
                } else if (fcf.BaseResponse.Ret != 0) {
                    Log.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq cgi failed, errCode = %d, errMsg = %s", Integer.valueOf(fcf.BaseResponse.Ret), fcf.BaseResponse.ErrMsg);
                    fVar.i(i2, bn.this.h("fail:cgi fail", null));
                    AppMethodBeat.o(147136);
                } else {
                    try {
                        LinkedList<hj> linkedList = fcf.Nye;
                        JSONArray jSONArray = new JSONArray();
                        Iterator<hj> it = linkedList.iterator();
                        while (it.hasNext()) {
                            hj next = it.next();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("scope", next.scope);
                                jSONObject.put("state", next.state);
                                jSONObject.put("desc", next.KKT);
                                jSONArray.put(jSONObject);
                            } catch (Exception e2) {
                                Log.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", e2.getMessage());
                            }
                        }
                        String jSONArray2 = jSONArray.toString();
                        Log.d("MicroMsg.JsApiGetSetting", "authInfo %s", jSONArray);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("errMsg", "getSetting:ok");
                            jSONObject2.put("authSetting", new JSONArray(Util.nullAsNil(jSONArray2)));
                            fVar.i(i2, jSONObject2.toString());
                            AppMethodBeat.o(147136);
                        } catch (JSONException e3) {
                            Log.printErrStackTrace("MicroMsg.JsApiGetSetting", e3, "set json error!", new Object[0]);
                            fVar.i(i2, bn.this.h("fail:resp invalid", null));
                            AppMethodBeat.o(147136);
                            return null;
                        }
                    } catch (Exception e4) {
                        fVar.i(i2, bn.this.h("fail:resp invalid", null));
                        AppMethodBeat.o(147136);
                        return null;
                    }
                }
                return null;
            }
        });
        AppMethodBeat.o(147138);
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends d<s> {
    private static final int CTRL_INDEX = 424;
    private static final String NAME = "openRedPacket";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46391);
        s sVar2 = sVar;
        if (jSONObject == null) {
            Log.i("MicroMsg.JsApiOpenRedPacket", "data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", -1);
            sVar2.i(i2, n("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.o(46391);
        } else if (Util.isNullOrNil(jSONObject.optString("redPacketId", null))) {
            Log.i("MicroMsg.JsApiOpenRedPacket", "redPacketId is nil");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", -1);
            sVar2.i(i2, n("fail:system error {{redPacketId is nil}}", hashMap2));
            AppMethodBeat.o(46391);
        } else {
            ac currentPageView = sVar2.getCurrentPageView();
            if (currentPageView != null) {
                com.tencent.luggage.game.page.d dVar = (com.tencent.luggage.game.page.d) currentPageView.S(com.tencent.luggage.game.page.d.class);
                if (dVar != null) {
                    dVar.MP();
                }
                new C0668a(this, sVar2, currentPageView, jSONObject, i2).run();
                AppMethodBeat.o(46391);
                return;
            }
            Log.i("MicroMsg.JsApiOpenRedPacket", "associated page view is null!!");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("errCode", -1);
            sVar2.i(i2, n("fail:system error {{associated page view is null}}", hashMap3));
            AppMethodBeat.o(46391);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return true;
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.j.a$a  reason: collision with other inner class name */
    public static class C0668a extends q {
        public C0668a(p pVar, s sVar, ac acVar, JSONObject jSONObject, int i2) {
            super(pVar, sVar, acVar, jSONObject, i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final boolean a(Activity activity, JSONObject jSONObject, int i2) {
            AppMethodBeat.i(174839);
            String appId = NY().getAppId();
            String optString = jSONObject.optString("redPacketId", null);
            if (Util.isNullOrNil(appId) || Util.isNullOrNil(optString)) {
                Log.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.launch appId = [%s] sendId = [%s]", appId, optString);
                AppMethodBeat.o(174839);
                return false;
            }
            ((com.tencent.mm.plugin.luckymoney.appbrand.a) g.af(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(activity, optString, appId, i2);
            AppMethodBeat.o(174839);
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final void C(Intent intent) {
            AppMethodBeat.i(46389);
            Log.i("MicroMsg.JsApiOpenRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 0);
            J(hashMap);
            AppMethodBeat.o(46389);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final void onError(int i2, String str) {
            AppMethodBeat.i(46390);
            Log.i("MicroMsg.JsApiOpenRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i2), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i2));
            o(str, hashMap);
            AppMethodBeat.o(46390);
        }
    }
}

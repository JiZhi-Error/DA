package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends d<c> {
    private static final int CTRL_INDEX = 423;
    private static final String NAME = "sendRedPacket";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46395);
        c cVar2 = cVar;
        if (jSONObject == null) {
            Log.i("MicroMsg.JsApiSendRedPacket", "data is null");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", -1);
            cVar2.i(i2, n("fail:system error {{data is null}}", hashMap));
            AppMethodBeat.o(46395);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            Log.i("MicroMsg.JsApiSendRedPacket", "scope is nil");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("errCode", -1);
            cVar2.i(i2, n("fail:system error {{scope is nil}}", hashMap2));
            AppMethodBeat.o(46395);
            return;
        }
        new a(this, cVar2, cVar2.ax(ag.class), jSONObject, i2).run();
        AppMethodBeat.o(46395);
    }

    public static class a extends q {
        public a(p pVar, s sVar, ac acVar, JSONObject jSONObject, int i2) {
            super(pVar, sVar, acVar, jSONObject, i2);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final boolean a(Activity activity, JSONObject jSONObject, int i2) {
            int i3;
            int i4 = 0;
            AppMethodBeat.i(174840);
            String optString = jSONObject.optString("defaultWishingWord", null);
            JSONArray optJSONArray = jSONObject.optJSONArray("scope");
            if (optJSONArray != null) {
                boolean contains = optJSONArray.toString().contains("friend");
                boolean contains2 = optJSONArray.toString().contains("public");
                if (contains) {
                }
                if (contains2) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                if (contains2 && contains) {
                    i3 = 2;
                }
                i4 = i3;
            } else {
                Log.i("MicroMsg.JsApiSendRedPacket", "launch scope is nil");
            }
            ((com.tencent.mm.plugin.luckymoney.appbrand.a) g.af(com.tencent.mm.plugin.luckymoney.appbrand.a.class)).a(activity, NY().getAppId(), i4, optString, i2);
            AppMethodBeat.o(174840);
            return true;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final void C(Intent intent) {
            AppMethodBeat.i(46393);
            Log.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult ");
            if (intent == null || intent.getStringExtra("sendId") == null) {
                Log.e("MicroMsg.JsApiSendRedPacket", "onResult data = [%s]", intent);
                onError(-1, "fail:system error {{result data error or sendId is null}}");
                AppMethodBeat.o(46393);
                return;
            }
            String stringExtra = intent.getStringExtra("sendId");
            Log.i("MicroMsg.JsApiSendRedPacket", "PrepareLuckyMoneyRequest.onResult sendId = %s,share = %b", stringExtra, Boolean.valueOf(intent.getBooleanExtra("result_share_msg", false)));
            Log.i("MicroMsg.JsApiSendRedPacket", "GetLuckMoneyRequest.onResult");
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", 0);
            hashMap.put("redPacketId", stringExtra);
            J(hashMap);
            AppMethodBeat.o(46393);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.q
        public final void onError(int i2, String str) {
            AppMethodBeat.i(46394);
            Log.i("MicroMsg.JsApiSendRedPacket", "onError errCode: %d,errMsg: %s", Integer.valueOf(i2), str);
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(i2));
            o(str, hashMap);
            AppMethodBeat.o(46394);
        }
    }
}

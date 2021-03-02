package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class am extends d<k> {
    public static final int CTRL_INDEX = 58;
    public static final String NAME = "addCard";
    int csv;
    final int lyj = a.aK(this);

    public am() {
        AppMethodBeat.i(174749);
        AppMethodBeat.o(174749);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45434);
        final k kVar2 = kVar;
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(kVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            kVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiAddCard", "mmActivity is null, invoke fail! with appId[%s] callbackId[%d]", kVar2.getAppId(), Integer.valueOf(i2));
            AppMethodBeat.o(45434);
            return;
        }
        Intent intent = new Intent();
        String optString = jSONObject.optString("cardList");
        if (Util.isNullOrNil(optString)) {
            kVar2.i(i2, h("fail:invalid data", null));
            Log.e("MicroMsg.JsApiAddCard", "cardList is null, invoke fail!");
            AppMethodBeat.o(45434);
            return;
        }
        this.csv = i2;
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.am.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                int i4;
                JSONArray jSONArray;
                AppMethodBeat.i(174748);
                if (i2 == am.this.lyj) {
                    if (i3 == -1) {
                        if (intent == null) {
                            kVar2.i(am.this.csv, am.this.h("fail:internal error", null));
                            Log.e("MicroMsg.JsApiAddCard", "location result is empty!");
                            AppMethodBeat.o(174748);
                            return true;
                        }
                        HashMap hashMap = new HashMap();
                        String stringExtra = intent.getStringExtra("card_list");
                        Log.d("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback cardList:%s", stringExtra);
                        try {
                            jSONArray = new JSONArray(stringExtra);
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.JsApiAddCard", "parse fail result:%s", Util.stackTraceToString(e2));
                            jSONArray = null;
                        }
                        if (jSONArray != null) {
                            hashMap.put("cardList", jSONArray);
                            kVar2.i(am.this.csv, am.this.n("ok", hashMap));
                        } else {
                            kVar2.i(am.this.csv, am.this.n("fail: cardList is empty", hashMap));
                            Log.e("MicroMsg.JsApiAddCard", "add card result is fail! cardList is empty");
                        }
                    } else if (i3 == 0) {
                        kVar2.i(am.this.csv, am.this.h("cancel", null));
                        Log.e("MicroMsg.JsApiAddCard", "add card result is cancel!");
                    } else {
                        if (intent != null) {
                            i4 = intent.getIntExtra("result_code", 2);
                        } else {
                            i4 = 2;
                        }
                        Log.i("MicroMsg.JsApiAddCard", "mmSetOnActivityResultCallback ret_code:%d", Integer.valueOf(i4));
                        if (i4 == 2) {
                            kVar2.i(am.this.csv, am.this.h("fail:internal error", null));
                        } else {
                            kVar2.i(am.this.csv, am.this.h("cancel", null));
                        }
                    }
                    AppMethodBeat.o(174748);
                    return true;
                }
                AppMethodBeat.o(174748);
                return false;
            }
        });
        intent.putExtra("key_in_card_list", optString);
        intent.putExtra("key_from_scene", 26);
        l OT = kVar2.getRuntime().OT();
        if (!(OT == null || OT.leE == null)) {
            intent.putExtra("key_from_appbrand_type", OT.leE.kNW);
        }
        c.b(castActivityOrNull, "card", ".ui.CardAddEntranceUI", intent, this.lyj);
        AppMethodBeat.o(45434);
    }
}

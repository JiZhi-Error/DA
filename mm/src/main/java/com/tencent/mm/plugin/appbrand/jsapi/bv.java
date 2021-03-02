package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public final class bv extends d<s> {
    public static final int CTRL_INDEX = 59;
    public static final String NAME = "openCard";
    final int lAW = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45574);
        final s sVar2 = sVar;
        Intent intent = new Intent();
        Activity castActivityOrNull = AndroidContextUtil.castActivityOrNull(sVar2.getRuntime().mContext);
        if (castActivityOrNull == null) {
            sVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiOpenCard", "mmActivity is null, invoke fail! with appId[%s] callbackId[%d]", sVar2.getAppId(), Integer.valueOf(i2));
            AppMethodBeat.o(45574);
            return;
        }
        String optString = jSONObject.optString("cardList");
        if (Util.isNullOrNil(optString)) {
            sVar2.i(i2, h("fail", null));
            Log.e("MicroMsg.JsApiOpenCard", "cardList is null, invoke fail!");
            AppMethodBeat.o(45574);
            return;
        }
        f.aK(castActivityOrNull).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.bv.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174755);
                if (i2 == bv.this.lAW) {
                    if (i3 == -1) {
                        sVar2.i(i2, bv.this.h("ok", null));
                        Log.i("MicroMsg.JsApiOpenCard", "view card result is ok!");
                    } else if (i3 == 0) {
                        sVar2.i(i2, bv.this.h("cancel", null));
                        Log.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
                    } else {
                        sVar2.i(i2, bv.this.h("fail", null));
                        Log.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
                    }
                    AppMethodBeat.o(174755);
                    return true;
                }
                AppMethodBeat.o(174755);
                return false;
            }
        });
        intent.putExtra("key_app_id", sVar2.getAppId());
        intent.putExtra("card_list", optString);
        intent.putExtra("key_from_scene", 26);
        l lVar = (l) sVar2.av(l.class);
        if (!(lVar == null || lVar.leE == null)) {
            intent.putExtra("key_from_appbrand_type", lVar.leE.kNW);
        }
        c.b(castActivityOrNull, "card", ".ui.CardViewEntranceUI", intent, this.lAW);
        AppMethodBeat.o(45574);
    }

    public bv() {
        AppMethodBeat.i(174756);
        AppMethodBeat.o(174756);
    }
}

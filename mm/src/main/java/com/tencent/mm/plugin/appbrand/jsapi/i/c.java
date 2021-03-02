package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.h.f;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends d<s> {
    public static final int CTRL_INDEX = 103;
    public static final String NAME = "chooseLocation";
    final int lWV = a.aK(this);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46374);
        final s sVar2 = sVar;
        Log.i("MicroMsg.JsApiChooseLocation", "chooseLocation data:%s", jSONObject);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 8);
        intent.putExtra("type_tag", 4);
        if (jSONObject != null && jSONObject.has("latitude") && jSONObject.has("longitude")) {
            double d2 = Util.getDouble(jSONObject.optString("latitude"), 0.0d);
            double d3 = Util.getDouble(jSONObject.optString("longitude"), 0.0d);
            intent.putExtra("KPickPoiLat", d2);
            intent.putExtra("KPickPoiLong", d3);
        }
        Activity ay = sVar2.ay(Activity.class);
        if (ay == null) {
            sVar2.i(i2, h("fail:internal error invalid android context", null));
            Log.e("MicroMsg.JsApiChooseLocation", "mmActivity is null, invoke fail!");
            AppMethodBeat.o(46374);
            return;
        }
        f.aK(ay).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.i.c.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                String str;
                AppMethodBeat.i(174837);
                if (i2 == c.this.lWV) {
                    if (i3 == -1) {
                        if (intent == null) {
                            sVar2.i(i2, c.this.h("fail", null));
                            Log.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                            AppMethodBeat.o(174837);
                            return true;
                        }
                        Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                        HashMap hashMap = new HashMap();
                        if (addr != null) {
                            Log.i("MicroMsg.JsApiChooseLocation", "addr: " + addr.toString());
                            StringBuilder sb = new StringBuilder();
                            sb.append(Util.nullAs(addr.country, "")).append(Util.nullAs(addr.iUP, "")).append(addr.bbW());
                            Log.d("MicroMsg.Addr", "detail addr res: [%s].", sb);
                            hashMap.put("address", sb.toString());
                            if (!Util.isNullOrNil(addr.iUX)) {
                                str = addr.iUX;
                            } else if (!Util.isNullOrNil(addr.iUO)) {
                                str = addr.iUO;
                            } else if (!Util.isNullOrNil(addr.iUW)) {
                                str = addr.iUW;
                            } else {
                                Log.e("MicroMsg.Addr", "wtf!!! all invalid!!!");
                                str = "";
                            }
                            hashMap.put("name", str);
                            hashMap.put("latitude", Float.valueOf(addr.iUY));
                            hashMap.put("longitude", Float.valueOf(addr.iUZ));
                            Log.d("MicroMsg.JsApiChooseLocation", "res: %s, %s.", hashMap.get("address"), hashMap.get("name"));
                            sVar2.i(i2, c.this.n("ok", hashMap));
                        } else {
                            sVar2.i(i2, c.this.h("fail", null));
                            Log.e("MicroMsg.JsApiChooseLocation", "location result is empty!");
                        }
                    } else if (i3 == 0) {
                        sVar2.i(i2, c.this.h("fail:cancel", null));
                        Log.e("MicroMsg.JsApiChooseLocation", "location result is cancel!");
                    } else {
                        sVar2.i(i2, c.this.h("fail", null));
                        Log.e("MicroMsg.JsApiChooseLocation", "location result is fail!");
                    }
                    AppMethodBeat.o(174837);
                    return true;
                }
                AppMethodBeat.o(174837);
                return false;
            }
        });
        com.tencent.mm.br.c.b(ay, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent, this.lWV);
        AppMethodBeat.o(46374);
    }

    public c() {
        AppMethodBeat.i(174838);
        AppMethodBeat.o(174838);
    }
}

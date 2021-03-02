package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.content.Intent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class p extends d<f> {
    public static final int CTRL_INDEX = 38;
    public static final String NAME = "openLocation";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46385);
        Intent X = X(jSONObject);
        if (X == null) {
            fVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(46385);
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            fVar.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46385);
            return;
        }
        c.b(context, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", X);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(46385);
    }

    public static Intent X(JSONObject jSONObject) {
        int i2;
        AppMethodBeat.i(226847);
        Log.i("MicroMsg.JsApiOpenLocation", "data:%s", jSONObject);
        try {
            float f2 = Util.getFloat(jSONObject.optString("latitude"), 0.0f);
            float f3 = Util.getFloat(jSONObject.optString("longitude"), 0.0f);
            String afH = com.tencent.mm.plugin.appbrand.utils.f.afH(jSONObject.optString("name"));
            String afH2 = com.tencent.mm.plugin.appbrand.utils.f.afH(jSONObject.optString("address"));
            try {
                i2 = Util.getInt(jSONObject.optString("scale"), 0);
            } catch (Exception e2) {
                i2 = 0;
            }
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 10);
            intent.putExtra("kwebmap_slat", (double) f2);
            intent.putExtra("kwebmap_lng", (double) f3);
            if (i2 > 0) {
                intent.putExtra("kwebmap_scale", i2);
            }
            intent.putExtra("kPoiName", afH);
            intent.putExtra("Kwebmap_locaion", afH2);
            AppMethodBeat.o(226847);
            return intent;
        } catch (Exception e3) {
            AppMethodBeat.o(226847);
            return null;
        }
    }
}

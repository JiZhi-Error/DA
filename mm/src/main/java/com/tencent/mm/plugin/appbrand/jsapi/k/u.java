package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class u extends b {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "moveMapMarkerAlong";

    static /* synthetic */ void a(u uVar, f fVar, int i2, String str, boolean z) {
        AppMethodBeat.i(234557);
        uVar.a(fVar, i2, str, z);
        AppMethodBeat.o(234557);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(234554);
        super.a(fVar, jSONObject, i2);
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.u.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234551);
                u.this.e(fVar, jSONObject, i2);
                AppMethodBeat.o(234551);
            }
        });
        AppMethodBeat.o(234554);
    }

    /* access modifiers changed from: protected */
    public final void e(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(234555);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "data is invalid, err");
            a(fVar, i2, "fail:invalid data", false);
            AppMethodBeat.o(234555);
            return;
        }
        Log.d("MicroMsg.JsApiMoveMapMarkerAlong", "data:%s", jSONObject.toString());
        final b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "mapView is null, return");
            a(fVar, i2, String.format("fail:internal error %s", "mapview is null"), false);
            AppMethodBeat.o(234555);
            return;
        }
        String optString = jSONObject.optString("markerId");
        try {
            long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
            if (optLong == 0) {
                Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "duration is zero, err return");
                a(fVar, i2, "fail:invalid data", false);
            }
            boolean optBoolean = jSONObject.optBoolean("autoRotate", false);
            JSONArray jSONArray = jSONObject.getJSONArray("path");
            ArrayList<b.i> arrayList = new ArrayList<>();
            Log.d("MicroMsg.JsApiMoveMapMarkerAlong", "path size :%d", Integer.valueOf(jSONArray.length()));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                String optString2 = jSONObject2.optString("latitude");
                double d2 = 0.0d;
                double d3 = 0.0d;
                if (!Util.isNullOrNil(optString2)) {
                    d2 = Util.getDouble(optString2, 0.0d);
                }
                String optString3 = jSONObject2.optString("longitude");
                if (!Util.isNullOrNil(optString3)) {
                    d3 = Util.getDouble(optString3, 0.0d);
                }
                arrayList.add(new b.i(d2, d3));
            }
            h2.a(optString, arrayList, optLong, optBoolean, new b.r() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.u.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.r
                public final void hv(boolean z) {
                    AppMethodBeat.i(234552);
                    Log.i("MicroMsg.JsApiMoveMapMarkerAlong", "moveMapMarkerAlong onMarkerTranslate result::%b", Boolean.valueOf(z));
                    if (z) {
                        u.a(u.this, fVar, i2, "ok", h2.bGX());
                        AppMethodBeat.o(234552);
                        return;
                    }
                    u.a(u.this, fVar, i2, "fail", h2.bGX());
                    AppMethodBeat.o(234552);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.r
                public final void bGP() {
                    AppMethodBeat.i(234553);
                    u.a(u.this, fVar, i2, "cancel", h2.bGX());
                    AppMethodBeat.o(234553);
                }
            });
            AppMethodBeat.o(234555);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiMoveMapMarkerAlong", "parse data error, exception : %s", e2);
            a(fVar, i2, String.format("fail:internal error %s", "parse json fail"), h2.bGX());
            AppMethodBeat.o(234555);
        }
    }

    private void a(f fVar, int i2, String str, boolean z) {
        AppMethodBeat.i(234556);
        a(fVar, i2, h(str, (JSONObject) null), str.equals("ok"), z);
        AppMethodBeat.o(234556);
    }
}

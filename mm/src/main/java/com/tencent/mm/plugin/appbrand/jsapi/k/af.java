package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class af extends b {
    public static final int CTRL_INDEX = 200;
    public static final String NAME = "translateMapMarker";
    private List<Runnable> lYs = new ArrayList();
    private AtomicBoolean lYt = new AtomicBoolean(false);

    public af() {
        AppMethodBeat.i(143695);
        AppMethodBeat.o(143695);
    }

    static /* synthetic */ void a(af afVar, f fVar, int i2, String str, boolean z) {
        AppMethodBeat.i(143700);
        afVar.a(fVar, i2, str, z);
        AppMethodBeat.o(143700);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(143696);
        super.a(fVar, jSONObject, i2);
        this.lYs.add(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.af.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(143693);
                af.this.e(fVar, jSONObject, i2);
                AppMethodBeat.o(143693);
            }
        });
        bGQ();
        AppMethodBeat.o(143696);
    }

    private synchronized void bGQ() {
        AppMethodBeat.i(143697);
        if (this.lYt.get()) {
            AppMethodBeat.o(143697);
        } else if (this.lYs.size() == 0) {
            AppMethodBeat.o(143697);
        } else {
            Runnable remove = this.lYs.remove(0);
            if (remove != null) {
                m.bZn().postToWorker(remove);
            }
            AppMethodBeat.o(143697);
        }
    }

    /* access modifiers changed from: protected */
    public final void e(final f fVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(143698);
        this.lYt.set(true);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiTranslateMapMarker", "data is invalid, err");
            a(fVar, i2, "fail:invalid data", false);
            AppMethodBeat.o(143698);
            return;
        }
        Log.d("MicroMsg.JsApiTranslateMapMarker", "data:%s", jSONObject.toString());
        final b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiTranslateMapMarker", "mapView is null, return");
            a(fVar, i2, String.format("fail:internal error %s", "mapview is null"), false);
            AppMethodBeat.o(143698);
            return;
        }
        String optString = jSONObject.optString("markerId");
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("keyFrames"));
            LinkedList<b.h> linkedList = new LinkedList<>();
            Log.d("MicroMsg.JsApiTranslateMapMarker", "keyFramesArray size :%d", Integer.valueOf(jSONArray.length()));
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                b.h hVar = new b.h();
                hVar.duration = jSONObject2.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
                if (hVar.duration == 0) {
                    Log.e("MicroMsg.JsApiTranslateMapMarker", "keyFrame.duration is zero, err continue");
                } else {
                    hVar.mat = (float) jSONObject2.optDouble(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0.0d);
                    String optString2 = jSONObject2.optString("latitude");
                    if (!Util.isNullOrNil(optString2)) {
                        hVar.latitude = Util.getDouble(optString2, 0.0d);
                    }
                    String optString3 = jSONObject2.optString("longitude");
                    if (!Util.isNullOrNil(optString3)) {
                        hVar.longitude = Util.getDouble(optString3, 0.0d);
                    }
                    linkedList.add(hVar);
                }
            }
            h2.a(optString, linkedList, new b.r() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.af.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.r
                public final void hv(boolean z) {
                    AppMethodBeat.i(143694);
                    Log.i("MicroMsg.JsApiTranslateMapMarker", "onMarkerTranslate result::%b", Boolean.valueOf(z));
                    if (z) {
                        af.a(af.this, fVar, i2, "ok", h2.bGX());
                        AppMethodBeat.o(143694);
                        return;
                    }
                    af.a(af.this, fVar, i2, "fail", h2.bGX());
                    AppMethodBeat.o(143694);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.r
                public final void bGP() {
                }
            });
            AppMethodBeat.o(143698);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiTranslateMapMarker", "parse keyFrames error, exception : %s", e2);
            a(fVar, i2, String.format("fail:internal error %s", "parse json fail"), h2.bGX());
            AppMethodBeat.o(143698);
        }
    }

    private void a(f fVar, int i2, String str, boolean z) {
        AppMethodBeat.i(143699);
        a(fVar, i2, h(str, (JSONObject) null), str.equals("ok"), z);
        this.lYt.set(false);
        bGQ();
        AppMethodBeat.o(143699);
    }
}

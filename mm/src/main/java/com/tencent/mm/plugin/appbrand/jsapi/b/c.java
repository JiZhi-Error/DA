package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends d<f> {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, JSONObject jSONObject, final int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(145528);
        try {
            int i5 = jSONObject.getInt("canvasId");
            h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
            if (c2 == null) {
                Log.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasPutImageData failed, component view is null.");
                fVar.i(i2, h("fail:page is null", null));
                AppMethodBeat.o(145528);
                return;
            }
            View viewById = c2.gA(jSONObject.optBoolean("independent", false)).getViewById(i5);
            if (viewById == null) {
                Log.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", Integer.valueOf(i5));
                fVar.i(i2, h("fail:view is null", null));
                AppMethodBeat.o(145528);
            } else if (!(viewById instanceof CoverViewContainer)) {
                Log.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i5));
                fVar.i(i2, h("fail:illegal view type", null));
                AppMethodBeat.o(145528);
            } else {
                View view = (View) ((CoverViewContainer) viewById).aB(View.class);
                if (!(view instanceof a)) {
                    Log.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i5));
                    fVar.i(i2, h("fail:illegal view type", null));
                    AppMethodBeat.o(145528);
                    return;
                }
                float bZk = com.tencent.mm.plugin.appbrand.ac.g.bZk();
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt("y");
                int optInt3 = jSONObject.optInt("width");
                int optInt4 = jSONObject.optInt("height");
                Math.round(((float) optInt) * bZk);
                Math.round(((float) optInt2) * bZk);
                Math.round(((float) optInt3) * bZk);
                Math.round(bZk * ((float) optInt4));
                if (optInt3 == 0 || optInt4 == 0) {
                    Log.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i5));
                    fVar.i(i2, h("fail:width or height is 0", null));
                    AppMethodBeat.o(145528);
                    return;
                }
                if (optInt3 < 0) {
                    optInt += optInt3;
                    i3 = -optInt3;
                } else {
                    i3 = optInt3;
                }
                if (optInt4 < 0) {
                    optInt2 += optInt4;
                    i4 = -optInt4;
                } else {
                    i4 = optInt4;
                }
                try {
                    Object obj = jSONObject.get("data");
                    if (!(obj instanceof ByteBuffer)) {
                        Log.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        fVar.i(i2, h("fail:illegal data", null));
                        AppMethodBeat.o(145528);
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    int[] m = m((ByteBuffer) obj);
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(optInt);
                        jSONArray2.put(optInt2);
                        jSONArray2.put(i3);
                        jSONArray2.put(i4);
                        jSONArray2.put(Bitmap.createBitmap(m, i3, i4, Bitmap.Config.ARGB_8888));
                        jSONObject2.put(FirebaseAnalytics.b.METHOD, "__setPixels");
                        jSONObject2.put("data", jSONArray2);
                        jSONArray.put(jSONObject2);
                        a aVar = (a) view;
                        aVar.b(jSONArray, new a.AbstractC0561a() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.b.c.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.canvas.widget.a.AbstractC0561a
                            public final void a(DrawCanvasArg drawCanvasArg) {
                                AppMethodBeat.i(145527);
                                fVar.i(i2, c.this.h("ok", null));
                                AppMethodBeat.o(145527);
                            }
                        });
                        aVar.bzg();
                        AppMethodBeat.o(145528);
                    } catch (JSONException e2) {
                        Log.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", e2);
                        fVar.i(i2, h("fail:build action JSON error", null));
                        AppMethodBeat.o(145528);
                    }
                } catch (JSONException e3) {
                    Log.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", android.util.Log.getStackTraceString(e3));
                    fVar.i(i2, h("fail:missing data", null));
                    AppMethodBeat.o(145528);
                }
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", android.util.Log.getStackTraceString(e4));
            fVar.i(i2, h("fail:illegal canvasId", null));
            AppMethodBeat.o(145528);
        }
    }

    private static int[] m(ByteBuffer byteBuffer) {
        int i2 = 0;
        AppMethodBeat.i(145529);
        byte[] p = com.tencent.mm.plugin.appbrand.ac.d.p(byteBuffer);
        int[] iArr = new int[(p.length / 4)];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = (p[i5] & 255) | ((p[i4] & 255) << 8) | ((p[i2] & 255) << 16);
            i2 = i6 + 1;
            iArr[i3] = ((p[i6] & 255) << 24) | i7;
        }
        AppMethodBeat.o(145529);
        return iArr;
    }
}

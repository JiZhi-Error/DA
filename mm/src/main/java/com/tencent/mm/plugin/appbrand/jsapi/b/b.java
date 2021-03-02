package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends d<f> {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(145524);
        try {
            int i7 = jSONObject.getInt("canvasId");
            h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
            if (c2 == null) {
                Log.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, component view is null.");
                fVar.i(i2, h("fail:page is null", null));
                AppMethodBeat.o(145524);
                return;
            }
            View viewById = c2.gA(jSONObject.optBoolean("independent", false)).getViewById(i7);
            if (viewById == null) {
                Log.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", Integer.valueOf(i7));
                fVar.i(i2, h("fail:view is null", null));
                AppMethodBeat.o(145524);
            } else if (!(viewById instanceof CoverViewContainer)) {
                Log.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", Integer.valueOf(i7));
                fVar.i(i2, h("fail:illegal view type", null));
                AppMethodBeat.o(145524);
            } else {
                View view = (View) ((CoverViewContainer) viewById).aB(View.class);
                if (!(view instanceof a)) {
                    Log.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", Integer.valueOf(i7));
                    fVar.i(i2, h("fail:illegal view type", null));
                    AppMethodBeat.o(145524);
                    return;
                }
                float bZk = com.tencent.mm.plugin.appbrand.ac.g.bZk();
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt("y");
                int optInt3 = jSONObject.optInt("width");
                int optInt4 = jSONObject.optInt("height");
                if (optInt3 == 0 || optInt4 == 0) {
                    Log.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i7));
                    fVar.i(i2, h("fail:width or height is 0", null));
                    AppMethodBeat.o(145524);
                    return;
                }
                if (optInt3 < 0) {
                    int i8 = optInt + optInt3;
                    optInt3 = -optInt3;
                    i3 = i8;
                } else {
                    i3 = optInt;
                }
                if (optInt4 < 0) {
                    optInt2 += optInt4;
                    i4 = -optInt4;
                } else {
                    i4 = optInt4;
                }
                int round = Math.round(((float) i3) * bZk);
                int round2 = Math.round(((float) optInt2) * bZk);
                int round3 = Math.round(((float) optInt3) * bZk);
                int round4 = Math.round(((float) i4) * bZk);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                if (round < 0) {
                    i5 = 0;
                } else if (round >= measuredWidth) {
                    fVar.i(i2, a(fVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                    AppMethodBeat.o(145524);
                    return;
                } else {
                    i5 = round;
                }
                if (round2 < 0) {
                    i6 = 0;
                } else if (round2 >= measuredHeight) {
                    fVar.i(i2, a(fVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                    AppMethodBeat.o(145524);
                    return;
                } else {
                    i6 = round2;
                }
                if (round + round3 > measuredWidth) {
                    round3 = measuredWidth - i5;
                } else if (round + round3 <= 0) {
                    fVar.i(i2, a(fVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                    AppMethodBeat.o(145524);
                    return;
                } else if (round < 0) {
                    round3 += round;
                }
                if (round2 + round4 > measuredHeight) {
                    round4 = measuredHeight - i6;
                } else if (round2 + round4 <= 0) {
                    fVar.i(i2, a(fVar, "ok", e(new int[(optInt3 * i4)], optInt3, i4)));
                    AppMethodBeat.o(145524);
                    return;
                } else if (round2 < 0) {
                    round4 += round2;
                }
                int round5 = Math.round(((float) i5) / bZk);
                int round6 = Math.round(((float) i6) / bZk);
                int round7 = Math.round(((float) round3) / bZk);
                int round8 = Math.round(((float) round4) / bZk);
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(round3, round4, Bitmap.Config.ARGB_8888);
                    com.tencent.mm.plugin.appbrand.canvas.f fVar2 = new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap);
                    fVar2.save();
                    fVar2.translate((float) (-i5), (float) (-i6));
                    ((a) view).o(fVar2);
                    fVar2.restore();
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round7, round8, false);
                    int[] iArr = new int[(optInt3 * i4)];
                    try {
                        createScaledBitmap.getPixels(iArr, ((round6 - optInt2) * optInt3) + (round5 - i3), optInt3, 0, 0, round7, round8);
                        fVar.i(i2, a(fVar, "ok", e(iArr, optInt3, i4)));
                        AppMethodBeat.o(145524);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed, viewId(%s). Exception: %s", Integer.valueOf(i7), e2);
                        Log.w("MicroMsg.JsApiCanvasGetImageData", "getPixels failed. finalXDp:%d finalYDp:%d finalWidthDp:%d finalHeightDp:%d wDp:%d data:%s", Integer.valueOf(round5), Integer.valueOf(round6), Integer.valueOf(round7), Integer.valueOf(round8), Integer.valueOf(optInt3), jSONObject);
                        fVar.i(i2, h("fail: getPixels failed", null));
                        AppMethodBeat.o(145524);
                    }
                } catch (Exception e3) {
                    Log.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i7), e3);
                    fVar.i(i2, h("fail:create bitmap failed", null));
                    AppMethodBeat.o(145524);
                }
            }
        } catch (JSONException e4) {
            Log.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", android.util.Log.getStackTraceString(e4));
            fVar.i(i2, h("fail:illegal canvasId", null));
            AppMethodBeat.o(145524);
        }
    }

    private static Map<String, Object> e(int[] iArr, int i2, int i3) {
        AppMethodBeat.i(145525);
        ByteBuffer v = v(iArr);
        HashMap hashMap = new HashMap();
        hashMap.put("data", v);
        hashMap.put("width", Integer.valueOf(i2));
        hashMap.put("height", Integer.valueOf(i3));
        AppMethodBeat.o(145525);
        return hashMap;
    }

    private static ByteBuffer v(int[] iArr) {
        int i2 = 0;
        AppMethodBeat.i(145526);
        byte[] bArr = new byte[(iArr.length * 4)];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i3] >> 16) & 255);
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((iArr[i3] >> 8) & 255);
            int i6 = i5 + 1;
            bArr[i5] = (byte) (iArr[i3] & 255);
            i2 = i6 + 1;
            bArr[i6] = (byte) ((iArr[i3] >> 24) & 255);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        AppMethodBeat.o(145526);
        return wrap;
    }
}

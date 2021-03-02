package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends com.tencent.mm.plugin.appbrand.jsapi.d<f> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(145531);
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.b.d.AnonymousClass1 */

            public final void run() {
                float f2;
                float f3;
                AppMethodBeat.i(145530);
                if (!fVar.isRunning()) {
                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                    fVar.i(i2, d.this.h("fail", null));
                    AppMethodBeat.o(145530);
                    return;
                }
                h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
                if (c2 == null) {
                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "invoke JsApi canvasToTempFilePath failed, component view is null.");
                    fVar.i(i2, d.this.h("fail:page is null", null));
                    AppMethodBeat.o(145530);
                    return;
                }
                d dVar = d.this;
                JSONObject jSONObject = jSONObject;
                i iVar = new i(fVar, i2);
                try {
                    int i2 = jSONObject.getInt("canvasId");
                    View viewById = c2.gA(jSONObject.optBoolean("independent", false)).getViewById(i2);
                    if (viewById == null) {
                        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "get view by viewId(%s) return null.", Integer.valueOf(i2));
                        iVar.ZA(dVar.h("fail:get canvas by canvasId failed", null));
                        AppMethodBeat.o(145530);
                    } else if (!(viewById instanceof CoverViewContainer)) {
                        Log.w("MicroMsg.JsApiCanvasToTempFilePath", "the view(%s) is not a instance of CoverViewContainer.", Integer.valueOf(i2));
                        iVar.ZA(dVar.h("fail:the view is not a instance of CoverViewContainer", null));
                        AppMethodBeat.o(145530);
                    } else {
                        View view = (View) ((CoverViewContainer) viewById).aB(View.class);
                        if (view == null) {
                            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "getTargetView return null, viewId(%s).", Integer.valueOf(i2));
                            iVar.ZA(dVar.h("fail:target view is null.", null));
                            AppMethodBeat.o(145530);
                            return;
                        }
                        int measuredWidth = view.getMeasuredWidth();
                        int measuredHeight = view.getMeasuredHeight();
                        try {
                            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                            float h2 = com.tencent.mm.plugin.appbrand.ac.g.h(jSONObject, "x");
                            float h3 = com.tencent.mm.plugin.appbrand.ac.g.h(jSONObject, "y");
                            float a2 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject, "width", (float) measuredWidth);
                            float a3 = com.tencent.mm.plugin.appbrand.ac.g.a(jSONObject, "height", (float) measuredHeight);
                            if (h2 + a2 > ((float) measuredWidth)) {
                                f2 = ((float) measuredWidth) - h2;
                            } else {
                                f2 = a2;
                            }
                            if (h3 + a3 > ((float) measuredHeight)) {
                                f3 = ((float) measuredHeight) - h3;
                            } else {
                                f3 = a3;
                            }
                            float f4 = Util.getFloat(jSONObject.optString("destWidth"), f2);
                            float f5 = Util.getFloat(jSONObject.optString("destHeight"), f3);
                            if (((int) h2) < 0 || ((int) h3) < 0 || ((int) f2) <= 0 || ((int) f3) <= 0 || ((int) (h2 + f2)) > measuredWidth || ((int) (h3 + f3)) > measuredHeight || ((int) f4) <= 0 || ((int) f5) <= 0) {
                                Log.e("MicroMsg.JsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, viewId(%s).", Float.valueOf(h2), Float.valueOf(h3), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2));
                                iVar.ZA(dVar.h("fail:illegal arguments", null));
                                AppMethodBeat.o(145530);
                                return;
                            }
                            if (view instanceof a) {
                                ((a) view).o(new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap));
                            } else {
                                view.draw(new com.tencent.mm.plugin.appbrand.canvas.f(createBitmap));
                            }
                            if (!(f2 == ((float) measuredWidth) && f3 == ((float) measuredHeight))) {
                                try {
                                    Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, (int) h2, (int) h3, (int) f2, (int) f3, (Matrix) null, false);
                                    Log.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createBitmap2;
                                } catch (Exception e2) {
                                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i2), e2);
                                    iVar.ZA(dVar.h("fail:create bitmap failed", null));
                                    AppMethodBeat.o(145530);
                                    return;
                                } catch (Throwable th) {
                                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", Integer.valueOf(i2), th);
                                    iVar.ZA(dVar.h("fail:create bitmap failed", null));
                                    AppMethodBeat.o(145530);
                                    return;
                                }
                            }
                            if (!(f2 == f4 && f3 == f5)) {
                                try {
                                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, (int) f4, (int) f5, false);
                                    Log.i("MicroMsg.JsApiCanvasToTempFilePath", "bitmap recycle %s", createBitmap);
                                    createBitmap.recycle();
                                    createBitmap = createScaledBitmap;
                                } catch (Exception e3) {
                                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i2), e3);
                                    iVar.ZA(dVar.h("fail:create bitmap failed", null));
                                    AppMethodBeat.o(145530);
                                    return;
                                } catch (Throwable th2) {
                                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", Integer.valueOf(i2), th2);
                                    iVar.ZA(dVar.h("fail:create bitmap failed", null));
                                    AppMethodBeat.o(145530);
                                    return;
                                }
                            }
                            Bitmap.CompressFormat S = d.S(jSONObject);
                            String str = S == Bitmap.CompressFormat.JPEG ? "jpg" : "png";
                            o Wa = c2.getFileSystem().Wa("canvas_" + i2 + "." + str);
                            if (Wa == null) {
                                Log.e("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, alloc file failed");
                                iVar.ZA(dVar.h("fail alloc file failed", null));
                                AppMethodBeat.o(145530);
                                return;
                            }
                            String z = aa.z(Wa.her());
                            Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, savePath = %s", z);
                            try {
                                BitmapUtil.saveBitmapToImage(createBitmap, d.R(jSONObject), S, z, true);
                                com.tencent.mm.plugin.appbrand.ac.i<String> iVar2 = new com.tencent.mm.plugin.appbrand.ac.i<>();
                                c2.getFileSystem().a(new o(z), str, true, iVar2);
                                T t = iVar2.value;
                                Log.d("MicroMsg.JsApiCanvasToTempFilePath", "toTempFilePath, returnPath = %s", t);
                                HashMap hashMap = new HashMap();
                                hashMap.put("tempFilePath", t);
                                iVar.ZA(dVar.n("ok", hashMap));
                                AppMethodBeat.o(145530);
                            } catch (IOException e4) {
                                Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i2), e4);
                                iVar.ZA(dVar.h("fail:write file failed", null));
                                AppMethodBeat.o(145530);
                            } catch (Throwable th3) {
                                Log.w("MicroMsg.JsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). throwable : %s", Integer.valueOf(i2), th3);
                                iVar.ZA(dVar.h("fail:write file failed", null));
                                AppMethodBeat.o(145530);
                            }
                        } catch (Exception e5) {
                            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Exception : %s", Integer.valueOf(i2), e5);
                            iVar.ZA(dVar.h("fail:create bitmap failed", null));
                            AppMethodBeat.o(145530);
                        } catch (Throwable th4) {
                            Log.w("MicroMsg.JsApiCanvasToTempFilePath", "create bitmap failed, viewId(%s). Throwable : %s", Integer.valueOf(i2), th4);
                            iVar.ZA(dVar.h("fail:create bitmap failed", null));
                            AppMethodBeat.o(145530);
                        }
                    }
                } catch (JSONException e6) {
                    Log.w("MicroMsg.JsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e6);
                    iVar.ZA(dVar.h("fail:canvasId do not exist", null));
                    AppMethodBeat.o(145530);
                }
            }
        });
        AppMethodBeat.o(145531);
    }

    public static int R(JSONObject jSONObject) {
        float f2 = 0.0f;
        AppMethodBeat.i(145532);
        float optDouble = (float) jSONObject.optDouble("quality", 1.0d);
        if (optDouble >= 0.0f) {
            if (optDouble > 1.0f) {
                f2 = 100.0f;
            } else {
                f2 = optDouble * 100.0f;
            }
        }
        int i2 = (int) f2;
        AppMethodBeat.o(145532);
        return i2;
    }

    public static Bitmap.CompressFormat S(JSONObject jSONObject) {
        AppMethodBeat.i(145533);
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        if ("jpg".equalsIgnoreCase(jSONObject.optString("fileType"))) {
            compressFormat = Bitmap.CompressFormat.JPEG;
        }
        AppMethodBeat.o(145533);
        return compressFormat;
    }
}

package com.tencent.luggage.game.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<s> {
    public static final int CTRL_INDEX = 100;
    public static final String NAME = "canvasToTempFilePath";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(130538);
        final s sVar2 = sVar;
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.luggage.game.d.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(130536);
                if (!sVar2.isRunning()) {
                    Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "invoke JsApi insertView failed, current page view is null.");
                    sVar2.i(i2, d.this.h("fail", null));
                    AppMethodBeat.o(130536);
                    return;
                }
                ac currentPageView = sVar2.getCurrentPageView();
                if (((com.tencent.luggage.game.page.d) currentPageView.S(com.tencent.luggage.game.page.d.class)) == null) {
                    sVar2.i(i2, d.this.h("fail", null));
                    AppMethodBeat.o(130536);
                    return;
                }
                i.a a2 = d.a(currentPageView, jSONObject, false);
                sVar2.i(i2, d.this.n(a2.errMsg, a2.values));
                AppMethodBeat.o(130536);
            }
        });
        AppMethodBeat.o(130538);
    }

    public static i.a a(ac acVar, JSONObject jSONObject, boolean z) {
        Bitmap bitmap;
        float f2;
        float f3;
        float f4;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        IllegalArgumentException e2;
        NullPointerException e3;
        AppMethodBeat.i(130537);
        try {
            int i2 = jSONObject.getInt("canvasId");
            if (acVar == null) {
                try {
                    i.a aVar = new i.a("fail: no page", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar;
                } catch (OutOfMemoryError e4) {
                    Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e4, "hy: out of memory!!", new Object[0]);
                    ((a) e.N(a.class)).Bl(12);
                    i.a aVar2 = new i.a("fail:out of memory!", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar2;
                } catch (RuntimeException e5) {
                    Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e5, "hy: runtime exception!", new Object[0]);
                    ((a) e.N(a.class)).idkeyStat(807, 13, 1, false);
                    i.a aVar3 = new i.a("fail:runtime exception! %s", e5.toString());
                    AppMethodBeat.o(130537);
                    return aVar3;
                }
            } else {
                com.tencent.luggage.game.page.d dVar = (com.tencent.luggage.game.page.d) acVar.S(com.tencent.luggage.game.page.d.class);
                boolean optBoolean = jSONObject.optBoolean("isScreenCanvas", false);
                if (dVar == null || dVar.MQ() == null) {
                    bitmap = null;
                } else if (!optBoolean) {
                    bitmap = dVar.u(i2, z);
                } else {
                    bitmap = dVar.MQ().getMagicBrush().cLA.h(dVar.MQ().getVirtualElementId(), -1, true);
                }
                if (bitmap == null) {
                    Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "get screenBitmap return null.");
                    ((a) e.N(a.class)).Bl(optBoolean ? 14 : 15);
                    i.a aVar4 = new i.a("fail:get bitmap failed", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar4;
                }
                float width = (float) bitmap.getWidth();
                float height = (float) bitmap.getHeight();
                float width2 = (float) bitmap.getWidth();
                float height2 = (float) bitmap.getHeight();
                Log.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenWidth:%f,screenHeight:%f,canvasWidth:%f,canvasHeight:%f", Float.valueOf(width), Float.valueOf(height), Float.valueOf(width2), Float.valueOf(height2));
                float optDouble = (float) jSONObject.optDouble("x", 0.0d);
                float optDouble2 = (float) jSONObject.optDouble("y", 0.0d);
                float optDouble3 = (float) jSONObject.optDouble("width", (double) width2);
                float optDouble4 = (float) jSONObject.optDouble("height", (double) height2);
                Log.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,width:%f,height:%f", Float.valueOf(optDouble), Float.valueOf(optDouble2), Float.valueOf(optDouble3), Float.valueOf(optDouble4));
                if (width2 <= 0.0f || height2 <= 0.0f || (width == width2 && height == height2)) {
                    f2 = optDouble2;
                } else {
                    if (optDouble > 0.0f) {
                        optDouble = (optDouble / width2) * width;
                    }
                    if (optDouble2 > 0.0f) {
                        optDouble2 = (optDouble2 / height2) * height;
                    }
                    optDouble3 = (optDouble3 / width2) * width;
                    optDouble4 = (optDouble4 / height2) * height;
                    f2 = optDouble2;
                }
                if (optDouble + optDouble3 > width) {
                    f3 = width - optDouble;
                } else {
                    f3 = optDouble3;
                }
                if (f2 + optDouble4 > height) {
                    f4 = height - f2;
                } else {
                    f4 = optDouble4;
                }
                float optDouble5 = (float) jSONObject.optDouble("destWidth", (double) f3);
                float optDouble6 = (float) jSONObject.optDouble("destHeight", (double) f4);
                Log.i("MicroMsg.WAGameJsApiCanvasToTempFilePath", "x:%f,y:%f,screenWidth:%f,screenHeight:%f,width:%f,height:%f,imgWidth:%f,imgHeight:%f", Float.valueOf(optDouble), Float.valueOf(f2), Float.valueOf(width), Float.valueOf(height), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                if (((int) optDouble) < 0 || ((int) f2) < 0 || ((int) f3) <= 0 || ((int) f4) <= 0 || ((int) (optDouble + f3)) > ((int) width) || ((int) (f2 + f4)) > ((int) height) || ((int) optDouble5) <= 0 || ((int) optDouble6) <= 0) {
                    Log.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "illegal arguments(x : %s, y : %s, width : %s, height : %s) failed, canvasId(%s).", Float.valueOf(optDouble), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(i2));
                    i.a aVar5 = new i.a("fail:illegal arguments", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar5;
                }
                if (f3 == width && f4 == height) {
                    bitmap2 = bitmap;
                } else {
                    bitmap2 = Bitmap.createBitmap(bitmap, (int) optDouble, (int) f2, (int) f3, (int) f4, (Matrix) null, false);
                    bitmap.recycle();
                }
                if (bitmap2 == null) {
                    Log.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content null!");
                    i.a aVar6 = new i.a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar6;
                } else if (bitmap2.getWidth() <= 0 || bitmap2.getHeight() <= 0) {
                    Log.e("MicroMsg.WAGameJsApiCanvasToTempFilePath", "screenBitmap.content width or height <=0!");
                    i.a aVar7 = new i.a("fail:gen bitmap failed!", new Object[0]);
                    AppMethodBeat.o(130537);
                    return aVar7;
                } else {
                    if (f3 == optDouble5 && f4 == optDouble6) {
                        bitmap3 = bitmap2;
                    } else {
                        try {
                            bitmap3 = Bitmap.createScaledBitmap(bitmap2, (int) optDouble5, (int) optDouble6, false);
                            bitmap2.recycle();
                            if (bitmap3 == null) {
                                try {
                                    ((a) e.N(a.class)).Bl(9);
                                    i.a aVar8 = new i.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.o(130537);
                                    return aVar8;
                                } catch (NullPointerException e6) {
                                    e3 = e6;
                                    Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap3.getWidth()), Integer.valueOf(bitmap3.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e3, "hy: weired exception occured!!", new Object[0]);
                                    ((a) e.N(a.class)).Bl(9);
                                    i.a aVar9 = new i.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                                    AppMethodBeat.o(130537);
                                    return aVar9;
                                } catch (IllegalArgumentException e7) {
                                    e2 = e7;
                                    Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(bitmap3.getWidth()), Integer.valueOf(bitmap3.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                                    Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e2, "hy: illegalArgument exception occured!!", new Object[0]);
                                    ((a) e.N(a.class)).Bl(10);
                                    i.a aVar10 = new i.a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                                    AppMethodBeat.o(130537);
                                    return aVar10;
                                }
                            }
                        } catch (NullPointerException e8) {
                            e3 = e8;
                            bitmap3 = bitmap2;
                            Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception npe: %d, %d, %f, %f", Integer.valueOf(bitmap3.getWidth()), Integer.valueOf(bitmap3.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e3, "hy: weired exception occured!!", new Object[0]);
                            ((a) e.N(a.class)).Bl(9);
                            i.a aVar92 = new i.a("fail:gen bitmap failed because of null pointer!", new Object[0]);
                            AppMethodBeat.o(130537);
                            return aVar92;
                        } catch (IllegalArgumentException e9) {
                            e2 = e9;
                            bitmap3 = bitmap2;
                            Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "hy: dump exception ilae: %d, %d, %f, %f", Integer.valueOf(bitmap3.getWidth()), Integer.valueOf(bitmap3.getHeight()), Float.valueOf(optDouble5), Float.valueOf(optDouble6));
                            Log.printErrStackTrace("MicroMsg.WAGameJsApiCanvasToTempFilePath", e2, "hy: illegalArgument exception occured!!", new Object[0]);
                            ((a) e.N(a.class)).Bl(10);
                            i.a aVar102 = new i.a("fail:gen bitmap failed because of illegal argument!", new Object[0]);
                            AppMethodBeat.o(130537);
                            return aVar102;
                        }
                    }
                    Bitmap.CompressFormat S = com.tencent.mm.plugin.appbrand.jsapi.b.d.S(jSONObject);
                    if (S == Bitmap.CompressFormat.PNG) {
                        bitmap4 = Bitmap.createBitmap(bitmap3.getWidth(), bitmap3.getHeight(), Bitmap.Config.RGB_565);
                        new Canvas(bitmap4).drawBitmap(bitmap3, 0.0f, 0.0f, (Paint) null);
                    } else {
                        bitmap4 = bitmap3;
                    }
                    String genMediaFilePath = AppBrandLocalMediaObjectManager.genMediaFilePath(acVar.getAppId(), "canvas_".concat(String.valueOf(i2)));
                    try {
                        BitmapUtil.saveBitmapToImage(bitmap4, com.tencent.mm.plugin.appbrand.jsapi.b.d.R(jSONObject), S, genMediaFilePath, true);
                        AppBrandLocalMediaObject b2 = AppBrandLocalMediaObjectManager.b(acVar.getAppId(), genMediaFilePath, S == Bitmap.CompressFormat.JPEG ? "jpg" : "png", true);
                        if (b2 == null) {
                            Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "gen temp file failed, canvasId : %s.", Integer.valueOf(i2));
                            i.a aVar11 = new i.a("fail:gen temp file failed", new Object[0]);
                            AppMethodBeat.o(130537);
                            return aVar11;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempFilePath", b2.dJX);
                        Log.v("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save file(id : %s) to path : %s", b2.dJX, b2.iGf);
                        i.a N = new i.a("ok", new Object[0]).N(hashMap);
                        AppMethodBeat.o(130537);
                        return N;
                    } catch (IOException e10) {
                        Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "save bitmap to file failed, viewId(%s). exception : %s", Integer.valueOf(i2), e10);
                        i.a aVar12 = new i.a("fail:write file failed", new Object[0]);
                        AppMethodBeat.o(130537);
                        return aVar12;
                    }
                }
            }
        } catch (JSONException e11) {
            Log.w("MicroMsg.WAGameJsApiCanvasToTempFilePath", "canvasId do not exist. exception : %s", e11);
            i.a aVar13 = new i.a("fail:canvasId do not exist", new Object[0]);
            AppMethodBeat.o(130537);
            return aVar13;
        }
    }
}

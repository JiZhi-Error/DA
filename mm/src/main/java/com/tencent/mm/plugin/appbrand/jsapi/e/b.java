package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.m.k;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.FaceTracker;
import com.tencent.mm.xeffect.XEffectLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Objects;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class b extends d<s> {
    public static final int CTRL_INDEX = 861;
    public static final String NAME = "faceDetect";
    private static String lUa = "Thread.AppBrand.JsApiFaceDetect";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(226765);
        final s sVar2 = sVar;
        final a bGl = a.bGl();
        bGl.lTO.execute(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.e.b.AnonymousClass1 */

            public final void run() {
                ByteBuffer byteBuffer;
                int i2;
                AppMethodBeat.i(226763);
                HashMap hashMap = new HashMap(1);
                if (bGl.lTN == null) {
                    Log.e("MicroMsg.JsApiFaceDetect", "hy: not prepared effect!");
                    hashMap.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultInitFail)));
                    sVar2.i(i2, b.this.n("fail: not started yet", hashMap));
                    AppMethodBeat.o(226763);
                } else if (!jSONObject.has("frameBuffer") || !jSONObject.has("width") || !jSONObject.has("height")) {
                    Log.e("MicroMsg.JsApiFaceDetect", "hy: not given framebuffer");
                    hashMap.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultFaceDetectedFail)));
                    sVar2.i(i2, b.this.n("fail: not given framebuffer or size", hashMap));
                    AppMethodBeat.o(226763);
                } else {
                    ByteBuffer byteBuffer2 = (ByteBuffer) jSONObject.opt("frameBuffer");
                    int optInt = jSONObject.optInt("width");
                    int optInt2 = jSONObject.optInt("height");
                    if (byteBuffer2 == null || optInt < 0 || optInt2 < 0) {
                        Log.e("MicroMsg.JsApiFaceDetect", "hy: invalid params when detect");
                        hashMap.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultFaceDetectedFail)));
                        sVar2.i(i2, b.this.n("fail: not valid params when detect frame buffer", hashMap));
                        AppMethodBeat.o(226763);
                        return;
                    }
                    a aVar = bGl;
                    HashMap hashMap2 = new HashMap(1);
                    if (a.lTL == null || a.lTL.lTN == null) {
                        hashMap2.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultNotInit)));
                    } else {
                        if (!byteBuffer2.isDirect()) {
                            byteBuffer = x.q(byteBuffer2).order(ByteOrder.nativeOrder());
                            byteBuffer.position(0);
                        } else {
                            byteBuffer = byteBuffer2;
                        }
                        FaceTracker faceTracker = a.lTL.lTN;
                        p.h(byteBuffer, "data");
                        if (faceTracker.Rxd != 0) {
                            i2 = faceTracker.nDetect(faceTracker.Rxd, byteBuffer, optInt, optInt2);
                        } else {
                            i2 = -1;
                        }
                        FaceTracker faceTracker2 = a.lTL.lTN;
                        RectF rectF = new RectF();
                        float[] nGetFaceRect = faceTracker2.nGetFaceRect(faceTracker2.Rxd);
                        if (nGetFaceRect != null) {
                            rectF.set(nGetFaceRect[0], nGetFaceRect[1], nGetFaceRect[0] + nGetFaceRect[2], nGetFaceRect[3] + nGetFaceRect[1]);
                            XEffectLog.d("FaceTracker", "rect is ".concat(String.valueOf(rectF)), new Object[0]);
                        }
                        if (i2 != 0 || rectF.isEmpty()) {
                            hashMap2.put("x", Float.valueOf(aVar.aTD));
                            hashMap2.put("y", Float.valueOf(aVar.aTE));
                            if (aVar.lTP.isEmpty()) {
                                aVar.lTP.put("originX", Float.valueOf(-1.0f));
                                aVar.lTP.put("originY", Float.valueOf(-1.0f));
                                aVar.lTP.put("width", Float.valueOf(0.0f));
                                aVar.lTP.put("height", Float.valueOf(0.0f));
                            }
                            hashMap2.put("detectRect", aVar.lTP);
                            hashMap2.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultFaceDetectedFail)));
                        } else {
                            hashMap2.put("errCode", Integer.valueOf(a.a(a.EnumC0659a.ResultOK)));
                            aVar.aTD = rectF.centerX();
                            aVar.aTE = rectF.centerY();
                            hashMap2.put("x", Float.valueOf(aVar.aTD));
                            hashMap2.put("y", Float.valueOf(aVar.aTE));
                            aVar.lTP.put("originX", Float.valueOf(rectF.centerX() - (rectF.width() / 2.0f)));
                            aVar.lTP.put("originY", Float.valueOf(rectF.centerY() - (rectF.height() / 2.0f)));
                            aVar.lTP.put("width", Float.valueOf(rectF.width()));
                            aVar.lTP.put("height", Float.valueOf(rectF.height()));
                            hashMap2.put("detectRect", aVar.lTP);
                        }
                    }
                    if (byteBuffer2.isDirect()) {
                        k kVar = (k) sVar2.getJsRuntime().R(k.class);
                        if (kVar == null) {
                            Log.w("MicroMsg.NativeBufferUtil", "hy: no buffer addon support");
                        } else {
                            kVar.releaseDirectByteBuffer(byteBuffer2);
                        }
                    }
                    if (Objects.equals(hashMap2.get("errCode"), Integer.valueOf(a.a(a.EnumC0659a.ResultOK)))) {
                        sVar2.i(i2, b.this.n("ok", hashMap2));
                        AppMethodBeat.o(226763);
                        return;
                    }
                    Log.w("MicroMsg.JsApiFaceDetect", "hy: face detect failed");
                    sVar2.i(i2, b.this.n("fail: face detect failed", hashMap2));
                    AppMethodBeat.o(226763);
                }
            }
        });
        AppMethodBeat.o(226765);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p
    public final ByteBuffer a(String str, k kVar, int i2) {
        AppMethodBeat.i(226764);
        if ("frameBuffer".equalsIgnoreCase(str)) {
            ByteBuffer N = kVar.N(i2, true);
            AppMethodBeat.o(226764);
            return N;
        }
        ByteBuffer a2 = super.a(str, kVar, i2);
        AppMethodBeat.o(226764);
        return a2;
    }
}

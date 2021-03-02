package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends d {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(137480);
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null or nil", null));
            AppMethodBeat.o(137480);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.n.AnonymousClass1 */

            public final void run() {
                f fVar;
                AppMethodBeat.i(137479);
                int optInt = jSONObject.optInt("cameraId");
                String optString = jSONObject.optString("type");
                Log.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", Integer.valueOf(optInt), optString);
                a aVar = a.C0654a.lOY;
                if (aVar.lOX.indexOfKey(optInt) >= 0) {
                    WeakReference<f> weakReference = aVar.lOX.get(optInt);
                    fVar = weakReference != null ? weakReference.get() : null;
                } else {
                    fVar = null;
                }
                if (fVar == null) {
                    fVar.i(i2, n.this.h("fail:no such camera", null));
                    AppMethodBeat.o(137479);
                    return;
                }
                fVar.setOperateCallBack(new c() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.camera.n.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.c
                    public final void a(int i2, String str, String str2, int i3, int i4) {
                        AppMethodBeat.i(137475);
                        if (i2 == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempImagePath", str);
                            hashMap.put("width", Integer.valueOf(i3));
                            hashMap.put("height", Integer.valueOf(i4));
                            fVar.i(i2, n.this.n("ok", hashMap));
                            AppMethodBeat.o(137475);
                            return;
                        }
                        fVar.i(i2, n.this.h("fail:".concat(String.valueOf(str2)), null));
                        AppMethodBeat.o(137475);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.c
                    public final void aj(int i2, String str) {
                        AppMethodBeat.i(137476);
                        if (i2 == 0) {
                            fVar.i(i2, n.this.h("ok", null));
                            AppMethodBeat.o(137476);
                            return;
                        }
                        fVar.i(i2, n.this.h("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(137476);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.c
                    public final void a(int i2, String str, String str2, String str3, int i3, long j2, int i4, int i5) {
                        AppMethodBeat.i(137477);
                        Log.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", Integer.valueOf(i2), str2, str3, Integer.valueOf(i3), Long.valueOf(j2), Integer.valueOf(i4), Integer.valueOf(i5));
                        if (i2 == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempThumbPath", str2);
                            hashMap.put("tempVideoPath", str3);
                            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i3));
                            hashMap.put("size", Long.valueOf(j2));
                            hashMap.put("height", Integer.valueOf(i5));
                            hashMap.put("width", Integer.valueOf(i4));
                            fVar.i(i2, n.this.n("ok", hashMap));
                            AppMethodBeat.o(137477);
                            return;
                        }
                        fVar.i(i2, n.this.h("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(137477);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.c
                    public final void h(String str, int i2, int i3, int i4) {
                        AppMethodBeat.i(137478);
                        if (!Util.isNullOrNil(str)) {
                            fVar.i(i2, n.this.h("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.o(137478);
                            return;
                        }
                        Log.d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                        HashMap hashMap = new HashMap();
                        hashMap.put("bufferId", Integer.valueOf(i2));
                        hashMap.put("width", Integer.valueOf(i3));
                        hashMap.put("height", Integer.valueOf(i4));
                        fVar.i(i2, n.this.n("ok", hashMap));
                        AppMethodBeat.o(137478);
                    }
                });
                char c2 = 65535;
                switch (optString.hashCode()) {
                    case -2144140699:
                        if (optString.equals("closeFrameChange")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1909077165:
                        if (optString.equals(JsApiStartRecordVoice.NAME)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1391995149:
                        if (optString.equals(JsApiStopRecordVoice.NAME)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -374265034:
                        if (optString.equals("listenFrameChange")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1484838379:
                        if (optString.equals("takePhoto")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1985172309:
                        if (optString.equals("setZoom")) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        fVar.setQuality(jSONObject.optString("quality", "high"));
                        fVar.bFK();
                        AppMethodBeat.o(137479);
                        return;
                    case 1:
                        float aJ = fVar.aJ((float) jSONObject.optDouble("zoom"));
                        if (aJ < 1.0f) {
                            fVar.i(i2, n.this.h("fail: zoom multiple not support", null));
                            AppMethodBeat.o(137479);
                            return;
                        }
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("zoom", Float.valueOf(aJ));
                        fVar.i(i2, n.this.n("ok", hashMap));
                        AppMethodBeat.o(137479);
                        return;
                    case 2:
                        fVar.bFT();
                        AppMethodBeat.o(137479);
                        return;
                    case 3:
                        fVar.setCompressRecord(jSONObject.optBoolean("compressed"));
                        fVar.bFU();
                        AppMethodBeat.o(137479);
                        return;
                    case 4:
                        jSONObject.optString("size");
                        fVar.o(fVar);
                        AppMethodBeat.o(137479);
                        return;
                    case 5:
                        fVar.bFN();
                        fVar.i(i2, n.this.h("ok", null));
                        AppMethodBeat.o(137479);
                        return;
                    default:
                        Log.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", optString);
                        fVar.i(i2, n.this.h("fail:operateType not supported", null));
                        AppMethodBeat.o(137479);
                        return;
                }
            }
        });
        AppMethodBeat.o(137480);
    }
}

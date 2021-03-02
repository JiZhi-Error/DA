package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.websocket.e;
import com.tencent.mm.plugin.appbrand.s.k;
import com.tencent.mm.plugin.appbrand.s.l;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class g extends d {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";
    private k.c mgf;
    private boolean mgj = false;
    private boolean mgk = false;
    private final AtomicBoolean mgl = new AtomicBoolean(false);

    public g(k.c cVar) {
        AppMethodBeat.i(144243);
        this.mgf = cVar;
        AppMethodBeat.o(144243);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(144244);
        Log.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (!this.mgl.getAndSet(true) && this.mgf != null) {
            this.mgj = this.mgf.Uw(fVar.getAppId());
            k.c cVar = this.mgf;
            fVar.getAppId();
            this.mgk = cVar.btz();
        }
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiOperateSocketTask", "data is null");
            AppMethodBeat.o(144244);
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            fVar.i(i2, h("fail:taskId is null or nil", null));
            AppMethodBeat.o(144244);
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            fVar.i(i2, h("fail:operationType is null or nil", null));
            AppMethodBeat.o(144244);
            return;
        }
        com.tencent.mm.plugin.appbrand.jsapi.websocket.d adh = l.bPF().adh(fVar.getAppId());
        if (adh == null) {
            fVar.i(i2, h("fail:no task", null));
            Log.w("MicroMsg.JsApiOperateSocketTask", "client is null");
            AppMethodBeat.o(144244);
            return;
        }
        e aby = adh.aby(optString);
        if (aby == null) {
            fVar.i(i2, h("fail:taskID not exist", null));
            Log.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
            AppMethodBeat.o(144244);
        } else if (optString2.equals("close")) {
            int optInt = jSONObject.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, 1000);
            if (optInt == 1000 || (optInt >= 3000 && optInt < 5000)) {
                String optString3 = jSONObject.optString("reason", "");
                adh.a(aby, optInt, optString3);
                fVar.i(i2, h("ok", null));
                Log.i("MicroMsg.JsApiOperateSocketTask", "closeSocket taskId:%s, code %d, reason %s", optString, Integer.valueOf(optInt), optString3);
                AppMethodBeat.o(144244);
                return;
            }
            fVar.i(i2, h("fail:The code must be either 1000, or between 3000 and 4999", null));
            AppMethodBeat.o(144244);
        } else if (!optString2.equals("send")) {
            fVar.i(i2, h("fail:unknown operationType", null));
            Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:unknown operationType");
            AppMethodBeat.o(144244);
        } else if (!adh.b(aby)) {
            fVar.i(i2, h("fail:don't send before socket connected", null));
            Log.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", optString);
            AppMethodBeat.o(144244);
        } else {
            Object opt = jSONObject.opt("data");
            if (opt != null) {
                try {
                    if (opt instanceof ByteBuffer) {
                        Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", opt);
                        adh.a(aby, (ByteBuffer) opt);
                        ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(972, 4, 1, false);
                    } else if (opt instanceof String) {
                        Log.d("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                        adh.a(aby, (String) opt);
                        ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(972, 4, 1, false);
                    } else {
                        Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                        fVar.i(i2, h("fail:unknown data", null));
                        AppMethodBeat.o(144244);
                        return;
                    }
                    fVar.i(i2, h("ok", null));
                    AppMethodBeat.o(144244);
                } catch (Exception e2) {
                    fVar.i(i2, h("fail:" + e2.getMessage(), null));
                    if (this.mgj || this.mgk) {
                        ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(972, 6, 1, false);
                        AppMethodBeat.o(144244);
                        return;
                    }
                    ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(972, 5, 1, false);
                    AppMethodBeat.o(144244);
                }
            } else {
                fVar.i(i2, h("fail:message is null or nil", null));
                Log.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", opt);
                AppMethodBeat.o(144244);
            }
        }
    }
}

package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.x;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.music.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class n extends d {
    public static final int CTRL_INDEX = 481;
    public static final String NAME = "setInnerAudioOption";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145774);
        String appId = fVar.getAppId();
        Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "data:%s, appId:%s", jSONObject, appId);
        Log.i("MicroMsg.AudioPlayerHelper", "getAudioContextOption()");
        x xVar = new x();
        xVar.dCQ.action = 20;
        a.a(xVar);
        com.tencent.mm.ai.a aVar = xVar.dCR.dCU;
        if (aVar == null) {
            aVar = new com.tencent.mm.ai.a();
        }
        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(aVar.appId) && !appId.equalsIgnoreCase(aVar.appId)) {
            aVar.reset();
            Log.i("MicroMsg.Audio.JsApiSetInnerAudioOption", "reset AudioContextParam");
        }
        aVar.appId = appId;
        if (jSONObject.has("mixWithOther")) {
            aVar.iJC = jSONObject.optBoolean("mixWithOther", true);
        }
        if (jSONObject.has("speakerOn")) {
            aVar.dtE = jSONObject.optBoolean("speakerOn", true);
        }
        if (!aVar.dtE) {
            aVar.iJC = false;
        }
        Log.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", Boolean.valueOf(aVar.iJC));
        x xVar2 = new x();
        xVar2.dCQ.action = 19;
        xVar2.dCQ.dCU = aVar;
        a.a(xVar2);
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(145774);
    }
}

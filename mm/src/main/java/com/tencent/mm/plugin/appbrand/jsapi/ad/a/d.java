package com.tencent.mm.plugin.appbrand.jsapi.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d {
    public static final int CTRL_INDEX = 469;
    public static final String NAME = "getAvailableAudioSources";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137903);
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject != null ? jSONObject.toString() : "";
        Log.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", objArr);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(c.a.AUTO.mFO);
        arrayList.add(c.a.MIC.mFO);
        arrayList.add(c.a.CAMCORDER.mFO);
        arrayList.add(c.a.VOICE_RECOGNITION.mFO);
        arrayList.add(c.a.VOICE_COMMUNICATION.mFO);
        if (com.tencent.mm.compatible.util.d.oD(24)) {
            arrayList.add(c.a.UNPROCESSED.mFO);
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : arrayList) {
            jSONArray.put(str);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("audioSources", jSONArray);
        Log.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", hashMap.toString());
        fVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(137903);
    }
}

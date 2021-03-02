package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends ab<s> {
    public static final int CTRL_INDEX = 668;
    public static final String NAME = "isGameRecorderSupported";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(45160);
        Log.i("MicroMsg.WAGameJsApiScreenRecorderSupport", "hy: trigger call whether is support screen recording");
        HashMap hashMap = new HashMap(2);
        hashMap.put("isVolumeSupported", Boolean.TRUE);
        hashMap.put("isAtempoSupported", Boolean.TRUE);
        hashMap.put("isFrameSupported", Boolean.TRUE);
        hashMap.put("isSoundSupported", Boolean.FALSE);
        String n = n("ok", hashMap);
        AppMethodBeat.o(45160);
        return n;
    }
}

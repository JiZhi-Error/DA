package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends d {
    public static final int CTRL_INDEX = 535;
    public static final String NAME = "getVolume";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137672);
        Log.i("MicroMsg.JsApiGetVolume", "invoke JsApiGetVolume!");
        if (fVar == null) {
            Log.e("MicroMsg.JsApiGetVolume", "component is null");
            AppMethodBeat.o(137672);
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiGetVolume", "fail:context is null");
            fVar.i(i2, h("fail:context is null", null));
            AppMethodBeat.o(137672);
        } else if (!(context instanceof Activity)) {
            Log.e("MicroMsg.JsApiGetVolume", "fail:context is not Activity");
            fVar.i(i2, h("fail:context is not Activity", null));
            AppMethodBeat.o(137672);
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                Log.e("MicroMsg.JsApiGetVolume", "fail:manager is null");
                fVar.i(i2, h("fail:manager is null", null));
                AppMethodBeat.o(137672);
                return;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            Log.i("MicroMsg.JsApiGetVolume", "JsApiGetVolume %d/%d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
            HashMap hashMap = new HashMap();
            hashMap.put("currentVolume", Integer.valueOf(streamVolume));
            hashMap.put("maxVolume", Integer.valueOf(streamMaxVolume));
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(137672);
        }
    }
}

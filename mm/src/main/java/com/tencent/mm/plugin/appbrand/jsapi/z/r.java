package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class r extends d {
    public static final int CTRL_INDEX = 534;
    public static final String NAME = "setVolume";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137688);
        Log.i("MicroMsg.JsApiSetVolume", "invoke JsApiSetVolume!");
        if (fVar == null) {
            Log.e("MicroMsg.JsApiSetVolume", "fail:component is null");
            AppMethodBeat.o(137688);
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            Log.e("MicroMsg.JsApiSetVolume", "fail:context is null");
            fVar.i(i2, h("fail:context is null", null));
            AppMethodBeat.o(137688);
        } else if (!(context instanceof Activity)) {
            Log.e("MicroMsg.JsApiSetVolume", "fail:context is not Activity");
            fVar.i(i2, h("fail:context is not Activity", null));
            AppMethodBeat.o(137688);
        } else {
            AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null) {
                Log.e("MicroMsg.JsApiSetVolume", "fail:manager is null");
                fVar.i(i2, h("fail:manager is null", null));
                AppMethodBeat.o(137688);
                return;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            int optInt = jSONObject.optInt("value", streamVolume);
            Log.i("MicroMsg.JsApiSetVolume", "JsApiSetVolume value:%d, current:%d, max:%d", Integer.valueOf(optInt), Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
            if (optInt < 0) {
                streamMaxVolume = 0;
            } else if (optInt <= streamMaxVolume) {
                streamMaxVolume = optInt;
            }
            if (streamMaxVolume != streamVolume) {
                a.a(audioManager, 3, streamMaxVolume, 0);
                fVar.i(i2, h("ok", null));
                AppMethodBeat.o(137688);
                return;
            }
            fVar.i(i2, h("fail:volume does not change", null));
            AppMethodBeat.o(137688);
        }
    }
}

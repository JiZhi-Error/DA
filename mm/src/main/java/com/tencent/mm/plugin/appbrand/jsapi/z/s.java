package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.os.Vibrator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class s extends d {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137689);
        Log.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        if (fVar.getAppState() != b.kQH) {
            fVar.i(i2, h("fail:not allowed in background", null));
            AppMethodBeat.o(137689);
            return;
        }
        Vibrator vibrator = (Vibrator) fVar.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(137689);
    }
}

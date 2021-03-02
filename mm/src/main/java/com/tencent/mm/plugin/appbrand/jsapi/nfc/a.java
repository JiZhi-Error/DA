package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class a extends bc {
    private static final int CTRL_INDEX = 355;
    private static final String NAME = "onHCEMessage";
    private static final a mgR = new a();

    static {
        AppMethodBeat.i(136078);
        AppMethodBeat.o(136078);
    }

    static synchronized void a(f fVar, int i2, Bundle bundle) {
        synchronized (a.class) {
            AppMethodBeat.i(136077);
            Log.i("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", fVar.getAppId(), Integer.valueOf(i2));
            if (i2 == 31) {
                if (bundle != null) {
                    String string = bundle.getString("key_apdu_command");
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageType", 1);
                    hashMap.put("data", string);
                    mgR.h(fVar).L(hashMap).bEo();
                    AppMethodBeat.o(136077);
                }
                AppMethodBeat.o(136077);
            } else {
                if (i2 == 41 && bundle != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("messageType", 2);
                    hashMap2.put("reason", Integer.valueOf(bundle.getInt("key_on_deactivated_reason")));
                    mgR.h(fVar).L(hashMap2).bEo();
                }
                AppMethodBeat.o(136077);
            }
        }
    }
}

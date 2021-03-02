package com.tencent.mm.plugin.appbrand.jsapi.y;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class e extends ab {
    public static final int CTRL_INDEX = 472;
    public static final String NAME = "enableDeviceOrientationChangeListening";
    protected ad mqA;
    private ad.b mqB = new ad.b() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.y.e.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.utils.ad.b
        public final void a(ad.a aVar, final ad.a aVar2) {
            AppMethodBeat.i(137633);
            Log.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.y.e.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(137632);
                    h.c(aVar2);
                    AppMethodBeat.o(137632);
                }
            }, 500);
            AppMethodBeat.o(137633);
        }
    };
    private boolean mqz = false;

    public e() {
        AppMethodBeat.i(137634);
        AppMethodBeat.o(137634);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(137635);
        if (jSONObject.optBoolean("enable", false)) {
            h.A(fVar);
            if (!this.mqz) {
                this.mqA = new ad(fVar.getContext(), this.mqB);
                this.mqA.enable();
                this.mqz = true;
            }
        } else {
            h.B(fVar);
            if (this.mqz) {
                this.mqA.disable();
                this.mqA = null;
                this.mqz = false;
            }
        }
        String h2 = h("ok", null);
        AppMethodBeat.o(137635);
        return h2;
    }
}

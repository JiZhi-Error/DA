package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningMonitor;
import com.tencent.mm.plugin.appbrand.backgroundrunning.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class i extends j {
    private static final int CTRL_INDEX = 586;
    private static final String NAME = "enableLocationUpdateBackground";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.j, com.tencent.mm.plugin.appbrand.jsapi.i.h, com.tencent.mm.plugin.appbrand.jsapi.i.a
    public final /* synthetic */ void d(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46380);
        b(sVar, jSONObject, i2);
        AppMethodBeat.o(46380);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.h
    public final /* synthetic */ Bundle g(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(46379);
        Bundle bundle = new Bundle();
        String optString = jSONObject.optString("subKey", "");
        String appId = sVar.getAppId();
        if (!Util.isNullOrNil(optString)) {
            bundle.putString("smallAppKey", optString + "#" + appId + ";");
        }
        bundle.putBoolean("enableIndoor", jSONObject.optBoolean("enableIndoor", false));
        Log.v("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationUpdate %s", jSONObject);
        AppMethodBeat.o(46379);
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public static class a implements k<IPCVoid, IPCInteger> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ IPCInteger invoke(IPCVoid iPCVoid) {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(46377);
            if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null) {
                for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : ((com.tencent.mm.plugin.appbrand.backgroundrunning.g) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).byZ()) {
                    if (c.contains(appBrandBackgroundRunningApp.beL, c.kYp.beL)) {
                        i2 = i3 + 1;
                    } else {
                        i2 = i3;
                    }
                    i3 = i2;
                }
                IPCInteger iPCInteger = new IPCInteger(i3);
                AppMethodBeat.o(46377);
                return iPCInteger;
            }
            IPCInteger iPCInteger2 = new IPCInteger(0);
            AppMethodBeat.o(46377);
            return iPCInteger2;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.j
    public final void b(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46378);
        this.lXb = (s) sVar.aw(s.class);
        if (this.lXb instanceof t) {
            t tVar = (t) this.lXb;
            if (tVar.kYn && tVar.lXu) {
                Log.i("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "already in location background mode");
                sVar.i(i2, h("ok", null));
                AppMethodBeat.o(46378);
                return;
            }
        }
        IPCInteger iPCInteger = (IPCInteger) XIPCInvoker.a(MainProcessIPCService.dkO, new IPCVoid(), a.class);
        AppBrandGlobalSystemConfig bzP = AppBrandGlobalSystemConfig.bzP();
        if (iPCInteger == null || iPCInteger.value < bzP.lcK) {
            super.b(sVar, jSONObject, i2);
            if (!(this.lXb instanceof t)) {
                Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "state manager not RuntimeLocationUpdateStateManagerWxa");
                sVar.i(i2, h("fail:system error", null));
                AppMethodBeat.o(46378);
                return;
            }
            if (this.lXb != null && this.lXb.lXu) {
                AppBrandBackgroundRunningMonitor.a(sVar, 1, c.kYp.beL);
            }
            AppMethodBeat.o(46378);
            return;
        }
        Log.w("MicroMsg.JsApiEnableLocationUpdateBackgroundWxImp", "enableLocationBackground: fail reach max concurrent background count");
        sVar.i(i2, h("fail reach max concurrent background count", null));
        AppMethodBeat.o(46378);
    }
}

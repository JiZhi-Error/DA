package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiNavigateToDevMiniProgram;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchMiniProgram;", "()V", "dispatchInJsThread", "", "onNavigationWillPerform", "service", "Lcom/tencent/luggage/sdk/jsapi/component/service/AppBrandServiceLU;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class e extends f {
    public static final int CTRL_INDEX = 967;
    public static final String NAME = "launchDevMiniProgram";
    public static final a meQ = new a((byte) 0);

    static {
        AppMethodBeat.i(228429);
        AppMethodBeat.o(228429);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiLaunchDevMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final boolean bEa() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f
    public final boolean a(d dVar, JSONObject jSONObject, int i2) {
        IPCVoid iPCVoid;
        boolean z;
        AppMethodBeat.i(228428);
        p.h(dVar, "service");
        p.h(jSONObject, "data");
        String optString = jSONObject.optString("appId");
        b a2 = b.a(jSONObject.optString("envVersion"), b.RELEASE);
        String optString2 = jSONObject.optString("downloadURL");
        String optString3 = jSONObject.optString("checkSumMd5");
        String optString4 = jSONObject.optString("extoptions");
        if (b.DEVELOP == a2) {
            String str = optString3;
            if (!(str == null || str.length() == 0)) {
                JsApiNavigateToDevMiniProgram.DevPkgInfo devPkgInfo = new JsApiNavigateToDevMiniProgram.DevPkgInfo();
                devPkgInfo.appId = optString;
                devPkgInfo.ecN = optString2;
                devPkgInfo.ecO = optString3;
                devPkgInfo.meX = optString4;
                try {
                    iPCVoid = (IPCVoid) XIPCInvoker.a(MainProcessIPCService.dkO, devPkgInfo, JsApiNavigateToDevMiniProgram.a.class);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrand.JsApiLaunchDevMiniProgram", "invoke IPCFlushDevPkg, parcel:" + devPkgInfo + ", exception:" + e2);
                    iPCVoid = null;
                }
                if (iPCVoid != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    dVar.i(i2, "fail save packageInfo failed");
                    AppMethodBeat.o(228428);
                    return false;
                }
            }
        }
        AppMethodBeat.o(228428);
        return true;
    }
}

package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiMarkScene;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandSyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "invoke", "", "service", "data", "Lorg/json/JSONObject;", "Companion", "plugin-appbrand-integration_release"})
public final class bq extends ab<c> {
    public static final int CTRL_INDEX = 651;
    public static final String NAME = "markScene";
    public static final a lAA = new a((byte) 0);

    static {
        AppMethodBeat.i(50405);
        AppMethodBeat.o(50405);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(c cVar, JSONObject jSONObject) {
        int i2 = -1;
        AppMethodBeat.i(50404);
        c cVar2 = cVar;
        if (!cVar2.isRunning()) {
            Log.i("MicroMsg.JsApiMarkScene", "Service dead, miss");
            String Zf = Zf("fail:service dead");
            p.g(Zf, "makeReturnJson(\"fail:service dead\")");
            AppMethodBeat.o(50404);
            return Zf;
        }
        QualitySessionRuntime aeU = b.aeU(cVar2.getAppId());
        if (aeU == null) {
            String Zf2 = Zf("fail:session dead");
            p.g(Zf2, "makeReturnJson(\"fail:session dead\")");
            AppMethodBeat.o(50404);
            return Zf2;
        }
        p.g(aeU, "AppBrandQualitySystem.ge…Json(\"fail:session dead\")");
        if (jSONObject != null) {
            i2 = jSONObject.optInt("sceneId", -1);
        }
        if (i2 < 0) {
            Log.i("MicroMsg.JsApiMarkScene", "parameter fail ".concat(String.valueOf(i2)));
            String Zf3 = Zf("fail:illegal argument");
            p.g(Zf3, "makeReturnJson(\"fail:illegal argument\")");
            AppMethodBeat.o(50404);
            return Zf3;
        }
        aeU.nLx.set(i2);
        if (DebuggerShell.bAx() && i2 == 0) {
            b.bUZ();
            com.tencent.mm.plugin.appbrand.report.quality.c.aeV(cVar2.getAppId());
        }
        String Zf4 = Zf("ok");
        p.g(Zf4, "makeReturnJson(\"ok\")");
        AppMethodBeat.o(50404);
        return Zf4;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiMarkScene$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

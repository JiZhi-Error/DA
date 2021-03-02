package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class a extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 646;
    public static final String NAME = "navigateBackNative";
    @Deprecated
    public static final C0683a mfV = new C0683a((byte) 0);

    static {
        AppMethodBeat.i(50629);
        AppMethodBeat.o(50629);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.a$a  reason: collision with other inner class name */
    public static final class C0683a {
        private C0683a() {
        }

        public /* synthetic */ C0683a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(228432);
        c.aem(NAME);
        AppMethodBeat.o(228432);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(50628);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(50628);
        } else if (dVar2.getRuntime() == null) {
            AppMethodBeat.o(50628);
        } else if (jSONObject == null) {
            AppMethodBeat.o(50628);
        } else {
            String optString = jSONObject.optString("extraData");
            AppBrandRuntime runtime = dVar2.getRuntime();
            p.g(runtime, "env.runtime");
            AppBrandInitConfig OU = runtime.OU();
            if (!(OU instanceof AppBrandInitConfigLU)) {
                OU = null;
            }
            AppBrandInitConfigLU appBrandInitConfigLU = (AppBrandInitConfigLU) OU;
            com.tencent.luggage.sdk.launching.a<?> aVar = appBrandInitConfigLU != null ? appBrandInitConfigLU.cyx : null;
            com.tencent.luggage.sdk.launching.a<?> aVar2 = !(aVar instanceof com.tencent.luggage.sdk.launching.a) ? null : aVar;
            AppBrandRuntime runtime2 = dVar2.getRuntime();
            p.g(runtime2, "env.runtime");
            runtime2.brl().a(new b(this, dVar2, i2, jSONObject, aVar2, optString));
            dVar2.getRuntime().close();
            AppMethodBeat.o(50628);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/native_navigator/JsApiNavigateBackNative$invoke$1", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningStateController$OnRunningStateChangedListener;", "onRunningStateChanged", "", "appId", "", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "plugin-appbrand-integration_release"})
    public static final class b implements c.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ JSONObject lFq;
        final /* synthetic */ int lyo;
        final /* synthetic */ a mfW;
        final /* synthetic */ com.tencent.luggage.sdk.launching.a mfX;
        final /* synthetic */ String mfY;

        b(a aVar, com.tencent.mm.plugin.appbrand.d dVar, int i2, JSONObject jSONObject, com.tencent.luggage.sdk.launching.a aVar2, String str) {
            this.mfW = aVar;
            this.lBv = dVar;
            this.lyo = i2;
            this.lFq = jSONObject;
            this.mfX = aVar2;
            this.mfY = str;
        }

        @Override // com.tencent.mm.plugin.appbrand.a.c.a
        public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
            AppMethodBeat.i(228431);
            p.h(str, "appId");
            p.h(bVar, "state");
            if (com.tencent.mm.plugin.appbrand.a.b.BACKGROUND == bVar) {
                AppBrandRuntime runtime = this.lBv.getRuntime();
                p.g(runtime, "env.runtime");
                runtime.brl().b(this);
                MMHandlerThread.postToMainThread(new RunnableC0684a(this));
            }
            AppMethodBeat.o(228431);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.n.a$b$a  reason: collision with other inner class name */
        static final class RunnableC0684a implements Runnable {
            final /* synthetic */ b mfZ;

            RunnableC0684a(b bVar) {
                this.mfZ = bVar;
            }

            public final void run() {
                AppMethodBeat.i(228430);
                try {
                    C0683a unused = a.mfV;
                    Log.i("MicroMsg.AppBrand.JsApiNavigateBackNative", "invoke onWXAppResult, appId:" + this.mfZ.lBv.getAppId() + ", callbackId:" + this.mfZ.lyo + " data:" + this.mfZ.lFq);
                    com.tencent.luggage.sdk.launching.a aVar = this.mfZ.mfX;
                    if (aVar != null) {
                        aVar.b(new IPCString(this.mfZ.mfY));
                    }
                    this.mfZ.lBv.i(this.mfZ.lyo, this.mfZ.mfW.Zf("ok"));
                    AppMethodBeat.o(228430);
                } catch (Exception e2) {
                    this.mfZ.lBv.i(this.mfZ.lyo, this.mfZ.mfW.Zf("fail " + e2.getMessage()));
                    AppMethodBeat.o(228430);
                }
            }
        }
    }
}

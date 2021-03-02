package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.a.ae;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "IPC_PreloadNextGame", "PreloadType", "plugin-appbrand-integration_release"})
public final class cz extends d<com.tencent.mm.plugin.appbrand.d> {
    public static final int CTRL_INDEX = 644;
    public static final String NAME = "preloadMiniProgramEnv";
    @Deprecated
    public static final a lCx = new a((byte) 0);

    static {
        AppMethodBeat.i(50418);
        AppMethodBeat.o(50418);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.d dVar, JSONObject jSONObject, int i2) {
        c cVar;
        AppMethodBeat.i(50417);
        com.tencent.mm.plugin.appbrand.d dVar2 = dVar;
        if (dVar2 == null) {
            AppMethodBeat.o(50417);
        } else if (jSONObject == null) {
            AppMethodBeat.o(50417);
        } else {
            c.a aVar = c.lCD;
            String optString = jSONObject.optString("type");
            if (optString != null) {
                c[] values = c.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    cVar = values[i3];
                    if (n.I(optString, cVar.name(), true)) {
                        break;
                    }
                    i3++;
                }
            }
            cVar = c.APP;
            g gVar = cVar.lCC;
            if (AppBrandRuntimeWCAccessible.d(dVar2) && gVar == g.WAGAME) {
                XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, b.class, null);
                dVar2.i(i2, Zf("ok"));
                AppMethodBeat.o(50417);
            } else if (e.l(gVar)) {
                int iF = com.tencent.mm.plugin.appbrand.task.preload.e.iF(AppBrandRuntimeWCAccessible.d(dVar2));
                h.INSTANCE.dN(iF, z.WXA_JSAPI_PRELOAD.nMT);
                e.a(gVar, (e.b) new d(this, gVar, iF, dVar2, i2), true);
                AppMethodBeat.o(50417);
            } else if (e.k(gVar)) {
                dVar2.i(i2, n("ok", ae.b(new o("alreadyExist", Boolean.TRUE))));
                AppMethodBeat.o(50417);
            } else {
                dVar2.i(i2, Zf("fail internal error"));
                AppMethodBeat.o(50417);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "", "serviceType", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;)V", "getServiceType", "()Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "APP", "GAME", "Companion", "plugin-appbrand-integration_release"})
    enum c {
        APP(g.WASERVICE),
        GAME(g.WAGAME);
        
        public static final a lCD = new a((byte) 0);
        final g lCC;

        public static c valueOf(String str) {
            AppMethodBeat.i(50415);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(50415);
            return cVar;
        }

        private c(g gVar) {
            this.lCC = gVar;
        }

        static {
            AppMethodBeat.i(50413);
            AppMethodBeat.o(50413);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType$Companion;", "", "()V", "safeValueOf", "Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$PreloadType;", "name", "", "plugin-appbrand-integration_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onReady"})
    static final class d implements e.b {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.d lBv;
        final /* synthetic */ cz lCE;
        final /* synthetic */ g lCF;
        final /* synthetic */ int lCG;
        final /* synthetic */ int lyo;

        d(cz czVar, g gVar, int i2, com.tencent.mm.plugin.appbrand.d dVar, int i3) {
            this.lCE = czVar;
            this.lCF = gVar;
            this.lCG = i2;
            this.lBv = dVar;
            this.lyo = i3;
        }

        @Override // com.tencent.mm.plugin.appbrand.task.e.b
        public final void onReady() {
            AppMethodBeat.i(50416);
            boolean z = e.j(this.lCF) != null;
            a unused = cz.lCx;
            Log.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "onReady, preloaded[" + z + ']');
            if (z) {
                h.INSTANCE.dN(this.lCG, z.WXA_JSAPI_PRELOAD.nMU);
                this.lBv.i(this.lyo, this.lCE.Zf("ok"));
                AppMethodBeat.o(50416);
                return;
            }
            this.lBv.i(this.lyo, this.lCE.Zf("fail"));
            AppMethodBeat.o(50416);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J#\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/PrivateJSApiPreloadMiniProgramEnv$IPC_PreloadNextGame;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
    static final class b implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            public static final a lCy = new a();

            static {
                AppMethodBeat.i(50411);
                AppMethodBeat.o(50411);
            }

            a() {
                super(0);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(50410);
                a unused = cz.lCx;
                Log.i("MicroMsg.AppBrand.PrivateJSApiPreloadMiniProgramEnv", "IPC_PreloadNextGame.invoke()");
                com.tencent.mm.plugin.appbrand.task.h.bWb().a(g.WAGAME, z.WXA_JSAPI_PRELOAD);
                x xVar = x.SXb;
                AppMethodBeat.o(50410);
                return xVar;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(50412);
            com.tencent.mm.ac.d.h(a.lCy);
            AppMethodBeat.o(50412);
        }
    }
}

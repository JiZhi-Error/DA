package com.tencent.mm.plugin.appbrand.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.appbrand.v8.w;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ag.c;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.s;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC;", "Lcom/tencent/mm/plugin/appbrand/worker/V8EngineWorkerManagerLU;", "client", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;", "(Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManagerClient;)V", "getPackageMd5", "", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentImpl;", "getWasmCachePath", "reportEvaluateResult", "", "item", "Lcom/tencent/mm/appbrand/v8/V8EngineWorkerManager$WorkerEvaluateDescriptor;", "startTimeMs", "", "endTimeMs", "Companion", "plugin-appbrand-integration_release"})
public final class d extends c {
    public static final a oFw = new a((byte) 0);

    static {
        AppMethodBeat.i(229693);
        AppMethodBeat.o(229693);
    }

    public d(w wVar) {
        super(wVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ag.c
    public final String a(g gVar) {
        AppMethodBeat.i(229690);
        p.h(gVar, "component");
        if (gVar instanceof s) {
            AppBrandRuntime runtime = ((s) gVar).getRuntime();
            p.g(runtime, "component.runtime");
            String str = runtime.OT().leE.md5;
            p.g(str, "component.runtime.sysConfig.appPkgInfo.md5");
            AppMethodBeat.o(229690);
            return str;
        }
        AppMethodBeat.o(229690);
        return "";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ag.c
    public final String OB() {
        AppMethodBeat.i(229691);
        String bDt = af.bDt();
        p.g(bDt, "V8WasmCachePathRetriever.retrieve()");
        AppMethodBeat.o(229691);
        return bDt;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ag.c
    public final void a(v.a aVar) {
        AppMethodBeat.i(229692);
        p.h(aVar, "item");
        String str = aVar.filePath;
        p.g(str, "item.filePath");
        if (!n.nm(str, "WAWorker.js")) {
            AppMethodBeat.o(229692);
            return;
        }
        c.a aVar2 = (c.a) aVar;
        q TQ = com.tencent.mm.plugin.appbrand.a.TQ(aVar2.appId);
        if (TQ == null || TQ.isDestroyed()) {
            AppMethodBeat.o(229692);
            return;
        }
        b.bUZ().r(aVar2.oFv, aVar2.appId).zy("WAWorker.js").vZ((long) aVar2.script.length()).zz(TQ.bqZ().bvb()).ajg().bfK();
        AppMethodBeat.o(229692);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/worker/V8WorkerManagerWC$Companion;", "", "()V", "LIB_SCRIPT_NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

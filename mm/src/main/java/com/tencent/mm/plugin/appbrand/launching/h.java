package com.tencent.mm.plugin.appbrand.launching;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\r\u001a\u00020\u000b2\u001c\u0010\u000e\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\fH\u0002J\u0006\u0010\u000f\u001a\u00020\u000bR*\u0010\u0007\u001a\u001e\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\tj\u0002`\f0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimePostResourcePreparedJobsBatchRun;", "", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "process", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime$PrepareProcess;)V", "actions", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lcom/tencent/mm/plugin/appbrand/launching/PostPreparedAction;", "addAction", NativeProtocol.WEB_DIALOG_ACTION, "run", "Companion", "plugin-appbrand-integration_release"})
public final class h {
    public static final a mRI = new a((byte) 0);
    private final q kFk;
    public final LinkedList<kotlin.g.a.b<kotlin.g.a.a<x>, x>> mRG = new LinkedList<>();
    public final AppBrandRuntime.b mRH;

    static {
        AppMethodBeat.i(228618);
        AppMethodBeat.o(228618);
    }

    public h(q qVar, AppBrandRuntime.b bVar) {
        p.h(qVar, "rt");
        p.h(bVar, "process");
        AppMethodBeat.i(50755);
        this.kFk = qVar;
        this.mRH = bVar;
        if (this.kFk.NA() && ((com.tencent.mm.plugin.appbrand.performance.a) this.kFk.av(com.tencent.mm.plugin.appbrand.performance.a.class)).nwA) {
            x(AnonymousClass1.mRJ);
        }
        Log.i("MicroMsg.AppBrandRuntimePostResourcePreparedJobsBatchRun[AppBrandSplashAd]", "app(" + this.kFk.getAppId() + ") mayShowSplashAdWhenLaunch:" + this.kFk.brL() + ", isCheckShowAdPrepareProcessReady:" + this.kFk.bsI());
        if (!this.kFk.brL() || this.kFk.bsI()) {
            Log.i("MicroMsg.AppBrandRuntimePostResourcePreparedJobsBatchRun[AppBrandSplashAd]", "app(" + this.kFk.getAppId() + ") add prepare orientation action");
            x(new kotlin.g.a.b<kotlin.g.a.a<? extends x>, x>(this) {
                /* class com.tencent.mm.plugin.appbrand.launching.h.AnonymousClass2 */
                final /* synthetic */ h mRK;

                {
                    this.mRK = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(kotlin.g.a.a<? extends x> aVar) {
                    AppMethodBeat.i(50751);
                    kotlin.g.a.a<? extends x> aVar2 = aVar;
                    p.h(aVar2, "cb");
                    this.mRK.kFk.S(new i(aVar2));
                    x xVar = x.SXb;
                    AppMethodBeat.o(50751);
                    return xVar;
                }
            });
            AppMethodBeat.o(50755);
            return;
        }
        Log.i("MicroMsg.AppBrandRuntimePostResourcePreparedJobsBatchRun[AppBrandSplashAd]", "app(" + this.kFk.getAppId() + ") do not add prepare orientation action");
        AppMethodBeat.o(50755);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/AppBrandRuntimePostResourcePreparedJobsBatchRun$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final void x(kotlin.g.a.b<? super kotlin.g.a.a<x>, x> bVar) {
        AppMethodBeat.i(50754);
        this.mRG.add(bVar);
        AppMethodBeat.o(50754);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ h mRK;

        public c(h hVar) {
            this.mRK = hVar;
        }

        public final void run() {
            AppMethodBeat.i(50753);
            this.mRK.mRH.KY();
            AppMethodBeat.o(50753);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ k mRL;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k kVar) {
            super(0);
            this.mRL = kVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(50752);
            this.mRL.countDown();
            x xVar = x.SXb;
            AppMethodBeat.o(50752);
            return xVar;
        }
    }
}

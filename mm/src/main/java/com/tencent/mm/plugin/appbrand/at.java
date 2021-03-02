package com.tencent.mm.plugin.appbrand;

import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.f.i.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B'\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/RemoteLoader;", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "data", "Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;", "callback", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "(Lcom/tencent/mm/plugin/appbrand/BindRemoteServiceData;Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "loaderId", "", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;ILcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;)V", "getKey", "", "run", "", "Companion", "plugin-appbrand-integration_release"})
public final class at implements h {
    @Deprecated
    public static final a kFo = new a((byte) 0);
    private final AppBrandStatObject kEH;
    private final int kEI;
    private final com.tencent.mm.plugin.appbrand.api.f kEZ;
    private final AppBrandInitConfigWC kFn;

    static {
        AppMethodBeat.i(227949);
        AppMethodBeat.o(227949);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"callbackOnPreRenderComplete", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<q, x> {
        final /* synthetic */ at kFq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(at atVar) {
            super(1);
            this.kFq = atVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(q qVar) {
            AppMethodBeat.i(227936);
            q(qVar);
            x xVar = x.SXb;
            AppMethodBeat.o(227936);
            return xVar;
        }

        public final void q(q qVar) {
            AppMethodBeat.i(227937);
            p.h(qVar, "$this$callbackOnPreRenderComplete");
            ak bri = qVar.bri();
            if (!(bri instanceof AppBrandRuntimeContainerWC)) {
                bri = null;
            }
            AppBrandRuntimeContainerWC appBrandRuntimeContainerWC = (AppBrandRuntimeContainerWC) bri;
            boolean z = appBrandRuntimeContainerWC != null && appBrandRuntimeContainerWC.bsd();
            a unused = at.kFo;
            StringBuilder append = new StringBuilder("run() callbackOnPreRenderComplete id:").append(this.kFq.kEI).append(", appId:").append(qVar.getAppId()).append(", instanceId:");
            AppBrandInitConfigWC bsC = qVar.bsC();
            p.g(bsC, "rt.initConfig");
            Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", append.append(bsC.NC()).append(", hasResumedContainer:").append(z).toString());
            if (z) {
                com.tencent.mm.plugin.appbrand.api.f fVar = this.kFq.kEZ;
                if (fVar != null) {
                    f.a.a(fVar, -2);
                    AppMethodBeat.o(227937);
                    return;
                }
                AppMethodBeat.o(227937);
                return;
            }
            qVar.dispatchPause();
            k.c(qVar);
            com.tencent.mm.plugin.appbrand.api.f fVar2 = this.kFq.kEZ;
            if (fVar2 != null) {
                fVar2.onSuccess();
                AppMethodBeat.o(227937);
                return;
            }
            AppMethodBeat.o(227937);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"waitForRuntimeInitReady", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<q, x> {
        final /* synthetic */ at kFq;
        final /* synthetic */ c kFr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(at atVar, c cVar) {
            super(1);
            this.kFq = atVar;
            this.kFr = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(q qVar) {
            AppMethodBeat.i(227940);
            q(qVar);
            x xVar = x.SXb;
            AppMethodBeat.o(227940);
            return xVar;
        }

        public final void q(final q qVar) {
            AppMethodBeat.i(227941);
            p.h(qVar, "$this$waitForRuntimeInitReady");
            a unused = at.kFo;
            Log.i("MicroMsg.AppBrandPreRenderColdStartService.RemoteLoader", "run() waitForRuntimeInitReady id:" + this.kFq.kEI + ", appId:" + qVar.getAppId() + ", instanceId:" + this.kFq.kFn.NC());
            qVar.a(new aq(this) {
                /* class com.tencent.mm.plugin.appbrand.at.d.AnonymousClass1 */
                final /* synthetic */ d kFs;

                {
                    this.kFs = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.aq
                public final void btr() {
                    AppMethodBeat.i(227938);
                    this.kFs.kFr.q(qVar);
                    AppMethodBeat.o(227938);
                }
            });
            qVar.a(new aw(this) {
                /* class com.tencent.mm.plugin.appbrand.at.d.AnonymousClass2 */
                final /* synthetic */ d kFs;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.kFs = r1;
                }

                @Override // com.tencent.mm.plugin.appbrand.aw
                public final void btt() {
                }

                @Override // com.tencent.mm.plugin.appbrand.aw
                public final void btu() {
                }

                @Override // com.tencent.mm.plugin.appbrand.aw
                public final void bru() {
                }

                @Override // com.tencent.mm.plugin.appbrand.aw
                public final void Uu(String str) {
                    AppMethodBeat.i(227939);
                    com.tencent.mm.plugin.appbrand.api.f fVar = this.kFs.kFq.kEZ;
                    if (fVar != null) {
                        f.a.a(fVar, -7);
                        AppMethodBeat.o(227939);
                        return;
                    }
                    AppMethodBeat.o(227939);
                }
            });
            qVar.brd();
            com.tencent.mm.plugin.appbrand.platform.window.c windowAndroid = qVar.getWindowAndroid();
            if (windowAndroid == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.platform.window.fake.PreRenderCustomWindowAndroid");
                AppMethodBeat.o(227941);
                throw tVar;
            }
            DisplayMetrics vDisplayMetrics = ((com.tencent.mm.plugin.appbrand.platform.window.b.a) windowAndroid).getVDisplayMetrics();
            qVar.brj().measure(View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(vDisplayMetrics.heightPixels, Integer.MIN_VALUE));
            AppMethodBeat.o(227941);
        }
    }

    private at(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject, int i2, com.tencent.mm.plugin.appbrand.api.f fVar) {
        p.h(appBrandInitConfigWC, "config");
        p.h(appBrandStatObject, "stat");
        AppMethodBeat.i(227947);
        this.kFn = appBrandInitConfigWC;
        this.kEH = appBrandStatObject;
        this.kEI = i2;
        this.kEZ = fVar;
        AppMethodBeat.o(227947);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/RemoteLoader$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.f.i.h, com.tencent.f.i.g
    public final String getKey() {
        AppMethodBeat.i(227945);
        String str = "AppBrandPreRenderColdStartService.RemoteLoader-" + this.kEI;
        AppMethodBeat.o(227945);
        return str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x010d, code lost:
        if (r0.getStackSize() <= 1) goto L_0x010f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 599
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.at.run():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        public static final b kFp = new b();

        static {
            AppMethodBeat.i(227935);
            AppMethodBeat.o(227935);
        }

        b() {
        }

        public final void run() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onReady"})
    static final class e implements i.f {
        final /* synthetic */ c kFr;
        final /* synthetic */ q kFu;

        e(c cVar, q qVar) {
            this.kFr = cVar;
            this.kFu = qVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.f
        public final void onReady() {
            AppMethodBeat.i(227943);
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.at.e.AnonymousClass1 */
                final /* synthetic */ e kFv;

                {
                    this.kFv = r1;
                }

                public final void run() {
                    AppMethodBeat.i(227942);
                    this.kFv.kFr.q(this.kFv.kFu);
                    AppMethodBeat.o(227942);
                }
            });
            AppMethodBeat.o(227943);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ c kFr;
        final /* synthetic */ q kFu;

        f(c cVar, q qVar) {
            this.kFr = cVar;
            this.kFu = qVar;
        }

        public final void run() {
            AppMethodBeat.i(227944);
            this.kFr.q(this.kFu);
            AppMethodBeat.o(227944);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public at(BindRemoteServiceData bindRemoteServiceData, com.tencent.mm.plugin.appbrand.api.f fVar) {
        this(bindRemoteServiceData.kEG, bindRemoteServiceData.kEH, bindRemoteServiceData.kEI, fVar);
        p.h(bindRemoteServiceData, "data");
        AppMethodBeat.i(227948);
        AppMethodBeat.o(227948);
    }
}

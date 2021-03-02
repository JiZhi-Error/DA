package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J+\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00018\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\u001c\u0010\u001e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0017\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0$H\bR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/LaunchPrepareCallbackWrapper;", "C", "Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "referenced", "(Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask$PrepareCallback;)V", "mDead", "", "mReferenced", "dead", "", "onDataTransferState", "state", "", "onDownloadProcess", "progress", "onDownloadStarted", "startTime", "", "onLaunchTimeoutFallbackReloadRequested", "onPrepareDone", "config", "errorAction", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;", "startupPerformanceReport", "Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;", "(Lcom/tencent/luggage/sdk/config/AppBrandSysConfigLU;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandLaunchErrorAction;Lcom/tencent/mm/plugin/appbrand/launching/AppStartupPerformanceReportBundle;)V", "onSyncJsApiInfoStart", "onSyncLaunchStart", "onVersionUpdateEvent", "Lcom/tencent/mm/plugin/appbrand/jsapi/version/UpdateState;", "passThroughInfo", "", "tryOrThrows", "block", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
public final class al<C extends AppBrandSysConfigLU> implements AppBrandPrepareTask.b<C>, a {
    private volatile boolean kBu;
    private volatile AppBrandPrepareTask.b<C> mVF;

    public al(AppBrandPrepareTask.b<C> bVar) {
        p.h(bVar, "referenced");
        AppMethodBeat.i(50765);
        Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "<init> hash=" + hashCode());
        this.mVF = bVar;
        AppMethodBeat.o(50765);
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.q
    public final void vy(int i2) {
        AppMethodBeat.i(50759);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.vy(i2);
                AppMethodBeat.o(50759);
                return;
            }
            AppMethodBeat.o(50759);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(50759);
                return;
            }
            AppMethodBeat.o(50759);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void a(C c2, AppBrandLaunchErrorAction appBrandLaunchErrorAction, AppStartupPerformanceReportBundle appStartupPerformanceReportBundle) {
        AppMethodBeat.i(50760);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.a(c2, appBrandLaunchErrorAction, appStartupPerformanceReportBundle);
                AppMethodBeat.o(50760);
                return;
            }
            AppMethodBeat.o(50760);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(50760);
                return;
            }
            AppMethodBeat.o(50760);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void AW(long j2) {
        AppMethodBeat.i(50761);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.AW(j2);
                AppMethodBeat.o(50761);
                return;
            }
            AppMethodBeat.o(50761);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(50761);
                return;
            }
            AppMethodBeat.o(50761);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void vz(int i2) {
        AppMethodBeat.i(50762);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.vz(i2);
                AppMethodBeat.o(50762);
                return;
            }
            AppMethodBeat.o(50762);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(50762);
                return;
            }
            AppMethodBeat.o(50762);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void a(b bVar, String str) {
        AppMethodBeat.i(228695);
        try {
            AppBrandPrepareTask.b<C> bVar2 = this.mVF;
            if (bVar2 != null) {
                bVar2.a(bVar, str);
                AppMethodBeat.o(228695);
                return;
            }
            AppMethodBeat.o(228695);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(228695);
                return;
            }
            AppMethodBeat.o(228695);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void bsQ() {
        AppMethodBeat.i(50764);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.bsQ();
                AppMethodBeat.o(50764);
                return;
            }
            AppMethodBeat.o(50764);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(50764);
                return;
            }
            AppMethodBeat.o(50764);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void bsR() {
        AppMethodBeat.i(228696);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.bsR();
                AppMethodBeat.o(228696);
                return;
            }
            AppMethodBeat.o(228696);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(228696);
                return;
            }
            AppMethodBeat.o(228696);
            throw th;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask.b
    public final void bsS() {
        AppMethodBeat.i(228697);
        try {
            AppBrandPrepareTask.b<C> bVar = this.mVF;
            if (bVar != null) {
                bVar.bsS();
                AppMethodBeat.o(228697);
                return;
            }
            AppMethodBeat.o(228697);
        } catch (Throwable th) {
            if (this.kBu) {
                Log.w("MicroMsg.LaunchPrepareCallbackWrapper", "tryOfThrows when dead, get exception: " + android.util.Log.getStackTraceString(th));
                AppMethodBeat.o(228697);
                return;
            }
            AppMethodBeat.o(228697);
            throw th;
        }
    }

    @Override // com.tencent.mm.vending.e.a
    public final void dead() {
        AppMethodBeat.i(180618);
        Log.i("MicroMsg.LaunchPrepareCallbackWrapper", "dead() hash=" + hashCode());
        this.mVF = null;
        this.kBu = true;
        AppMethodBeat.o(180618);
    }
}

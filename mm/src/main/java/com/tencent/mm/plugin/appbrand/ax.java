package com.tencent.mm.plugin.appbrand;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.i;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask;
import com.tencent.mm.plugin.appbrand.launching.AppBrandPrepareTask;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.report.AppBrandRuntimeReloadReportBundle;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPreInitTask$PreInitCallback;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;)V", "TAG", "", "mCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancel", "", "onResult", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "Companion", "plugin-appbrand-integration_release"})
public final class ax implements AppBrandPreInitTask.a {
    public static final a kFF = new a((byte) 0);
    private final String TAG = ("MicroMsg.AppBrand.RuntimeLaunchTimeoutFallbackReloadTask[" + this.kFk.getAppId() + '|' + this.kFk.hashCode() + ']');
    final AtomicBoolean kFD = new AtomicBoolean(false);
    private final AppBrandPrepareTask kFE;
    private final q kFk;

    static {
        AppMethodBeat.i(227953);
        AppMethodBeat.o(227953);
    }

    private ax(q qVar, AppBrandPrepareTask appBrandPrepareTask) {
        p.h(qVar, "rt");
        p.h(appBrandPrepareTask, "prepareTask");
        AppMethodBeat.i(227952);
        this.kFk = qVar;
        this.kFE = appBrandPrepareTask;
        AppMethodBeat.o(227952);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask$Companion;", "", "()V", "start", "Lcom/tencent/mm/plugin/appbrand/RuntimeLaunchTimeoutFallbackReloadTask;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "prepareTask", "Lcom/tencent/mm/plugin/appbrand/launching/AppBrandPrepareTask;", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.AppBrandPreInitTask.a
    public final void a(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(227951);
        if (this.kFD.get()) {
            Log.w(this.TAG, "onResult but canceled");
            AppMethodBeat.o(227951);
            return;
        }
        Log.i(this.TAG, "onResult with config:".concat(String.valueOf(appBrandInitConfigWC)));
        this.kFE.interrupt();
        if (appBrandInitConfigWC == null) {
            this.kFk.finish();
            AppMethodBeat.o(227951);
            return;
        }
        this.kFk.P(new b(this, appBrandInitConfigWC, appBrandStatObject));
        AppMethodBeat.o(227951);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ax kFG;
        final /* synthetic */ AppBrandInitConfigWC kFH;
        final /* synthetic */ AppBrandStatObject kFI;

        b(ax axVar, AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
            this.kFG = axVar;
            this.kFH = appBrandInitConfigWC;
            this.kFI = appBrandStatObject;
        }

        public final void run() {
            AppMethodBeat.i(227950);
            this.kFH.led = true;
            this.kFH.a(this.kFI);
            this.kFH.resetSession();
            AppBrandInitConfigWC appBrandInitConfigWC = this.kFH;
            String str = this.kFG.kFk.bsC().ldW.kEY;
            p.g(str, "rt.initConfig.qualityReportSession.instanceId");
            appBrandInitConfigWC.lef = new AppBrandRuntimeReloadReportBundle(str, "TimeoutFallback");
            this.kFG.kFk.a((AppBrandInitConfig) this.kFH, "TimeoutFallback");
            AppMethodBeat.o(227950);
        }
    }

    public static final ax a(q qVar, AppBrandPrepareTask appBrandPrepareTask) {
        Activity activity;
        AppMethodBeat.i(227954);
        p.h(qVar, "rt");
        p.h(appBrandPrepareTask, "prepareTask");
        Activity context = qVar.getContext();
        if (context != null) {
            activity = context;
        } else {
            Context appContext = qVar.getAppContext();
            p.g(appContext, "rt.appContext");
            activity = appContext;
        }
        AppBrandInitConfigWC bsC = qVar.bsC();
        p.g(bsC, "rt.initConfig");
        LaunchParcel e2 = i.e(bsC);
        ax axVar = new ax(qVar, appBrandPrepareTask);
        new AppBrandPreInitTask(activity, e2, true, axVar).bNf();
        AppMethodBeat.o(227954);
        return axVar;
    }
}

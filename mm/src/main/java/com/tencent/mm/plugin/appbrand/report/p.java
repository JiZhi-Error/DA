package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter;", "", "()V", "hadReportFirstUserLaunchAfterPreRender", "", "isCreatedByPreRenderLaunch", "lastVisibleHalfScreenStatus", "onPostInit", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "report", "key", "", "reportOnLaunch", "reportOnUpdateConfig", "newConfig", "forceRestartByLaunchModeChanged", "Companion", "plugin-appbrand-integration_release"})
public final class p {
    public static final a nHL = new a((byte) 0);
    public boolean nHI;
    public boolean nHJ;
    public boolean nHK;

    static {
        AppMethodBeat.i(229303);
        AppMethodBeat.o(229303);
    }

    public static void pl(int i2) {
        AppMethodBeat.i(229302);
        h.INSTANCE.dN(1520, i2);
        Log.i("HalfScreenReporter", "[report] key=".concat(String.valueOf(i2)));
        AppMethodBeat.o(229302);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter$Companion;", "", "()V", "FULL_SCREEN_TO_HALF_SCREEN", "", "HALF_SCREEN_TO_FULL_SCREEN", "RESTART_FOR_LAUNCH_MODE_CHANGE", "STARTUP_COLD", "STARTUP_COLD_USER_ACTION", "STARTUP_HOT", "STARTUP_HOT_USER_ACTION", "STARTUP_HOT_USER_ACTION_RUNTIME_CREATED_BY_PRE_RENDER", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE_RUNTIME_CREATED_BY_PRE_RENDER", "KEY", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}

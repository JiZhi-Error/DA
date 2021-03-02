package com.tencent.mm.plugin.appbrand.launching.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/launching/parallel/AppBrandParallelTaskReporter;", "", "()V", "ID", "", "KEY_DOWNLOAD_FAIL", "KEY_GET_DOWNLOAD_URL", "KEY_GET_LAUNCH", "KEY_HIT_DOWNLOAD_URL", "KEY_HIT_LAUNCH_AFTER_WAIT", "KEY_HIT_LAUNCH_WITHOUT_WAIT", "KEY_NO_CONTACT", "TAG", "", "report", "", "idKey", "plugin-appbrand-integration_release"})
public final class b {
    public static final b mYz = new b();

    static {
        AppMethodBeat.i(175194);
        AppMethodBeat.o(175194);
    }

    private b() {
    }

    public static final void pl(int i2) {
        AppMethodBeat.i(175193);
        Log.i("MicroMsg.AppBrandParallelTaskReporter", "report: key = [%d]", Integer.valueOf(i2));
        if (i2 < 0 || i2 > 255) {
            AppMethodBeat.o(175193);
            return;
        }
        h.INSTANCE.dN(1248, i2);
        AppMethodBeat.o(175193);
    }
}

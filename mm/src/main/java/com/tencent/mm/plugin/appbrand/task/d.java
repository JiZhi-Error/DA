package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.backgroundrunning.service.AppBrandForegroundNotificationService;
import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.loading.AppBrandProcessTriggerService0;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingForPluginUI;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends n {
    d() {
        super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class, AppBrandForegroundNotificationService.class, AppBrandProcessTriggerService0.class, AppBrandPreLoadingForPluginUI.class);
        AppMethodBeat.i(227436);
        super.z(g.WASERVICE);
        AppMethodBeat.o(227436);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.task.n
    public final void iB(boolean z) {
        AppMethodBeat.i(227437);
        if (!bWp()) {
            Log.e("MicroMsg.AppBrandPluginUITask", "preload, already attached");
            AppMethodBeat.o(227437);
            return;
        }
        super.z(g.WASERVICE);
        super.iB(true);
        AppMethodBeat.o(227437);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.task.n
    public final boolean c(g gVar) {
        return gVar != g.WAGAME;
    }
}

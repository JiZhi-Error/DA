package com.tencent.mm.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.d;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.xweb.WebView;

public final class ah extends i {
    @Override // com.tencent.mm.kernel.a.b, com.tencent.mm.app.i
    public final void Wa() {
        AppMethodBeat.i(160135);
        Log.i("MicroMsg.ToolsProcessBootStep", "installPlugins()");
        if (MMApplicationContext.isToolsProcess()) {
            x.gmG();
        }
        d.a((WebView.PreInitCallback) null);
        super.Wa();
        AppMethodBeat.o(160135);
    }
}

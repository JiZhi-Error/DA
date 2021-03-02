package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

@Deprecated
public final class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(43979);
        com.tencent.mm.plugin.appbrand.app.n nVar = new com.tencent.mm.plugin.appbrand.app.n();
        AppMethodBeat.o(43979);
        return nVar;
    }
}

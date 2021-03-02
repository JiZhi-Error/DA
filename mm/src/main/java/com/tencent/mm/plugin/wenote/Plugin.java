package com.tencent.mm.plugin.wenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(30256);
        a aVar = new a();
        AppMethodBeat.o(30256);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(30257);
        com.tencent.mm.plugin.wenote.model.c cVar = new com.tencent.mm.plugin.wenote.model.c();
        AppMethodBeat.o(30257);
        return cVar;
    }
}

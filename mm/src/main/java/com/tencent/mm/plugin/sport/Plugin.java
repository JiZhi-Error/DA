package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.sport.model.l;
import com.tencent.mm.plugin.sport.ui.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(28808);
        c cVar = new c();
        AppMethodBeat.o(28808);
        return cVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        AppMethodBeat.i(28809);
        b bVar = new b();
        AppMethodBeat.o(28809);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(28810);
        l lVar = new l();
        AppMethodBeat.o(28810);
        return lVar;
    }
}

package com.tencent.mm.plugin.location;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(55666);
        a aVar = new a();
        AppMethodBeat.o(55666);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(55667);
        com.tencent.mm.plugin.location.model.n nVar = new com.tencent.mm.plugin.location.model.n();
        AppMethodBeat.o(55667);
        return nVar;
    }
}

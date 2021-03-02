package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(26132);
        a aVar = new a();
        AppMethodBeat.o(26132);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(26133);
        e eVar = new e();
        AppMethodBeat.o(26133);
        return eVar;
    }
}

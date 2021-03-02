package com.tencent.mm.plugin.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.search.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(28065);
        a aVar = new a();
        AppMethodBeat.o(28065);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(28066);
        b bVar = new b();
        AppMethodBeat.o(28066);
        return bVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return null;
    }
}

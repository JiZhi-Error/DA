package com.tencent.mm.plugin.wear;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

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
        AppMethodBeat.i(29949);
        a aVar = new a();
        AppMethodBeat.o(29949);
        return aVar;
    }
}

package com.tencent.mm.plugin.order;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(66630);
        b bVar = new b();
        AppMethodBeat.o(66630);
        return bVar;
    }
}

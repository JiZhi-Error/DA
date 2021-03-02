package com.tencent.mm.plugin.emoji;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(108288);
        c cVar = new c();
        AppMethodBeat.o(108288);
        return cVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(108289);
        k kVar = new k();
        AppMethodBeat.o(108289);
        return kVar;
    }
}

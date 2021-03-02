package com.tencent.mm.plugin.address;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.address.a.a;
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
        AppMethodBeat.i(20755);
        a aVar = new a();
        AppMethodBeat.o(20755);
        return aVar;
    }
}

package com.tencent.mm.plugin.clean;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.clean.a.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(22759);
        a aVar = new a();
        AppMethodBeat.o(22759);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(22760);
        com.tencent.mm.plugin.clean.c.d cyM = com.tencent.mm.plugin.clean.c.d.cyM();
        AppMethodBeat.o(22760);
        return cyM;
    }
}

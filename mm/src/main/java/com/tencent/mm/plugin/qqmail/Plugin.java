package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.d.ac;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    private d BqT = new d();

    public Plugin() {
        AppMethodBeat.i(122626);
        AppMethodBeat.o(122626);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(122627);
        a aVar = new a();
        AppMethodBeat.o(122627);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return this.BqT;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(122628);
        ac acVar = new ac();
        AppMethodBeat.o(122628);
        return acVar;
    }
}

package com.tencent.mm.plugin.luckymoney;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.luckymoney.b.a;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public final n createApplication() {
        AppMethodBeat.i(64854);
        a aVar = new a();
        AppMethodBeat.o(64854);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public final bd createSubCore() {
        AppMethodBeat.i(64855);
        a aVar = new a();
        AppMethodBeat.o(64855);
        return aVar;
    }
}

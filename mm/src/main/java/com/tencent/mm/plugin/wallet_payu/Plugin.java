package com.tencent.mm.plugin.wallet_payu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
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
        AppMethodBeat.i(71960);
        com.tencent.mm.plugin.wallet_payu.a.d dVar = new com.tencent.mm.plugin.wallet_payu.a.d();
        AppMethodBeat.o(71960);
        return dVar;
    }
}

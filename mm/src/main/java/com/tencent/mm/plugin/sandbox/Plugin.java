package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        AppMethodBeat.i(28046);
        a aVar = new a();
        AppMethodBeat.o(28046);
        return aVar;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(28047);
        SubCoreSandBox subCoreSandBox = new SubCoreSandBox();
        AppMethodBeat.o(28047);
        return subCoreSandBox;
    }
}
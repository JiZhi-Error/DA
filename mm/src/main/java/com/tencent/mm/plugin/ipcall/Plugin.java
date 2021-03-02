package com.tencent.mm.plugin.ipcall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    b yor = new b();

    public Plugin() {
        AppMethodBeat.i(25326);
        AppMethodBeat.o(25326);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        return this.yor;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(25327);
        i eaq = i.eaq();
        AppMethodBeat.o(25327);
        return eaq;
    }
}

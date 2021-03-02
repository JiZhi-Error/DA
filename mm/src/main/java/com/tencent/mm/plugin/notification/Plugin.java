package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements d {
    b AGF = new b();

    public Plugin() {
        AppMethodBeat.i(26723);
        AppMethodBeat.o(26723);
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public n createApplication() {
        return this.AGF;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public c getContactWidgetFactory() {
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.b.d
    public bd createSubCore() {
        AppMethodBeat.i(26724);
        f eyV = f.eyV();
        AppMethodBeat.o(26724);
        return eyV;
    }
}

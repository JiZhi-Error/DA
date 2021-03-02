package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sandbox.updater.i;
import com.tencent.mm.sdk.event.EventCenter;

public final class a implements n {
    public a() {
        AppMethodBeat.i(28048);
        EventCenter.instance.addListener(new i());
        AppMethodBeat.o(28048);
    }

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(m mVar) {
    }

    @Override // com.tencent.mm.pluginsdk.n
    public final void a(l lVar) {
    }
}

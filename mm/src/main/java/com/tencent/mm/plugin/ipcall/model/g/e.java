package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.h;
import com.tencent.mm.protocal.protobuf.dfn;
import com.tencent.mm.sdk.event.EventCenter;

public final class e extends a implements h.a {
    private h ysy = null;

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[0];
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 8;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
        AppMethodBeat.i(25520);
        this.ysy = new h();
        this.ysy.ypb = this;
        EventCenter.instance.addListener(this.ysy);
        AppMethodBeat.o(25520);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
        AppMethodBeat.i(25521);
        EventCenter.instance.removeListener(this.ysy);
        AppMethodBeat.o(25521);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
    }

    @Override // com.tencent.mm.ak.i, com.tencent.mm.plugin.ipcall.model.b.a
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.h.a
    public final void a(dfn dfn) {
        AppMethodBeat.i(25522);
        this.ypE.a(8, dfn, 0, 0);
        AppMethodBeat.o(25522);
    }
}

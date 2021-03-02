package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.k;

public final class f extends a {
    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{726};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 6;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
        AppMethodBeat.i(25523);
        if (cVar != null) {
            bg.azz().a(new k(cVar.roomId, cVar.ypH, cVar.ypI), 0);
        }
        AppMethodBeat.o(25523);
    }
}

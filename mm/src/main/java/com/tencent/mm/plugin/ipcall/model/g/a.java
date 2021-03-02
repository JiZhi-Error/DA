package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends com.tencent.mm.plugin.ipcall.model.b.a {
    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{843};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
        AppMethodBeat.i(25512);
        if (cVar != null) {
            Log.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", Integer.valueOf(cVar.roomId), Integer.valueOf(cVar.ypJ));
            bg.azz().a(new com.tencent.mm.plugin.ipcall.model.e.a(cVar.roomId, cVar.ypH, cVar.dkV, cVar.yqi, cVar.ypJ, cVar.ypI), 0);
        }
        AppMethodBeat.o(25512);
    }
}

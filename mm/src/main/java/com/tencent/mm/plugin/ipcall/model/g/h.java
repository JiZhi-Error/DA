package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.n;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends a {
    public boolean ysA = false;
    public int ysz = 1;

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{723};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
        AppMethodBeat.i(25525);
        if (cVar != null) {
            Log.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", Integer.valueOf(cVar.roomId), Integer.valueOf(cVar.ypJ));
            bg.azz().a(new n(cVar.roomId, cVar.ypH, cVar.ypI, this.ysz), 0);
        }
        AppMethodBeat.o(25525);
    }
}

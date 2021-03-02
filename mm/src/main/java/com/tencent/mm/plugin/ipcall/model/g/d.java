package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.i;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{991};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
        AppMethodBeat.i(25519);
        if (cVar != null) {
            if (cVar.ypJ == 0) {
                cVar.ypJ = (int) System.currentTimeMillis();
            }
            bg.azz().a(new i(cVar.dkV, cVar.yqi, cVar.ypJ, cVar.ypK, cVar.ypL), 0);
            Log.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", cVar.dkV, cVar.yqi, Integer.valueOf(cVar.ypJ));
        }
        AppMethodBeat.o(25519);
    }
}

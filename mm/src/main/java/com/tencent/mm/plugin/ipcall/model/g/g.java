package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.a;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends a {
    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{227};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 7;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void b(c cVar) {
        AppMethodBeat.i(25524);
        if (cVar != null) {
            bg.azz().a(new l(cVar.roomId, cVar.ypI, cVar.yqk), 0);
            Log.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", Integer.valueOf(cVar.roomId), Long.valueOf(cVar.ypI), Boolean.valueOf(cVar.yqk));
        }
        AppMethodBeat.o(25524);
    }
}

package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.b.c;
import com.tencent.mm.plugin.ipcall.model.e.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends b {
    private int hjw = 0;
    private o ysB = null;

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{819};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void onStop() {
        AppMethodBeat.i(25526);
        if (this.ysB != null) {
            bg.azz().a(this.ysB);
        }
        AppMethodBeat.o(25526);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a, com.tencent.mm.plugin.ipcall.model.b.b
    public final void b(c cVar) {
        boolean z = true;
        AppMethodBeat.i(25527);
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.d("MicroMsg.IPCallSyncService", "serviceImpl, info==null: %b", objArr);
        if (this.yoW != null) {
            this.hjw = this.yoW.ypQ;
            this.ysB = new o(this.yoW.roomId, this.yoW.ypH, this.yoW.eaI(), this.yoW.ypI, false);
            bg.azz().a(this.ysB, 0);
        }
        AppMethodBeat.o(25527);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final int getTimerInterval() {
        return this.hjw;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void eaG() {
        AppMethodBeat.i(25528);
        Log.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
        AppMethodBeat.o(25528);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void eaH() {
        AppMethodBeat.i(25529);
        Log.d("MicroMsg.IPCallSyncService", "onLoopFailed");
        AppMethodBeat.o(25529);
    }
}

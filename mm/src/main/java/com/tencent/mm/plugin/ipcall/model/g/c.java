package com.tencent.mm.plugin.ipcall.model.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.b.b;
import com.tencent.mm.plugin.ipcall.model.e.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c extends b {
    private h ysx;

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int[] eaF() {
        return new int[]{824};
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void onStop() {
        AppMethodBeat.i(25515);
        if (this.ysx != null) {
            bg.azz().a(this.ysx);
        }
        AppMethodBeat.o(25515);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final int getServiceType() {
        return 5;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.a, com.tencent.mm.plugin.ipcall.model.b.b
    public final void b(com.tencent.mm.plugin.ipcall.model.b.c cVar) {
        AppMethodBeat.i(25516);
        if (this.yoW != null) {
            this.ysx = new h(this.yoW.roomId, this.yoW.ypH, this.yoW.ypI);
            bg.azz().a(this.ysx, 0);
        }
        AppMethodBeat.o(25516);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final int getTimerInterval() {
        return SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void eaG() {
        AppMethodBeat.i(25517);
        Log.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
        AppMethodBeat.o(25517);
    }

    @Override // com.tencent.mm.plugin.ipcall.model.b.b
    public final void eaH() {
        AppMethodBeat.i(25518);
        Log.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
        AppMethodBeat.o(25518);
    }
}

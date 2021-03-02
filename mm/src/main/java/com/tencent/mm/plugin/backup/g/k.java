package com.tencent.mm.plugin.backup.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.n;
import com.tencent.mm.plugin.backup.i.o;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends b {
    private n oQo = new n();
    public o oQp = new o();

    public k(String str) {
        AppMethodBeat.i(21738);
        Log.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", str);
        this.oQo.ID = str;
        AppMethodBeat.o(21738);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgr() {
        return this.oQo;
    }

    public final void a(long j2, m mVar, int i2) {
        this.oQo.oTO = 0;
        this.oQo.oTP = j2;
        this.oQo.oTQ = 0;
        this.oQo.oTR = mVar;
        this.oQo.oTS = 0;
        this.oQo.oTT = i2;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21739);
        Log.i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.oQp.oTW != 0) {
            q(4, this.oQp.oTW, "BackupStartScene onSceneEnd failed");
            AppMethodBeat.o(21739);
            return;
        }
        q(0, this.oQp.oTW, "BackupStartScene onSceneEnd success");
        AppMethodBeat.o(21739);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final /* bridge */ /* synthetic */ a cgq() {
        return this.oQp;
    }
}

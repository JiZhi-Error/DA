package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.backup.i.ab;
import com.tencent.mm.plugin.backup.i.ac;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends com.tencent.mm.plugin.backup.g.b {
    private ab oSo = new ab();
    private ac oSp = new ac();

    public b(int i2) {
        AppMethodBeat.i(21938);
        this.oSo.oTl = i2;
        AppMethodBeat.o(21938);
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgq() {
        return this.oSp;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final a cgr() {
        return this.oSo;
    }

    @Override // com.tencent.mm.plugin.backup.g.b
    public final void Bm(int i2) {
        AppMethodBeat.i(21939);
        if (this.oSp.oTW == 0) {
            q(0, 0, "ok");
            AppMethodBeat.o(21939);
            return;
        }
        Log.e("MicroMsg.BakSceneCommand", " type:%d  errCode:%d", Integer.valueOf(this.oSo.oTl), Integer.valueOf(this.oSp.oTW));
        q(4, this.oSp.oTW, "fail");
        AppMethodBeat.o(21939);
    }

    @Override // com.tencent.mm.plugin.backup.g.b, com.tencent.mm.ak.q
    public final int getType() {
        return 3;
    }
}

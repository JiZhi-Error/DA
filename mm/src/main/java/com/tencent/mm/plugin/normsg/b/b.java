package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.s;

public final class b extends q implements m {
    private boolean AEJ = true;
    private int AEK = 0;
    private final String TAG = "NetSceneFPInit";
    private i callback;
    private final s iMO;

    public b(boolean z, byte[] bArr) {
        AppMethodBeat.i(149011);
        this.AEJ = z;
        this.iMO = new s.a(this.AEJ);
        ((s.b) this.iMO.getReqObj()).KAa.Luw = com.tencent.mm.bw.b.cD(bArr);
        AppMethodBeat.o(149011);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(149012);
        this.callback = iVar;
        this.AEK++;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(149012);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return this.AEJ ? 3789 : 3644;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(com.tencent.mm.network.s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(149013);
        if (i3 == 0 && i4 == 0) {
            sVar.getRespObj();
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(149013);
        } else if (this.AEK >= 2) {
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(149013);
        } else if (doScene(dispatcher(), this.callback) < 0) {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(149013);
        } else {
            AppMethodBeat.o(149013);
        }
    }
}

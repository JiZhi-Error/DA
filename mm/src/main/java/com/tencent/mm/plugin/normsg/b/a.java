package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.r;

public final class a extends q implements m {
    private boolean AEJ = true;
    private int AEK = 0;
    private final String TAG = "NetSceneFPFresh";
    private i callback;
    private final s iMO;

    public a(boolean z, byte[] bArr) {
        AppMethodBeat.i(149008);
        this.AEJ = z;
        this.iMO = new r.a(this.AEJ);
        ((r.b) this.iMO.getReqObj()).KzW.Luw = b.cD(bArr);
        AppMethodBeat.o(149008);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(149009);
        this.callback = iVar;
        this.AEK++;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(149009);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return this.AEJ ? 3944 : 836;
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(149010);
        if (i3 == 0 && i4 == 0) {
            sVar.getRespObj();
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(149010);
        } else if (this.AEK >= 2) {
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(149010);
        } else if (doScene(dispatcher(), this.callback) < 0) {
            this.callback.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(149010);
        } else {
            AppMethodBeat.o(149010);
        }
    }
}

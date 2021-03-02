package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.d.e;
import com.tencent.mm.protocal.protobuf.ebq;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends d implements m {
    private i callback;
    public final com.tencent.mm.ak.d rr;
    public String wFE = "";
    public boolean wFM = false;

    public a(int i2) {
        AppMethodBeat.i(64453);
        d.a aVar = new d.a();
        aVar.iLN = new ebq();
        aVar.iLO = new ebr();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.funcId = 1586;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ebq ebq = (ebq) this.rr.iLK.iLR;
        e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str = flM.FhU;
        String str2 = flM.hFF;
        Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", str, str2);
        ebq.FhU = str;
        ebq.hFF = str2;
        ebq.scene = 0;
        ebq.Nbr = i2;
        ebq.Nbs = 1;
        AppMethodBeat.o(64453);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1586;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(64454);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(64454);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void d(int i2, int i3, String str, s sVar) {
        boolean z;
        AppMethodBeat.i(64455);
        Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ebr ebr = (ebr) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            this.wFE = ebr.wFE;
            p.IML.wFE = this.wFE;
            this.wFM = 1 == ebr.Nbt;
            Object[] objArr = new Object[1];
            if (1 == ebr.Nbt) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.d("MicroMsg.NetSceneSoterGetPayChallenge", "get pay challenge needChangeAuthKey: %b", objArr);
            p.IML.wFM = this.wFM;
            Log.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", this.wFE, Boolean.valueOf(this.wFM));
        }
        this.callback.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(64455);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void dKB() {
        AppMethodBeat.i(64456);
        Log.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(64456);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void MO(int i2) {
        AppMethodBeat.i(64457);
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(64457);
    }
}

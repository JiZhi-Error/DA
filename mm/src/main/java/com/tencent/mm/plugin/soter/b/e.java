package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eny;
import com.tencent.mm.protocal.protobuf.enz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;

public final class e extends d implements m, com.tencent.soter.a.f.e {
    private i callback;
    private d rr;
    private b<e.b> wGj = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.soter.a.f.a
    public final /* synthetic */ void setRequest(e.a aVar) {
        AppMethodBeat.i(130816);
        e.a aVar2 = aVar;
        d.a aVar3 = new d.a();
        aVar3.iLN = new eny();
        aVar3.iLO = new enz();
        aVar3.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar3.funcId = 1185;
        aVar3.iLP = 0;
        aVar3.respCmdId = 0;
        this.rr = aVar3.aXF();
        eny eny = (eny) this.rr.iLK.iLR;
        eny.NlL = aVar2.RQJ;
        eny.NlM = aVar2.RQK;
        AppMethodBeat.o(130816);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1185;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(130811);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(130811);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void d(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(130812);
        Log.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        if (this.wGj != null) {
            if (i2 == 0 && i3 == 0) {
                this.wGj.eB(new e.b(true));
                AppMethodBeat.o(130812);
                return;
            }
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(130812);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void dKB() {
        AppMethodBeat.i(130813);
        Log.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        if (this.wGj != null) {
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(130813);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void MO(int i2) {
        AppMethodBeat.i(130814);
        Log.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", 3, Integer.valueOf(i2));
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(130814);
    }

    @Override // com.tencent.soter.a.f.a
    public final void execute() {
        AppMethodBeat.i(130815);
        com.tencent.mm.kernel.g.azz().a(this, 0);
        AppMethodBeat.o(130815);
    }

    @Override // com.tencent.soter.a.f.a
    public final void a(b<e.b> bVar) {
        this.wGj = bVar;
    }
}

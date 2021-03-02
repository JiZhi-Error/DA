package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.protocal.protobuf.emf;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;

public final class f extends q implements m, e {
    private i callback;
    private d rr;
    private b<e.b> wGj = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.soter.a.f.a
    public final /* synthetic */ void setRequest(e.a aVar) {
        AppMethodBeat.i(130820);
        e.a aVar2 = aVar;
        d.a aVar3 = new d.a();
        aVar3.iLN = new emf();
        aVar3.iLO = new emg();
        aVar3.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar3.funcId = cf.CTRL_INDEX;
        aVar3.iLP = 0;
        aVar3.respCmdId = 0;
        this.rr = aVar3.aXF();
        emf emf = (emf) this.rr.iLK.iLR;
        emf.Scene = cf.CTRL_INDEX;
        emf.NkI = aVar2.RQK;
        emf.NkJ = aVar2.RQJ;
        Log.i("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", aVar2.RQJ, aVar2.RQK);
        Log.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
        AppMethodBeat.o(130820);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return cf.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(130817);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(130817);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(130818);
        Log.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        com.tencent.mm.plugin.soter.d.m.Fic = str;
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.wGj != null) {
                this.wGj.eB(new e.b(true));
                AppMethodBeat.o(130818);
                return;
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
            if (this.wGj != null) {
                this.wGj.eB(new e.b(false));
            }
        }
        AppMethodBeat.o(130818);
    }

    @Override // com.tencent.soter.a.f.a
    public final void a(b<e.b> bVar) {
        this.wGj = bVar;
    }

    @Override // com.tencent.soter.a.f.a
    public final void execute() {
        AppMethodBeat.i(130819);
        Log.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        com.tencent.mm.kernel.g.azz().a(this, 0);
        AppMethodBeat.o(130819);
    }
}

package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends q implements m {
    private i callback;
    private d rr;

    public h(b bVar) {
        AppMethodBeat.i(20786);
        d.a aVar = new d.a();
        aVar.iLN = new djr();
        aVar.iLO = new djs();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoupdate";
        aVar.funcId = 418;
        aVar.iLP = 203;
        aVar.respCmdId = 1000000203;
        this.rr = aVar.aXF();
        djr djr = (djr) this.rr.iLK.iLR;
        djr.MNr = new djk();
        djr.MNr.id = bVar.id;
        djr.MNr.MNy = new dqi().bhy(Util.nullAs(bVar.kti, ""));
        djr.MNr.MNw = new dqi().bhy(Util.nullAs(bVar.ktg, ""));
        djr.MNr.MNB = new dqi().bhy(Util.nullAs(bVar.ktl, ""));
        djr.MNr.MNz = new dqi().bhy(Util.nullAs(bVar.ktj, ""));
        djr.MNr.MNC = new dqi().bhy(Util.nullAs(bVar.ktm, ""));
        djr.MNr.MND = new dqi().bhy(Util.nullAs(bVar.ktn, ""));
        djr.MNr.MNx = new dqi().bhy(Util.nullAs(bVar.kth, ""));
        djr.MNr.MNA = new dqi().bhy(Util.nullAs(bVar.ktk, ""));
        djr.MNr.MNE = new dqi().bhy(Util.nullAs(bVar.kto, ""));
        AppMethodBeat.o(20786);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20787);
        Log.d("MicroMsg.NetSceneRcptInfoUpdate", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            djs djs = (djs) ((d) sVar).iLL.iLR;
            if (djs.MNs.MNv != null) {
                Log.d("MicroMsg.NetSceneRcptInfoUpdate", "resp.rImpl.rcptinfolist.rcptinfolist " + djs.MNs.MNv.size());
                a.bqb();
                a.bqd().t(djs.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20787);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 418;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20788);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20788);
        return dispatch;
    }
}

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
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.djk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends q implements m {
    private i callback;
    private d rr;

    public c(b bVar) {
        AppMethodBeat.i(20771);
        d.a aVar = new d.a();
        aVar.iLN = new djf();
        aVar.iLO = new djg();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoadd";
        aVar.funcId = 415;
        aVar.iLP = 200;
        aVar.respCmdId = 1000000200;
        this.rr = aVar.aXF();
        djf djf = (djf) this.rr.iLK.iLR;
        djf.MNr = new djk();
        djf.MNr.MNy = new dqi().bhy(Util.nullAs(bVar.kti, ""));
        djf.MNr.MNw = new dqi().bhy(Util.nullAs(bVar.ktg, ""));
        djf.MNr.MNB = new dqi().bhy(Util.nullAs(bVar.ktl, ""));
        djf.MNr.MNz = new dqi().bhy(Util.nullAs(bVar.ktj, ""));
        djf.MNr.MNC = new dqi().bhy(Util.nullAs(bVar.ktm, ""));
        djf.MNr.MND = new dqi().bhy(Util.nullAs(bVar.ktn, ""));
        djf.MNr.MNx = new dqi().bhy(Util.nullAs(bVar.kth, ""));
        djf.MNr.MNA = new dqi().bhy(Util.nullAs(bVar.ktk, ""));
        djf.MNr.MNE = new dqi().bhy(Util.nullAs(bVar.kto, ""));
        AppMethodBeat.o(20771);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20772);
        Log.d("MicroMsg.NetSceneRcptInfoAdd", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            djg djg = (djg) ((d) sVar).iLL.iLR;
            if (djg.MNs.MNv != null) {
                Log.d("MicroMsg.NetSceneRcptInfoAdd", "resp.rImpl.rcptinfolist.rcptinfolist " + djg.MNs.MNv.size());
                a.bqb();
                a.bqd().t(djg.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20772);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 415;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20773);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20773);
        return dispatch;
    }
}

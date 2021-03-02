package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.djl;
import com.tencent.mm.protocal.protobuf.djm;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    public boolean ksQ;
    public String nickname;
    private d rr;
    public String username;

    public e(String str, String str2, int i2) {
        AppMethodBeat.i(20777);
        d.a aVar = new d.a();
        aVar.iLN = new djl();
        aVar.iLO = new djm();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        aVar.funcId = 417;
        aVar.iLP = 202;
        aVar.respCmdId = 1000000202;
        this.rr = aVar.aXF();
        djl djl = (djl) this.rr.iLK.iLR;
        djl.qwL = 0;
        djl.MNF = str;
        djl.dNI = str2;
        djl.scene = i2;
        AppMethodBeat.o(20777);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.i(20778);
        Log.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            djm djm = (djm) ((d) sVar).iLL.iLR;
            this.username = djm.rJH;
            this.nickname = djm.MNI;
            if (djm.MNH != 1) {
                z = false;
            }
            this.ksQ = z;
            if (djm.MNs.MNv != null) {
                Log.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + djm.MNs.MNv.size());
                a.bqb();
                a.bqd().t(djm.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20778);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 417;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20779);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20779);
        return dispatch;
    }
}

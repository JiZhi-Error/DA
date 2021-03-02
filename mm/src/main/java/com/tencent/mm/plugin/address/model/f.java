package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.djn;
import com.tencent.mm.protocal.protobuf.djo;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private i callback;
    public int ksR = 0;
    private d rr;

    public f(int i2) {
        AppMethodBeat.i(20780);
        d.a aVar = new d.a();
        aVar.iLN = new djn();
        aVar.iLO = new djo();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinforemove";
        aVar.funcId = 416;
        aVar.iLP = 201;
        aVar.respCmdId = 1000000201;
        this.rr = aVar.aXF();
        this.ksR = i2;
        Log.d("MicroMsg.NetSceneRcptInfoRemove", "remove Id ".concat(String.valueOf(i2)));
        ((djn) this.rr.iLK.iLR).id = i2;
        AppMethodBeat.o(20780);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20781);
        Log.d("MicroMsg.NetSceneRcptInfoRemove", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            djo djo = (djo) ((d) sVar).iLL.iLR;
            if (djo.MNs.MNv != null) {
                Log.d("MicroMsg.NetSceneRcptInfoRemove", "resp.rImpl.rcptinfolist.rcptinfolist " + djo.MNs.MNv.size());
                a.bqb();
                a.bqd().t(djo.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20781);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 416;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20782);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20782);
        return dispatch;
    }
}

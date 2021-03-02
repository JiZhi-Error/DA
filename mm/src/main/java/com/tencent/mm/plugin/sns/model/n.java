package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class n extends q implements m {
    public i callback;
    private d rr;

    public n(List<Long> list) {
        AppMethodBeat.i(202722);
        d.a aVar = new d.a();
        aVar.iLN = new ks();
        aVar.iLO = new kt();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsbatchobjectdetail";
        aVar.funcId = 5987;
        aVar.iLP = 97;
        aVar.respCmdId = 1000000097;
        this.rr = aVar.aXF();
        ((ks) this.rr.iLK.iLR).KOJ.addAll(list);
        AppMethodBeat.o(202722);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 5987;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(202723);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(202723);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(202724);
        Log.i("MicroMsg.NetSceneSnsBatchDetail", "errType:%s, errCode:%s, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        kt ktVar = (kt) ((d) sVar).iLL.iLR;
        if (ktVar != null && !Util.isNullOrNil(ktVar.KOK)) {
            an.a("@__batch", 128, ktVar.KOK, r.aOr(r.Jb(ktVar.KOK.getFirst().Id)));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(202724);
    }
}

package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eta;
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    public d rr;

    public c(int i2, String str, int i3, byte[] bArr, byte[] bArr2, String str2) {
        AppMethodBeat.i(125428);
        d.a aVar = new d.a();
        aVar.iLN = new eta();
        aVar.iLO = new etb();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipinvite";
        aVar.funcId = 823;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eta eta = (eta) this.rr.iLK.iLR;
        eta.MKg = i2;
        eta.Nqu = str;
        eta.Llx = i3;
        eta.Nqv = b.cD(bArr);
        eta.Nqw = b.cD(bArr2);
        eta.MKf = System.currentTimeMillis();
        if (str2 != null && !str2.equals("")) {
            eta.Nqx = str2;
        }
        AppMethodBeat.o(125428);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125429);
        Log.i("MicroMsg.NetSceneVoipCSInvite", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125429);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 823;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125430);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125430);
        return dispatch;
    }
}

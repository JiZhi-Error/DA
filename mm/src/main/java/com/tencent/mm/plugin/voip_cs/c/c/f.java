package com.tencent.mm.plugin.voip_cs.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eti;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.sdk.platformtools.Log;

public final class f extends q implements m {
    private i callback;
    public d rr;

    public f(long j2, long j3, int i2) {
        AppMethodBeat.i(125437);
        d.a aVar = new d.a();
        aVar.iLN = new eti();
        aVar.iLO = new etj();
        aVar.uri = "/cgi-bin/micromsg-bin/csvoipsync";
        aVar.funcId = 818;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eti eti = (eti) this.rr.iLK.iLR;
        eti.NeG = j2;
        eti.Lta = j3;
        eti.NqC = i2;
        eti.MKf = System.currentTimeMillis();
        AppMethodBeat.o(125437);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125438);
        Log.i("MicroMsg.NetSceneVoipCSSync", "onGYNetEnd, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125438);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 818;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(125439);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125439);
        return dispatch;
    }
}

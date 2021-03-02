package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class b extends q implements m {
    private i callback;
    private final d rr;
    public String yBU = null;

    public b(String str) {
        AppMethodBeat.i(26146);
        d.a aVar = new d.a();
        aVar.iLN = new afi();
        aVar.iLO = new afj();
        aVar.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
        aVar.funcId = 636;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yBU = str;
        AppMethodBeat.o(26146);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26147);
        Log.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26147);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 636;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26148);
        this.callback = iVar;
        afi afi = (afi) this.rr.iLK.iLR;
        afi.Lqm = this.yBU;
        if (this.yBU == null || Util.isNullOrNil(this.yBU)) {
            Log.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
            iVar.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
            AppMethodBeat.o(26148);
            return 0;
        }
        afi.Lqm = this.yBU;
        afi.Lqm = this.yBU;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26148);
        return dispatch;
    }
}

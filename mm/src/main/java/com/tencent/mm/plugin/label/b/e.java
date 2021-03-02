package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgu;
import com.tencent.mm.protocal.protobuf.elt;
import com.tencent.mm.protocal.protobuf.elu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class e extends q implements m {
    private i callback;
    private final d rr;
    private cgu yBW = null;

    public e(int i2, String str) {
        AppMethodBeat.i(26155);
        d.a aVar = new d.a();
        aVar.iLN = new elt();
        aVar.iLO = new elu();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.funcId = 637;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        if (i2 >= 0 && !Util.isNullOrNil(str)) {
            this.yBW = new cgu();
            this.yBW.Mmc = i2;
            this.yBW.Mmb = str;
        }
        AppMethodBeat.o(26155);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26156);
        Log.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26156);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 637;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26157);
        this.callback = iVar;
        elt elt = (elt) this.rr.iLK.iLR;
        if (this.yBW != null) {
            elt.NkF = this.yBW;
            int dispatch = dispatch(gVar, this.rr, this);
            AppMethodBeat.o(26157);
            return dispatch;
        }
        Log.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        iVar.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
        AppMethodBeat.o(26157);
        return 0;
    }
}

package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dvw;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.og;
import com.tencent.mm.sdk.platformtools.Log;

public final class af extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public af(og ogVar, Object obj) {
        AppMethodBeat.i(124146);
        d.a aVar = new d.a();
        aVar.iLN = new dvw();
        aVar.iLO = new dvx();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbizenterpriseattr";
        aVar.funcId = 1228;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dvw dvw = (dvw) this.rr.iLK.iLR;
        dvw.LTl = ogVar;
        dvw.mask = 17;
        dvw.LTj = 1;
        this.data = obj;
        AppMethodBeat.o(124146);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124147);
        Log.d("MicroMsg.NetSceneSetBizEnterpriseAttr", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124147);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1228;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124148);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneSetBizEnterpriseAttr", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124148);
        return dispatch;
    }
}

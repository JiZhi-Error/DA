package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dip;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends q implements m {
    private i callback;
    public d rr;

    public v(String str, String str2) {
        AppMethodBeat.i(124319);
        d.a aVar = new d.a();
        aVar.iLN = new dip();
        aVar.iLO = new diq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/quitbizchat";
        aVar.funcId = 1358;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dip dip = (dip) this.rr.iLK.iLR;
        dip.KTt = str;
        dip.KTl = str2;
        AppMethodBeat.o(124319);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124320);
        Log.d("MicroMsg.brandservice.NetSceneQuitBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124320);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1358;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124321);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneQuitBizChat", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124321);
        return dispatch;
    }
}

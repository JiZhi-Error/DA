package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elp;
import com.tencent.mm.protocal.protobuf.elq;
import com.tencent.mm.protocal.protobuf.nw;
import com.tencent.mm.sdk.platformtools.Log;

public final class y extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public y(String str, String str2, nw nwVar, nw nwVar2, Object obj) {
        AppMethodBeat.i(124328);
        d.a aVar = new d.a();
        aVar.iLN = new elp();
        aVar.iLO = new elq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/updatebizchatmemberlist";
        aVar.funcId = 1357;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elp elp = (elp) this.rr.iLK.iLR;
        elp.KTt = str;
        elp.KTl = str2;
        elp.NkD = nwVar;
        elp.NkE = nwVar2;
        this.data = obj;
        AppMethodBeat.o(124328);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124329);
        Log.d("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124329);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1357;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124330);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneUpdateBizChatMemberList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124330);
        return dispatch;
    }
}

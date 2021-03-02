package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.sdk.platformtools.Log;

public final class w extends q implements m {
    private i callback;
    public d rr;

    public w(String str, String str2, int i2) {
        AppMethodBeat.i(124322);
        d.a aVar = new d.a();
        aVar.iLN = new dit();
        aVar.iLO = new diu();
        aVar.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        aVar.funcId = 1361;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dit dit = (dit) this.rr.iLK.iLR;
        dit.KTt = str;
        dit.KTl = str2;
        dit.time_stamp = i2;
        AppMethodBeat.o(124322);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124323);
        Log.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124323);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1361;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124324);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124324);
        return dispatch;
    }
}

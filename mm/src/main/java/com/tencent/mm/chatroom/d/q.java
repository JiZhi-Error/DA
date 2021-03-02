package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.sdk.platformtools.Log;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    private d rr;

    public q(String str, String str2) {
        AppMethodBeat.i(12489);
        d.a aVar = new d.a();
        aVar.iLN = new dpi();
        aVar.iLO = new dpj();
        aVar.uri = "/cgi-bin/micromsg-bin/revokechatroomqrcode";
        aVar.funcId = 700;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dpi dpi = (dpi) this.rr.iLK.iLR;
        dpi.MSF = str;
        dpi.MSG = str2;
        AppMethodBeat.o(12489);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12490);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12490);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 700;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12491);
        Log.d("MicroMsg.RevokeChatRoomQRCodeRequest", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12491);
    }
}

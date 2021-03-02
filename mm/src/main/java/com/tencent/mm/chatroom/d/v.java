package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.di;
import com.tencent.mm.protocal.protobuf.ejm;
import com.tencent.mm.protocal.protobuf.ejn;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends q implements m {
    private i callback;
    private final d rr;
    public String username;

    public v(String str, String str2) {
        AppMethodBeat.i(12495);
        d.a aVar = new d.a();
        this.username = str2;
        ejm ejm = new ejm();
        ejm.KGO = str;
        ejm.NiT = str2;
        aVar.iLN = ejm;
        aVar.iLO = new ejn();
        aVar.uri = "/cgi-bin/micromsg-bin/transferchatroomowner";
        aVar.funcId = di.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(12495);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12496);
        Log.w("MicroMsg.NetSceneTransferChatRoomOwner", "errType = " + i3 + " errCode " + i4 + " errMsg " + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12496);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return di.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12497);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12497);
        return dispatch;
    }
}

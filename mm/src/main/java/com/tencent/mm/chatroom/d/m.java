package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.openvoice.n;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback = null;
    public String chatroomName;
    public int gsf;
    public int gsg;
    public String resultMsg;
    private final d rr;
    public int status;

    public m(String str) {
        AppMethodBeat.i(12473);
        d.a aVar = new d.a();
        aVar.iLN = new blc();
        aVar.iLO = new bld();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroomupgradestatus";
        aVar.funcId = n.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.chatroomName = str;
        ((blc) this.rr.iLK.iLR).KGO = str;
        AppMethodBeat.o(12473);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12474);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12474);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return n.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12475);
        bld bld = (bld) this.rr.iLL.iLR;
        Log.d("MicroMsg.NetSceneGetChatRoomUpgradeStatus", "NetSceneGetChatRoomUpgradeStatus onGYNetEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.status = bld.oTW;
        this.resultMsg = bld.LUf;
        this.gsg = bld.LUg;
        this.resultMsg = bld.LUf;
        this.gsf = bld.LUe;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12475);
    }
}

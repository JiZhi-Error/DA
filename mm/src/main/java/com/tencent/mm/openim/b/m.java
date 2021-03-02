package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.p.x;
import com.tencent.mm.protocal.protobuf.dpm;
import com.tencent.mm.protocal.protobuf.dpn;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    private final String dOe;
    private final d rr;

    public m(String str, String str2) {
        AppMethodBeat.i(151212);
        d.a aVar = new d.a();
        aVar.iLN = new dpm();
        aVar.iLO = new dpn();
        aVar.uri = "/cgi-bin/micromsg-bin/revokeopenimchatroomqrcode";
        aVar.funcId = x.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.dOe = str;
        dpm dpm = (dpm) this.rr.iLK.iLR;
        dpm.dOe = str;
        dpm.dTx = str2;
        Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "get roomname:%s, qrcode:%s", str, str2);
        AppMethodBeat.o(151212);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151213);
        Log.i("MicroMsg.Openim.NetSceneRevokeOpenIMChatRoomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151213);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return x.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151214);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151214);
        return dispatch;
    }
}

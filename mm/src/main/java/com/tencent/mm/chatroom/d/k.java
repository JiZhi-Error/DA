package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class k extends q implements m {
    private i callback;
    private String errMsg;
    public bik gsa;
    private final d rr;

    public k(String str) {
        AppMethodBeat.i(182082);
        Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo roomname:%s", Util.nullAs(str, ""));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
        aVar.funcId = 3553;
        aVar.iLN = new bij();
        aVar.iLO = new bik();
        this.rr = aVar.aXF();
        bij bij = (bij) this.rr.iLK.iLR;
        bij.dOe = Util.nullAs(str, "");
        bij.scene = 0;
        AppMethodBeat.o(182082);
    }

    public k(String str, byte b2) {
        AppMethodBeat.i(194026);
        Log.i("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "NetSceneGetAssociateChatRoomManageInfo ticket:%s", Util.nullAs(str, ""));
        d.a aVar = new d.a();
        aVar.uri = "/cgi-bin/micromsg-bin/getassociatechatroommanageinfo";
        aVar.funcId = 3553;
        aVar.iLN = new bij();
        aVar.iLO = new bik();
        this.rr = aVar.aXF();
        bij bij = (bij) this.rr.iLK.iLR;
        bij.dHx = Util.nullAs(str, "");
        bij.scene = 1;
        AppMethodBeat.o(194026);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 3553;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(182083);
        this.callback = iVar;
        this.gsa = (bik) this.rr.iLL.iLR;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(182083);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(182084);
        Log.d("MicroMsg.NetSceneGetAssociateChatRoomManageInfo", "onGYNetEnd:[%d,%d,%s]", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        this.errMsg = str;
        AppMethodBeat.o(182084);
    }
}

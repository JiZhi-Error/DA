package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cpy;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;

public final class p extends q implements m {
    private i callback;
    private final d rr;
    public String username;

    public p(String str, String str2) {
        AppMethodBeat.i(151222);
        d.a aVar = new d.a();
        this.username = str2;
        cpy cpy = new cpy();
        cpy.jHa = str;
        cpy.MvS = new cvt();
        cpy.MvS.userName = str2;
        aVar.iLN = cpy;
        aVar.iLO = new cpz();
        aVar.uri = "/cgi-bin/micromsg-bin/modopenimchatroomowner";
        aVar.funcId = 811;
        this.rr = aVar.aXF();
        AppMethodBeat.o(151222);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 811;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151223);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151223);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151224);
        Log.w("MicroMsg.NetSceneTransferOpenImChatRoomOwner", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151224);
    }
}

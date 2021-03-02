package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.protocal.protobuf.bzy;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback = null;
    private final d rr;

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 339;
    }

    public o(String str) {
        AppMethodBeat.i(12482);
        d.a aVar = new d.a();
        aVar.iLN = new bzx();
        aVar.iLO = new bzy();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.funcId = 339;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bzx) this.rr.iLK.iLR).xNG = str;
        Log.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :".concat(String.valueOf(str)));
        AppMethodBeat.o(12482);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12483);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12483);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12484);
        Log.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i3 + " " + i4 + "  " + str);
        if (i3 == 0 && i4 == 0) {
            int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(135176, (Object) 0)).intValue();
            if (intValue - 1 >= 0) {
                com.tencent.mm.kernel.g.aAh().azQ().set(135176, Integer.valueOf(intValue - 1));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(12484);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12484);
    }
}

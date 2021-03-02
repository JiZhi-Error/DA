package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bnk;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.sdk.platformtools.Log;

public final class t extends q implements m {
    private i callback;
    public d rr;

    public t(String str) {
        AppMethodBeat.i(124313);
        d.a aVar = new d.a();
        aVar.iLN = new bnk();
        aVar.iLO = new bnl();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        aVar.funcId = 1367;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bnk) this.rr.iLK.iLR).KTt = str;
        AppMethodBeat.o(124313);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124314);
        Log.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124314);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1367;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124315);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124315);
        return dispatch;
    }
}

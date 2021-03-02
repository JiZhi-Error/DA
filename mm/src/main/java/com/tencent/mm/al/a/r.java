package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.protocal.protobuf.bjo;
import com.tencent.mm.sdk.platformtools.Log;

public final class r extends q implements m {
    private i callback;
    Object data;
    public d rr;

    public r(String str, Object obj) {
        AppMethodBeat.i(124307);
        d.a aVar = new d.a();
        aVar.iLN = new bjn();
        aVar.iLO = new bjo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        aVar.funcId = 1354;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bjn) this.rr.iLK.iLR).KTt = str;
        this.data = obj;
        AppMethodBeat.o(124307);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124308);
        Log.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124308);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1354;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124309);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124309);
        return dispatch;
    }
}

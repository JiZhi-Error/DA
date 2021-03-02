package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.k.w;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.brn;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends q implements m {
    private i callback;
    private final String dOe;
    private final d rr;

    public g(String str) {
        AppMethodBeat.i(151196);
        d.a aVar = new d.a();
        aVar.iLN = new brm();
        aVar.iLO = new brn();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroomqrcode";
        aVar.funcId = w.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.dOe = str;
        ((brm) this.rr.iLK.iLR).jHa = str;
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "get roomname:%s", str);
        AppMethodBeat.o(151196);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151197);
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatroomQRCode", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151197);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return w.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151198);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151198);
        return dispatch;
    }
}

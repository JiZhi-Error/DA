package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback;
    private String jGZ;
    private final d rr;

    public o(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(223645);
        this.jGZ = str;
        d.a aVar = new d.a();
        aVar.iLN = new dtw();
        aVar.iLO = new dtx();
        aVar.uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX;
        this.rr = aVar.aXF();
        dtw dtw = (dtw) this.rr.iLK.iLR;
        dtw.jGZ = str;
        dtw.MVG = str2;
        dtw.KHz = str3;
        dtw.KHA = (long) i2;
        Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", str, str3);
        AppMethodBeat.o(223645);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151220);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151220);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.o.b.d.CTRL_INDEX;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151221);
        Log.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.jGZ);
        if (!(i3 == 0 && i4 == 0)) {
            Log.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", Integer.valueOf(i3), Integer.valueOf(i4));
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151221);
    }
}

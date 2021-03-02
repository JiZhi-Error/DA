package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.cx;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    private String dNI;
    private final d rr;

    private i() {
        AppMethodBeat.i(24811);
        d.a aVar = new d.a();
        aVar.iLN = new cw();
        aVar.iLO = new cx();
        aVar.uri = "/cgi-bin/mmo2o-bin/addcontact";
        aVar.funcId = 1703;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(24811);
    }

    public i(String str, String str2, int i2, String str3) {
        this();
        AppMethodBeat.i(24812);
        this.dNI = str;
        cw cwVar = (cw) this.rr.iLK.iLR;
        cwVar.KGX = str;
        cwVar.Url = str2;
        cwVar.KCx = i2;
        cwVar.KCy = str3;
        Log.i("MicroMsg.FreeWifi.NetSceneAddContact", "appid = %s", str);
        AppMethodBeat.o(24812);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(24813);
        Log.i("MicroMsg.FreeWifi.NetSceneAddContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dNI);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(24813);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1703;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(24814);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(24814);
        return dispatch;
    }
}

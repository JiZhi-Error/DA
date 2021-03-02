package com.tencent.mm.plugin.webwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.l;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public int dJY;
    private final d iUB;

    public b(int i2) {
        AppMethodBeat.i(30169);
        this.dJY = i2;
        d.a aVar = new d.a();
        akp akp = new akp();
        akq akq = new akq();
        aVar.iLN = akp;
        aVar.iLO = akq;
        aVar.uri = "/cgi-bin/micromsg-bin/extdevicecontrol";
        aVar.funcId = l.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        akp.him = i2;
        akp.Ltz = 1;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(30169);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(30170);
        Log.d("MicroMsg.NetSceneExtDeviceControl", "onGYNetEnd  errType:" + i3 + " errCode:" + i4 + " errMsg:" + str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(30170);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return l.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(30171);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(30171);
        return dispatch;
    }
}

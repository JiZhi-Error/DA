package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.game.e.a.a;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public String jGZ;
    private final d rr;

    public b(String str, String str2) {
        AppMethodBeat.i(151180);
        d.a aVar = new d.a();
        aVar.iLN = new dk();
        aVar.iLO = new dl();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimcontact";
        aVar.funcId = a.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.jGZ = str;
        dk dkVar = (dk) this.rr.iLK.iLR;
        dkVar.jGZ = str;
        dkVar.KHz = str2;
        Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", str, str2);
        AppMethodBeat.o(151180);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151181);
        Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.jGZ);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151181);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return a.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151182);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151182);
        return dispatch;
    }
}

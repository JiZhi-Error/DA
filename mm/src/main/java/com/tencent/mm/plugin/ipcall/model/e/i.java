package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.protocal.protobuf.dfl;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback = null;
    private d rr = null;
    public dfl yrE = null;
    public dfm yrF = null;

    public i(String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(25475);
        d.a aVar = new d.a();
        aVar.iLN = new dfl();
        aVar.iLO = new dfm();
        aVar.funcId = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        long currentTimeMillis = System.currentTimeMillis();
        int ebM = c.ebM();
        dfl dfl = (dfl) this.rr.iLK.iLR;
        dfl.xNH = z.aTY();
        dfl.MKh = str2;
        dfl.xNG = str;
        dfl.MKg = i2;
        dfl.Llx = ebM;
        dfl.MKp = 1;
        dfl.MKf = currentTimeMillis;
        dfl.MKo = i3;
        dfl.MKq = i4;
        this.yrE = dfl;
        Log.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", str, str2, Integer.valueOf(i2), Integer.valueOf(ebM), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(25475);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 991;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(25476);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25476);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25477);
        Log.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrF = (dfm) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(25477);
            return;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25477);
    }
}

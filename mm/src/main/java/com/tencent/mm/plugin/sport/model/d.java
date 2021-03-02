package com.tencent.mm.plugin.sport.model;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eyb;
import com.tencent.mm.protocal.protobuf.eyc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ck;

public final class d extends q implements m {
    eyc Fjq;
    private i callback;
    private com.tencent.mm.ak.d iUB;

    public d() {
        AppMethodBeat.i(149302);
        d.a aVar = new d.a();
        aVar.funcId = 1947;
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/getwxsportconfig";
        aVar.iLN = new eyb();
        aVar.iLO = new eyc();
        this.iUB = aVar.aXF();
        eyb eyb = (eyb) this.iUB.iLK.iLR;
        eyb.oTI = com.tencent.mm.protocal.d.DEVICE_NAME;
        eyb.KLO = ck.getFingerprint();
        eyb.hie = Build.BRAND;
        eyb.hid = Build.MODEL;
        eyb.Nvj = com.tencent.mm.protocal.d.KyK;
        eyb.hif = com.tencent.mm.protocal.d.KyL;
        eyb.hig = com.tencent.mm.protocal.d.KyM;
        eyb.Nvk = BuildInfo.CLIENT_VERSION;
        eyb.Nvl = Build.MANUFACTURER;
        Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "request params=[%s, %s, %s, %s, %s, %s, %s, %s, %s]", eyb.KLO, eyb.hie, eyb.hid, eyb.oTI, eyb.hig, eyb.hif, eyb.hig, eyb.Nvk, eyb.Nvl);
        AppMethodBeat.o(149302);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1947;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(149303);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(149303);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(149304);
        Log.i("MicroMsg.Sport.NetSceneGetWeSportConfig", "onGYNetEnd %d %d %d %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.Fjq = (eyc) this.iUB.iLL.iLR;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(149304);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(149304);
    }
}

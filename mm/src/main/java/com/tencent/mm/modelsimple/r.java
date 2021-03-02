package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.buo;
import com.tencent.mm.protocal.protobuf.bup;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r extends q implements m {
    private i callback;
    public final d iFd;

    public r() {
        AppMethodBeat.i(20638);
        d.a aVar = new d.a();
        aVar.iLN = new buo();
        aVar.iLO = new bup();
        aVar.uri = "/cgi-bin/micromsg-bin/getresourcecontrolinfo";
        aVar.funcId = 725;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iFd = aVar.aXF();
        ((buo) this.iFd.iLK.iLR).oUv = 0;
        Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo type[%d], stack[%s]", 0, Util.getStack());
        AppMethodBeat.o(20638);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20639);
        Log.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate GetResourceControlInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            h.INSTANCE.idkeyStat(405, 2, 1, true);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20639);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 725;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20640);
        this.callback = iVar;
        h.INSTANCE.idkeyStat(405, 1, 1, true);
        int dispatch = dispatch(gVar, this.iFd, this);
        AppMethodBeat.o(20640);
        return dispatch;
    }
}

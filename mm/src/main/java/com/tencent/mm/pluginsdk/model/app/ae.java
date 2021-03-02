package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class ae extends q implements m {
    private i callback;
    public d rr;

    public ae(int i2, String str) {
        AppMethodBeat.i(151818);
        d.a aVar = new d.a();
        aVar.iLN = new ckq();
        aVar.iLO = new ckr();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/getserviceapplist";
        aVar.funcId = 1060;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ckq ckq = (ckq) this.rr.iLK.iLR;
        ckq.offset = i2;
        ckq.limit = 20;
        ckq.lang = str;
        g.aAi();
        ckq.Mqa = String.valueOf(((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, (Object) 0)).intValue());
        AppMethodBeat.o(151818);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151819);
        Log.d("MicroMsg.NetSceneGetServiceAppList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151819);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1060;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151820);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneGetServiceAppList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151820);
        return dispatch;
    }
}

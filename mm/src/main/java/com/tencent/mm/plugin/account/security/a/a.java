package com.tencent.mm.plugin.account.security.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a extends q implements m {
    private i callback;
    private String dGL;
    private d rr;

    public a(String str) {
        AppMethodBeat.i(125511);
        this.dGL = str;
        d.a aVar = new d.a();
        aVar.iLN = new afx();
        aVar.iLO = new afy();
        aVar.uri = "/cgi-bin/micromsg-bin/delsafedevice";
        aVar.funcId = 362;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((afx) this.rr.iLK.iLR).Lke = str;
        AppMethodBeat.o(125511);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(125512);
        Log.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            afy afy = (afy) this.rr.iLL.iLR;
            g.aAh().azQ().set(64, Integer.valueOf(afy.KEf));
            Log.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + afy.KEf);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(125512);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 362;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(125513);
        if (Util.isNullOrNil(this.dGL)) {
            Log.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
            AppMethodBeat.o(125513);
            return -1;
        }
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(125513);
        return dispatch;
    }
}

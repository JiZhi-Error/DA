package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private boolean HPM;
    private akd HPR;
    public ake HPS;
    private i callback;
    private d hJu;

    public o(String str, boolean z) {
        AppMethodBeat.i(69920);
        this.HPM = z;
        d.a aVar = new d.a();
        aVar.iLN = new akd();
        aVar.iLO = new ake();
        if (z) {
            aVar.funcId = 2529;
            aVar.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            aVar.funcId = 2888;
            aVar.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.HPR = (akd) this.hJu.iLK.iLR;
        this.HPR.Ltl = str;
        AppMethodBeat.o(69920);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        if (this.HPM) {
            return 2529;
        }
        return 2888;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69921);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hJu, this);
        AppMethodBeat.o(69921);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69922);
        Log.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.HPS = (ake) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69922);
    }
}

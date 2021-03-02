package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.eph;
import com.tencent.mm.protocal.protobuf.epi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class n extends w {
    private i callback;
    public int errCode;
    public String productId;
    private d rr;

    public n(int i2, int i3, String str, ccv ccv, ccu ccu) {
        AppMethodBeat.i(71827);
        d.a aVar = new d.a();
        aVar.iLN = new eph();
        aVar.iLO = new epi();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/verifyandroidiappackage";
        aVar.funcId = 1306;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        eph eph = (eph) this.rr.iLK.iLR;
        eph.LSk = i2;
        eph.dUT = i3;
        this.productId = str;
        eph.LSp = ccv;
        eph.LSo = ccu;
        AppMethodBeat.o(71827);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71828);
        Log.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "ErrType:" + i3 + ",errCode:" + i4 + ",errMsg:" + str);
        if (i3 == 0 && i4 == 0) {
            epi epi = (epi) this.rr.iLL.iLR;
            Log.e("MicroMsg.NetSceneVerifyAndroidIapPackage", "business: errCode:" + epi.dOK + ",errMsg:" + epi.dOL);
            this.callback.onSceneEnd(i3, epi.dOK, str, this);
            AppMethodBeat.o(71828);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(71828);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1306;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(71829);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71829);
        return dispatch;
    }
}

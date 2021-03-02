package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class g extends w {
    public ccu IqP;
    public ccv IqQ;
    private i callback;
    public int errCode;
    private d rr;

    public g(int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(71819);
        d.a aVar = new d.a();
        aVar.iLN = new bhy();
        aVar.iLO = new bhz();
        aVar.uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
        aVar.funcId = 1130;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bhy bhy = (bhy) this.rr.iLK.iLR;
        bhy.dNI = str;
        bhy.LSk = i2;
        bhy.LSl = Integer.parseInt(str2);
        bhy.desc = str3;
        bhy.count = i3;
        bhy.scene = 13;
        bhy.LSm = str4;
        bhy.GaP = str5;
        bhy.sign = str6;
        bhy.LSn = str7;
        AppMethodBeat.o(71819);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(71820);
        Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + i3 + ",errCode:" + i4 + ",errMsg:" + str);
        if (i3 == 0 && i4 == 0) {
            bhz bhz = (bhz) this.rr.iLL.iLR;
            Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + bhz.dOK + ",errMsg:" + bhz.dOL);
            int i5 = bhz.dOK;
            String str2 = bhz.dOL;
            if (i5 == 0) {
                this.IqP = bhz.LSo;
                this.IqQ = bhz.LSp;
            }
            this.callback.onSceneEnd(i3, i5, str2, this);
            AppMethodBeat.o(71820);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(71820);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1130;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(71821);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(71821);
        return dispatch;
    }
}

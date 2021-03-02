package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dnk;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.sdk.platformtools.Log;

public final class aw extends q implements m {
    private i callback;
    private final d rr;
    private dnl yXB;

    public aw(String str, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(65297);
        Log.i("MicroMsg.NetSceneLuckyMoneyReport", "NetSceneLuckyMoneyReport() sendId:%s unique_id:%s reportType:%s sendUsername:%s recvUserName:%s", str, str2, Integer.valueOf(i2), str3, str4);
        d.a aVar = new d.a();
        dnk dnk = new dnk();
        dnk.yQE = str;
        dnk.MBV = str2;
        dnk.dYn = i2;
        dnk.yVy = str3;
        dnk.MQD = str4;
        aVar.iLN = dnk;
        aVar.iLO = new dnl();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/wxhbreport";
        aVar.funcId = 2715;
        this.rr = aVar.aXF();
        AppMethodBeat.o(65297);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2715;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(65298);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(65298);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(65299);
        Log.w("MicroMsg.NetSceneLuckyMoneyReport", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.yXB = (dnl) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(65299);
    }
}

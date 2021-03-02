package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.vo;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.net.URLDecoder;

public final class n extends r {
    public vp CoK;
    private final String TAG = "MicroMsg.NetSceneF2fDynamicCode";

    public n(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(67863);
        d.a aVar = new d.a();
        aVar.iLN = new vo();
        aVar.iLO = new vp();
        aVar.funcId = 2736;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fdynamiccode";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        vo voVar = (vo) this.rr.iLK.iLR;
        voVar.yRL = i2;
        voVar.pWm = str;
        voVar.CpJ = str2;
        voVar.LgC = URLDecoder.decode(str3);
        voVar.Cpr = str4;
        voVar.Cps = str5;
        voVar.CpM = str6;
        voVar.nickname = str7;
        voVar.Cpg = str8;
        Log.i("MicroMsg.NetSceneF2fDynamicCode", "amount: %s, username: %s, transfer_code_id: %s", Integer.valueOf(i2), str, URLDecoder.decode(str3));
        AppMethodBeat.o(67863);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2736;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67864);
        Log.i("MicroMsg.NetSceneF2fDynamicCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CoK = (vp) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneF2fDynamicCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.CoK.dDN), this.CoK.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67864);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        vp vpVar = (vp) ((d) sVar).iLL.iLR;
        this.RtZ = vpVar.dDN;
        this.Rua = vpVar.qwn;
    }
}

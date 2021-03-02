package com.tencent.mm.plugin.remittance.bankcard.a;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.doq;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;

public final class o extends b implements j {
    public dor CiW;
    private final String TAG = "MicroMsg.NetSceneBankRemitRequestOrder";
    private i callback;
    private d rr;

    public o(String str, String str2, String str3, int i2, int i3, String str4, int i4, int i5, String str5, String str6, b bVar, int i6) {
        AppMethodBeat.i(67391);
        Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "unique_id:%s last_transfer_bill_id:%s unpay_type:%s", Util.nullAsNil(str6), Base64.encodeToString(bVar.toByteArray(), 2), Integer.valueOf(i6));
        d.a aVar = new d.a();
        aVar.iLN = new doq();
        aVar.iLO = new dor();
        aVar.funcId = 1380;
        aVar.uri = "/cgi-bin/mmpay-bin/request_tsbc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        doq doq = (doq) this.rr.iLK.iLR;
        doq.Cjt = str;
        doq.Cju = str2;
        doq.dDj = str3;
        doq.Cjg = i2;
        doq.MRP = i3;
        doq.MRQ = str4;
        doq.MRR = i4;
        doq.MRS = i5;
        doq.KKI = str5;
        doq.MBV = str6;
        doq.MRT = bVar;
        doq.KYp = i6;
        AppMethodBeat.o(67391);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1380;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67392);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67392);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67393);
        Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.CiW = (dor) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.NetSceneBankRemitRequestOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.CiW.dDN), this.CiW.qwn);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67393);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        dor dor = (dor) ((d) sVar).iLL.iLR;
        this.RtZ = dor.dDN;
        this.Rua = dor.qwn;
    }

    @Override // com.tencent.mm.wallet_core.c.r, com.tencent.mm.plugin.remittance.bankcard.a.b
    public final boolean czQ() {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final boolean eMZ() {
        if (this.CiW.MRU == null || this.CiW.MRU.cSx != 1) {
            return true;
        }
        return false;
    }
}

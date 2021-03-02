package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.epu;
import com.tencent.mm.protocal.protobuf.epv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v extends w {
    public int Irs = 0;
    private i callback;
    public int errCode;
    public String rcD = null;
    public String rcF;
    private final d rr;

    public v(String str, int i2, int i3, int i4, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(72800);
        d.a aVar = new d.a();
        aVar.iLN = new epu();
        aVar.iLO = new epv();
        aVar.uri = "/cgi-bin/micromsg-bin/verifypurchase";
        aVar.funcId = 414;
        aVar.iLP = 215;
        aVar.respCmdId = 1000000215;
        this.rr = aVar.aXF();
        epu epu = (epu) this.rr.iLK.iLR;
        this.rcD = str;
        epu.ProductID = str;
        epu.Nnp = i2;
        epu.MJB = i4;
        epu.APa = i3;
        if (!Util.isNullOrNil(str6)) {
            epu.MJz = str6;
            epu.MJA = str5;
        }
        epu.MJC = str2;
        epu.Nnr = str4;
        if (str3 != null) {
            epu.Nno = new SKBuiltinBuffer_t().setBuffer(str3.getBytes());
        } else {
            epu.Nno = new SKBuiltinBuffer_t();
        }
        epu.Nnq = (int) Util.nowSecond();
        Log.i("MicroMsg.NetSceneVerifyPurchase", "productId:" + this.rcD + ",verifyType:" + i2 + ",palyType:" + i3 + ",payload:" + str2 + ",purchaseData:" + str3 + ",dataSignature:" + str4);
        AppMethodBeat.o(72800);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(72801);
        Log.e("MicroMsg.NetSceneVerifyPurchase", "ErrType:" + i3 + "   errCode:" + i4);
        this.errCode = 0;
        if (i3 == 0 && i4 == 0) {
            epv epv = (epv) ((d) sVar).iLL.iLR;
            if (epv.BaseResponse != null) {
                this.Irs = epv.Nnt;
                Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Series ID is " + epv.SeriesID);
                Log.d("MicroMsg.NetSceneVerifyPurchase", " Get Biz Type is " + epv.Nns);
                this.rcF = epv.SeriesID;
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(72801);
            return;
        }
        this.errCode = -1;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(72801);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 414;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72802);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72802);
        return dispatch;
    }
}

package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.f;

public class a extends w {
    private i callback;
    private d rr;

    public a(String str, int i2, int i3) {
        AppMethodBeat.i(69276);
        d.a aVar = new d.a();
        tj tjVar = new tj();
        tjVar.KKR = str;
        tjVar.LbX = i2;
        tjVar.LbY = i3;
        aVar.iLN = tjVar;
        aVar.iLO = new tk();
        aVar.uri = getUri();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        aVar.routeInfo = f.bpA(str);
        this.rr = aVar.aXF();
        Log.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", getUri(), str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(69276);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69277);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69277);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69278);
        Log.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", getUri(), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            try {
                tk tkVar = (tk) ((d) sVar).iLL.iLR;
                Log.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", Integer.valueOf(tkVar.BaseResponse.Ret), tkVar.BaseResponse.ErrMsg);
            } catch (Exception e2) {
                Log.i("MicroMsg.NetSceneCancelPay", e2.getMessage());
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(69278);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        AppMethodBeat.i(69279);
        int funcId = getFuncId();
        AppMethodBeat.o(69279);
        return funcId;
    }

    public int getFuncId() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}

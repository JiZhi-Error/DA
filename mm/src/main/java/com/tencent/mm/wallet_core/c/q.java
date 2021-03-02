package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class q extends com.tencent.mm.ak.q implements m {
    private int RtW = 2632;
    private b.a RtX;
    private i callback;
    private final d rr;

    public q(Map<String, Object> map, String str, String str2, int i2, b.a aVar) {
        AppMethodBeat.i(72789);
        Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "new pay sercuretunnel netscene url :" + str + " appid: " + str2);
        this.RtX = aVar;
        d.a aVar2 = new d.a();
        aVar2.iLN = new dtf();
        aVar2.iLO = new dtg();
        aVar2.uri = "/cgi-bin/mmpay-bin/securetunnel";
        aVar2.funcId = this.RtW;
        if (map.containsKey("timeout")) {
            aVar2.timeout = ((Integer) map.get("timeout")).intValue();
        }
        this.rr = aVar2.aXF();
        dtf dtf = (dtf) this.rr.iLK.iLR;
        dtf.MVs = (String) map.get("reqbuf");
        dtf.Lmp = (String) map.get("cmd");
        dtf.url = str;
        dtf.dNI = str2;
        dtf.scene = i2;
        dtf.source = 0;
        AppMethodBeat.o(72789);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(72790);
        Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "onGYNetEnd, netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        if (this.RtX != null) {
            Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback");
            if (i3 == 0 && i4 == 0) {
                Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback success");
                this.RtX.onSuccess(((dtg) this.rr.iLL.iLR).MVt);
            } else {
                Log.i("MicroMsg.NetSceneJSAPISecureTunnel", "secureTunnel callback fail");
                this.RtX.aas(str);
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(72790);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return this.RtW;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(72791);
        this.callback = iVar;
        Log.d("MicroMsg.NetSceneJSAPISecureTunnel", "doScene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(72791);
        return dispatch;
    }
}

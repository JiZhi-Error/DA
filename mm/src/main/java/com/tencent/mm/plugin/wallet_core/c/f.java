package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.td;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.LinkedList;

public final class f extends q implements m {
    public LinkedList<String> HPE;
    private i callback;
    private d rr;

    public f(LinkedList<String> linkedList) {
        AppMethodBeat.i(69897);
        Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        d.a aVar = new d.a();
        aVar.iLN = new bjb();
        aVar.iLO = new bjc();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        aVar.funcId = getType();
        this.rr = aVar.aXF();
        this.rr.setIsUserCmd(true);
        bjb bjb = (bjb) this.rr.iLK.iLR;
        bjb.LSP = linkedList;
        bjb.Lcc = k.fQy();
        if (!e.gsQ()) {
            bjb.LhT = e.gsR();
        }
        com.tencent.mm.wallet_core.ui.f.aqm(42);
        AppMethodBeat.o(69897);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1650;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69898);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69898);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69899);
        Log.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i3 + "errCode=" + i4);
        if (i3 == 0 && i4 == 0) {
            bjc bjc = (bjc) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", bjc.LSQ);
            this.HPE = bjc.HPE;
            LinkedList<String> linkedList = this.HPE;
            if (linkedList == null || linkedList.size() == 0) {
                Log.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                td tdVar = new td();
                tdVar.dZA.dZC = linkedList;
                EventCenter.instance.publish(tdVar);
            }
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, Util.nullAs(bjc.LSQ, ""));
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            com.tencent.mm.wallet_core.ui.f.aqm(43);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69899);
    }
}

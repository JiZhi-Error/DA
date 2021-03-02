package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cfr;
import com.tencent.mm.protocal.protobuf.cfs;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ad extends q implements m {
    public String brandUsername;
    private i callback;
    public d rr;
    public String tag;

    public ad(String str, LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        AppMethodBeat.i(212186);
        d.a aVar = new d.a();
        aVar.iLN = new cfr();
        aVar.iLO = new cfs();
        aVar.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        aVar.funcId = 675;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cfr cfr = (cfr) this.rr.iLK.iLR;
        cfr.MlA = str;
        cfr.MlD = linkedList;
        cfr.MlE = linkedList2;
        this.brandUsername = str;
        AppMethodBeat.o(212186);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124141);
        Log.i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124141);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 675;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124142);
        this.callback = iVar;
        Log.i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124142);
        return dispatch;
    }

    public final cfs bae() {
        if (this.rr == null || this.rr.iLL.iLR == null) {
            return null;
        }
        return (cfs) this.rr.iLL.iLR;
    }
}

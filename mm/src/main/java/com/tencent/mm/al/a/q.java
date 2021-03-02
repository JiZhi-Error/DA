package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bjj;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.protocal.protobuf.nu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    Map<String, String> iQB = new HashMap();
    public d rr;

    public q(LinkedList<nu> linkedList) {
        AppMethodBeat.i(124304);
        Iterator<nu> it = linkedList.iterator();
        while (it.hasNext()) {
            nu next = it.next();
            String str = next.KTl;
            String str2 = next.KTt;
            if (!(str2 == null || str == null)) {
                this.iQB.put(str, str2);
            }
        }
        d.a aVar = new d.a();
        aVar.iLN = new bjj();
        aVar.iLO = new bjk();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.funcId = 1365;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bjj) this.rr.iLK.iLR).LTg = linkedList;
        AppMethodBeat.o(124304);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(124305);
        Log.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124305);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1365;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124306);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124306);
        return dispatch;
    }
}

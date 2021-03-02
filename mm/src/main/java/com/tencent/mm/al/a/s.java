package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.bjp;
import com.tencent.mm.protocal.protobuf.bjq;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class s extends q implements m {
    private i callback;
    Object data;
    Map<String, String> iQC = new HashMap();
    public d rr;

    public s(LinkedList<qv> linkedList, Object obj) {
        AppMethodBeat.i(124310);
        Iterator<qv> it = linkedList.iterator();
        while (it.hasNext()) {
            qv next = it.next();
            LinkedList<String> linkedList2 = next.KXK;
            String str = next.KTt;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator<String> it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.iQC.put(it2.next(), str);
                }
            }
        }
        d.a aVar = new d.a();
        aVar.iLN = new bjp();
        aVar.iLO = new bjq();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.funcId = 1353;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((bjp) this.rr.iLK.iLR).LTi = linkedList;
        this.data = obj;
        AppMethodBeat.o(124310);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(124311);
        Log.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(124311);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1353;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(124312);
        this.callback = iVar;
        Log.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(124312);
        return dispatch;
    }
}

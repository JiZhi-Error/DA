package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class q extends com.tencent.mm.ak.q implements m {
    private ArrayList<Long> BrQ;
    private i callback;
    private d rr;

    public q(ArrayList<Long> arrayList) {
        AppMethodBeat.i(122712);
        this.BrQ = arrayList;
        d.a aVar = new d.a();
        aVar.iLN = new b();
        aVar.iLO = new c();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.funcId = 483;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(122712);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(122713);
        Log.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        if ((i3 == 0 && i4 == 0) || this.callback == null) {
            if (this.callback != null) {
                this.callback.onSceneEnd(i3, i4, str, this);
            }
            AppMethodBeat.o(122713);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(122713);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 483;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(122714);
        this.callback = iVar;
        b bVar = (b) this.rr.iLK.iLR;
        bVar.oTz = this.BrQ.size();
        LinkedList<g> linkedList = new LinkedList<>();
        Iterator<Long> it = this.BrQ.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            g gVar2 = new g();
            gVar2.Brn = longValue;
            linkedList.add(gVar2);
            Log.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", Long.valueOf(longValue));
        }
        bVar.Brd = linkedList;
        Log.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", Integer.valueOf(bVar.oTz), Integer.valueOf(bVar.Brd.size()));
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(122714);
        return dispatch;
    }

    public final LinkedList<f> eGp() {
        return ((c) this.rr.iLL.iLR).Bre;
    }
}

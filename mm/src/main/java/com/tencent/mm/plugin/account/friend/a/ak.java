package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dtr;
import com.tencent.mm.protocal.protobuf.dts;
import java.util.LinkedList;

public final class ak extends q implements m {
    private i callback;
    private final d rr;

    public ak(int[] iArr) {
        AppMethodBeat.i(131136);
        d.a aVar = new d.a();
        aVar.iLN = new dtr();
        aVar.iLO = new dts();
        aVar.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        aVar.funcId = 116;
        aVar.iLP = 41;
        aVar.respCmdId = 1000000041;
        this.rr = aVar.aXF();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i2 : iArr) {
            linkedList.add(Integer.valueOf(i2));
        }
        ((dtr) this.rr.iLK.iLR).MVF = linkedList;
        ((dtr) this.rr.iLK.iLR).MVE = linkedList.size();
        AppMethodBeat.o(131136);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(131137);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(131137);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 116;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(131138);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(131138);
    }
}

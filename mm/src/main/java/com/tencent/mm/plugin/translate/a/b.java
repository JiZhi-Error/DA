package com.tencent.mm.plugin.translate.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.protocal.protobuf.bwg;
import com.tencent.mm.protocal.protobuf.ekr;
import com.tencent.mm.protocal.protobuf.eks;
import java.util.LinkedList;

public final class b extends q implements m {
    public LinkedList<eks> Gtk;
    private i callback = null;
    private final d rr;

    public b(LinkedList<ekr> linkedList) {
        AppMethodBeat.i(29739);
        d.a aVar = new d.a();
        aVar.iLN = new bwf();
        aVar.iLO = new bwg();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.funcId = 631;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bwf bwf = (bwf) this.rr.iLK.iLR;
        bwf.Mcg = linkedList;
        bwf.oTy = linkedList.size();
        AppMethodBeat.o(29739);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29740);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29740);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 631;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29741);
        this.Gtk = ((bwg) this.rr.iLL.iLR).Mcg;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29741);
    }
}

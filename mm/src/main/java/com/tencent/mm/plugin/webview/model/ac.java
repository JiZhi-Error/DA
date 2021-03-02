package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.drh;
import com.tencent.mm.protocal.protobuf.dri;
import java.util.LinkedList;

public final class ac extends q implements m {
    final LinkedList<String> IXZ = new LinkedList<>();
    private i heq;
    private final d rr;
    private long startTime = 0;

    public ac(int i2, String str, String str2, String str3, LinkedList<String> linkedList, String str4) {
        AppMethodBeat.i(210978);
        d.a aVar = new d.a();
        aVar.iLN = new drh();
        aVar.iLO = new dri();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        aVar.funcId = 1346;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        drh drh = (drh) this.rr.iLK.iLR;
        drh.Mzq = i2;
        drh.dNI = str;
        drh.Mzr = linkedList;
        drh.state = str2;
        drh.MTR = str4;
        drh.MTQ = str3;
        if (linkedList != null) {
            this.IXZ.addAll(linkedList);
        }
        AppMethodBeat.o(210978);
    }

    public ac(String str, String str2, String str3, LinkedList<String> linkedList, int i2, String str4) {
        AppMethodBeat.i(210979);
        d.a aVar = new d.a();
        aVar.iLN = new drh();
        aVar.iLO = new dri();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        aVar.funcId = 1346;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        drh drh = (drh) this.rr.iLK.iLR;
        drh.Mzq = 1;
        drh.dNI = str;
        drh.Mzr = linkedList;
        drh.state = str2;
        drh.MTQ = str3;
        drh.Lqj = i2;
        drh.MTR = str4;
        this.startTime = System.currentTimeMillis();
        if (linkedList != null) {
            this.IXZ.addAll(linkedList);
        }
        AppMethodBeat.o(210979);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78932);
        this.heq.onSceneEnd(i3, i4, str, this);
        b.INSTANCE.aO(4, (int) (System.currentTimeMillis() - this.startTime), i4);
        AppMethodBeat.o(78932);
    }

    public final dri gcA() {
        return (dri) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1346;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78933);
        this.startTime = System.currentTimeMillis();
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78933);
        return dispatch;
    }
}

package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.protocal.protobuf.al;
import com.tencent.mm.protocal.protobuf.dvq;
import com.tencent.mm.protocal.protobuf.dvr;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class n extends q implements m {
    private i callback;
    private final d rr;

    public n(List<qw> list) {
        AppMethodBeat.i(5593);
        d.a aVar = new d.a();
        aVar.iLN = new dvq();
        aVar.iLO = new dvr();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        aVar.funcId = 386;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dvq dvq = (dvq) this.rr.iLK.iLR;
        LinkedList<al> linkedList = new LinkedList<>();
        for (qw qwVar : list) {
            al alVar = new al();
            alVar.UserName = qwVar.userName;
            linkedList.add(alVar);
        }
        dvq.oTz = linkedList.size();
        dvq.oTA = linkedList;
        Log.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        AppMethodBeat.o(5593);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(5594);
        Log.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            dvr dvr = (dvr) this.rr.iLL.iLR;
            Log.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", Integer.valueOf(dvr.LSe));
            b.k(196610, Integer.valueOf(dvr.LSe));
            b.k(196611, Boolean.FALSE);
        } else {
            b.k(196611, Boolean.TRUE);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(5594);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 386;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(5595);
        this.callback = iVar;
        Log.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(5595);
        return dispatch;
    }
}

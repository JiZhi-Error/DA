package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dpb;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.protocal.protobuf.zi;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends n {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final String getTag() {
        return "MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate";
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final zi h(s sVar) {
        return (zi) ((d) sVar).iLL.iLR;
    }

    public m() {
    }

    public m(int i2) {
        AppMethodBeat.i(152000);
        Log.i("MicroMsg.ResDownloader.CheckResUpdate.NetSceneCheckResUpdate", "NetSceneCheckResUpdate init, resType:%d", Integer.valueOf(i2));
        dpb dpb = new dpb();
        dpb.oUv = i2;
        this.JZC.clear();
        this.JZC.add(dpb);
        AppMethodBeat.o(152000);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.pluginsdk.j.a.a.n
    public final s gnS() {
        AppMethodBeat.i(152001);
        d.a aVar = new d.a();
        zh zhVar = new zh();
        zhVar.LkB.addAll(this.JZC);
        aVar.iLN = zhVar;
        aVar.iLO = new zi();
        aVar.uri = "/cgi-bin/micromsg-bin/checkresupdate";
        aVar.funcId = 721;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        AppMethodBeat.o(152001);
        return aXF;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 721;
    }
}

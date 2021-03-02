package com.tencent.mm.plugin.websearch.api;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.fal;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.sdk.platformtools.Log;

public final class z extends a implements m {
    private v IDt;
    private i callback;
    private d rr;

    public z(v vVar) {
        boolean z = true;
        AppMethodBeat.i(117630);
        this.IDt = vVar;
        this.xsj = vVar.dDv;
        this.fs = vVar.offset;
        this.mScene = vVar.scene;
        this.IDq = vVar.dVL;
        this.IDt = vVar;
        this.IDr = vVar.CAJ;
        d.a aVar = new d.a();
        aVar.funcId = getType();
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.iLN = new fal();
        aVar.iLO = new fam();
        this.rr = aVar.aXF();
        fal fal = (fal) this.rr.iLK.iLR;
        fal.KZk = vVar.offset;
        fal.MaY = ai.aft(1);
        fal.MRb = vVar.IDE;
        fal.LPT = vVar.dDv;
        fal.MlQ = ai.clJ();
        fal.Scene = vVar.scene;
        fal.KZj = vVar.rjq;
        fal.MRf = vVar.dVS;
        fal.NwG = vVar.IDK;
        fal.NgA = vVar.channelId;
        fal.NwI = vVar.IDW;
        aca aca = new aca();
        aca.key = "client_system_version";
        aca.LmC = (long) Build.VERSION.SDK_INT;
        vVar.IDO.add(aca);
        fal.Nva = vVar.IDO;
        fal.NwH = vVar.sessionId;
        this.dVP = vVar.dPI;
        if (vVar.IEa) {
            ah.a(vVar.scene, vVar.sessionId, vVar.dVO, vVar.rjq, vVar.offset, vVar.IDE != 1 ? false : z, vVar.dPI, vVar.dDv, vVar.businessType, vVar.IDU);
        }
        AppMethodBeat.o(117630);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1943;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(117631);
        ar.kb(this.mScene, 2);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(117631);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(117632);
        Log.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str);
        boolean z = i3 == 0 && i4 == 0;
        if (this.IDt.IEa) {
            ah.a(this.IDt.scene, this.IDt.sessionId, this.IDt.dVO, this.IDt.rjq, this.IDt.offset, this.IDt.IDE == 1, this.IDt.dPI, z, this.IDt.dDv, this.IDt.businessType, this.IDt.IDU);
        }
        if (i4 == -1) {
            ar.kb(this.mScene, 4);
        } else if (i3 == 0 && i4 == 0) {
            ar.kb(this.mScene, 3);
        } else {
            ar.kb(this.mScene, 8);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(117632);
    }

    private fam fXR() {
        return (fam) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final String fXC() {
        AppMethodBeat.i(117633);
        if (fXR() != null) {
            String str = fXR().MaZ;
            AppMethodBeat.o(117633);
            return str;
        }
        AppMethodBeat.o(117633);
        return "";
    }

    @Override // com.tencent.mm.plugin.websearch.api.a
    public final int fXD() {
        AppMethodBeat.i(117634);
        if (fXR() != null) {
            int i2 = fXR().NwM;
            AppMethodBeat.o(117634);
            return i2;
        }
        AppMethodBeat.o(117634);
        return 0;
    }
}

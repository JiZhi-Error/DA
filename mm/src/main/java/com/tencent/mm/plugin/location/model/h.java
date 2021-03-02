package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends q implements m {
    private i callback;
    public final d rr;
    private byte[] yFF;
    String yFG;

    public h(float f2, float f3, int i2, int i3, int i4, String str, String str2) {
        AppMethodBeat.i(55691);
        d.a aVar = new d.a();
        aVar.iLN = new bpv();
        aVar.iLO = new bpw();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        aVar.funcId = a.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bpv bpv = (bpv) this.rr.iLK.iLR;
        bpv.rBI = str2;
        if (Util.isOverseasUser(MMApplicationContext.getContext())) {
            bpv.LXN = 1;
        } else {
            bpv.LXN = 0;
        }
        bpv.LbD = f2;
        bpv.LbC = f3;
        bpv.LXO = i2;
        Log.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", Integer.valueOf(i3), Integer.valueOf(i4));
        while (i3 * i4 > 270000) {
            i3 = (int) (((double) i3) / 1.2d);
            i4 = (int) (((double) i4) / 1.2d);
        }
        Log.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), bpv.rBI);
        bpv.Height = i4;
        bpv.Width = i3;
        this.yFG = str;
        AppMethodBeat.o(55691);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return a.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(55692);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(55692);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(55693);
        Log.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i3), Integer.valueOf(i4));
        try {
            this.yFF = ((bpw) ((d) sVar).iLL.iLR).KHp.getBuffer().zy;
            com.tencent.mm.vfs.s.f(this.yFG, this.yFF, this.yFF.length);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e2, "", new Object[0]);
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(55693);
    }
}

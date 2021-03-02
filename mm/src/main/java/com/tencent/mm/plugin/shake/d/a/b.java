package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private String DiK;
    private i callback;
    public d rr;
    private int scene;

    public b(String str, int i2) {
        this.DiK = str;
        this.scene = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28274);
        this.callback = iVar;
        d.a aVar = new d.a();
        aVar.iLN = new bvx();
        aVar.iLO = new bvy();
        aVar.uri = "/cgi-bin/micromsg-bin/gettvinfo";
        aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bvx bvx = (bvx) this.rr.iLK.iLR;
        bvx.MbU = this.DiK;
        bvx.Scene = this.scene;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28274);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        AppMethodBeat.i(28275);
        bvx bvx = (bvx) ((d) sVar).iLK.iLR;
        if (bvx.Scene < 0 || bvx.MbU == null || bvx.MbU.length() <= 0) {
            Log.e("MicroMsg.scanner.NetSceneGetTVInfo", "ERR: Security Check Failed, Scene = %s", Integer.valueOf(bvx.Scene));
            q.b bVar = q.b.EFailed;
            AppMethodBeat.o(28275);
            return bVar;
        }
        q.b bVar2 = q.b.EOk;
        AppMethodBeat.o(28275);
        return bVar2;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28276);
        Log.d("MicroMsg.scanner.NetSceneGetTVInfo", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28276);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.share.g.CTRL_INDEX;
    }
}

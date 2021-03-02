package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.ac;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d extends q implements m {
    private i callback;
    private com.tencent.mm.ak.d rr;
    public int status;

    public d(String str, String str2, p pVar) {
        boolean z = true;
        AppMethodBeat.i(20774);
        d.a aVar = new d.a();
        aVar.iLN = new djh();
        aVar.iLO = new dji();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.funcId = ac.CTRL_INDEX;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "a2key is " + (!Util.isNullOrNil(str)) + ", newa2key is " + (Util.isNullOrNil(str2) ? false : z));
        this.rr = aVar.aXF();
        djh djh = (djh) this.rr.iLK.iLR;
        djh.KLh = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str));
        djh.MNt = new SKBuiltinBuffer_t().setBuffer(Util.decodeHexString(str2));
        djh.qq = pVar.intValue();
        AppMethodBeat.o(20774);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20775);
        Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            dji dji = (dji) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            this.status = dji.MNu;
            Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (dji.MNs.MNv != null && this.status == 0) {
                Log.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + dji.MNs.MNv.size());
                a.bqb();
                a.bqd().t(dji.MNs.MNv);
                a.bqb();
                a.bqd().bqf();
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20775);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ac.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20776);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20776);
        return dispatch;
    }
}

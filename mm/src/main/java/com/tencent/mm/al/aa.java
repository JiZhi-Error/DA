package com.tencent.mm.al;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.cl;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.btv;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa extends q implements m {
    private i callback;
    private btv iOT;
    private a<aa> iOU;
    private final d rr;

    public interface a<T extends q> {
        void a(int i2, int i3, String str, T t);
    }

    public aa(a<aa> aVar) {
        this();
        this.iOU = aVar;
    }

    public aa() {
        AppMethodBeat.i(212182);
        Log.i("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "NetSceneGetReceiptAssisPluginMenu begin");
        d.a aVar = new d.a();
        aVar.funcId = 1769;
        aVar.uri = "/cgi-bin/mmpay-bin/getreceiptassismenu";
        btu btu = new btu();
        btu.timestamp = cl.aWz();
        aVar.iLN = btu;
        aVar.iLO = new btv();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(212182);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1769;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(212183);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(212183);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(212184);
        Log.w("MicroMsg.NetSceneGetReceiptAssisPluginMenu", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.iOT = (btv) ((d) sVar).iLL.iLR;
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (this.iOU != null) {
            this.iOU.a(i3, i4, str, this);
        }
        AppMethodBeat.o(212184);
    }

    public final btv bab() {
        AppMethodBeat.i(212185);
        if (this.iOT == null) {
            btv btv = new btv();
            AppMethodBeat.o(212185);
            return btv;
        }
        btv btv2 = this.iOT;
        AppMethodBeat.o(212185);
        return btv2;
    }
}

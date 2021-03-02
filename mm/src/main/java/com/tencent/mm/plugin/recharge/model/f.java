package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.protocal.protobuf.czo;
import com.tencent.mm.protocal.protobuf.czp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;

public final class f extends q implements m {
    public boolean BDA;
    public boolean BDp;
    public int BDq;
    public ArrayList<com.tencent.mm.plugin.wallet.a.q> BDr;
    public ArrayList<com.tencent.mm.plugin.wallet.a.q> BDs;
    public e BDt;
    public e BDu;
    public e BDv;
    public e BDw;
    public e BDx;
    public p BDy;
    public List<a> BDz;
    public String appId;
    private i callback;
    public int cmdId;
    public String desc;
    public int errCode;
    public String errMsg;
    public String knP;
    private d rr;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i2) {
        AppMethodBeat.i(67110);
        this.knP = "";
        this.appId = "";
        this.BDp = false;
        this.desc = "";
        this.errCode = 0;
        this.errMsg = "";
        this.BDA = false;
        this.knP = str;
        d.a aVar = new d.a();
        aVar.iLN = new czo();
        aVar.iLO = new czp();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.funcId = 1571;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        czo czo = (czo) this.rr.iLK.iLR;
        czo.Lms = i2;
        this.cmdId = i2;
        Log.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", Integer.valueOf(i2));
        if (!Util.isNullOrNil(this.knP)) {
            Log.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", this.knP);
            czo.MES = String.format("phone=%s", this.knP);
        }
        AppMethodBeat.o(67110);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1571;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(67111);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(67111);
        return dispatch;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x02cd  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0395  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x040e  */
    @Override // com.tencent.mm.network.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onGYNetEnd(int r8, int r9, int r10, java.lang.String r11, com.tencent.mm.network.s r12, byte[] r13) {
        /*
        // Method dump skipped, instructions count: 1076
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.recharge.model.f.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
    }
}

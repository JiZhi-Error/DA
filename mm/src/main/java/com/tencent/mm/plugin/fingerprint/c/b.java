package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.ebs;
import com.tencent.mm.protocal.protobuf.ebt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements m {
    private i callback;
    public final com.tencent.mm.ak.d rr;
    private int wGi;

    public b(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(64458);
        d.a aVar = new d.a();
        aVar.iLN = new ebs();
        aVar.iLO = new ebt();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        aVar.funcId = 1638;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ebs ebs = (ebs) this.rr.iLK.iLR;
        ebs.MBA = str;
        ebs.signature = str2;
        ebs.Nbu = str3;
        ebs.dPr = TenpayUtil.signWith3Des("passwd=" + ebs.Nbu);
        ebs.Nbr = i2;
        ebs.Nbs = 1;
        this.wGi = i2;
        Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "soter type: %s", Integer.valueOf(i2));
        AppMethodBeat.o(64458);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void d(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64459);
        Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            if (this.wGi == 1) {
                ((a) g.af(a.class)).pj(true);
                ((a) g.af(a.class)).pk(false);
            } else {
                ((a) g.af(a.class)).pk(true);
                ((a) g.af(a.class)).pj(false);
            }
        } else {
            Log.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.callback.onSceneEnd(i2, i3, "", this);
        AppMethodBeat.o(64459);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void dKB() {
        AppMethodBeat.i(64460);
        Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(64460);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void MO(int i2) {
        AppMethodBeat.i(64461);
        Log.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", 3, Integer.valueOf(i2));
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(64461);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1638;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(64462);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(64462);
        return dispatch;
    }
}

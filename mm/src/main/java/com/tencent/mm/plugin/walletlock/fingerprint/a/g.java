package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.ejd;
import com.tencent.mm.protocal.protobuf.eje;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;

public final class g extends d implements m, e {
    private i callback;
    private String krw = null;
    public com.tencent.mm.ak.d rr;
    private b<e.b> wGj = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.soter.a.f.a
    public final /* synthetic */ void setRequest(e.a aVar) {
        AppMethodBeat.i(129694);
        e.a aVar2 = aVar;
        d.a aVar3 = new d.a();
        aVar3.iLN = new ejd();
        aVar3.iLO = new eje();
        aVar3.uri = "/cgi-bin/mmpay-bin/touchlockupdateauthkey";
        aVar3.funcId = 1244;
        aVar3.iLP = 0;
        aVar3.respCmdId = 0;
        this.rr = aVar3.aXF();
        ejd ejd = (ejd) this.rr.iLK.iLR;
        ejd.Nbv = aVar2.RQJ;
        ejd.Nbw = aVar2.RQK;
        ejd.Nbu = this.krw;
        kh khVar = new kh();
        khVar.dPo.dPq = this.krw;
        EventCenter.instance.publish(khVar);
        ejd.dPr = khVar.dPp.dPr;
        Log.v("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo wcpaysign: %s", ejd.dPr);
        AppMethodBeat.o(129694);
    }

    public g(String str) {
        this.krw = str;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1665;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(129689);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(129689);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void d(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(129690);
        Log.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        if (this.wGj != null) {
            if (i2 == 0 && i3 == 0) {
                this.wGj.eB(new e.b(true));
                AppMethodBeat.o(129690);
                return;
            }
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(129690);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void dKB() {
        AppMethodBeat.i(129691);
        Log.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        if (this.wGj != null) {
            Log.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(129691);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void MO(int i2) {
        AppMethodBeat.i(129692);
        Log.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", 3, Integer.valueOf(i2));
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(129692);
    }

    @Override // com.tencent.soter.a.f.a
    public final void execute() {
        AppMethodBeat.i(129693);
        com.tencent.mm.kernel.g.azz().a(this, 0);
        AppMethodBeat.o(129693);
    }

    @Override // com.tencent.soter.a.f.a
    public final void a(b<e.b> bVar) {
        this.wGj = bVar;
    }
}

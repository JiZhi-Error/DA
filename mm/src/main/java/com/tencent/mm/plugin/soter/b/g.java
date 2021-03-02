package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.ba;
import com.tencent.mm.plugin.soter.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;

public final class g extends q implements m, e {
    private i callback;
    private s iMO;
    private b<e.b> wGj = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.soter.a.f.a
    public final /* synthetic */ void setRequest(e.a aVar) {
        AppMethodBeat.i(130824);
        e.a aVar2 = aVar;
        this.iMO = new b();
        c.a aVar3 = (c.a) this.iMO.getReqObj();
        aVar3.Fhq.NkI = aVar2.RQK;
        aVar3.Fhq.NkJ = aVar2.RQJ;
        AppMethodBeat.o(130824);
    }

    @Override // com.tencent.mm.ak.q
    public final int securityLimitCount() {
        return 3;
    }

    @Override // com.tencent.mm.ak.q
    public final q.b securityVerificationChecked(s sVar) {
        return q.b.EOk;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return ba.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(130821);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(130821);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(130822);
        Log.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.wGj != null) {
                this.wGj.eB(new e.b(true));
                AppMethodBeat.o(130822);
                return;
            }
        } else {
            Log.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
            if (this.wGj != null) {
                this.wGj.eB(new e.b(false));
            }
        }
        AppMethodBeat.o(130822);
    }

    @Override // com.tencent.soter.a.f.a
    public final void execute() {
        AppMethodBeat.i(130823);
        Log.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        com.tencent.mm.kernel.g.azz().a(this, 0);
        AppMethodBeat.o(130823);
    }

    @Override // com.tencent.soter.a.f.a
    public final void a(b<e.b> bVar) {
        this.wGj = bVar;
    }
}

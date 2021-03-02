package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.protocal.protobuf.ebv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.f.b;
import com.tencent.soter.a.f.e;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements m, e {
    private i callback;
    private int ecL;
    private String krw = null;
    public com.tencent.mm.ak.d rr;
    private int wGi;
    private b<e.b> wGj = null;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.soter.a.f.a
    public final /* synthetic */ void setRequest(e.a aVar) {
        AppMethodBeat.i(64468);
        e.a aVar2 = aVar;
        d.a aVar3 = new d.a();
        aVar3.iLN = new ebu();
        aVar3.iLO = new ebv();
        aVar3.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar3.funcId = 1665;
        aVar3.iLP = 0;
        aVar3.respCmdId = 0;
        this.rr = aVar3.aXF();
        ebu ebu = (ebu) this.rr.iLK.iLR;
        ebu.Nbu = this.krw;
        ebu.Nbv = aVar2.RQJ;
        ebu.Nbw = aVar2.RQK;
        ebu.dPr = TenpayUtil.signWith3Des("passwd=" + ebu.Nbu);
        ebu.Nbr = this.wGi;
        ebu.Nbs = this.ecL;
        try {
            JSONObject jSONObject = new JSONObject(aVar2.RQJ);
            com.tencent.mm.plugin.soter.d.d.kV(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e2, "save device info exception", new Object[0]);
        }
        Log.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "json: %s, sign: %s", aVar2.RQJ, aVar2.RQK);
        AppMethodBeat.o(64468);
    }

    public c(String str, int i2) {
        this.krw = str;
        this.wGi = i2;
        this.ecL = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1665;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(64463);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(64463);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void d(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(64464);
        Log.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        com.tencent.mm.plugin.soter.d.m.Fid = str;
        if (this.wGj != null) {
            if (i2 == 0 && i3 == 0) {
                this.wGj.eB(new e.b(true));
                AppMethodBeat.o(64464);
                return;
            }
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(64464);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void dKB() {
        AppMethodBeat.i(64465);
        Log.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        if (this.wGj != null) {
            Log.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.wGj.eB(new e.b(false));
        }
        AppMethodBeat.o(64465);
    }

    @Override // com.tencent.mm.plugin.soter.b.d
    public final void MO(int i2) {
        AppMethodBeat.i(64466);
        Log.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", 3, Integer.valueOf(i2));
        if (this.callback != null) {
            this.callback.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(64466);
    }

    @Override // com.tencent.soter.a.f.a
    public final void execute() {
        AppMethodBeat.i(64467);
        com.tencent.mm.kernel.g.azz().a(this, 0);
        AppMethodBeat.o(64467);
    }

    @Override // com.tencent.soter.a.f.a
    public final void a(b<e.b> bVar) {
        this.wGj = bVar;
    }
}

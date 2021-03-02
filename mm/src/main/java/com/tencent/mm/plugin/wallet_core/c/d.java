package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.c.z;

public final class d extends w {
    public int HPC = 0;
    private i callback;
    public com.tencent.mm.ak.d rr;

    public d(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, int i3) {
        AppMethodBeat.i(69890);
        this.HPC = i2;
        d.a aVar = new d.a();
        aVar.iLN = new ze();
        aVar.iLO = new zf();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.funcId = 580;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ze zeVar = (ze) this.rr.iLK.iLR;
        zeVar.jfi = str;
        zeVar.KPJ = str2;
        zeVar.Lkp = str3;
        zeVar.Lkq = str4;
        zeVar.Lks = str5;
        zeVar.Lkr = str6;
        zeVar.Ljk = str7;
        zeVar.Lkt = i2;
        zeVar.Lcc = k.fQy();
        if (z.hhq()) {
            zeVar.Lku = z.getBindCardUuid();
        }
        zeVar.KHd = 1;
        zeVar.Lkw = str8;
        zeVar.Lkv = i3;
        Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, url: %s, jsapiScene: %s", str, str7, Integer.valueOf(i2));
        AppMethodBeat.o(69890);
    }

    public d(String str, String str2, String str3, String str4, String str5, String str6, int i2, String str7, String str8, String str9, int i3) {
        AppMethodBeat.i(69891);
        this.HPC = i2;
        d.a aVar = new d.a();
        aVar.iLN = new ze();
        aVar.iLO = new zf();
        aVar.uri = "/cgi-bin/mmpay-bin/checkpayjsapi";
        aVar.funcId = 580;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ze zeVar = (ze) this.rr.iLK.iLR;
        zeVar.jfi = str;
        zeVar.KPJ = str2;
        zeVar.Lkp = str3;
        zeVar.Lkq = str4;
        zeVar.Lks = str5;
        zeVar.Lkr = str6;
        zeVar.Lkt = i2;
        zeVar.UserName = str7;
        zeVar.xut = str8;
        zeVar.KHd = 2;
        zeVar.Lkw = str9;
        zeVar.Lkv = i3;
        zeVar.Lcc = k.fQy();
        if (z.hhq()) {
            zeVar.Lku = z.getBindCardUuid();
        }
        Log.i("MicroMsg.NetSceneCheckPayJsapi", "appId: %s, UserName: %s, path: %s", str, str7, str8);
        AppMethodBeat.o(69891);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 580;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69892);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69892);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69893);
        Log.d("MicroMsg.NetSceneCheckPayJsapi", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            zf zfVar = (zf) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + zfVar.rBL + " resp.ErrMsg is " + zfVar.rBM);
            ze zeVar = (ze) ((com.tencent.mm.ak.d) sVar).iLK.iLR;
            if (zeVar.Ljk != null) {
                String queryParameter = Uri.parse(zeVar.Ljk).getQueryParameter("appid");
                if (queryParameter != zeVar.jfi) {
                    h.INSTANCE.a(14954, zfVar.KxE, "", Integer.valueOf(zeVar.Lkt), zeVar.Lkw, zeVar.jfi, Integer.valueOf(zeVar.KHd), Integer.valueOf(zeVar.Lkv), zeVar.Ljk, queryParameter);
                } else {
                    h.INSTANCE.a(14954, zfVar.KxE, "", Integer.valueOf(zeVar.Lkt), zeVar.Lkw, zeVar.jfi, Integer.valueOf(zeVar.KHd), Integer.valueOf(zeVar.Lkv), zeVar.Ljk);
                }
            } else if (!(zeVar.UserName == null || zeVar.xut == null)) {
                h.INSTANCE.a(14954, zfVar.KxE, "", Integer.valueOf(zeVar.Lkt), zeVar.Lkw, zeVar.jfi, Integer.valueOf(zeVar.KHd), Integer.valueOf(zeVar.Lkv), zeVar.xut, zeVar.UserName);
            }
            Log.i("MicroMsg.NetSceneCheckPayJsapi", "NetSceneCheckPayJsapi resp.ErrCode is " + zfVar.rBL + " resp.ErrMsg is " + zfVar.rBM);
            str = zfVar.rBM;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69893);
    }

    public final String getToken() {
        return ((zf) this.rr.iLL.iLR).token;
    }

    public final String fPP() {
        return ((zf) this.rr.iLL.iLR).KxE;
    }

    public final dal fPQ() {
        return ((zf) this.rr.iLL.iLR).Lkx;
    }
}

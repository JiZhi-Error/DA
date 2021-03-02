package com.tencent.mm.plugin.wallet_core.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class e extends w {
    public int HPC;
    public zx HPD;
    private i callback;
    private d rr;

    public e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        this(str, str2, str3, str4, str5, str6, str7, str8, i2, (byte) 0);
    }

    private e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, byte b2) {
        AppMethodBeat.i(69894);
        this.HPC = 0;
        this.HPC = 5;
        d.a aVar = new d.a();
        aVar.iLN = new zw();
        aVar.iLO = new zx();
        aVar.uri = "/cgi-bin/mmpay-bin/checkuserauthjsapi";
        aVar.funcId = 2728;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        zw zwVar = (zw) this.rr.iLK.iLR;
        zwVar.jfi = str;
        zwVar.KPJ = str2;
        zwVar.Lkp = str3;
        zwVar.Lkq = str4;
        zwVar.Lks = str5;
        zwVar.Lkr = str6;
        zwVar.Ljk = str7;
        zwVar.Lkt = 5;
        zwVar.Lcc = k.fQy();
        zwVar.KHd = 1;
        zwVar.UserName = null;
        zwVar.xut = null;
        zwVar.Lkw = str8;
        zwVar.Lkv = i2;
        boolean dJO = ((a) g.af(a.class)).dJO();
        com.tencent.mm.plugin.soter.d.e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str9 = flM.FhU;
        String str10 = flM.hFF;
        zwVar.Llf = 0;
        zwVar.FhU = str9;
        zwVar.hFF = str10;
        zwVar.Llg = dJO ? 1 : 0;
        Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "cpu_id: %s, uid: %s", str9, str10);
        Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "appId: %s, url: %s, jsapiScene: %s, isOpenTouchPay: %b", str, str7, 5, Boolean.valueOf(dJO));
        AppMethodBeat.o(69894);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 580;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(69895);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69895);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69896);
        Log.d("MicroMsg.NetSceneCheckUserAuthJsapi", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            this.HPD = (zx) ((d) sVar).iLL.iLR;
            zw zwVar = (zw) ((d) sVar).iLK.iLR;
            if (zwVar.Ljk != null) {
                String queryParameter = Uri.parse(zwVar.Ljk).getQueryParameter("appid");
                if (queryParameter != zwVar.jfi) {
                    h.INSTANCE.a(14954, this.HPD.KxE, "", Integer.valueOf(zwVar.Lkt), zwVar.Lkw, zwVar.jfi, Integer.valueOf(zwVar.KHd), Integer.valueOf(zwVar.Lkv), zwVar.Ljk, queryParameter);
                } else {
                    h.INSTANCE.a(14954, this.HPD.KxE, "", Integer.valueOf(zwVar.Lkt), zwVar.Lkw, zwVar.jfi, Integer.valueOf(zwVar.KHd), Integer.valueOf(zwVar.Lkv), zwVar.Ljk);
                }
            } else if (!(zwVar.UserName == null || zwVar.xut == null)) {
                h.INSTANCE.a(14954, this.HPD.KxE, "", Integer.valueOf(zwVar.Lkt), zwVar.Lkw, zwVar.jfi, Integer.valueOf(zwVar.KHd), Integer.valueOf(zwVar.Lkv), zwVar.xut, zwVar.UserName);
            }
            Log.i("MicroMsg.NetSceneCheckUserAuthJsapi", "CheckUserAuthJsapiResponse resp.ErrCode is " + this.HPD.rBL + " resp.ErrMsg is " + this.HPD.rBM);
            str = this.HPD.rBM;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69896);
    }
}

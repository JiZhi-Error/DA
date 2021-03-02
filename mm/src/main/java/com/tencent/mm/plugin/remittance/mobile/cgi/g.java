package com.tencent.mm.plugin.remittance.mobile.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ekh;
import com.tencent.mm.protocal.protobuf.eki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends a {
    private eki Cmc;
    public int Cmd;
    public boolean Cme;
    public boolean Cmf;
    private final String TAG = "MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder";
    public int yRL;

    public g(String str, String str2, String str3, double d2, String str4, int i2, String str5, String str6, boolean z, String str7, boolean z2) {
        AppMethodBeat.i(67656);
        d.a aVar = new d.a();
        aVar.iLN = new ekh();
        aVar.iLO = new eki();
        aVar.funcId = 2878;
        aVar.uri = "/cgi-bin/mmpay-bin/transferphoneplaceorder";
        this.rr = aVar.aXF();
        ekh ekh = (ekh) this.rr.iLK.iLR;
        ekh.Njb = str;
        ekh.Njc = str2;
        ekh.Njd = str3;
        ekh.yRL = (int) Math.round(100.0d * d2);
        ekh.desc = str4;
        ekh.Nju = i2;
        ekh.Njf = str5;
        ekh.Njp = str6;
        if (z) {
            ekh.Njv = Util.nullAs(str7, "");
        }
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "do scene NetSceneMobileRemitGetRecord rcvr_openid:%s rcvr_token:%s get_rcvr_ext%s amount:%s desc:%s delay_code:%s real_name_token:%s timestamp_ms:%s isFromForceCheckName:%s replaceorder_token:%s", str, str2, str3, Double.valueOf(d2), str4, Integer.valueOf(i2), str5, str6, Boolean.valueOf(z), Util.nullAs(str7, BuildConfig.COMMAND));
        this.yRL = ekh.yRL;
        this.Cmd = ekh.Nju;
        this.Cme = z;
        this.Cmf = z2;
        AppMethodBeat.o(67656);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void b(int i2, int i3, String str, s sVar) {
        AppMethodBeat.i(67657);
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.Cmc = (eki) ((d) sVar).iLL.iLR;
        Log.i("MicroMsg.mobileRemit.NetSceneMobileRemitPlaceOrder", "ret_code: %s, ret_msg: %s", Integer.valueOf(this.Cmc.pTZ), this.Cmc.pUa);
        if (this.callback != null) {
            this.callback.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(67657);
    }

    @Override // com.tencent.mm.wallet_core.c.r
    public final void e(s sVar) {
        eki eki = (eki) ((d) sVar).iLL.iLR;
        this.RtZ = eki.pTZ;
        this.Rua = eki.pUa;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2878;
    }

    public final eki eNo() {
        if (this.Cmc == null) {
            return null;
        }
        return this.Cmc;
    }
}

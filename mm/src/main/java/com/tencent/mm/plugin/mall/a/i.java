package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback;
    private d rr;
    public exh zjx;

    public i() {
        boolean z;
        AppMethodBeat.i(66000);
        d.a aVar = new d.a();
        aVar.iLN = new dae();
        aVar.iLO = new daf();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        aVar.funcId = 1577;
        this.rr = aVar.aXF();
        dae dae = (dae) this.rr.iLK.iLR;
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        dae.MFl = z ? 1 : 0;
        dae.language = LocaleUtil.getApplicationLanguage();
        dae.MFo = Build.VERSION.RELEASE;
        dae.MFn = ChannelUtil.formatVersion(null, com.tencent.mm.protocal.d.KyO);
        dae.MFp = Build.MANUFACTURER;
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", Integer.valueOf(dae.MFl), dae.language, dae.MFo, dae.MFn, dae.MFp);
        AppMethodBeat.o(66000);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66001);
        Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i4 + ", errMsg " + str);
        if (i3 == 0 && i4 == 0) {
            daf daf = (daf) ((d) sVar).iLL.iLR;
            if (daf.MFs == null || daf.MFt == null) {
                Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + daf.zjs);
            } else {
                Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd wallet_region : %s wallet_gray_area: %s wallet_threepoint_area size: %s", Integer.valueOf(daf.zjs), Integer.valueOf(daf.MFs.LSL.size()), Integer.valueOf(daf.MFt.LSL.size()));
                if (daf.MFw != null) {
                    this.zjx = daf.MFw;
                    Log.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "wallet_key_info flag %s wallet_key_info.url %s", Integer.valueOf(daf.MFw.NuH), daf.MFw.url);
                }
            }
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(daf.zjs));
            c.cjL();
            t.fQO().a(daf.zjs, daf);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(66001);
    }

    public final String egK() {
        if (this.zjx == null) {
            return "";
        }
        return this.zjx.url;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1577;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(66002);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(66002);
        return dispatch;
    }
}

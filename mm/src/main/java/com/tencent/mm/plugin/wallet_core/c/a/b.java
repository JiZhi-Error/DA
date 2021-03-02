package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dac;
import com.tencent.mm.protocal.protobuf.dad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.w;

public final class b extends w {
    public int HQH = 0;
    private i callback;
    public String jumpUrl;
    private d rr;

    public b() {
        boolean z;
        int i2;
        AppMethodBeat.i(69970);
        d.a aVar = new d.a();
        dac dac = new dac();
        g.aAi();
        Object obj = g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.FALSE);
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        } else {
            z = false;
        }
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        dac.MFl = i2;
        aVar.iLN = dac;
        aVar.iLO = new dad();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.funcId = 1564;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(69970);
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        AppMethodBeat.i(69971);
        Log.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        dad dad = (dad) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            Log.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", Integer.valueOf(dad.rBL), dad.rBM);
            str = dad.rBM;
            i4 = dad.rBL;
            this.jumpUrl = dad.xIy;
            this.HQH = dad.MFm;
        } else {
            Log.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (Util.isNullOrNil(str)) {
            str = MMApplicationContext.getContext().getString(R.string.ibn);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69971);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1564;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(69972);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69972);
        return dispatch;
    }
}

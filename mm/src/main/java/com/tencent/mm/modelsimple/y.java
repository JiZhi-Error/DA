package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;

public final class y extends q implements m {
    private i callback;
    private final s iMO;

    public y(int i2, String str) {
        this(i2, str, "");
    }

    public y(int i2, String str, String str2) {
        AppMethodBeat.i(150946);
        this.iMO = new e();
        z.a aVar = (z.a) this.iMO.getReqObj();
        aVar.KAp.UserName = com.tencent.mm.model.z.aTY();
        aVar.KAp.iAc = (i2 == 0 ? 64 : i2) + ";" + (str == null ? "" : str);
        Log.d("MicroMsg.NetSceneSendCard", "content:" + aVar.KAp.iAc);
        Assert.assertTrue("empty sendcard", true);
        aVar.KAp.MyL = 64;
        if (str2 != null && str2.length() > 0) {
            aVar.KAp.MVB = str2;
        }
        AppMethodBeat.o(150946);
    }

    public y(String str) {
        AppMethodBeat.i(150947);
        this.iMO = new e();
        z.a aVar = (z.a) this.iMO.getReqObj();
        aVar.KAp.UserName = com.tencent.mm.model.z.aTY();
        aVar.KAp.iAc = str;
        Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        aVar.KAp.KUh = Util.nullAsNil((Integer) g.aAh().azQ().get(66561, (Object) null));
        Assert.assertTrue("empty sendcard", true);
        aVar.KAp.MyL = 128;
        AppMethodBeat.o(150947);
    }

    public y(String str, boolean z, boolean z2) {
        int i2;
        AppMethodBeat.i(150948);
        this.iMO = new e();
        z.a aVar = (z.a) this.iMO.getReqObj();
        aVar.KAp.UserName = com.tencent.mm.model.z.aTY();
        aVar.KAp.iAc = str;
        Log.d("MicroMsg.NetSceneSendCard", "content:".concat(String.valueOf(str)));
        aVar.KAp.KUh = Util.nullAsNil((Integer) g.aAh().azQ().get(66561, (Object) null));
        int i3 = (z ? 1 : 0) | 0 | 0;
        if (z2) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        Assert.assertTrue("empty sendcard", true);
        aVar.KAp.MyL = i2 | i3 | 8;
        AppMethodBeat.o(150948);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(150949);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iMO, this);
        AppMethodBeat.o(150949);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 26;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150950);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, sVar.getRespObj().getErrMsg(), this);
        AppMethodBeat.o(150950);
    }
}

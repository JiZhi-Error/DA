package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bff;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;

public final class c extends com.tencent.mm.ak.c<bfg> {
    public c(String str, String str2, int i2) {
        AppMethodBeat.i(213269);
        bff bff = new bff();
        bff.egX = str;
        bff.yQE = str2;
        bff.msgType = 1;
        bff.LON = i2;
        as Kn = ((l) g.af(l.class)).aSN().Kn(z.aTY());
        if (Kn != null) {
            bff.fuJ = Kn.gBR();
            bff.fuK = Kn.getCityCode();
        }
        d.a aVar = new d.a();
        aVar.iLN = bff;
        aVar.iLO = new bfg();
        aVar.funcId = 4787;
        aVar.uri = "/cgi-bin/mmpay-bin/foreignhbreceive";
        d aXF = aVar.aXF();
        aXF.setIsUserCmd(true);
        c(aXF);
        Log.i("MicroMsg.CgiHKHbReceive", "nativeUrl: %s, sendId: %s", str, str2);
        AppMethodBeat.o(213269);
    }
}

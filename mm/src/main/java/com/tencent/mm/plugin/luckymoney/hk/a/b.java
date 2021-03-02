package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.bfd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;

public final class b extends c<bfd> {
    public b(String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(213268);
        bfc bfc = new bfc();
        bfc.egX = str;
        bfc.yQE = str2;
        bfc.LOM = str3;
        bfc.msgType = 1;
        bfc.LON = i2;
        bfc.yXR = str4;
        as Kn = ((l) g.af(l.class)).aSN().Kn(z.aTY());
        if (Kn != null) {
            bfc.fuJ = Kn.gBR();
            bfc.fuK = Kn.getCityCode();
        }
        d.a aVar = new d.a();
        aVar.iLN = bfc;
        aVar.iLO = new bfd();
        aVar.funcId = 4583;
        aVar.uri = "/cgi-bin/mmpay-bin/foreignhbopen";
        d aXF = aVar.aXF();
        aXF.setIsUserCmd(true);
        c(aXF);
        Log.i("MicroMsg.CgiHKHbOpen", "nativeUrl: %s, sendId: %s, username: %s", str, str2, str3);
        AppMethodBeat.o(213268);
    }
}

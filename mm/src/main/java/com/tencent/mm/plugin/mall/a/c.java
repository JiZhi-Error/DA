package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.protocal.protobuf.dik;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c extends com.tencent.mm.ak.c<dil> {
    public c(long j2, dil dil) {
        AppMethodBeat.i(65989);
        dik dik = new dik();
        dik.MMR = (int) j2;
        dik.MMS = b.bfZ("all_type");
        bf fQy = k.fQy();
        if (fQy != null) {
            if (!Util.isNullOrNil(fQy.fuJ)) {
                dik.MMT = b.bfZ(fQy.fuJ);
            }
            if (!Util.isNullOrNil(fQy.fuK)) {
                dik.MMU = b.bfZ(fQy.fuK);
            }
        }
        a aVar = (a) g.af(a.class);
        dik.Llf = 0;
        if (aVar != null) {
            dik.Llg = 1;
        } else {
            dik.Llg = 0;
        }
        dik.MMV = 1;
        dik.timestamp = System.currentTimeMillis();
        if (dil.BaseResponse == null) {
            dil.BaseResponse = new BaseResponse();
            dil.BaseResponse.ErrMsg = new dqi().bhy("");
            dil.BaseResponse.Ret = 0;
        }
        dik.MMW = dil;
        d.a aVar2 = new d.a();
        aVar2.iLN = dik;
        aVar2.iLO = new dil();
        aVar2.funcId = 2672;
        aVar2.uri = "/cgi-bin/mmpay-bin/tenpay/querywechatwallet";
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        c(aVar2.aXF());
        Log.i("MicroMsg.CgiQueryWeChatWallet", "balanceVersion: %s, isRoot: %s, openTouch: %s", Long.valueOf(j2), Integer.valueOf(dik.Llf), Integer.valueOf(dik.Llg));
        AppMethodBeat.o(65989);
    }
}

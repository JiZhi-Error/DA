package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.protocal.protobuf.cqz;
import com.tencent.mm.protocal.protobuf.cra;
import com.tencent.mm.protocal.protobuf.ehn;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends com.tencent.mm.ak.c<cra> {
    public c(ehn ehn) {
        AppMethodBeat.i(68400);
        cqz cqz = new cqz();
        cqz.Mwt = ehn;
        cqz.time_stamp = (int) System.currentTimeMillis();
        cqz.HuS = ag.fNb();
        d.a aVar = new d.a();
        aVar.iLN = cqz;
        aVar.iLO = new cra();
        aVar.funcId = 1640;
        aVar.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/modifytrantime";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Object[] objArr = new Object[1];
        objArr[0] = ehn != null ? Integer.valueOf(ehn.Nhb) : BuildConfig.COMMAND;
        Log.i("MicroMsg.CgiLqtAutoChargeModifyTime", "modify time: %s", objArr);
        AppMethodBeat.o(68400);
    }
}

package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.protocal.protobuf.adf;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;

public final class c extends com.tencent.mm.ak.c<adg> {
    public c(String str) {
        AppMethodBeat.i(65162);
        adf adf = new adf();
        adf.Lot = str;
        d.a aVar = new d.a();
        aVar.iLN = adf;
        aVar.iLO = new adg();
        if (((b) g.af(b.class)).a(b.a.clicfg_hongbao_envelope_transfer_new_cgi, 1) == 1) {
            aVar.funcId = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
            aVar.uri = "/cgi-bin/micromsg-bin/deleteshowsourcenew";
        } else {
            aVar.funcId = 2665;
            aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource";
        }
        c(aVar.aXF());
        AppMethodBeat.o(65162);
    }
}

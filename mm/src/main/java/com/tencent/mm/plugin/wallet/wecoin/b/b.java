package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.adm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiConsumeWecoinRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/ConsumeWecoinResponse;", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sessionID", "", "signBuff", "(Lcom/tencent/mm/protobuf/ByteString;Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class b extends l<adm> {
    public b(com.tencent.mm.bw.b bVar, String str, com.tencent.mm.bw.b bVar2) {
        p.h(bVar, "ctxBuff");
        p.h(bVar2, "signBuff");
        AppMethodBeat.i(212688);
        adl adl = new adl();
        adl.LoA = bVar2;
        adl.Loz = bVar;
        adl.LoB = str;
        a(adl, new adm(), 5994, "/cgi-bin/micromsg-bin/consumewecoin");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiConsumeWecoinRequest: ctxBuff: " + bVar + ", sign: " + bVar2 + ", sessionID: " + str);
        AppMethodBeat.o(212688);
    }
}

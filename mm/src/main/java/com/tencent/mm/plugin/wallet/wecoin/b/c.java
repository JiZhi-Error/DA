package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiEncashIncomeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/EncashIncomeResponse;", "token", "", "ctxBuff", "Lcom/tencent/mm/protobuf/ByteString;", "sign", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-wxpay_release"})
public final class c extends l<aji> {
    public c(String str, b bVar, b bVar2) {
        p.h(str, "token");
        p.h(bVar, "ctxBuff");
        p.h(bVar2, "sign");
        AppMethodBeat.i(212689);
        ajh ajh = new ajh();
        ajh.Loz = bVar;
        ajh.LoA = bVar2;
        ajh.token = str;
        a(ajh, new aji(), 5991, "/cgi-bin/micromsg-bin/encashincome");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiEncashIncomeRequest: ctx_buff: " + bVar + ", sign: " + bVar2);
        AppMethodBeat.o(212689);
    }
}

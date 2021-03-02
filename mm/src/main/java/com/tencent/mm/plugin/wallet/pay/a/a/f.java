package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class f extends c {
    public f(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c
    public final void aX(Map<String, String> map) {
        AppMethodBeat.i(69270);
        map.put("busi_scene", this.HFI.dDj);
        AppMethodBeat.o(69270);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1259;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69271);
        h.INSTANCE.idkeyStat(663, 20, 1, false);
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69271);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69272);
        super.onGYNetEnd(i2, str, jSONObject);
        if (i2 != 0) {
            h.INSTANCE.idkeyStat(663, 21, 1, false);
        }
        AppMethodBeat.o(69272);
    }
}

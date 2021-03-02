package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;
import java.util.Map;
import org.json.JSONObject;

public final class i extends b {
    public i(v vVar, Orders orders) {
        super(vVar, orders);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.a.d.b, com.tencent.mm.plugin.wallet.pay.a.d.g
    public final void aX(Map<String, String> map) {
        AppMethodBeat.i(69296);
        map.put("busi_scene", this.HFW.dDj);
        AppMethodBeat.o(69296);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.b, com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1281;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.b, com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.b, com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(69297);
        h.INSTANCE.idkeyStat(663, 26, 1, false);
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69297);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.plugin.wallet.pay.a.d.b, com.tencent.mm.wallet_core.c.s, com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.n
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69298);
        super.onGYNetEnd(i2, str, jSONObject);
        h.INSTANCE.idkeyStat(663, 27, 1, false);
        AppMethodBeat.o(69298);
    }
}

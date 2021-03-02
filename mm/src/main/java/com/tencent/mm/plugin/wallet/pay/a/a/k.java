package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public final class k extends c {
    public k(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c
    public final void aX(Map<String, String> map) {
        AppMethodBeat.i(69273);
        map.put("busi_scene", this.HFI.dDj);
        AppMethodBeat.o(69273);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1274;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69274);
        h.INSTANCE.idkeyStat(663, 24, 1, false);
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69274);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.plugin.wallet.pay.a.a.c, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69275);
        super.onGYNetEnd(i2, str, jSONObject);
        if (i2 != 0) {
            h.INSTANCE.idkeyStat(663, 25, 1, false);
        }
        AppMethodBeat.o(69275);
    }
}

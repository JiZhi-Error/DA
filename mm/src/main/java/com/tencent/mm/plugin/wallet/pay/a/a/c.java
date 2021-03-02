package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import java.util.Map;
import org.json.JSONObject;

public class c extends b {
    private boolean HFQ;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.HFQ = z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b
    public void aX(Map<String, String> map) {
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 120;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        return 1600;
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69268);
        int doScene = super.doScene(gVar, iVar);
        AppMethodBeat.o(69268);
        return doScene;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69269);
        super.onGYNetEnd(i2, str, jSONObject);
        AppMethodBeat.o(69269);
    }
}

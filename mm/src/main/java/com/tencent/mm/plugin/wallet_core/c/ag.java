package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.storage.ar;
import org.json.JSONObject;

public final class ag extends ad {
    public al HwB;

    public ag() {
        super(null, 3);
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2750;
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2750;
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/savebindquery";
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69959);
        super.onGYNetEnd(i2, str, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("save_to_lqt_entry");
        if (optJSONObject != null) {
            ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_BALANCE_LQT_OPERATION_STRING_SYNC, optJSONObject.toString());
            this.HwB = al.bx(optJSONObject);
        }
        AppMethodBeat.o(69959);
    }
}

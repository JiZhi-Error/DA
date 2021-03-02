package com.tencent.mm.plugin.wallet_core.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import org.json.JSONObject;

public final class a extends d {
    private static a Icx = null;

    public static a fSl() {
        AppMethodBeat.i(70575);
        if (Icx == null) {
            Icx = new a();
        }
        a aVar = Icx;
        AppMethodBeat.o(70575);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.wallet_core.model.d
    public final Bankcard bA(JSONObject jSONObject) {
        AppMethodBeat.i(70576);
        Bankcard bA = super.bA(jSONObject);
        bA.field_ext_msg = b.bU(jSONObject);
        bA.field_bankcardClientType = 1;
        bA.field_desc = jSONObject.optString("description");
        bA.field_trueName = jSONObject.optString("name_on_card");
        if ("CREDITCARD_PAYU".equals(jSONObject.optString("bank_type"))) {
            bA.field_cardType |= Bankcard.HVp;
        } else {
            bA.field_cardType |= Bankcard.HVr;
        }
        AppMethodBeat.o(70576);
        return bA;
    }
}

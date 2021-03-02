package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends m {
    public String AJx = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private String AJy = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private boolean AJz = false;
    public String dSf = "";

    public i(Bankcard bankcard, String str, String str2, int i2, String str3) {
        AppMethodBeat.i(66296);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("oper", str2);
        if (str2.equals("changeto")) {
            if (TextUtils.isEmpty(str3)) {
                hashMap.put("verify_code", "");
            } else {
                hashMap.put("verify_code", str3);
            }
            hashMap.put("chg_fee", String.valueOf(i2));
            hashMap.put("bind_serialno", bankcard.field_bindSerial);
            hashMap.put("bank_type", bankcard.field_bankcardType);
            hashMap.put("card_tail", bankcard.field_bankcardTail);
        }
        this.dSf = bankcard.field_mobile;
        setRequestData(hashMap);
        AppMethodBeat.o(66296);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 50;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66297);
        if (jSONObject != null) {
            this.AJx = jSONObject.optString("verify_flag");
            this.AJy = jSONObject.optString("limit_fee");
        }
        AppMethodBeat.o(66297);
    }
}

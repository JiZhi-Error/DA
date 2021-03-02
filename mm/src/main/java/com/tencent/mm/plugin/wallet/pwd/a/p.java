package com.tencent.mm.plugin.wallet.pwd.a;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.d;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends m {
    private Map<String, String> AJV = new HashMap();
    public boolean HFE;
    private String token = null;

    public p(Authen authen, boolean z, int i2) {
        AppMethodBeat.i(69567);
        this.AJV.put("flag", new StringBuilder().append(authen.cSx).toString());
        if (!Util.isNullOrNil(authen.HUV)) {
            this.AJV.put("first_name", authen.HUV);
            this.AJV.put("last_name", authen.HUW);
            this.AJV.put(UserDataStore.COUNTRY, authen.country);
            this.AJV.put("area", authen.fuJ);
            this.AJV.put("city", authen.fuK);
            this.AJV.put("address", authen.iUO);
            this.AJV.put("phone_number", authen.ynV);
            this.AJV.put("zip_code", authen.ksV);
            this.AJV.put(Scopes.EMAIL, authen.fuD);
        }
        this.AJV.put("business_source", String.valueOf(i2));
        this.AJV.put("bank_type", authen.dDj);
        if (authen.HUQ > 0) {
            this.AJV.put("cre_type", new StringBuilder().append(authen.HUQ).toString());
        }
        if (!Util.isNullOrNil(authen.HTZ)) {
            this.AJV.put("true_name", authen.HTZ);
        }
        if (!Util.isNullOrNil(authen.HUP)) {
            this.AJV.put("identify_card", authen.HUP);
        }
        this.AJV.put("mobile_no", authen.HQc);
        this.AJV.put("bank_card_id", authen.HUR);
        if (!Util.isNullOrNil(authen.HUS)) {
            this.AJV.put("cvv2", authen.HUS);
        }
        if (!Util.isNullOrNil(authen.HUT)) {
            this.AJV.put("valid_thru", authen.HUT);
        }
        this.AJV.put("new_card_reset_pwd", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        setRequestData(this.AJV);
        AppMethodBeat.o(69567);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean resend() {
        AppMethodBeat.i(69568);
        super.resend();
        this.AJV.put("is_repeat_send", "1");
        setRequestData(this.AJV);
        this.HFE = true;
        AppMethodBeat.o(69568);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 10;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69569);
        if (jSONObject != null) {
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.o(69569);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final String getToken() {
        return this.token;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdauthen";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return d.CTRL_INDEX;
    }
}

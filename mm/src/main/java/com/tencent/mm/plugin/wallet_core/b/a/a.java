package com.tencent.mm.plugin.wallet_core.b.a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends m {
    private Map<String, String> AJV = new HashMap();
    public boolean HFE;
    private Map<String, String> HFF = new HashMap();
    public u HPz;
    public String mReqKey = null;
    private String token = null;

    public a(Authen authen, String str, String str2) {
        AppMethodBeat.i(69882);
        setPayInfo(authen.BDB, this.AJV, this.HFF);
        this.AJV.put("flag", new StringBuilder().append(authen.cSx).toString());
        this.AJV.put("bank_type", authen.dDj);
        this.AJV.put("mobile_area", authen.HVd);
        this.AJV.put("session_id", str2);
        if (!Util.isNullOrNil(authen.HUO)) {
            this.AJV.put("passwd", authen.HUO);
        }
        if (!Util.isNullOrNil(authen.token)) {
            this.AJV.put("token", authen.token);
        }
        if (!Util.isNullOrNil(authen.HCy)) {
            g.aAi();
            p pVar = new p(Util.nullAs((Integer) g.aAh().azQ().get(9, (Object) null), 0));
            this.AJV.put("import_code", authen.HCy);
            this.AJV.put("qqid", pVar.toString());
            if (authen.HUQ > 0) {
                this.AJV.put("cre_type", new StringBuilder().append(authen.HUQ).toString());
            }
            this.AJV.put("bind_serailno", authen.ANo);
        }
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
            this.AJV.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getApplicationLanguage());
        }
        if (!Util.isNullOrNil(authen.HTZ)) {
            this.AJV.put("true_name", authen.HTZ);
        }
        if (!Util.isNullOrNil(authen.HUP)) {
            this.AJV.put("identify_card", authen.HUP);
        }
        if (authen.HUQ > 0) {
            this.AJV.put("cre_type", new StringBuilder().append(authen.HUQ).toString());
        }
        if (!Util.isNullOrNil(authen.HQc)) {
            this.AJV.put("mobile_no", authen.HQc);
        }
        this.AJV.put("bank_card_id", authen.HUR);
        if (!Util.isNullOrNil(authen.HUS)) {
            this.AJV.put("cvv2", authen.HUS);
        }
        if (!Util.isNullOrNil(authen.HUT)) {
            this.AJV.put("valid_thru", authen.HUT);
        }
        if (authen.cSx == 1 || authen.cSx == 2) {
            this.AJV.put("creid_renewal", String.valueOf(authen.HUj));
            this.AJV.put("birth_date", authen.HUo);
            this.AJV.put("cre_expire_date", authen.HUk);
        }
        if ((authen.cSx == 2 || authen.cSx == 5) && authen.HVe == 1 && !Util.isNullOrNil(authen.HQm)) {
            this.AJV.put("verify_user_token", "1");
            this.AJV.put("usertoken", authen.HQm);
        }
        if (!Util.isNullOrNil(authen.HVf) && authen.HVf.isEmpty()) {
            this.AJV.put("checkpayjsapi_token", authen.HVf);
        }
        if (z.hhq()) {
            this.HFF.put("uuid_for_bindcard", z.getBindCardUuid());
            this.HFF.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        if (!Util.isNullOrNil(str)) {
            this.AJV.put("has_underage_alert", str);
        }
        setRequestData(this.AJV);
        setWXRequestData(this.HFF);
        AppMethodBeat.o(69882);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean resend() {
        AppMethodBeat.i(69883);
        super.resend();
        this.AJV.put("is_repeat_send", "1");
        setRequestData(this.AJV);
        this.HFE = true;
        AppMethodBeat.o(69883);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 12;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69884);
        if (jSONObject != null) {
            this.mReqKey = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
            this.HPz = u.bM(jSONObject);
        }
        AppMethodBeat.o(69884);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final String getToken() {
        return this.token;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 471;
    }
}

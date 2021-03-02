package com.tencent.mm.plugin.wallet.pay.a.a;

import com.facebook.appevents.UserDataStore;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.d.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.utils.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class b extends n {
    private Map<String, String> AJV;
    public boolean HFE;
    private Map<String, String> HFF;
    public boolean HFG;
    public Orders HFH;
    public Authen HFI;
    public String HFJ;
    public String HFK;
    private String HFL;
    public int HFM;
    public String HFN;
    public int HFO;
    public JSONArray HFP;
    private String token;

    public b(Authen authen, Orders orders) {
        this(authen, orders, false);
    }

    public b(Authen authen, Orders orders, boolean z) {
        this(authen, orders, z, (byte) 0);
    }

    private b(Authen authen, Orders orders, boolean z, byte b2) {
        boolean z2 = true;
        AppMethodBeat.i(69264);
        this.HFG = false;
        this.HFH = null;
        this.token = null;
        this.HFJ = null;
        this.HFK = null;
        this.HFL = null;
        this.HFM = 0;
        this.HFO = 0;
        this.HFI = authen;
        this.HFH = orders;
        if (authen == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("authen == null");
            AppMethodBeat.o(69264);
            throw illegalArgumentException;
        }
        a(orders, authen);
        if (authen.BDB == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("authen.payInfo == null");
            AppMethodBeat.o(69264);
            throw illegalArgumentException2;
        }
        Log.i("MicroMsg.NetSceneTenpayAuthen", "pay channel :" + authen.BDB.channel);
        this.AJV = new HashMap();
        this.HFF = new HashMap();
        boolean z3 = !z && !Util.isNullOrNil(this.HFI.HUO);
        Log.i("MicroMsg.NetSceneTenpayAuthen", "hy: has pwd: %b", Boolean.valueOf(z3));
        setPayInfo(authen.BDB, this.AJV, this.HFF, z3);
        if (z) {
            this.AJV.put("brief_reg", "1");
        } else {
            this.AJV.put("passwd", authen.HUO);
        }
        this.HZm = orders.HZm;
        this.AJV.put("default_favorcomposedid", authen.HUX);
        this.AJV.put("favorcomposedid", authen.HUY);
        this.AJV.put("arrive_type", authen.HUU);
        this.AJV.put("sms_flag", authen.HUZ);
        this.AJV.put("ban_sms_bind_serial", authen.HVa);
        this.AJV.put("ban_sms_bank_type", authen.HVb);
        this.AJV.put("busi_sms_flag", authen.HVc);
        this.AJV.put("buttontype", new StringBuilder().append(authen.BDB.Kxz).toString());
        this.AJV.put("mobile_area", authen.HVd);
        Log.i("MicroMsg.NetSceneTenpayAuthen", "buttontype %s not_support_retry %s, mobile area: %s", Integer.valueOf(authen.BDB.Kxz), Integer.valueOf(this.HZm), authen.HVd);
        switch (authen.cSx) {
            case 1:
                this.AJV.put("flag", "1");
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("true_name", authen.HTZ);
                this.AJV.put("identify_card", authen.HUP);
                if (authen.HUQ > 0) {
                    this.AJV.put("cre_type", new StringBuilder().append(authen.HUQ).toString());
                }
                this.AJV.put("mobile_no", authen.HQc);
                this.AJV.put("bank_card_id", authen.HUR);
                if (!Util.isNullOrNil(authen.HUS)) {
                    this.AJV.put("cvv2", authen.HUS);
                }
                if (!Util.isNullOrNil(authen.HUT)) {
                    this.AJV.put("valid_thru", authen.HUT);
                }
                this.AJV.put("creid_renewal", String.valueOf(authen.HUj));
                this.AJV.put("birth_date", authen.HUo);
                this.AJV.put("cre_expire_date", authen.HUk);
                break;
            case 2:
                this.AJV.put("flag", "2");
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("h_bind_serial", authen.ANo);
                this.AJV.put("card_tail", authen.xxN);
                if (!Util.isNullOrNil(authen.HTZ)) {
                    this.AJV.put("true_name", authen.HTZ);
                }
                if (!Util.isNullOrNil(authen.HUP)) {
                    this.AJV.put("identify_card", authen.HUP);
                }
                this.AJV.put("cre_type", new StringBuilder().append(authen.HUQ).toString());
                this.AJV.put("mobile_no", authen.HQc);
                this.AJV.put("bank_card_id", authen.HUR);
                if (!Util.isNullOrNil(authen.HUS)) {
                    this.AJV.put("cvv2", authen.HUS);
                }
                if (!Util.isNullOrNil(authen.HUT)) {
                    this.AJV.put("valid_thru", authen.HUT);
                }
                this.AJV.put("creid_renewal", String.valueOf(authen.HUj));
                this.AJV.put("birth_date", authen.HUo);
                this.AJV.put("cre_expire_date", authen.HUk);
                break;
            case 3:
                if (authen.HUN == 1) {
                    this.AJV.put("reset_flag", "1");
                    if (!Util.isNullOrNil(authen.HQc)) {
                        this.AJV.put("mobile_no", authen.HQc);
                    }
                    if (!Util.isNullOrNil(authen.HUS)) {
                        this.AJV.put("cvv2", authen.HUS);
                    }
                    if (!Util.isNullOrNil(authen.HUT)) {
                        this.AJV.put("valid_thru", authen.HUT);
                    }
                }
                this.AJV.put("flag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("bind_serial", authen.ANo);
                break;
            case 4:
                this.AJV.put("flag", "4");
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("first_name", authen.HUV);
                this.AJV.put("last_name", authen.HUW);
                this.AJV.put(UserDataStore.COUNTRY, authen.country);
                this.AJV.put("area", authen.fuJ);
                this.AJV.put("city", authen.fuK);
                this.AJV.put("address", authen.iUO);
                this.AJV.put("phone_number", authen.ynV);
                this.AJV.put("zip_code", authen.ksV);
                this.AJV.put(Scopes.EMAIL, authen.fuD);
                this.AJV.put("bank_card_id", authen.HUR);
                if (!Util.isNullOrNil(authen.HUS)) {
                    this.AJV.put("cvv2", authen.HUS);
                }
                if (!Util.isNullOrNil(authen.HUT)) {
                    this.AJV.put("valid_thru", authen.HUT);
                    break;
                }
                break;
            case 5:
                this.AJV.put("flag", "5");
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("first_name", authen.HUV);
                this.AJV.put("last_name", authen.HUW);
                this.AJV.put(UserDataStore.COUNTRY, authen.country);
                this.AJV.put("area", authen.fuJ);
                this.AJV.put("city", authen.fuK);
                this.AJV.put("address", authen.iUO);
                this.AJV.put("phone_number", authen.ynV);
                this.AJV.put("zip_code", authen.ksV);
                this.AJV.put(Scopes.EMAIL, authen.fuD);
                this.AJV.put("bank_card_id", authen.HUR);
                if (!Util.isNullOrNil(authen.HUS)) {
                    this.AJV.put("cvv2", authen.HUS);
                }
                if (!Util.isNullOrNil(authen.HUT)) {
                    this.AJV.put("valid_thru", authen.HUT);
                }
                this.AJV.put("h_bind_serial", authen.ANo);
                this.AJV.put("card_tail", authen.xxN);
                break;
            case 6:
                if (authen.HUN == 1) {
                    this.AJV.put("reset_flag", "1");
                    if (!Util.isNullOrNil(authen.HUS)) {
                        this.AJV.put("cvv2", authen.HUS);
                    }
                    if (!Util.isNullOrNil(authen.HUT)) {
                        this.AJV.put("valid_thru", authen.HUT);
                    }
                }
                this.AJV.put("phone_number", authen.HQc);
                this.AJV.put("flag", "6");
                this.AJV.put("bank_type", authen.dDj);
                this.AJV.put("bind_serial", authen.ANo);
                break;
        }
        aX(this.AJV);
        setRequestData(this.AJV);
        Map<String, String> dJZ = ((a) g.af(a.class)).dJZ();
        if (dJZ != null) {
            this.HFF.putAll(dJZ);
        }
        com.tencent.mm.plugin.wallet.pay.a.b.u(authen.BDB.KxB, authen.BDB.bex ? 2 : 1, authen.BDB.Ijy != 1 ? false : z2);
        if (z.hhq()) {
            this.HFF.put("uuid_for_bindcard", z.getBindCardUuid());
            this.HFF.put("bindcard_scene", new StringBuilder().append(z.hhr()).toString());
        }
        setWXRequestData(this.HFF);
        AppMethodBeat.o(69264);
    }

    /* access modifiers changed from: protected */
    public void aX(Map<String, String> map) {
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public boolean resend() {
        AppMethodBeat.i(69265);
        super.resend();
        this.AJV.put("is_repeat_send", "1");
        setRequestData(this.AJV);
        this.HFE = true;
        AppMethodBeat.o(69265);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69266);
        super.onGYNetEnd(i2, str, jSONObject);
        Log.i("MicroMsg.NetSceneTenpayAuthen", " errCode: " + i2 + " errMsg :" + str);
        Log.d("MicroMsg.NetSceneTenpayAuthen", "banlance_mobile: %s", this.HFJ);
        this.HFG = "1".equals(jSONObject.optString("is_free_sms"));
        this.token = jSONObject.optString("token");
        this.HFJ = jSONObject.optString("balance_mobile");
        this.HFK = jSONObject.optString("balance_help_url");
        this.HFL = jSONObject.optString("modify_mobile_url");
        String optString = jSONObject.optString("bind_serial");
        if (!Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.NetSceneTenpayAuthen", "Pay Success! saving bind_serial:".concat(String.valueOf(optString)));
        }
        if ("1".equals(jSONObject.optString("pay_flag"))) {
            setPaySuccess(true);
            this.HFH = Orders.a(jSONObject, this.HFH);
        } else {
            setPaySuccess(false);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("verify_cre_tail_info");
        if (optJSONObject != null) {
            this.HFM = optJSONObject.optInt("is_can_verify_tail", 0);
            this.HFN = optJSONObject.optString("verify_tail_wording");
        }
        this.HFO = jSONObject.optInt("no_reset_mobile", 0);
        Log.i("MicroMsg.NetSceneTenpayAuthen", "pay_scene:" + this.HFI.BDB.dVv);
        if (this.HFI.BDB.dVv == 21) {
            this.HFP = jSONObject.optJSONArray("fetch_charge_show_info");
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_FETCH_CHARGE_RATE_VERSION_STRING_SYNC, jSONObject.optString("charge_rate_version"));
        }
        if (i2 == 0 && this.HFI.BDB.dVv == 39) {
            Log.i("MicroMsg.NetSceneTenpayAuthen", "it's the sns scene, parse the sns pay data");
            e.bW(jSONObject);
        } else {
            Log.i("MicroMsg.NetSceneTenpayAuthen", "it's not the sns scene or occurs error,  errCode:".concat(String.valueOf(i2)));
        }
        for (d dVar : com.tencent.mm.wallet_core.a.bpk("PayProcess")) {
            dVar.dQL.putInt("key_is_clear_failure", this.RuW);
        }
        AppMethodBeat.o(69266);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.p, com.tencent.mm.wallet_core.c.s, com.tencent.mm.wallet_core.tenpay.model.n
    public void onGYNetEnd2(com.tencent.mm.wallet_core.c.e eVar, JSONObject jSONObject) {
        int i2 = 2;
        AppMethodBeat.i(69267);
        super.onGYNetEnd2(eVar, jSONObject);
        if (this.SVR_ERR_TYPE != 0 || this.SVR_ERR_CODE != 0) {
            String str = this.HFI.BDB.KxB;
            if (!this.HFI.BDB.bex) {
                i2 = 1;
            }
            com.tencent.mm.plugin.wallet.pay.a.b.fY(str, i2);
            com.tencent.mm.plugin.wallet.pay.a.b.cD(this.HFI.BDB.KxB, checkRecSrvResp());
        } else if (this.isPaySuccess) {
            String str2 = this.HFI.BDB.KxB;
            if (!this.HFI.BDB.bex) {
                i2 = 1;
            }
            com.tencent.mm.plugin.wallet.pay.a.b.fY(str2, i2);
            com.tencent.mm.plugin.wallet.pay.a.b.cD(this.HFI.BDB.KxB, checkRecSrvResp());
            AppMethodBeat.o(69267);
            return;
        }
        AppMethodBeat.o(69267);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public String getToken() {
        return this.token;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public String getUri() {
        if (this.HFI.BDB.dVv == 11) {
            return "/cgi-bin/mmpay-bin/tenpay/saveauthen";
        }
        if (this.HFI.BDB.dVv == 21) {
            return "/cgi-bin/mmpay-bin/tenpay/fetchauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/authen";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public int getFuncId() {
        if (this.HFI.BDB.dVv == 11) {
            return 1610;
        }
        if (this.HFI.BDB.dVv == 21) {
            return 1605;
        }
        return 461;
    }

    public final boolean fOm() {
        return this.HFI.BDB.Ijy == 1;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.n
    public final boolean fOn() {
        if (this.HFI.BDB.dVv == 11 || this.HFI.BDB.dVv == 21) {
            return true;
        }
        return false;
    }
}

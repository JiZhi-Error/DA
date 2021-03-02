package com.tencent.mm.plugin.remittance.model;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gl;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import org.json.JSONObject;

public final class w extends m implements j {
    public String CoC = "";
    public gl CoD = null;
    public int CoV = 0;
    public a CoW;
    public String CoX;
    public String CoY;
    public double CoZ;
    public double Cpa;
    public String Cpb;
    public boolean Cpc;
    public double Cpd;
    public double Cpe;
    public double Cpf;
    public String Cpg;
    public String Cph;
    public String Cpi;
    public double Cpj = 0.0d;
    public String Cpk = "";
    public String Cpl = "";
    public String Cpm;
    public int Cpn;
    public String Cpo;
    public String Cpp;
    public int Cpq;
    public String Cpr;
    public String Cps;
    public String Cpt;
    public String Cpu;
    public int Cpv = 0;
    public zd Cpw;
    public String dDM;
    public String dNQ = null;
    public String dQp;
    public com.tencent.mm.plugin.wallet_core.model.a ebb;
    private int efQ;
    public String qvD;
    public String qya;
    public String username = "";
    public int yRL;
    public int yXM;

    public static class a {
        public String Cpx;
        public String Cpy;
        public String dQx;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0282  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public w(double r12, java.lang.String r14, java.lang.String r15, java.lang.String r16, int r17, int r18, java.lang.String r19, int r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, com.tencent.mm.g.a.gl r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, int r39) {
        /*
        // Method dump skipped, instructions count: 654
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.remittance.model.w.<init>(double, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.mm.g.a.gl, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int):void");
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        if (this.efQ == 32 || this.efQ == 33) {
            return 1582;
        }
        return 1544;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        if (this.efQ == 32 || this.efQ == 33) {
            return "/cgi-bin/mmpay-bin/f2fplaceorder";
        }
        return "/cgi-bin/mmpay-bin/transferplaceorder";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        boolean z;
        AppMethodBeat.i(67886);
        Log.d("Micromsg.NetSceneTenpayRemittanceGen", "errCode " + i2 + " errMsg: " + str);
        if (i2 == 0 || i2 == 2) {
            if (jSONObject.has("used_fee")) {
                this.Cpf = jSONObject.optDouble("used_fee");
            } else {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            this.dNQ = jSONObject.optString("req_key");
            this.CoV = jSONObject.optInt("tansfering_num", 0);
            this.CoX = jSONObject.optString("transfer_interrupt_desc");
            this.CoY = jSONObject.optString("appmsgcontent");
            this.Cpb = jSONObject.optString("transfer_interrupt_charge_desc");
            if (jSONObject.optInt("is_show_charge") == 1) {
                z = true;
            } else {
                z = false;
            }
            this.Cpc = z;
            this.Cpg = jSONObject.optString("receiver_true_name");
            this.Cph = jSONObject.optString("f2f_id", "");
            this.qvD = jSONObject.optString("trans_id", "");
            this.qya = jSONObject.optString("extend_str", "");
            this.Cpi = jSONObject.optString("receiver_open_id", "");
            this.yRL = jSONObject.optInt("amount", 0);
            this.dQp = jSONObject.optString("transfer_id", "");
            this.dDM = jSONObject.optString(FirebaseAnalytics.b.TRANSACTION_ID, "");
            this.Cpm = jSONObject.optString("receiver_openid", "");
            if (Util.isNullOrNil(this.Cpg)) {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "receiver_true_name is null");
            }
            if (jSONObject.has("remain_fee")) {
                this.Cpd = jSONObject.optDouble("remain_fee");
            } else {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "remain_fee is null");
            }
            if (jSONObject.has("exceed_fee")) {
                this.Cpe = jSONObject.optDouble("exceed_fee");
            } else {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "exceed_fee is null");
            }
            if (jSONObject.has("charge_fee")) {
                this.CoZ = jSONObject.optDouble("charge_fee");
            } else {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "charge_fee is null");
            }
            if (jSONObject.has("free_limit")) {
                this.Cpa = jSONObject.optDouble("free_limit");
            } else {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "free_limit is null");
            }
            if (jSONObject.has("showmessage")) {
                Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has alert item");
                com.tencent.mm.plugin.wallet_core.model.a aVar = new com.tencent.mm.plugin.wallet_core.model.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("showmessage");
                aVar.lHA = optJSONObject.optString("left_button_wording");
                aVar.lHB = optJSONObject.optString("right_button_wording");
                aVar.qwt = optJSONObject.optString("right_button_url");
                this.ebb = aVar;
                this.ebb.dQx = str;
            }
            if (jSONObject.has("fee")) {
                this.Cpk = jSONObject.optString("fee");
            }
            if (jSONObject.has("double_check_wording")) {
                Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has fee, show alert");
                this.Cpl = jSONObject.optString("double_check_wording");
            }
            if (jSONObject.has("zaitu_message")) {
                Log.i("Micromsg.NetSceneTenpayRemittanceGen", "has zaitu_message");
                a aVar2 = new a();
                JSONObject optJSONObject2 = jSONObject.optJSONObject("zaitu_message");
                aVar2.dQx = optJSONObject2.optString("wording");
                aVar2.Cpx = optJSONObject2.optString("open_button");
                aVar2.Cpy = optJSONObject2.optString("bill_url");
                Log.d("Micromsg.NetSceneTenpayRemittanceGen", "parseZaituMessage() wording:%s open_button:%s bill_url:%s", Util.nullAsNil(aVar2.dQx), Util.nullAsNil(aVar2.Cpx), Util.nullAsNil(aVar2.Cpy));
                this.CoW = aVar2;
            }
            this.Cpn = jSONObject.optInt("scan_scene", 0);
            this.Cpo = jSONObject.optString("placeorder_suc_sign");
            this.Cpp = jSONObject.optString("pay_suc_extend");
            if (TextUtils.isEmpty(this.CoY)) {
                Log.e("Micromsg.NetSceneTenpayRemittanceGen", "appmsgcontent is null");
            }
            this.Cpq = jSONObject.optInt("get_dynamic_code_flag", 0);
            this.Cpr = jSONObject.optString("get_dynamic_code_sign", "");
            this.Cps = jSONObject.optString("get_dynamic_code_extend", "");
            this.Cpt = jSONObject.optString("show_paying_wording", "");
            this.Cpu = jSONObject.optString("dynamic_code_spam_wording", "");
            this.Cpv = jSONObject.optInt("need_checkname", 0);
            this.yXM = jSONObject.optInt("return_to_session", 0);
            Log.i("Micromsg.NetSceneTenpayRemittanceGen", "return_to_session:%s", Integer.valueOf(this.yXM));
            JSONObject optJSONObject3 = jSONObject.optJSONObject("namemessage");
            if (optJSONObject3 != null) {
                this.Cpw = new zd();
                this.Cpw.title = optJSONObject3.optString("title");
                this.Cpw.Crt = optJSONObject3.optString("checkname_sign");
                this.Cpw.AOv = optJSONObject3.optString(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                this.Cpw.dQx = optJSONObject3.optString("wording");
                this.Cpw.Lko = optJSONObject3.optInt("message_type", 0);
            }
            AppMethodBeat.o(67886);
            return;
        }
        AppMethodBeat.o(67886);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean shouldResolveJsonWhenError() {
        return true;
    }
}

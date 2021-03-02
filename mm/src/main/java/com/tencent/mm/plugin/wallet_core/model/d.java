package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static d HWb = null;

    public static d fQh() {
        AppMethodBeat.i(70226);
        if (HWb == null) {
            HWb = new d();
        }
        d dVar = HWb;
        AppMethodBeat.o(70226);
        return dVar;
    }

    public Bankcard bA(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(70227);
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject == null ? "" : jSONObject;
        Log.i("MicroMsg.BankcardParser", "parseJson jsonBankcard %s", objArr);
        Bankcard bankcard = new Bankcard();
        try {
            bankcard.field_bankName = jSONObject.getString("bank_name");
            bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
            bankcard.field_bankcardType = jSONObject.getString("bank_type");
            bankcard.field_bindSerial = jSONObject.optString("bind_serial");
            Log.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            bankcard.HVA = jSONObject.optString("h_bind_serialno");
            if (2 == jSONObject.optInt("bankacc_type", 0)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bankcard.field_cardType |= Bankcard.HVp;
            }
            if (!"NORMAL".equals(jSONObject.optString("extra_bind_flag"))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.HVq;
            }
            if ("QMF".equals(bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.HVv;
                JSONObject optJSONObject = jSONObject.optJSONObject("qmfCardInfo");
                if (optJSONObject != null) {
                    bankcard.HVN = optJSONObject.optLong("total_credit_line", 0);
                    bankcard.HVO = optJSONObject.optLong("use_credit_line", 0);
                    bankcard.HVP = optJSONObject.optLong("unuse_credit_line", 0);
                    bankcard.HVQ = optJSONObject.optString("payer_username", "");
                    bankcard.HVR = optJSONObject.optInt("hide_credit_line", 0);
                    bankcard.HVS = optJSONObject.optInt("card_type", 0);
                    bankcard.HVT = optJSONObject.optString("card_type_name", "");
                    bankcard.HVU = optJSONObject.optString("icon_url", "");
                }
            }
            bankcard.field_mobile = URLDecoder.decode(jSONObject.optString("mobile").replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            if (Util.isNullOrNil(bankcard.field_mobile)) {
                bankcard.field_mobile = jSONObject.optString("mobile_mask");
            }
            bankcard.field_onceQuotaKind = jSONObject.optDouble("once_quota_3") / 100.0d;
            bankcard.field_onceQuotaVirtual = jSONObject.optDouble("once_quota_1") / 100.0d;
            bankcard.field_dayQuotaKind = jSONObject.optDouble("day_quota_3") / 100.0d;
            bankcard.field_dayQuotaVirtual = jSONObject.optDouble("day_quota_1") / 100.0d;
            bankcard.field_bankcardTail = jSONObject.optString("bind_tail");
            if (Util.isNullOrNil(bankcard.field_bankcardTail)) {
                bankcard.field_bankcardTail = jSONObject.optString("card_tail");
            }
            bankcard.HVy = jSONObject.optString("card_mask");
            bankcard.field_forbidWord = jSONObject.optString("forbid_word");
            bankcard.field_repay_url = jSONObject.optString("repay_url");
            bankcard.field_wxcreditState = 2;
            if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == jSONObject.optInt("expired_flag", 0)) {
                bankcard.field_bankcardState = 1;
            } else if (jSONObject.optInt("bank_flag", 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            if (Util.isEqual("FQF", bankcard.field_bankcardType)) {
                bankcard.field_cardType |= Bankcard.HVw;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("fqf_info");
                if (optJSONObject2 != null) {
                    bankcard.HVY = optJSONObject2.optString("fqf_pay_desk_title", "");
                    bankcard.HVZ = optJSONObject2.optString("fqf_title", "");
                    bankcard.HWa = optJSONObject2.optString("fqf_sub_title", "");
                }
            }
            bankcard.Hwr = jSONObject.optString("tinyapp_username", "");
            bankcard.Hws = jSONObject.optString("tinyapp_path", "");
            bankcard.field_bankPhone = jSONObject.optString("bank_phone");
            bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_pre_arrive_time") * 1000;
            bankcard.field_fetchArriveTimeWording = jSONObject.optString("fetch_pre_arrive_time_wording");
            bankcard.field_bankcardTag = jSONObject.optInt("bank_card_tag", 1);
            if (bankcard.field_bankcardTag == 2) {
                bankcard.field_cardType |= Bankcard.HVo;
            }
            String optString = jSONObject.optString("support_micropay");
            if (TextUtils.isEmpty(optString)) {
                bankcard.field_support_micropay = true;
            }
            if ("1".equals(optString)) {
                bankcard.field_support_micropay = true;
            } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(optString)) {
                bankcard.field_support_micropay = false;
            }
            bankcard.field_arrive_type = jSONObject.optString("arrive_type");
            bankcard.field_avail_save_wording = jSONObject.optString("avail_save_wording");
            Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + jSONObject.optString("support_micropay"));
            int optInt = jSONObject.optInt("fetch_charge_rate", 0);
            Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(optInt)));
            bankcard.field_fetch_charge_rate = ((double) optInt) / 10000.0d;
            Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            int optInt2 = jSONObject.optInt("full_fetch_charge_fee", 0);
            Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) optInt2) / 100.0d;
            bankcard.field_fetch_charge_info = jSONObject.optString("fetch_charge_info");
            bankcard.field_tips = jSONObject.optString("tips");
            bankcard.field_forbid_title = jSONObject.optString("forbid_title");
            bankcard.field_forbid_url = jSONObject.optString("forbid_url");
            bankcard.field_no_micro_word = jSONObject.optString("no_micro_word");
            bankcard.field_card_bottom_wording = jSONObject.optString("card_bottom_wording");
            bankcard.field_support_lqt_turn_in = jSONObject.optInt("support_lqt_turn_in", 0);
            bankcard.field_support_lqt_turn_out = jSONObject.optInt("support_lqt_turn_out", 0);
            bankcard.field_is_hightlight_pre_arrive_time_wording = jSONObject.optInt("is_hightlight_pre_arrive_time_wording", 0);
            bankcard.HVV = jSONObject.optInt("support_foreign_mobile", 0);
            bankcard.field_card_state_name = jSONObject.optString("card_state_name");
            bankcard.HVW = jSONObject.optString("card_fetch_wording");
            bankcard.HVX = jSONObject.optLong("card_min_charge_fee");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("prompt_info");
            if (optJSONObject3 != null) {
                bankcard.field_prompt_info_prompt_text = optJSONObject3.optString("prompt_text");
                bankcard.field_prompt_info_jump_text = optJSONObject3.optString("jump_text");
                bankcard.field_prompt_info_jump_url = optJSONObject3.optString("jump_url");
            }
            f(bankcard);
            int optInt3 = jSONObject.optInt("default_card_state");
            Log.i("MicroMsg.BankcardParser", "fqfCardSettingState : %s", Integer.valueOf(optInt3));
            if (optInt3 != 0) {
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_OFFLINE_FQF_SETTING_STATE_INT_SYNC, Integer.valueOf(optInt3));
            }
            AppMethodBeat.o(70227);
            return bankcard;
        } catch (JSONException e2) {
            Log.i("MicroMsg.BankcardParser", "parseJson() JSONException:" + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.BankcardParser", e2, "", new Object[0]);
            AppMethodBeat.o(70227);
            return null;
        } catch (UnsupportedEncodingException e3) {
            Log.i("MicroMsg.BankcardParser", "parseJson() UnsupportedEncodingException :" + e3.getMessage());
            Log.printErrStackTrace("MicroMsg.BankcardParser", e3, "", new Object[0]);
            AppMethodBeat.o(70227);
            return null;
        } catch (Exception e4) {
            Log.i("MicroMsg.BankcardParser", "parseJson() Exception:" + e4.getMessage());
            Log.printErrStackTrace("MicroMsg.BankcardParser", e4, "", new Object[0]);
            AppMethodBeat.o(70227);
            return null;
        }
    }

    public static List<Bankcard> hX(List<vk> list) {
        AppMethodBeat.i(70228);
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Log.i("MicroMsg.BankcardParser", "record size: %s", Integer.valueOf(list.size()));
            for (vk vkVar : list) {
                arrayList.add(a(vkVar));
            }
        }
        AppMethodBeat.o(70228);
        return arrayList;
    }

    public static Bankcard a(vk vkVar) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(70229);
        Log.i("MicroMsg.BankcardParser", "parseFromBindQueryRecord %s", vkVar);
        Bankcard bankcard = new Bankcard();
        try {
            bankcard.field_bankName = vkVar.ynT;
            bankcard.field_bankcardTypeName = vkVar.KNu;
            bankcard.field_bankcardType = vkVar.dDj;
            bankcard.field_bindSerial = vkVar.ANo;
            Log.d("MicroMsg.BankcardParser", "bind_serial: %s", bankcard.field_bindSerial);
            if (2 == Util.getInt(vkVar.KNs, 2)) {
                bankcard.field_cardType |= Bankcard.HVp;
            }
            if (!"NORMAL".equals(vkVar.LfU)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bankcard.field_cardType |= Bankcard.HVq;
            }
            if (!Util.isNullOrNil(vkVar.dSf)) {
                bankcard.field_mobile = URLDecoder.decode(vkVar.dSf.replaceAll("x", "%"), ProtocolPackage.ServerEncoding);
            }
            bankcard.field_onceQuotaKind = f.a(vkVar.LfQ, "100", 2, RoundingMode.HALF_UP);
            bankcard.field_onceQuotaVirtual = f.a(vkVar.LfO, "100", 2, RoundingMode.HALF_UP);
            bankcard.field_dayQuotaKind = f.a(vkVar.LfM, "100", 2, RoundingMode.HALF_UP);
            bankcard.field_dayQuotaVirtual = f.a(vkVar.LfK, "100", 2, RoundingMode.HALF_UP);
            bankcard.field_bankcardTail = vkVar.KNt;
            bankcard.field_forbidWord = vkVar.ANp;
            bankcard.field_repay_url = vkVar.JPU;
            bankcard.field_wxcreditState = 2;
            if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else if (1 == Util.getInt(vkVar.LfN, 0)) {
                bankcard.field_bankcardState = 1;
            } else if (Util.getInt(vkVar.HXn, 1) == 0) {
                bankcard.field_bankcardState = 2;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_bankPhone = vkVar.HXo;
            bankcard.field_fetchArriveTime = Util.getLong(vkVar.LfZ, 0) * 1000;
            bankcard.field_fetchArriveTimeWording = vkVar.Lgl;
            bankcard.field_bankcardTag = Util.getInt(vkVar.LfR, 1);
            if (bankcard.field_bankcardTag == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                bankcard.field_cardType |= Bankcard.HVo;
            }
            if (vkVar.LfW != 1) {
                z3 = false;
            }
            bankcard.field_support_micropay = z3;
            Log.i("MicroMsg.BankcardParser", "getBalance() support_micropay:" + vkVar.LfW);
            bankcard.field_arrive_type = vkVar.Lgf;
            bankcard.field_avail_save_wording = vkVar.Lgh;
            int i2 = vkVar.Lgm;
            Log.i("MicroMsg.BankcardParser", "fetch_charge_rate:".concat(String.valueOf(i2)));
            bankcard.field_fetch_charge_rate = ((double) i2) / 10000.0d;
            Log.i("MicroMsg.BankcardParser", "field_fetch_charge_rate:" + bankcard.field_fetch_charge_rate);
            int i3 = vkVar.Lgn;
            Log.i("MicroMsg.BankcardParser", "full_fetch_charge_fee:" + bankcard.field_full_fetch_charge_fee);
            bankcard.field_full_fetch_charge_fee = ((double) i3) / 100.0d;
            bankcard.field_fetch_charge_info = vkVar.Lgo;
            bankcard.field_tips = vkVar.pWf;
            bankcard.field_forbid_title = vkVar.KNk;
            bankcard.field_forbid_url = vkVar.KNl;
            bankcard.field_no_micro_word = vkVar.Lgg;
            bankcard.field_card_bottom_wording = vkVar.Lgu;
            bankcard.field_support_lqt_turn_in = vkVar.Lgx;
            bankcard.field_support_lqt_turn_out = vkVar.Lgy;
            bankcard.field_is_hightlight_pre_arrive_time_wording = vkVar.Lgw;
            if (vkVar.KNo != null) {
                bankcard.field_prompt_info_prompt_text = vkVar.KNo.LmX;
                bankcard.field_prompt_info_jump_text = vkVar.KNo.LmY;
                bankcard.field_prompt_info_jump_url = vkVar.KNo.pTL;
            }
            f(bankcard);
            AppMethodBeat.o(70229);
            return bankcard;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.BankcardParser", e2, "parseFromBindQueryRecord() error:" + e2.getMessage(), new Object[0]);
            AppMethodBeat.o(70229);
            return null;
        }
    }

    public static void f(Bankcard bankcard) {
        AppMethodBeat.i(70230);
        if (bankcard == null) {
            AppMethodBeat.o(70230);
        } else if (bankcard.fQb()) {
            bankcard.field_desc = bankcard.field_bankName;
            AppMethodBeat.o(70230);
        } else if (bankcard.fQf()) {
            bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.idf, bankcard.HVT, f.ht(bankcard.HVQ, 8));
            AppMethodBeat.o(70230);
        } else if (bankcard.fQd()) {
            bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.ibl, bankcard.field_bankName, bankcard.field_bankcardTail);
            AppMethodBeat.o(70230);
        } else if (bankcard.fQa()) {
            bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.iw2, bankcard.field_bankName, bankcard.field_bankcardTail);
            AppMethodBeat.o(70230);
        } else if (bankcard.fQg()) {
            bankcard.field_desc = bankcard.HVZ;
            AppMethodBeat.o(70230);
        } else {
            bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.ic5, bankcard.field_bankName, bankcard.field_bankcardTail);
            AppMethodBeat.o(70230);
        }
    }
}

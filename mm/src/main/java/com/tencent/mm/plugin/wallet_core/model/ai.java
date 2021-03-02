package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.protocal.protobuf.cul;
import com.tencent.mm.protocal.protobuf.cum;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.c.y;
import com.tencent.mm.wallet_core.ui.f;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai {
    public static void a(JSONObject jSONObject, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(70450);
        Log.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard(): %s, %s", Integer.valueOf(i2), Boolean.valueOf(z));
        try {
            long optLong = jSONObject.optLong("time_stamp");
            if (optLong > 0) {
                y.setTimeStamp(String.valueOf(optLong));
            } else {
                Log.w("MicroMsg.WalletQueryBankcardParser", "no time_stamp at WalletQueryBankcardParser.");
            }
            am a2 = a(jSONObject.getJSONObject("user_info"), i2);
            if (z) {
                a2.field_switchConfig = jSONObject.getJSONObject("switch_info").getInt("switch_bit");
            } else {
                a2.field_switchConfig = t.fQD().fRN().field_switchConfig;
            }
            a2.field_paymenu_use_new = jSONObject.optInt("paymenu_use_new");
            Log.i("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard, paymenu_use_new: %s", Integer.valueOf(a2.field_paymenu_use_new));
            String optString = jSONObject.optString("support_bank_word");
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, Util.nullAsNil(optString));
            ArrayList<Bankcard> L = L(jSONObject.optJSONArray("Array"));
            ArrayList<Bankcard> M = M(jSONObject.optJSONArray("virtual_card_array"));
            Bankcard b2 = b(jSONObject.optJSONObject("balance_info"), i2);
            if (b2 != null && i2 == 10) {
                Log.i("MicroMsg.WalletQueryBankcardParser", "carson: entry_url: %s、entry_word：%s", b2.HVG, b2.HVH);
                JSONObject optJSONObject = jSONObject.optJSONObject("bill_entry");
                if (optJSONObject != null) {
                    b2.HVG = optJSONObject.optString("entry_url");
                    b2.HVH = optJSONObject.optString("entry_word");
                }
            }
            int optInt = jSONObject.optInt("query_cache_time");
            Log.i("MicroMsg.WalletQueryBankcardParser", "hy: cache time: %d", Integer.valueOf(optInt));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("complex_switch_info");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("bind_newcard_switch");
                optJSONObject3.optInt("forbid_bind_card");
                optJSONObject3.optString("forbid_word");
            }
            g.fQl().bC(optJSONObject2);
            Bankcard N = N(jSONObject.optJSONArray("history_card_array"));
            bR(jSONObject);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("bank_priority");
            if (optJSONObject4 != null) {
                a2.field_bank_priority = optJSONObject4.toString();
            }
            List<c> bQ = bQ(optJSONObject4);
            a2.field_unipay_order_state = jSONObject.optInt("unipayorderstate", 0);
            a(jSONObject, a2, z);
            if (z2) {
                t.fQI().c(bP(jSONObject));
            }
            jSONObject.optString("query_order_time");
            n bS = bS(jSONObject.optJSONObject("loan_entry_info"));
            JSONObject optJSONObject5 = jSONObject.optJSONObject("fetch_info");
            b bVar = t.fQI().IbO;
            Log.d("MicroMsg.WalletQueryBankcardParser", "fetchInfo: %s", bVar);
            if (optJSONObject5 != null) {
                bVar = c(optJSONObject5, true);
            } else {
                Log.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard() fetch_info is null");
            }
            Bankcard bT = bT(jSONObject.optJSONObject("lqt_info"));
            if (i2 == 4) {
                Log.d("MicroMsg.WalletQueryBankcardParser", "update fetch scene data");
                t.fQI().Hvt = jSONObject.optInt("is_use_dynamic_free_fee");
                t.fQI().Hvu = jSONObject.optInt("dynamic_free_fee_hold_time");
            }
            t.fQI().a(a2, L, M, b2, N, bS, bVar, bT, optInt, i2, bQ);
            AppMethodBeat.o(70450);
        } catch (Exception e2) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "parseQueryBankcard Exception :" + e2.getMessage());
            Log.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
            AppMethodBeat.o(70450);
        }
    }

    private static cul bP(JSONObject jSONObject) {
        AppMethodBeat.i(70451);
        if (jSONObject.has("guide_bar")) {
            try {
                cul cul = new cul();
                JSONObject optJSONObject = jSONObject.optJSONObject("guide_bar");
                cul.HFS = optJSONObject.optInt("guide_type");
                if (optJSONObject.has("guide_data")) {
                    cul.MzF = new cum();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("guide_data");
                    cul.MzF.ANo = optJSONObject2.optString("bind_serial");
                }
                cul.HEc = optJSONObject.optInt("is_show_guide");
                cul.HEe = optJSONObject.optString("guide_content");
                cul.HEf = optJSONObject.optString("guide_content_color");
                cul.HEg = optJSONObject.optString("guide_btn_text");
                cul.HEh = optJSONObject.optString("guide_btn_text_color");
                cul.HEi = optJSONObject.optString("guide_btn_bg_color");
                cul.HEj = optJSONObject.optString("guide_logo");
                cul.LFY = optJSONObject.optString("background_color");
                cul.MzG = optJSONObject.optString("attach_info_left_wording");
                cul.MzH = optJSONObject.optString("attach_info_right_wording");
                cul.MzI = optJSONObject.optInt("btn_jump_mode");
                cul.MzJ = optJSONObject.optString("btn_jump_h5");
                cul.MzK = optJSONObject.optString("btn_jump_tinyapp_username");
                cul.MzL = optJSONObject.optString("btn_jump_tinyapp_path");
                cul.MzM = optJSONObject.optString("dark_guide_btn_text_color");
                cul.MzN = optJSONObject.optString("dark_guide_btn_bg_color");
                cul.MzO = optJSONObject.optString("dark_background_color");
                AppMethodBeat.o(70451);
                return cul;
            } catch (Exception e2) {
                Log.e("MicroMsg.WalletQueryBankcardParser", "parseOfflineGuideBar Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(70451);
                return null;
            }
        } else {
            AppMethodBeat.o(70451);
            return null;
        }
    }

    public static void a(cul cul) {
        AppMethodBeat.i(70452);
        g.aAh().azQ().set(ar.a.USERINFO_OFFLINE_GUIDE_BAR_CONFIG_STRING_SYNC, b(cul));
        AppMethodBeat.o(70452);
    }

    public static cul fQV() {
        AppMethodBeat.i(70453);
        cul aVk = aVk((String) g.aAh().azQ().get(ar.a.USERINFO_OFFLINE_GUIDE_BAR_CONFIG_STRING_SYNC, ""));
        AppMethodBeat.o(70453);
        return aVk;
    }

    public static List<c> bQ(JSONObject jSONObject) {
        AppMethodBeat.i(70454);
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("bankinfo_array");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        c cVar = new c();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        cVar.ANo = jSONObject2.optString("bind_serial");
                        cVar.HVn = jSONObject2.optString("polling_forbid_word");
                        arrayList.add(cVar);
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(70454);
        return arrayList;
    }

    private static void a(JSONObject jSONObject, am amVar, boolean z) {
        AppMethodBeat.i(70455);
        if (z) {
            JSONObject optJSONObject = jSONObject.optJSONObject("wallet_info");
            if (optJSONObject != null) {
                amVar.field_wallet_balance = optJSONObject.optLong("wallet_balance", -1);
                amVar.field_wallet_entrance_balance_switch_state = optJSONObject.optInt("wallet_entrance_balance_switch_state", -1);
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_NEW_BALANCE_LONG_SYNC, Long.valueOf(amVar.field_wallet_balance));
            }
            AppMethodBeat.o(70455);
            return;
        }
        amVar.field_wallet_balance = t.fQD().fRN().field_wallet_balance;
        amVar.field_wallet_entrance_balance_switch_state = t.fQD().fRN().field_wallet_entrance_balance_switch_state;
        AppMethodBeat.o(70455);
    }

    public static boolean aeL(int i2) {
        if (i2 == 9 || i2 == 10 || i2 == 11 || i2 == 12 || i2 == 13 || i2 == 14 || i2 == 15 || i2 == 16 || i2 == 17 || i2 == 18 || i2 == 19 || i2 == 20 || i2 == 21 || i2 == 22 || i2 == 23) {
            return true;
        }
        return false;
    }

    private static void bR(JSONObject jSONObject) {
        String str;
        String str2;
        AppMethodBeat.i(70456);
        JSONArray optJSONArray = jSONObject.optJSONArray("balance_notice");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("fetch_notice");
        if (optJSONArray != null) {
            str = Util.nullAs(optJSONArray.toString(), "");
        } else {
            str = "";
        }
        if (optJSONArray2 != null) {
            str2 = Util.nullAs(optJSONArray2.toString(), "");
        } else {
            str2 = "";
        }
        Log.i("MicroMsg.WalletQueryBankcardParser", "hy: balance notice: %s, fetchNotice: %s", str, str2);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_NOTICE_STRING, str);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_WALLET_FETCH_NOTICE_STRING, str2);
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(70456);
    }

    private static am a(JSONObject jSONObject, int i2) {
        int i3;
        AppMethodBeat.i(70457);
        Log.i("MicroMsg.WalletQueryBankcardParser", "getUserInfo()");
        am amVar = new am();
        if (jSONObject == null || jSONObject.length() <= 0) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getUserInfo() json == null or json.length() == 0");
            AppMethodBeat.o(70457);
            return null;
        }
        amVar.field_is_reg = jSONObject.getInt("is_reg");
        amVar.field_true_name = jSONObject.optString("true_name");
        amVar.field_cre_type = jSONObject.optInt("cre_type", -1);
        amVar.field_main_card_bind_serialno = jSONObject.optString("last_card_bind_serialno");
        Log.i("MicroMsg.WalletQueryBankcardParser", "mUserInfo.field_main_card_bind_serialno ：%s", amVar.field_main_card_bind_serialno);
        amVar.field_cre_name = jSONObject.optString("cre_name");
        amVar.field_ftf_pay_url = jSONObject.optString("transfer_url");
        amVar.field_reset_passwd_flag = jSONObject.optString("reset_passwd_flag");
        amVar.field_find_passwd_url = jSONObject.optString("reset_passwd_url");
        amVar.field_forget_passwd_url = jSONObject.optString("forget_passwd_url");
        t.fQI();
        an.aVo(amVar.field_main_card_bind_serialno);
        amVar.field_isDomesticUser = "2".equals(jSONObject.optString("icard_user_flag", "2"));
        JSONObject optJSONObject = jSONObject.optJSONObject("touch_info");
        if (optJSONObject != null) {
            amVar.field_is_open_touch = optJSONObject.optInt("is_open_touch", 0);
            amVar.field_soter_pay_open_type = optJSONObject.optInt("soter_pay_open_type", 0);
            Log.d("MicroMsg.WalletQueryBankcardParser", "getUserInfo field_is_open_touch() is %s, %s", Integer.valueOf(amVar.field_is_open_touch), Integer.valueOf(amVar.field_soter_pay_open_type));
        } else {
            Log.e("MicroMsg.WalletQueryBankcardParser", "touch_info is null ");
            if (t.fQI().fRo()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            amVar.field_is_open_touch = i3;
            amVar.field_soter_pay_open_type = t.fQI().fRq();
            Log.e("MicroMsg.WalletQueryBankcardParser", "old field_is_open_touch is " + amVar.field_is_open_touch);
        }
        amVar.field_lct_wording = jSONObject.optString("lct_wording");
        amVar.field_lct_url = jSONObject.optString("lct_url");
        Log.i("MicroMsg.WalletQueryBankcardParser", "field_lct_wording: " + amVar.field_lct_wording + ", field_lct_url:" + amVar.field_lct_url);
        amVar.field_lqt_state = jSONObject.optInt("lqt_state", -1);
        JSONObject optJSONObject2 = jSONObject.optJSONObject("lqb_show_info");
        Log.i("MicroMsg.WalletQueryBankcardParser", "field_lqt_state: %s, lqb_show_info: %s", Integer.valueOf(amVar.field_lqt_state), optJSONObject2);
        if (optJSONObject2 != null) {
            amVar.field_is_show_lqb = optJSONObject2.optInt("is_show_lqb");
            amVar.field_is_open_lqb = optJSONObject2.optInt("is_open_lqb");
            amVar.field_lqb_open_url = optJSONObject2.optString("lqb_open_url");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("lqt_cell_info");
        Log.i("MicroMsg.WalletQueryBankcardParser", "lqt_cell_info: %s", optJSONObject3);
        if (optJSONObject3 != null) {
            amVar.field_lqt_cell_is_show = optJSONObject3.optInt("is_show_cell");
            amVar.field_lqt_cell_icon = optJSONObject3.optString("cell_icon");
            amVar.field_lqt_cell_is_open_lqt = optJSONObject3.optInt("is_open_lqt");
            amVar.field_lqt_cell_lqt_open_url = optJSONObject3.optString("lqt_open_url");
            amVar.field_lqt_cell_lqt_title = optJSONObject3.optString("lqt_title");
            amVar.field_lqt_cell_lqt_wording = optJSONObject3.optString("lqt_wording");
        }
        if (aeL(i2) || i2 == 3 || i2 == 4) {
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(amVar.field_lqt_state));
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, amVar.field_lct_wording);
        }
        AppMethodBeat.o(70457);
        return amVar;
    }

    private static Bankcard b(JSONObject jSONObject, int i2) {
        boolean z;
        AppMethodBeat.i(214198);
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject == null ? "" : jSONObject;
        Log.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance %s", objArr);
        if (jSONObject == null || jSONObject.length() <= 0) {
            Log.i("MicroMsg.WalletQueryBankcardParser", "getBalance() json == null or json.length() == 0");
            AppMethodBeat.o(214198);
            return null;
        }
        Bankcard bankcard = new Bankcard((byte) 0);
        a(bankcard, jSONObject.optLong("balance_version", -1), jSONObject.optLong("time_out", 7200), jSONObject.optInt("avail_balance"));
        bankcard.HVC = f.a(jSONObject.optString("avail_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
        bankcard.HVD = jSONObject.optString("balance_show_wording");
        bankcard.HVI = jSONObject.optString("max_fetch_wording");
        bankcard.HVJ = jSONObject.optString("avail_fetch_wording");
        bankcard.HVE = f.a(jSONObject.optString("fetch_balance", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
        bankcard.field_cardType |= Bankcard.HVr;
        bankcard.field_bankcardType = jSONObject.optString("balance_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("balance_bind_serial");
        bankcard.field_forbidWord = jSONObject.optString("balance_forbid_word");
        if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
            bankcard.field_bankcardState = 8;
        } else {
            bankcard.field_bankcardState = 0;
        }
        bankcard.field_fetchArriveTime = jSONObject.optLong("fetch_arrive_time");
        bankcard.field_mobile = jSONObject.optString("mobile");
        if (jSONObject.optInt("support_micropay", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        bankcard.field_support_micropay = z;
        Log.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + jSONObject.optInt("support_micropay", 0));
        bankcard.HVF = jSONObject.optString("balance_list_url");
        Log.i("MicroMsg.WalletQueryBankcardParser", "carson balance_list_url: %s", bankcard.HVF);
        String string = MMApplicationContext.getContext().getString(R.string.i5u);
        bankcard.field_desc = string;
        bankcard.field_bankName = string;
        bankcard.field_bankcardTail = "10000";
        bankcard.field_forbid_title = jSONObject.optString("forbid_title");
        bankcard.field_forbid_url = jSONObject.optString("forbid_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("prompt_info");
        if (optJSONObject != null) {
            bankcard.field_prompt_info_prompt_text = optJSONObject.optString("prompt_text");
            bankcard.field_prompt_info_jump_text = optJSONObject.optString("jump_text");
            bankcard.field_prompt_info_jump_url = optJSONObject.optString("jump_url");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("balance_menu_info");
        if (optJSONObject2 != null) {
            String jSONObject2 = optJSONObject2.toString();
            Log.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", jSONObject2);
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, jSONObject2);
        } else {
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, "");
        }
        if (i2 == 10) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("lqp_entrance_info");
            if (optJSONObject3 != null) {
                String jSONObject3 = optJSONObject3.toString();
                Log.d("MicroMsg.WalletQueryBankcardParser", "balance entrance info: %s", jSONObject3);
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_BALANCE_ENTRANCE_INFO_STRING_SYNC, jSONObject3);
            } else {
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().set(ar.a.USERINFO_WALLET_BALANCE_ENTRANCE_INFO_STRING_SYNC, "");
            }
        }
        AppMethodBeat.o(214198);
        return bankcard;
    }

    public static Bankcard a(iu iuVar) {
        AppMethodBeat.i(70459);
        Log.i("MicroMsg.WalletQueryBankcardParser", "Bankcard getBalance from balance info %s", iuVar);
        Bankcard bankcard = null;
        if (iuVar != null) {
            bankcard = new Bankcard((byte) 0);
            a(bankcard, iuVar.KNh, (long) iuVar.KNi, Util.getInt(iuVar.KNd, 0));
            bankcard.HVC = f.a(iuVar.KNd, "100", 2, RoundingMode.HALF_UP);
            bankcard.HVD = iuVar.HVD;
            bankcard.HVI = iuVar.HVI;
            bankcard.HVJ = iuVar.HVJ;
            bankcard.HVE = f.a(iuVar.KNf, "100", 2, RoundingMode.HALF_UP);
            bankcard.field_cardType |= Bankcard.HVr;
            bankcard.field_bankcardType = iuVar.KMZ;
            bankcard.field_bindSerial = iuVar.KNa;
            bankcard.field_forbidWord = iuVar.KNb;
            if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
                bankcard.field_bankcardState = 8;
            } else {
                bankcard.field_bankcardState = 0;
            }
            bankcard.field_mobile = iuVar.dSf;
            bankcard.field_support_micropay = Util.getInt(iuVar.KNg, 0) == 1;
            Log.i("MicroMsg.WalletQueryBankcardParser", "getBalance() support_micropay:" + iuVar.KNg);
            bankcard.HVF = iuVar.HVF;
            String string = MMApplicationContext.getContext().getString(R.string.i5u);
            bankcard.field_desc = string;
            bankcard.field_bankName = string;
            bankcard.field_bankcardTail = "10000";
            bankcard.field_forbid_title = iuVar.KNk;
            bankcard.field_forbid_url = iuVar.KNl;
            if (iuVar.KNo != null) {
                bankcard.field_prompt_info_prompt_text = iuVar.KNo.LmX;
                bankcard.field_prompt_info_jump_text = iuVar.KNo.LmY;
                bankcard.field_prompt_info_jump_url = iuVar.KNo.pTL;
            }
            iv ivVar = iuVar.KNn;
            if (ivVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("is_show_menu", ivVar.KNp);
                    LinkedList<iw> linkedList = ivVar.KNq;
                    JSONArray jSONArray = new JSONArray();
                    for (iw iwVar : linkedList) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("title", iwVar.title);
                        jSONObject2.put("jump_type", iwVar.uSc);
                        jSONObject2.put("jump_h5_url", iwVar.HLy);
                        jSONObject2.put("tinyapp_username", iwVar.Hwr);
                        jSONObject2.put("tinyapp_path", iwVar.Hws);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("balance_menu_item", jSONArray);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.WalletQueryBankcardParser", e2, "Bankcard getBalance from balance, assemble menuInfoJson error: %s", e2.getMessage());
                }
                Log.d("MicroMsg.WalletQueryBankcardParser", "balance menu info: %s", jSONObject.toString());
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, jSONObject.toString());
            } else {
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_BALANCE_MENU_INFO_STRING_SYNC, "");
            }
        }
        AppMethodBeat.o(70459);
        return bankcard;
    }

    public static b c(JSONObject jSONObject, boolean z) {
        AppMethodBeat.i(70460);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is null");
            AppMethodBeat.o(70460);
            return null;
        }
        Log.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), json is valid");
        b bVar = new b();
        bVar.HVg = jSONObject.optString("fetch_charge_title");
        Log.i("MicroMsg.WalletQueryBankcardParser", "fetch_charge_title:" + bVar.HVg);
        if (z) {
            Log.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery true");
            bVar.Hvn = jSONObject.optInt("is_cal_charge", 0);
            bVar.Hvm = jSONObject.optInt("is_show_charge", 0);
            bVar.Hvo = jSONObject.optInt("is_full_fetch_direct", 0);
            bVar.Hvp = f.a(jSONObject.optString("min_charge_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            bVar.Cpd = f.a(jSONObject.optString("remain_fee", AppEventsConstants.EVENT_PARAM_VALUE_NO), "100", 2, RoundingMode.HALF_UP);
            bVar.HVi = jSONObject.optString("card_list_wording_title", "");
            bVar.HVj = jSONObject.optString("card_list_wording_content", "");
            if (jSONObject.has("withdraw_sector")) {
                bVar.HVk = b.bz(jSONObject.optJSONObject("withdraw_sector"));
            }
            Log.i("MicroMsg.WalletQueryBankcardParser", " is_cal_charge:" + bVar.Hvn + " is_show_charge:" + bVar.Hvm + " min_charge_fee:" + bVar.Hvp + " remain_fee:" + bVar.Cpd + " is_full_fetch_direct:" + bVar.Hvo);
        } else {
            Log.i("MicroMsg.WalletQueryBankcardParser", "isBindQuery false");
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("item");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getBalanceFetchInfo(), itemJsonArray is null");
        } else {
            bVar.HVh = new LinkedList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    b.C1916b bVar2 = new b.C1916b();
                    bVar2.key = optJSONObject.optString("key");
                    bVar2.value = optJSONObject.optString("value");
                    Log.i("MicroMsg.WalletQueryBankcardParser", "feeItem.key is " + bVar2.key + " , feeItem.value is " + bVar2.value);
                    if (!TextUtils.isEmpty(bVar2.key) && !TextUtils.isEmpty(bVar2.value)) {
                        bVar.HVh.add(bVar2);
                    }
                } else {
                    Log.e("MicroMsg.WalletQueryBankcardParser", "item index " + i2 + " is empty");
                }
            }
            Log.i("MicroMsg.WalletQueryBankcardParser", "itemsList size is " + bVar.HVh.size());
        }
        AppMethodBeat.o(70460);
        return bVar;
    }

    private static void a(final Bankcard bankcard, final long j2, final long j3, final int i2) {
        AppMethodBeat.i(70461);
        f.a(new String[]{"wallet_balance_version", "wallet_balance_last_update_time", "wallet_balance"}, new f.a() {
            /* class com.tencent.mm.plugin.wallet_core.model.ai.AnonymousClass1 */

            @Override // com.tencent.mm.wallet_core.ui.f.a
            public final void bb(Map<String, Object> map) {
                AppMethodBeat.i(70446);
                if (map != null) {
                    long nullAs = Util.nullAs((Long) map.get("wallet_balance_version"), -1);
                    long nullAs2 = Util.nullAs((Long) map.get("wallet_balance_last_update_time"), -1);
                    if (nullAs2 < 0 || nullAs < 0 || nullAs2 + j3 > Util.currentTicks() || j2 >= nullAs) {
                        f.a(new f.c("wallet_balance_version", Long.valueOf(j2)), new f.c("wallet_balance_last_update_time", Long.valueOf(Util.currentTicks())), new f.c("wallet_balance", Double.valueOf(((double) i2) / 100.0d)));
                        bankcard.HVC = ((double) i2) / 100.0d;
                        AppMethodBeat.o(70446);
                        return;
                    }
                    Log.w("MicroMsg.WalletQueryBankcardParser", "hy: new balance comes but last msg is not timeout and balance version is smaller than before");
                }
                AppMethodBeat.o(70446);
            }
        });
        AppMethodBeat.o(70461);
    }

    private static ArrayList<Bankcard> L(JSONArray jSONArray) {
        AppMethodBeat.i(70462);
        Log.i("MicroMsg.WalletQueryBankcardParser", "getBankcards()：%s", jSONArray);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Bankcard bA = d.fQh().bA(jSONArray.getJSONObject(i2));
                if (bA != null) {
                    d.f(bA);
                    arrayList.add(bA);
                }
            }
        }
        AppMethodBeat.o(70462);
        return arrayList;
    }

    private static ArrayList<Bankcard> M(JSONArray jSONArray) {
        AppMethodBeat.i(70463);
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                Bankcard bankcard = new Bankcard();
                bankcard.field_cardType |= Bankcard.HVq;
                bankcard.field_bankName = jSONObject.getString("bank_name");
                bankcard.field_bankcardType = jSONObject.getString("bank_type");
                bankcard.field_bankcardTypeName = jSONObject.optString("bankacc_type_name");
                bankcard.HVy = jSONObject.getString("card_id");
                bankcard.field_bizUsername = jSONObject.getString("app_username");
                bankcard.field_wxcreditState = jSONObject.getInt("card_status");
                if (bankcard.field_wxcreditState != 2) {
                    bankcard.field_bankcardState = 9;
                } else {
                    bankcard.field_bankcardState = 0;
                }
                bankcard.field_desc = MMApplicationContext.getContext().getString(R.string.iw2, bankcard.field_bankName, bankcard.field_bankcardTail);
                bankcard.HVM = new e();
                bankcard.HVM.AAU = jSONObject.getString("logo_url");
                bankcard.HVM.HWc = jSONObject.getString("background_logo_url");
                bankcard.HVM.HWd = jSONObject.getString("big_logo_url");
                arrayList.add(bankcard);
            }
        }
        AppMethodBeat.o(70463);
        return arrayList;
    }

    private static Bankcard N(JSONArray jSONArray) {
        AppMethodBeat.i(70464);
        if (jSONArray == null || jSONArray.length() <= 0) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getHistroyBankcard() json == null or json.length() == 0");
            AppMethodBeat.o(70464);
            return null;
        }
        Bankcard bA = d.fQh().bA(jSONArray.getJSONObject(0));
        bA.field_cardType |= Bankcard.HVs;
        AppMethodBeat.o(70464);
        return bA;
    }

    private static n bS(JSONObject jSONObject) {
        AppMethodBeat.i(70465);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo json is null");
            AppMethodBeat.o(70465);
            return null;
        }
        Log.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo()");
        n nVar = new n();
        nVar.field_title = jSONObject.optString("title");
        nVar.field_loan_jump_url = jSONObject.optString("loan_jump_url");
        Log.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_loan_jump_url:" + nVar.field_loan_jump_url);
        nVar.field_is_show_entry = jSONObject.optInt("is_show_entry", 0);
        nVar.field_tips = jSONObject.optString("tips");
        nVar.field_is_overdue = jSONObject.optInt("is_overdue", 0);
        if (jSONObject.has("available_otb")) {
            nVar.field_available_otb = f.d(jSONObject.optDouble("available_otb") / 100.0d, "CNY");
        }
        if (jSONObject.has(FirebaseAnalytics.b.INDEX)) {
            nVar.field_red_dot_index = jSONObject.optInt(FirebaseAnalytics.b.INDEX);
        }
        Log.i("MicroMsg.WalletQueryBankcardParser", "getLoanEntryInfo() field_index:" + nVar.field_red_dot_index + "  field_is_overdue:" + nVar.field_is_overdue + "  field_is_show_entry:" + nVar.field_is_show_entry);
        AppMethodBeat.o(70465);
        return nVar;
    }

    private static Bankcard bT(JSONObject jSONObject) {
        boolean z = true;
        AppMethodBeat.i(70466);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getLqtInfo, json object is null!");
            AppMethodBeat.o(70466);
            return null;
        }
        Log.i("MicroMsg.WalletQueryBankcardParser", "now get getLqtInfo: %s", jSONObject.toString());
        Bankcard bankcard = new Bankcard((byte) 0);
        bankcard.field_bankcardType = jSONObject.optString("lqt_bank_type");
        bankcard.field_bindSerial = jSONObject.optString("lqt_bind_serial");
        bankcard.field_bankName = jSONObject.optString("lqt_bank_name");
        bankcard.HVC = ((double) jSONObject.optLong("total_balance")) / 100.0d;
        bankcard.HVE = ((double) jSONObject.optLong("avail_balance")) / 100.0d;
        bankcard.HVM = new e();
        bankcard.HVM.AAU = jSONObject.optString("lqt_logo_url");
        bankcard.field_forbidWord = jSONObject.optString("lqt_forbid_word");
        bankcard.field_forbid_title = jSONObject.optString("forbid_title");
        bankcard.field_forbid_url = jSONObject.optString("forbid_url");
        bankcard.HVD = jSONObject.optString("lqt_show_wording");
        bankcard.field_mobile = jSONObject.optString("mobile");
        if (jSONObject.optInt("support_micropay", 0) != 1) {
            z = false;
        }
        bankcard.field_support_micropay = z;
        bankcard.field_cardType |= Bankcard.HVu;
        if (Util.isNullOrNil(bankcard.field_bankName)) {
            bankcard.field_bankName = MMApplicationContext.getContext().getString(R.string.iik);
        }
        bankcard.field_desc = bankcard.field_bankName;
        if (!Util.isNullOrNil(bankcard.field_forbidWord)) {
            bankcard.field_bankcardState = 8;
        } else {
            bankcard.field_bankcardState = 0;
        }
        AppMethodBeat.o(70466);
        return bankcard;
    }

    private static String b(cul cul) {
        AppMethodBeat.i(70467);
        if (cul == null) {
            AppMethodBeat.o(70467);
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("guide_type", cul.HFS);
            JSONObject jSONObject2 = new JSONObject();
            if (cul.MzF != null) {
                jSONObject2.put("bind_serial", cul.MzF.ANo);
            }
            jSONObject.put("guide_data", jSONObject2.toString());
            jSONObject.put("is_show_guide", cul.HEc);
            jSONObject.put("guide_content", cul.HEe);
            jSONObject.put("guide_content_color", cul.HEf);
            jSONObject.put("guide_btn_text", cul.HEg);
            jSONObject.put("guide_btn_text_color", cul.HEh);
            jSONObject.put("guide_btn_bg_color", cul.HEi);
            jSONObject.put("guide_logo", cul.HEj);
            jSONObject.put("background_color", cul.LFY);
            jSONObject.put("attach_info_left_wording", cul.MzG);
            jSONObject.put("attach_info_right_wording", cul.MzH);
            jSONObject.put("btn_jump_mode", cul.MzI);
            jSONObject.put("btn_jump_h5", cul.MzJ);
            jSONObject.put("btn_jump_tinyapp_username", cul.MzK);
            jSONObject.put("btn_jump_tinyapp_path", cul.MzL);
            jSONObject.put("dark_guide_btn_text_color", cul.MzM);
            jSONObject.put("dark_guide_btn_bg_color", cul.MzN);
            jSONObject.put("dark_background_color", cul.MzO);
            String jSONObject3 = jSONObject.toString();
            AppMethodBeat.o(70467);
            return jSONObject3;
        } catch (JSONException e2) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getOfflineGuideBarJSONStr() Exception: %s", e2.getMessage());
            AppMethodBeat.o(70467);
            return "";
        }
    }

    private static cul aVk(String str) {
        AppMethodBeat.i(70468);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(70468);
            return null;
        }
        cul cul = new cul();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cul.HFS = jSONObject.optInt("guide_type");
            String optString = jSONObject.optString("guide_type");
            cul.MzF = new cum();
            if (Util.isNullOrNil(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                cul.MzF.ANo = jSONObject2.optString("bind_serial");
            }
            cul.HEc = jSONObject.optInt("is_show_guide");
            cul.HEe = jSONObject.optString("guide_content");
            cul.HEf = jSONObject.optString("guide_content_color");
            cul.HEg = jSONObject.optString("guide_btn_text");
            cul.HEh = jSONObject.optString("guide_btn_text_color");
            cul.HEi = jSONObject.optString("guide_btn_bg_color");
            cul.HEj = jSONObject.optString("guide_logo");
            cul.LFY = jSONObject.optString("background_color");
            cul.MzG = jSONObject.optString("attach_info_left_wording");
            cul.MzH = jSONObject.optString("attach_info_right_wording");
            cul.MzI = jSONObject.optInt("btn_jump_mode");
            cul.MzJ = jSONObject.optString("btn_jump_h5");
            cul.MzK = jSONObject.optString("btn_jump_tinyapp_username");
            cul.MzL = jSONObject.optString("btn_jump_tinyapp_path");
            cul.MzM = jSONObject.optString("dark_guide_btn_text_color");
            cul.MzN = jSONObject.optString("dark_guide_btn_bg_color");
            cul.MzO = jSONObject.optString("dark_background_color");
            AppMethodBeat.o(70468);
            return cul;
        } catch (JSONException e2) {
            Log.e("MicroMsg.WalletQueryBankcardParser", "getOfflineGuideBarFromJSONStr() Exception:%s", e2.getMessage());
            AppMethodBeat.o(70468);
            return null;
        }
    }

    public enum a {
        GuideType_FQF_SWITCH("切换分付", 1),
        GuideType_FQF_SWITCH_OPEN("分付开通条", 2);
        
        public final String ADM;
        public final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(70448);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(70448);
            return aVar;
        }

        static {
            AppMethodBeat.i(70449);
            AppMethodBeat.o(70449);
        }

        private a(String str, int i2) {
            this.ADM = str;
            this.value = i2;
        }
    }
}

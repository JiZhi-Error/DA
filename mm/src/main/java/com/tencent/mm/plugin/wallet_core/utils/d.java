package com.tencent.mm.plugin.wallet_core.utils;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.d.c;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.BankcardScene;
import com.tencent.mm.plugin.wallet_core.model.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    public static boolean E(List<Bankcard> list, int i2) {
        AppMethodBeat.i(71636);
        if (list == null) {
            AppMethodBeat.o(71636);
            return false;
        }
        if (i2 == 8) {
            ArrayList arrayList = new ArrayList();
            for (Bankcard bankcard : list) {
                BankcardScene k = k(bankcard);
                k.field_scene = 8;
                arrayList.add(k);
            }
            t.fQG().ib(arrayList);
        } else if (i2 == 12) {
            ArrayList arrayList2 = new ArrayList();
            for (Bankcard bankcard2 : list) {
                BankcardScene k2 = k(bankcard2);
                k2.field_scene = 12;
                arrayList2.add(k2);
            }
            t.fQG().ib(arrayList2);
        } else {
            t.fQF().ib(list);
        }
        AppMethodBeat.o(71636);
        return true;
    }

    public static boolean a(Bankcard bankcard, int i2) {
        boolean g2;
        AppMethodBeat.i(71637);
        if (bankcard == null) {
            AppMethodBeat.o(71637);
            return false;
        }
        if (i2 == 8) {
            BankcardScene k = k(bankcard);
            k.field_scene = 8;
            g2 = t.fQG().a(k);
        } else if (i2 == 12) {
            BankcardScene k2 = k(bankcard);
            k2.field_scene = 12;
            g2 = t.fQG().a(k2);
        } else {
            g2 = t.fQF().g(bankcard);
        }
        AppMethodBeat.o(71637);
        return g2;
    }

    public static boolean aeX(int i2) {
        boolean bnU;
        AppMethodBeat.i(71638);
        if (i2 == 8) {
            bnU = t.fQG().aeN(i2);
        } else {
            bnU = t.fQG().bnU();
        }
        AppMethodBeat.o(71638);
        return bnU;
    }

    public static ArrayList<Bankcard> aeY(int i2) {
        ArrayList arrayList;
        AppMethodBeat.i(214262);
        c fQG = t.fQG();
        Cursor rawQuery = fQG.db.rawQuery("select * from WalletBankcardScene where (cardType <= 7 OR cardType & " + BankcardScene.HVw + " != 0 OR cardType & " + BankcardScene.HVv + " != 0) and scene=" + i2, null, 2);
        if (rawQuery == null) {
            arrayList = null;
        } else {
            arrayList = null;
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    BankcardScene bankcardScene = new BankcardScene();
                    bankcardScene.convertFrom(rawQuery);
                    arrayList.add(bankcardScene);
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        if (arrayList == null) {
            AppMethodBeat.o(214262);
            return null;
        }
        ArrayList<Bankcard> arrayList2 = new ArrayList<>();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            BankcardScene bankcardScene2 = (BankcardScene) it.next();
            Bankcard bankcard = new Bankcard(bankcardScene2.HVx, bankcardScene2.HVy, bankcardScene2.HUS, bankcardScene2.HVz, bankcardScene2.HVA, bankcardScene2.HVB, bankcardScene2.HVC, bankcardScene2.HVD, bankcardScene2.HVE, bankcardScene2.HVF, bankcardScene2.HVG, bankcardScene2.HVH, bankcardScene2.HVI, bankcardScene2.HVJ, bankcardScene2.HVK, bankcardScene2.HUQ, bankcardScene2.HVL, bankcardScene2.dKO, bankcardScene2.HVM, bankcardScene2.HVN, bankcardScene2.HVO, bankcardScene2.HVP, bankcardScene2.HVQ, bankcardScene2.HVR, bankcardScene2.HVS, bankcardScene2.HVT, bankcardScene2.HVU, bankcardScene2.HVV, bankcardScene2.HVW, bankcardScene2.HVX, bankcardScene2.HVY, bankcardScene2.HVZ, bankcardScene2.HWa, bankcardScene2.Hwr, bankcardScene2.Hws);
            bankcard.field_bindSerial = bankcardScene2.field_bindSerial;
            bankcard.field_cardType = bankcardScene2.field_cardType;
            bankcard.field_bankcardState = bankcardScene2.field_bankcardState;
            bankcard.field_forbidWord = bankcardScene2.field_forbidWord;
            bankcard.field_bankName = bankcardScene2.field_bankName;
            bankcard.field_bankcardType = bankcardScene2.field_bankcardType;
            bankcard.field_bankcardTypeName = bankcardScene2.field_bankcardTypeName;
            bankcard.field_bankcardTag = bankcardScene2.field_bankcardTag;
            bankcard.field_bankcardTail = bankcardScene2.field_bankcardTail;
            bankcard.field_supportTag = bankcardScene2.field_supportTag;
            bankcard.field_mobile = bankcardScene2.field_mobile;
            bankcard.field_trueName = bankcardScene2.field_trueName;
            bankcard.field_desc = bankcardScene2.field_desc;
            bankcard.field_bankPhone = bankcardScene2.field_bankPhone;
            bankcard.field_bizUsername = bankcardScene2.field_bizUsername;
            bankcard.field_onceQuotaKind = bankcardScene2.field_onceQuotaKind;
            bankcard.field_onceQuotaVirtual = bankcardScene2.field_onceQuotaVirtual;
            bankcard.field_dayQuotaKind = bankcardScene2.field_dayQuotaKind;
            bankcard.field_dayQuotaVirtual = bankcardScene2.field_dayQuotaVirtual;
            bankcard.field_fetchArriveTime = bankcardScene2.field_fetchArriveTime;
            bankcard.field_fetchArriveTimeWording = bankcardScene2.field_fetchArriveTimeWording;
            bankcard.field_repay_url = bankcardScene2.field_repay_url;
            bankcard.field_wxcreditState = bankcardScene2.field_wxcreditState;
            bankcard.field_bankcardClientType = bankcardScene2.field_bankcardClientType;
            bankcard.field_ext_msg = bankcardScene2.field_ext_msg;
            bankcard.field_support_micropay = bankcardScene2.field_support_micropay;
            bankcard.field_arrive_type = bankcardScene2.field_arrive_type;
            bankcard.field_avail_save_wording = bankcardScene2.field_avail_save_wording;
            bankcard.field_fetch_charge_rate = bankcardScene2.field_fetch_charge_rate;
            bankcard.field_full_fetch_charge_fee = bankcardScene2.field_full_fetch_charge_fee;
            bankcard.field_fetch_charge_info = bankcardScene2.field_fetch_charge_info;
            bankcard.field_tips = bankcardScene2.field_tips;
            bankcard.field_forbid_title = bankcardScene2.field_forbid_title;
            bankcard.field_forbid_url = bankcardScene2.field_forbid_url;
            bankcard.field_no_micro_word = bankcardScene2.field_no_micro_word;
            bankcard.field_card_bottom_wording = bankcardScene2.field_card_bottom_wording;
            bankcard.field_support_lqt_turn_in = bankcardScene2.field_support_lqt_turn_in;
            bankcard.field_support_lqt_turn_out = bankcardScene2.field_support_lqt_turn_out;
            bankcard.field_is_hightlight_pre_arrive_time_wording = bankcardScene2.field_is_hightlight_pre_arrive_time_wording;
            bankcard.field_card_state_name = bankcardScene2.field_card_state_name;
            bankcard.field_prompt_info_prompt_text = bankcardScene2.field_prompt_info_prompt_text;
            bankcard.field_prompt_info_jump_text = bankcardScene2.field_prompt_info_jump_text;
            bankcard.field_prompt_info_jump_url = bankcardScene2.field_prompt_info_jump_url;
            arrayList2.add(bankcard);
        }
        AppMethodBeat.o(214262);
        return arrayList2;
    }

    private static BankcardScene k(Bankcard bankcard) {
        AppMethodBeat.i(71640);
        BankcardScene bankcardScene = new BankcardScene(bankcard.HVx, bankcard.HVy, bankcard.HUS, bankcard.HVz, bankcard.HVA, bankcard.HVB, bankcard.HVC, bankcard.HVD, bankcard.HVE, bankcard.HVF, bankcard.HVG, bankcard.HVH, bankcard.HVI, bankcard.HVJ, bankcard.HVK, bankcard.HUQ, bankcard.HVL, bankcard.dKO, bankcard.HVM, bankcard.HVN, bankcard.HVO, bankcard.HVP, bankcard.HVQ, bankcard.HVR, bankcard.HVS, bankcard.HVT, bankcard.HVU, bankcard.HVV, bankcard.HVW, bankcard.HVX, bankcard.HVY, bankcard.HVZ, bankcard.HWa, bankcard.Hwr, bankcard.Hws);
        bankcardScene.field_bindSerial = bankcard.field_bindSerial;
        bankcardScene.field_cardType = bankcard.field_cardType;
        bankcardScene.field_bankcardState = bankcard.field_bankcardState;
        bankcardScene.field_forbidWord = bankcard.field_forbidWord;
        bankcardScene.field_bankName = bankcard.field_bankName;
        bankcardScene.field_bankcardType = bankcard.field_bankcardType;
        bankcardScene.field_bankcardTypeName = bankcard.field_bankcardTypeName;
        bankcardScene.field_bankcardTag = bankcard.field_bankcardTag;
        bankcardScene.field_bankcardTail = bankcard.field_bankcardTail;
        bankcardScene.field_supportTag = bankcard.field_supportTag;
        bankcardScene.field_mobile = bankcard.field_mobile;
        bankcardScene.field_trueName = bankcard.field_trueName;
        bankcardScene.field_desc = bankcard.field_desc;
        bankcardScene.field_bankPhone = bankcard.field_bankPhone;
        bankcardScene.field_bizUsername = bankcard.field_bizUsername;
        bankcardScene.field_onceQuotaKind = bankcard.field_onceQuotaKind;
        bankcardScene.field_onceQuotaVirtual = bankcard.field_onceQuotaVirtual;
        bankcardScene.field_dayQuotaKind = bankcard.field_dayQuotaKind;
        bankcardScene.field_dayQuotaVirtual = bankcard.field_dayQuotaVirtual;
        bankcardScene.field_fetchArriveTime = bankcard.field_fetchArriveTime;
        bankcardScene.field_fetchArriveTimeWording = bankcard.field_fetchArriveTimeWording;
        bankcardScene.field_repay_url = bankcard.field_repay_url;
        bankcardScene.field_wxcreditState = bankcard.field_wxcreditState;
        bankcardScene.field_bankcardClientType = bankcard.field_bankcardClientType;
        bankcardScene.field_ext_msg = bankcard.field_ext_msg;
        bankcardScene.field_support_micropay = bankcard.field_support_micropay;
        bankcardScene.field_arrive_type = bankcard.field_arrive_type;
        bankcardScene.field_avail_save_wording = bankcard.field_avail_save_wording;
        bankcardScene.field_fetch_charge_rate = bankcard.field_fetch_charge_rate;
        bankcardScene.field_full_fetch_charge_fee = bankcard.field_full_fetch_charge_fee;
        bankcardScene.field_fetch_charge_info = bankcard.field_fetch_charge_info;
        bankcardScene.field_tips = bankcard.field_tips;
        bankcardScene.field_forbid_title = bankcard.field_forbid_title;
        bankcardScene.field_forbid_url = bankcard.field_forbid_url;
        bankcardScene.field_no_micro_word = bankcard.field_no_micro_word;
        bankcardScene.field_card_bottom_wording = bankcard.field_card_bottom_wording;
        bankcardScene.field_support_lqt_turn_in = bankcard.field_support_lqt_turn_in;
        bankcardScene.field_support_lqt_turn_out = bankcard.field_support_lqt_turn_out;
        bankcardScene.field_is_hightlight_pre_arrive_time_wording = bankcard.field_is_hightlight_pre_arrive_time_wording;
        bankcardScene.field_card_state_name = bankcard.field_card_state_name;
        bankcardScene.field_prompt_info_prompt_text = bankcard.field_prompt_info_prompt_text;
        bankcardScene.field_prompt_info_jump_text = bankcard.field_prompt_info_jump_text;
        bankcardScene.field_prompt_info_jump_url = bankcard.field_prompt_info_jump_url;
        AppMethodBeat.o(71640);
        return bankcardScene;
    }
}

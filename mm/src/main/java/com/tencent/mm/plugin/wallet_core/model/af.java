package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class af {
    public static ArrayList<Bankcard> yh(boolean z) {
        ArrayList<Bankcard> yj;
        AppMethodBeat.i(70433);
        Log.i("MicroMsg.WalletPayOrderMgr", "sort bankcard isPos: %s", Boolean.valueOf(z));
        if (z) {
            yj = t.fQI().fRI();
        } else {
            yj = t.fQI().yj(true);
        }
        List<c> fRF = t.fQI().fRF();
        if (fRF == null) {
            Log.w("MicroMsg.WalletPayOrderMgr", "empty bankinfo list");
            AppMethodBeat.o(70433);
            return yj;
        }
        ArrayList<Bankcard> arrayList = new ArrayList<>();
        for (c cVar : fRF) {
            Iterator<Bankcard> it = yj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Bankcard next = it.next();
                if (next.field_bindSerial.equals(cVar.ANo)) {
                    yj.remove(next);
                    arrayList.add(next);
                    break;
                }
            }
        }
        if (!yj.isEmpty()) {
            Log.w("MicroMsg.WalletPayOrderMgr", "has unsort bankcard");
            arrayList.addAll(yj);
        }
        AppMethodBeat.o(70433);
        return arrayList;
    }

    public static List<Bankcard> fQT() {
        AppMethodBeat.i(258739);
        ArrayList<Bankcard> yh = yh(false);
        AppMethodBeat.o(258739);
        return yh;
    }

    public static Bankcard yi(boolean z) {
        boolean z2;
        ArrayList<Bankcard> arrayList;
        AppMethodBeat.i(214197);
        Log.i("MicroMsg.WalletPayOrderMgr", "defaultLocalOfflineBankcard");
        g.aAi();
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_OFFLINE_FQF_SETTING_STATE_INT_SYNC, (Object) 1)).intValue() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        t.fQI();
        String fRR = an.fRR();
        Log.i("MicroMsg.WalletPayOrderMgr", " getSelectedDefault BindBankCard %s，isFqfCardSettingEnable： %s ，needJudeSwitchFQF ：%s", fRR, Boolean.valueOf(z2), Boolean.valueOf(z));
        ArrayList<Bankcard> fRH = t.fQI().fRH();
        if (fRH == null) {
            arrayList = t.fQI().yj(true);
        } else {
            arrayList = fRH;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way1：getLastBankcard");
        int i2 = 0;
        while (!TextUtils.isEmpty(fRR) && arrayList != null && i2 < arrayList.size()) {
            Bankcard bankcard = arrayList.get(i2);
            if (bankcard != null) {
                Log.i("MicroMsg.WalletPayOrderMgr", "compared bankcard.field_bindSerial:%s", bankcard.field_bindSerial);
            }
            if (bankcard != null && fRR.equals(bankcard.field_bindSerial)) {
                Log.i("MicroMsg.WalletPayOrderMgr", "micropay: %s, forbidword: %s", Boolean.valueOf(bankcard.field_support_micropay), bankcard.field_forbidWord);
                if (!bankcard.field_support_micropay) {
                    continue;
                } else if (!z || !bankcard.fQg()) {
                    Log.i("MicroMsg.WalletPayOrderMgr", " final getLastBankcard：%s ", bankcard.field_bindSerial);
                    AppMethodBeat.o(214197);
                    return bankcard;
                } else if (z2) {
                    Log.i("MicroMsg.WalletPayOrderMgr", " final getLastBankcard FQF");
                    AppMethodBeat.o(214197);
                    return bankcard;
                }
            }
            i2++;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "clear default bindserial");
        t.fQI();
        an.aVq("");
        Log.i("MicroMsg.WalletPayOrderMgr", "way2：mainBankcard");
        t.fQI();
        Bankcard fRX = an.fRX();
        if (fRX != null && Util.isNullOrNil(fRX.field_forbidWord)) {
            Log.i("MicroMsg.WalletPayOrderMgr", "do change main card: %s", fRX.field_bankcardType);
            if (!z || !fRX.fQg()) {
                Log.i("MicroMsg.WalletPayOrderMgr", "final mainBankcard：%s ", fRX.field_bindSerial);
                AppMethodBeat.o(214197);
                return fRX;
            } else if (z2) {
                Log.i("MicroMsg.WalletPayOrderMgr", " final mainBankcard FQF ");
                AppMethodBeat.o(214197);
                return fRX;
            }
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way3：do change first card");
        int i3 = 0;
        while (arrayList != null && i3 < arrayList.size()) {
            Bankcard bankcard2 = arrayList.get(i3);
            if (bankcard2 != null && bankcard2.field_support_micropay && !bankcard2.fQb()) {
                Log.i("MicroMsg.WalletPayOrderMgr", "do change first card: %s", bankcard2.field_bankcardType);
                if (!z || !bankcard2.fQg()) {
                    Log.i("MicroMsg.WalletPayOrderMgr", " final do change first card:%s", bankcard2.field_bindSerial);
                    AppMethodBeat.o(214197);
                    return bankcard2;
                } else if (z2) {
                    Log.i("MicroMsg.WalletPayOrderMgr", " final do change first card FQF");
                    AppMethodBeat.o(214197);
                    return bankcard2;
                }
            }
            i3++;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "way4：do change balance");
        Bankcard bankcard3 = t.fQI().Hwc;
        if (bankcard3 == null || !bankcard3.field_support_micropay) {
            Log.i("MicroMsg.WalletPayOrderMgr", "way5：do change lqtbalance ");
            Bankcard bankcard4 = t.fQI().IbQ;
            if (bankcard4 == null || !bankcard4.field_support_micropay || !Util.isNullOrNil(bankcard4.field_forbidWord)) {
                AppMethodBeat.o(214197);
                return null;
            }
            Log.i("MicroMsg.WalletPayOrderMgr", " final do change lqtbalance: %s", bankcard4.field_bankcardType);
            AppMethodBeat.o(214197);
            return bankcard4;
        }
        Log.i("MicroMsg.WalletPayOrderMgr", "final do change balance: %s", bankcard3.field_bankcardType);
        AppMethodBeat.o(214197);
        return bankcard3;
    }
}

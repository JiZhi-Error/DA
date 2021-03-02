package com.tencent.mm.plugin.wallet_core.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class ak {
    public ArrayList<Bankcard> IbD = new ArrayList<>();
    public String IbE;

    public ak() {
        AppMethodBeat.i(70472);
        AppMethodBeat.o(70472);
    }

    public final Bankcard aVl(String str) {
        Bankcard bankcard;
        AppMethodBeat.i(70473);
        if (this.IbD.size() > 0) {
            Iterator<Bankcard> it = this.IbD.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bankcard = null;
                    break;
                }
                bankcard = it.next();
                if (bankcard.field_bindSerial.equals(str)) {
                    break;
                }
            }
            if (bankcard == null) {
                Log.e("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo return null");
            } else {
                Log.i("MicroMsg.WalletRepaymentBankcardMgr", "getBankcardBySerialNo succ");
            }
        } else {
            Log.e("MicroMsg.WalletRepaymentBankcardMgr", "repayment bankcard list size is 0");
            bankcard = null;
        }
        AppMethodBeat.o(70473);
        return bankcard;
    }

    public final boolean fQW() {
        AppMethodBeat.i(70474);
        if (this.IbD.size() > 0) {
            AppMethodBeat.o(70474);
            return true;
        }
        AppMethodBeat.o(70474);
        return false;
    }

    public final Bankcard fQX() {
        AppMethodBeat.i(70475);
        if (!fQW()) {
            Log.e("MicroMsg.WalletRepaymentBankcardMgr", "Repayment card list is null");
            AppMethodBeat.o(70475);
            return null;
        } else if (!TextUtils.isEmpty(this.IbE)) {
            Bankcard aVl = aVl(this.IbE);
            AppMethodBeat.o(70475);
            return aVl;
        } else {
            Log.i("MicroMsg.WalletRepaymentBankcardMgr", "last_use_card_serialno is empty,return the first one");
            Bankcard bankcard = this.IbD.get(0);
            AppMethodBeat.o(70475);
            return bankcard;
        }
    }
}

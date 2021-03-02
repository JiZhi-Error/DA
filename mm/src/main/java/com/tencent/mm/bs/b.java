package com.tencent.mm.bs;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.protocal.protobuf.bzu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public static void run() {
        AppMethodBeat.i(32072);
        if (!bg.aAc() || bg.azj()) {
            AppMethodBeat.o(32072);
            return;
        }
        long nowSecond = Util.nowSecond();
        bg.aVF();
        long nullAs = Util.nullAs((Long) c.azQ().get(331797, (Object) null), 0);
        if (10013 == ac.jOC && ac.jOD != 0) {
            nullAs = 0;
        }
        if (nullAs < nowSecond) {
            bg.aVF();
            c.azQ().set(331797, Long.valueOf(432000 + nowSecond));
            try {
                bzu bzu = new bzu();
                bzu.Mfs = "";
                Account[] accountsByType = AccountManager.get(MMApplicationContext.getContext()).getAccountsByType("com.google");
                for (Account account : accountsByType) {
                    if (!Util.isNullOrNil(bzu.Mfs)) {
                        break;
                    }
                    Log.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                    bzu.Mfs = account.name;
                }
                if (10013 == ac.jOC && ac.jOD != 0) {
                    bzu.Mfs = "rssjbbk@gmail.com";
                }
                if (!Util.isNullOrNil(bzu.Mfs)) {
                    bg.aVF();
                    c.aSM().d(new k.a(57, bzu));
                    AppMethodBeat.o(32072);
                    return;
                }
                Log.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                AppMethodBeat.o(32072);
                return;
            } catch (Exception e2) {
                Log.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e2.getMessage());
            }
        }
        AppMethodBeat.o(32072);
    }
}

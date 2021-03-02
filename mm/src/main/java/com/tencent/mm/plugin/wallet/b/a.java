package com.tencent.mm.plugin.wallet.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.bm;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public final class a {
    public static boolean aeG(int i2) {
        AppMethodBeat.i(69858);
        g.aAi();
        if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_LOAN_ENTRANCE_RED_POINT_INT, (Object) -1)).intValue() >= i2 || i2 <= 0) {
            AppMethodBeat.o(69858);
            return false;
        }
        AppMethodBeat.o(69858);
        return true;
    }

    public static boolean fPB() {
        boolean z;
        AppMethodBeat.i(69859);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        Log.i("MicroMsg.WalletUtil", "mgr==null?" + (aVar == null));
        if (aVar != null) {
            Log.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + aVar.dJT());
        }
        s.fOg();
        an fOh = s.fOh();
        al fRs = fOh.fRs();
        StringBuilder sb = new StringBuilder("config==null?");
        if (fRs == null) {
            z = true;
        } else {
            z = false;
        }
        Log.i("MicroMsg.WalletUtil", sb.append(z).toString());
        if (fRs != null) {
            Log.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + fRs.fRa());
        }
        Log.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + fOh.fRk());
        if (aVar == null || !aVar.dJT() || fRs == null || !fRs.fRa() || !fOh.fRk()) {
            AppMethodBeat.o(69859);
            return false;
        }
        AppMethodBeat.o(69859);
        return true;
    }

    public static boolean fPC() {
        AppMethodBeat.i(69860);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (aVar == null) {
            Log.w("MicroMsg.WalletUtil", "no finger mgr!");
            AppMethodBeat.o(69860);
            return false;
        }
        s.fOg();
        an fOh = s.fOh();
        al fRs = fOh.fRs();
        h.INSTANCE.dN(bm.CTRL_INDEX, 0);
        Log.i("MicroMsg.WalletUtil", "support faceid: %s, %s, %s", Boolean.valueOf(aVar.dKb()), Boolean.valueOf(fRs.fRa()), Boolean.valueOf(fOh.fRk()));
        if (!aVar.dKb() || !fRs.fRa() || !fOh.fRk()) {
            AppMethodBeat.o(69860);
            return false;
        }
        AppMethodBeat.o(69860);
        return true;
    }
}

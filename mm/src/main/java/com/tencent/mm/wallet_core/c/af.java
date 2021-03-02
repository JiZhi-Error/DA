package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class af {
    public static void z(int i2, String str, int i3) {
        AppMethodBeat.i(72819);
        Log.v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", Integer.valueOf(i2), str, Integer.valueOf(i3));
        h.INSTANCE.a(14997, Integer.valueOf(i2), str, Integer.valueOf(i3));
        AppMethodBeat.o(72819);
    }

    public static void f(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(72820);
        Log.v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", Integer.valueOf(i2), str, Integer.valueOf(i3), str2);
        h.INSTANCE.a(15001, Integer.valueOf(i2), str, Integer.valueOf(i3), str2);
        AppMethodBeat.o(72820);
    }
}

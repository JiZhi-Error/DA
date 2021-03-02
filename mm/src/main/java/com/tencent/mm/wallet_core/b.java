package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.c;

public final class b {
    private static b RrX;

    public static b hgC() {
        AppMethodBeat.i(72641);
        if (RrX == null) {
            RrX = new b();
        }
        b bVar = RrX;
        AppMethodBeat.o(72641);
        return bVar;
    }

    public static boolean hgD() {
        int i2;
        AppMethodBeat.i(72642);
        c Fu = d.aXu().Fu("100368");
        if (!Fu.isValid() || !"1".equals(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Log.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", Integer.valueOf(i2));
        if (i2 > 0) {
            AppMethodBeat.o(72642);
            return true;
        }
        AppMethodBeat.o(72642);
        return false;
    }

    public static boolean hgE() {
        int i2;
        AppMethodBeat.i(72643);
        c Fu = d.aXu().Fu("100370");
        if (!Fu.isValid() || !"1".equals(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Log.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", Integer.valueOf(i2));
        if (i2 > 0) {
            AppMethodBeat.o(72643);
            return true;
        }
        AppMethodBeat.o(72643);
        return false;
    }

    public static boolean hgF() {
        int i2;
        AppMethodBeat.i(72644);
        c Fu = d.aXu().Fu("100369");
        if (!Fu.isValid() || !"1".equals(Fu.gzz().get(WeChatBrands.Business.GROUP_OPEN))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        Log.i("MicroMsg.TenPaySdkAbTest", "isCertOpen2048 %s", Integer.valueOf(i2));
        if (i2 > 0) {
            AppMethodBeat.o(72644);
            return true;
        }
        AppMethodBeat.o(72644);
        return false;
    }

    public static boolean b(b.a aVar, boolean z) {
        int i2;
        AppMethodBeat.i(72645);
        a.cMr();
        try {
            i2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_KINDA_PAY_CONFIG_TYPE_INT, (Object) 0)).intValue();
        } catch (com.tencent.mm.model.b e2) {
            Log.printErrStackTrace("MicroMsg.TenPaySdkAbTest", e2, "isKindaEnable get configVal error! AccountNotReady!", new Object[0]);
            i2 = 0;
        }
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, z);
        Log.i("MicroMsg.TenPaySdkAbTest", "isKindaBindCardEnable configval %s svrConfig %s isDebug %s isFlavorRed %s isFlavorPurple %s BuildInfo %s", Integer.valueOf(i2), Boolean.valueOf(a2), Boolean.FALSE, Boolean.valueOf(BuildInfo.IS_FLAVOR_RED), Boolean.valueOf(BuildInfo.IS_FLAVOR_PURPLE), BuildInfo.KINDA_DEFAULT);
        if (WeChatBrands.Business.GROUP_OPEN.equals(BuildInfo.KINDA_DEFAULT)) {
            AppMethodBeat.o(72645);
            return true;
        } else if ("close".equals(BuildInfo.KINDA_DEFAULT)) {
            AppMethodBeat.o(72645);
            return false;
        } else if (i2 == 1) {
            AppMethodBeat.o(72645);
            return true;
        } else if (i2 == 2) {
            AppMethodBeat.o(72645);
            return false;
        } else if (a2) {
            AppMethodBeat.o(72645);
            return true;
        } else if (BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            AppMethodBeat.o(72645);
            return true;
        } else {
            AppMethodBeat.o(72645);
            return false;
        }
    }
}

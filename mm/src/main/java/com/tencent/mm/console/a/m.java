package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class m implements a {
    static {
        AppMethodBeat.i(20192);
        b.a(new m(), "//pay");
        AppMethodBeat.o(20192);
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20191);
        if (strArr.length < 2) {
            AppMethodBeat.o(20191);
            return true;
        }
        String str2 = strArr[1];
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1943286194:
                if (str2.equals("forcenewcashier")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1543416301:
                if (str2.equals("resethbguide")) {
                    c2 = 5;
                    break;
                }
                break;
            case -1326045846:
                if (str2.equals("dorder")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99657:
                if (str2.equals("dot")) {
                    c2 = 2;
                    break;
                }
                break;
            case 174797075:
                if (str2.equals("sethassource")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1110195625:
                if (str2.equals("fackchatting")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                c.V(context, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
                AppMethodBeat.o(20191);
                return true;
            case 1:
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, (Object) 1);
                AppMethodBeat.o(20191);
                return true;
            case 2:
                com.tencent.mm.y.c.axV().b(ar.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                AppMethodBeat.o(20191);
                return true;
            case 3:
                if (strArr.length >= 3) {
                    g.aAh().azQ().set(ar.a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(Util.getInt(strArr[2], 0)));
                }
                AppMethodBeat.o(20191);
                return true;
            case 4:
                ((com.tencent.mm.plugin.wxpay.a.a) g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).doRedPacketPreviewLoading(context, "");
                AppMethodBeat.o(20191);
                return true;
            case 5:
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_GUIDE_TIME_INT_SYNC, (Object) 0);
                g.aAh().azQ().set(ar.a.USERINFO_LUCKY_MONEY_STORY_PREVIEW_GUIDE_TIME_INT_SYNC, (Object) 0);
                AppMethodBeat.o(20191);
                return true;
            default:
                AppMethodBeat.o(20191);
                return false;
        }
    }

    public static void init() {
    }
}

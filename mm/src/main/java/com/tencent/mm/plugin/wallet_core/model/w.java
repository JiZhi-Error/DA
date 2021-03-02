package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.Map;

public final class w {
    public String DWN;
    public String Iba;
    public int Ibb;
    public String Ibc;
    public String Ibd;
    public String Ibe;
    public String dQx;

    public static w ba(Map<String, String> map) {
        AppMethodBeat.i(70408);
        if (map == null) {
            AppMethodBeat.o(70408);
            return null;
        }
        w wVar = new w();
        wVar.dQx = map.get(".sysmsg.paymsg.BalanceNotice.wording");
        wVar.Iba = map.get(".sysmsg.paymsg.BalanceNotice.wording_color");
        wVar.DWN = map.get(".sysmsg.paymsg.BalanceNotice.bg_color");
        wVar.Ibc = map.get(".sysmsg.paymsg.BalanceNotice.route_url");
        wVar.Ibd = map.get(".sysmsg.paymsg.BalanceNotice.left_icon");
        wVar.Ibe = map.get(".sysmsg.paymsg.BalanceNotice.right_icon");
        wVar.Ibb = Util.getInt(map.get(".sysmsg.paymsg.BalanceNotice.wording_size"), 14);
        AppMethodBeat.o(70408);
        return wVar;
    }

    public static void aVh(String str) {
        AppMethodBeat.i(70409);
        ((a) g.ah(a.class)).getWalletCacheStg().set(ar.a.USERINFO_BALANCE_FREEZE_MESSAGE_STRING_SYNC, str);
        AppMethodBeat.o(70409);
    }
}

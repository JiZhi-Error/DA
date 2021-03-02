package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.HashSet;
import java.util.Set;

public final class w {
    private Object lock = new Object();
    private Set<String> yWh = new HashSet();

    public w() {
        AppMethodBeat.i(65225);
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(",");
            for (String str2 : split) {
                this.yWh.add(str2);
            }
        }
        AppMethodBeat.o(65225);
    }

    public final boolean aDu(String str) {
        boolean z = false;
        AppMethodBeat.i(65226);
        synchronized (this.lock) {
            try {
                if (!this.yWh.contains(str)) {
                    StringBuilder sb = new StringBuilder((String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, ""));
                    if (this.yWh.size() <= 0) {
                        sb.append(str);
                    } else {
                        sb.append(",").append(str);
                    }
                    g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, sb.toString());
                    z = this.yWh.add(str);
                } else {
                    Log.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", str);
                    AppMethodBeat.o(65226);
                }
            } finally {
                AppMethodBeat.o(65226);
            }
        }
        return z;
    }

    public final void aDv(String str) {
        String substring;
        AppMethodBeat.i(65227);
        synchronized (this.lock) {
            try {
                this.yWh.remove(str);
                StringBuilder sb = new StringBuilder();
                for (String str2 : this.yWh) {
                    sb.append(str2).append(",");
                }
                if (sb.length() == 0) {
                    substring = sb.toString();
                } else {
                    substring = sb.substring(0, sb.length() - 1);
                }
                g.aAh().azQ().set(ar.a.USERINFO_WALLET_HONGBAO_PAYMSGID_STRING_SYNC, substring);
            } finally {
                AppMethodBeat.o(65227);
            }
        }
    }
}

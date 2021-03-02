package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;

public final class b {
    public static boolean c(Bankcard bankcard) {
        AppMethodBeat.i(69076);
        if (bankcard == null) {
            AppMethodBeat.o(69076);
            return false;
        }
        g.aAi();
        String str = (String) g.aAh().azQ().get(196659, (Object) null);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(69076);
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            AppMethodBeat.o(69076);
            return true;
        }
        for (String str2 : split) {
            if (str2 != null && str2.equals(bankcard.field_bankcardType)) {
                AppMethodBeat.o(69076);
                return false;
            }
        }
        AppMethodBeat.o(69076);
        return true;
    }
}

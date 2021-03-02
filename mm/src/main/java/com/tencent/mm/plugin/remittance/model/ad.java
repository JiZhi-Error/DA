package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ad {
    public static void aMh(String str) {
        Object[] split;
        AppMethodBeat.i(67912);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(67912);
            return;
        }
        String eNA = eNA();
        Log.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(eNA)));
        StringBuilder sb = new StringBuilder();
        if (!Util.isNullOrNil(eNA) && (split = eNA.split(",")) != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < split.length; i3++) {
                if (!str.equals(split[i3])) {
                    sb.append(split[i3]);
                    sb.append(",");
                    i2++;
                    if (i2 >= 4) {
                        break;
                    }
                }
            }
        }
        sb.insert(0, ",");
        sb.insert(0, str);
        sb.deleteCharAt(sb.length() - 1);
        Log.d("Micromsg.RemittanceLogic", "new friendsListStr=" + sb.toString());
        g.aAi();
        g.aAh().azQ().set(327733, sb.toString());
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(67912);
    }

    public static String eNA() {
        AppMethodBeat.i(67913);
        g.aAi();
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(327733, (Object) null));
        AppMethodBeat.o(67913);
        return nullAsNil;
    }
}

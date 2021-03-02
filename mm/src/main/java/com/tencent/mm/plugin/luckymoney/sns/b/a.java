package com.tencent.mm.plugin.luckymoney.sns.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ar;

public final class a {
    public static int efC() {
        AppMethodBeat.i(65408);
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, (Object) 0)).intValue();
        AppMethodBeat.o(65408);
        return intValue;
    }

    public static void PO(int i2) {
        AppMethodBeat.i(65409);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_IS_OPEN_SNS_PAY_INT_SYNC, Integer.valueOf(i2));
        g.aAi();
        g.aAh().azQ().gBI();
        AppMethodBeat.o(65409);
    }

    public static String efD() {
        AppMethodBeat.i(65410);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_TITLE_STRING_SYNC, "");
        AppMethodBeat.o(65410);
        return str;
    }

    public static String efE() {
        AppMethodBeat.i(65411);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_NEWYEAR_2016_HONGBAO_SET_SNS_PAY_WORDING_STRING_SYNC, "");
        AppMethodBeat.o(65411);
        return str;
    }
}

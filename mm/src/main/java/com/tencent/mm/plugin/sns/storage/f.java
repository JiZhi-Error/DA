package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.aj;

public final class f {
    public static SnsInfo aQl(String str) {
        AppMethodBeat.i(97444);
        if (y.aNz(str)) {
            SnsInfo JJ = aj.faO().JJ(y.aOa(str));
            AppMethodBeat.o(97444);
            return JJ;
        }
        AdSnsInfo JE = aj.faR().JE(y.aOa(str));
        if (JE != null) {
            SnsInfo convertToSnsInfo = JE.convertToSnsInfo();
            AppMethodBeat.o(97444);
            return convertToSnsInfo;
        }
        AppMethodBeat.o(97444);
        return null;
    }

    public static boolean a(String str, SnsInfo snsInfo) {
        AppMethodBeat.i(97445);
        if (y.aNz(str)) {
            boolean b2 = aj.faO().b(y.aOa(str), snsInfo);
            AppMethodBeat.o(97445);
            return b2;
        }
        boolean b3 = aj.faR().b(y.aOa(str), snsInfo.getAdSnsInfo());
        AppMethodBeat.o(97445);
        return b3;
    }

    public static SnsInfo aQm(String str) {
        AppMethodBeat.i(97446);
        if (y.aNz(str)) {
            SnsInfo Zr = aj.faO().Zr(y.aQI(str));
            AppMethodBeat.o(97446);
            return Zr;
        }
        AdSnsInfo Zp = aj.faR().Zp(y.aQI(str));
        if (Zp != null) {
            SnsInfo convertToSnsInfo = Zp.convertToSnsInfo();
            AppMethodBeat.o(97446);
            return convertToSnsInfo;
        }
        AppMethodBeat.o(97446);
        return null;
    }
}

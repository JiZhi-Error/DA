package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class b {
    private static b kxL;
    public d kxI;
    public f kxJ;
    public a kxK;
    public String kxM = null;
    public String kxN = null;

    public static b bqC() {
        AppMethodBeat.i(238936);
        if (kxL == null) {
            kxL = new b();
        }
        b bVar = kxL;
        AppMethodBeat.o(238936);
        return bVar;
    }

    public static void l(String[] strArr) {
        AppMethodBeat.i(238937);
        for (int i2 = 0; i2 < 2; i2++) {
            String str = strArr[i2];
            s.boN(str);
            s.bpc(str);
        }
        AppMethodBeat.o(238937);
    }

    public final String TM(String str) {
        AppMethodBeat.i(238938);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(238938);
            return "";
        }
        String str2 = this.kxN + new StringBuilder().append(Math.abs(str.hashCode())).toString() + FilePathGenerator.ANDROID_DIR_SEP;
        AppMethodBeat.o(238938);
        return str2;
    }
}

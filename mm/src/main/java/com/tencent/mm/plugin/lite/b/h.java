package com.tencent.mm.plugin.lite.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class h {
    public static String aw(String str, String str2, String str3) {
        AppMethodBeat.i(198888);
        if (!Util.isNullOrNil(str2)) {
            str3 = str2;
        } else if (Util.isNullOrNil(str3)) {
            str3 = "_";
        }
        String str4 = ar.NSg + "/pkg/" + str + FilePathGenerator.ANDROID_DIR_SEP + str3;
        AppMethodBeat.o(198888);
        return str4;
    }
}

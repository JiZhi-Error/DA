package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.vfs.o;

public final class m {
    public static String cz(String str, boolean z) {
        AppMethodBeat.i(29794);
        String str2 = ar.NSe;
        Log.i("MicroMsg.VoicePrintLogic", "dbCachePath ".concat(String.valueOf(str2)));
        String str3 = str2.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? str2 + str : str2 + FilePathGenerator.ANDROID_DIR_SEP + str;
        Log.i("MicroMsg.VoicePrintLogic", "genpath ".concat(String.valueOf(str3)));
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(29794);
            return null;
        } else if (z) {
            AppMethodBeat.o(29794);
            return str3;
        } else if (new o(str3).exists()) {
            AppMethodBeat.o(29794);
            return str3;
        } else {
            AppMethodBeat.o(29794);
            return str3;
        }
    }
}

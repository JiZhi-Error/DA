package com.tencent.mm.plugin.sns.device.appstore;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e {
    public final String DFh;
    public final String DFi;
    public final boolean DFj;
    public final long DFk;
    public final String adExtInfo;
    public final String uxInfo;

    public static e C(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202661);
        try {
            e eVar = new e(str, str2, str3, str4);
            AppMethodBeat.o(202661);
            return eVar;
        } catch (Throwable th) {
            AppMethodBeat.o(202661);
            return null;
        }
    }

    private e(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(202662);
        this.DFh = str;
        this.DFi = str2;
        this.uxInfo = str3 == null ? "" : str3;
        this.adExtInfo = str4 == null ? "" : str4;
        this.DFj = true;
        this.DFk = SystemClock.elapsedRealtime();
        AppMethodBeat.o(202662);
    }
}

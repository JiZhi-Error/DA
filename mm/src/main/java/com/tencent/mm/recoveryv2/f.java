package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.d;
import com.tencent.mm.recoveryv2.a;
import com.tencent.mm.recoveryv2.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static void i(String str, String str2) {
        AppMethodBeat.i(193933);
        Log.i(str, str2);
        a.C2043a.log(4, str, str2);
        AppMethodBeat.o(193933);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(193934);
        Log.w(str, str2);
        a.C2043a.log(5, str, str2);
        AppMethodBeat.o(193934);
    }

    public static void w(String str, String str2, Throwable th) {
        AppMethodBeat.i(193935);
        Log.printErrStackTrace(str, th, str2, new Object[0]);
        a.w(str, str2, th);
        AppMethodBeat.o(193935);
    }

    public static void iL(Context context) {
        AppMethodBeat.i(193936);
        i("MicroMsg.recovery.logger", "flush recovery log to file");
        h.c iP = h.c.iP(context);
        iP.guM();
        d.cg(context).CN("RECOVERY");
        String guN = iP.guN();
        if (TextUtils.isEmpty(guN)) {
            guN = "nothing";
        }
        Log.i("MicroMsg.recovery.logger", ">>>>> dump recovery internal log (:recovery) <<<<<");
        Log.i("MicroMsg.recovery.logger", "\n".concat(String.valueOf(guN)));
        Log.i("MicroMsg.recovery.logger", ">>>>>>>>>>>>>>>>>>>>>> end <<<<<<<<<<<<<<<<<<<<<<<");
        Log.appenderFlush();
        AppMethodBeat.o(193936);
    }
}

package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public final class a {
    private static a rNH = null;
    long rNI = 0;

    public static a cMx() {
        AppMethodBeat.i(220248);
        if (rNH == null) {
            rNH = new a();
        }
        a aVar = rNH;
        AppMethodBeat.o(220248);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(220249);
        if (g.aAc()) {
            this.rNI = g.aAh().azQ().a(ar.a.USERINFO_GET_EXPTID_BEGIN_TIME_LONG, Util.nowMilliSecond());
            AppMethodBeat.o(220249);
            return;
        }
        this.rNI = Util.nowMilliSecond();
        AppMethodBeat.o(220249);
    }

    public static boolean GK(int i2) {
        AppMethodBeat.i(220250);
        if (i2 < 0) {
            Log.e("MicroMsg.ExptIdCount", "exptid err  less than  0 :  [%d]", Integer.valueOf(i2));
            AppMethodBeat.o(220250);
            return false;
        }
        b cMz = b.cMz();
        if (i2 < 0) {
            Log.e(b.TAG, "exptid or exptidcount less than 0 [%d] [%d] ", Integer.valueOf(i2), 1);
        } else if (i2 >= 0) {
            MultiProcessMMKV aTI = cMz.aTI();
            if (aTI == null) {
                Log.e(b.TAG, "get mmkv is null!, err");
            } else {
                int decodeInt = aTI.decodeInt(String.valueOf(i2));
                if (decodeInt == 0) {
                    aTI.putInt(String.valueOf(i2), 1);
                } else {
                    aTI.putInt(String.valueOf(i2), decodeInt + 1);
                }
                Log.i(b.TAG, "exptid  count  [%d] [%d]", Integer.valueOf(i2), Integer.valueOf(decodeInt + 1));
            }
        }
        e.INSTANCE.idkeyStat(863, 163, 1, false);
        AppMethodBeat.o(220250);
        return true;
    }

    public final boolean Dl(long j2) {
        AppMethodBeat.i(220251);
        if (j2 <= 0) {
            Log.e("MicroMsg.ExptIdCount", "acquisition time is less than 0  [%d]", Long.valueOf(j2));
            AppMethodBeat.o(220251);
            return false;
        } else if (g.aAc()) {
            Log.i("MicroMsg.ExptIdCount", "last begin time and last end time [%d], [%d]", Long.valueOf(g.aAh().azQ().a(ar.a.USERINFO_GET_EXPTID_BEGIN_TIME_LONG, 0)), Long.valueOf(j2));
            g.aAh().azQ().set(ar.a.USERINFO_GET_EXPTID_BEGIN_TIME_LONG, Long.valueOf(j2));
            this.rNI = j2;
            AppMethodBeat.o(220251);
            return true;
        } else {
            AppMethodBeat.o(220251);
            return false;
        }
    }

    public static void cMy() {
        AppMethodBeat.i(220252);
        g.azz().a(new c(), 0);
        AppMethodBeat.o(220252);
    }
}

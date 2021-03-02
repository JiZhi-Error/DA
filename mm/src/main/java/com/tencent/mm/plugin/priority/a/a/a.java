package com.tencent.mm.plugin.priority.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Calendar;

public final class a {
    public static final boolean hL(int i2, int i3) {
        return (i2 & i3) > 0;
    }

    public static String aB(String str, String str2, String str3) {
        String str4;
        int i2 = 1;
        AppMethodBeat.i(40495);
        o oVar = new o(str);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        if (Util.isNullOrNil(str2)) {
            str4 = str + "da_" + Util.nowMilliSecond();
            if (!Util.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        } else {
            if (!Util.isNullOrNil(str3) && !str2.endsWith(str3)) {
                str2 = str2 + "." + str3;
            }
            str4 = str + str2;
            if (s.YS(str4)) {
                while (true) {
                    if (i2 >= 20) {
                        break;
                    } else if (!s.YS(str + i2 + "_" + str2)) {
                        str4 = str + i2 + "_" + str2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 == 20) {
                    str4 = str + "da_" + Util.nowMilliSecond();
                    if (!Util.isNullOrNil(str3)) {
                        str4 = str4 + "." + str3;
                    }
                }
            }
        }
        try {
            if (!aa.z(new o(str4).heq().her()).equalsIgnoreCase(aa.z(new o(str).her()))) {
                str4 = str + "da_" + Util.nowMilliSecond();
                Log.w("MicroMsg.Priority.PriorityUtil", "maybe DirTraversal attach. %s", str4);
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Priority.PriorityUtil", e2, "", new Object[0]);
            str4 = str + "da_" + Util.nowMilliSecond();
            if (!Util.isNullOrNil(str3)) {
                str4 = str4 + "." + str3;
            }
        }
        AppMethodBeat.o(40495);
        return str4;
    }

    public static long eCQ() {
        AppMethodBeat.i(40496);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(40496);
        return timeInMillis;
    }
}

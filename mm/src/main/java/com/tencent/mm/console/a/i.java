package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ck;
import java.util.Calendar;

public final class i implements a {
    static {
        AppMethodBeat.i(20184);
        b.a(new i(), "//sport");
        AppMethodBeat.o(20184);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20183);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(20183);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(20183);
            return true;
        } else {
            String str2 = strArr[1];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -734972924:
                    if (str2.equals("setdevicestep")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1761741959:
                    if (str2.equals("setextapistep")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    int intValue = Integer.valueOf(strArr[2]).intValue();
                    Util.getBeginTimeOfToday();
                    Calendar instance = Calendar.getInstance();
                    instance.set(11, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).b("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), intValue, ck.getFingerprint());
                    break;
                case 1:
                    ((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).fmh();
                    com.tencent.mm.hellhoundlib.b.a a2 = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
                    Object obj = new Object();
                    com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/console/command/SportCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    Process.killProcess(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/console/command/SportCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
                    break;
                case 2:
                    ge geVar = new ge();
                    geVar.dJP.action = 2;
                    geVar.dJP.dJS = (long) Integer.valueOf(strArr[2]).intValue();
                    geVar.dJP.bqc = 1;
                    EventCenter.instance.asyncPublish(geVar, Looper.getMainLooper());
                    break;
            }
            AppMethodBeat.o(20183);
            return true;
        }
    }
}

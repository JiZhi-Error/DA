package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements a {
    static {
        AppMethodBeat.i(20180);
        b.a(new g(), "//normsg");
        AppMethodBeat.o(20180);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20179);
        if (!CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(20179);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(20179);
            return false;
        } else {
            try {
                if (strArr.length >= 3) {
                    Integer.valueOf(strArr[2]).intValue();
                }
            } catch (Exception e2) {
            }
            String lowerCase = strArr[1].toLowerCase();
            long nanoTime = System.nanoTime();
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case -1422437344:
                    if (lowerCase.equals("testrpp")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3403373:
                    if (lowerCase.equals("oaid")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    d.INSTANCE.ik(0, 63);
                    Toast.makeText(context, "info is reported.", 0).show();
                    break;
                case 1:
                    String aoK = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aoK();
                    Toast.makeText(context, "oaid: ".concat(String.valueOf(aoK)), 1).show();
                    Log.i("MicroMsg.NorMsgTest", "[+] oaid: %s", aoK);
                    break;
                default:
                    AppMethodBeat.o(20179);
                    return false;
            }
            String format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", strArr[1], Long.valueOf(System.nanoTime() - nanoTime));
            Log.i("MicroMsg.NorMsgTest", format);
            Toast.makeText(context, format, 0).show();
            AppMethodBeat.o(20179);
            return true;
        }
    }
}

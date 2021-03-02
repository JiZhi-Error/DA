package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class l implements a {
    static {
        AppMethodBeat.i(20190);
        b.a(new l(), "//warpgate");
        AppMethodBeat.o(20190);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20189);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(20189);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(20189);
            return true;
        } else {
            String str2 = strArr[1];
            char c2 = 65535;
            switch (str2.hashCode()) {
                case 3551:
                    if (str2.equals("on")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 109935:
                    if (str2.equals("off")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3540994:
                    if (str2.equals("stop")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 109757538:
                    if (str2.equals("start")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    ac.jPw = true;
                    ac.jPv = true;
                    break;
                case 1:
                    ac.jPw = false;
                    ac.jPv = false;
                    break;
                case 2:
                    int i2 = 8888;
                    if (strArr.length >= 3) {
                        i2 = Util.getInt(strArr[2], 8888);
                    }
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("startServer", Integer.TYPE).invoke(null, Integer.valueOf(i2));
                        Toast.makeText(MMApplicationContext.getContext(), "start server on ".concat(String.valueOf(i2)), 1).show();
                        break;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.WarpgateCommand", e2, "", new Object[0]);
                        break;
                    }
                case 3:
                    try {
                        Class.forName("com.tencent.mm.plugin.sl_warpgate.server.WarpGateHttpServer").getMethod("stopServer", new Class[0]).invoke(null, new Object[0]);
                        Toast.makeText(MMApplicationContext.getContext(), "stop server", 1).show();
                        break;
                    } catch (Exception e3) {
                        Log.printErrStackTrace("MicroMsg.WarpgateCommand", e3, "", new Object[0]);
                        break;
                    }
            }
            AppMethodBeat.o(20189);
            return true;
        }
    }
}

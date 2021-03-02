package com.tencent.mm.plugin.wepkg.downloader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class d {
    private static volatile d JMh;
    private static Object lock = new Object();
    HashMap<String, c> JMi = new HashMap<>();

    static {
        AppMethodBeat.i(110601);
        AppMethodBeat.o(110601);
    }

    public static d gkL() {
        AppMethodBeat.i(110597);
        if (JMh == null) {
            synchronized (lock) {
                try {
                    if (JMh == null) {
                        JMh = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(110597);
                    throw th;
                }
            }
        }
        d dVar = JMh;
        AppMethodBeat.o(110597);
        return dVar;
    }

    private d() {
        AppMethodBeat.i(110598);
        AppMethodBeat.o(110598);
    }

    public final boolean bcv(String str) {
        AppMethodBeat.i(110599);
        if (this.JMi.containsKey(str)) {
            this.JMi.remove(str);
        }
        AppMethodBeat.o(110599);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(c cVar) {
        AppMethodBeat.i(110600);
        if (this.JMi.containsKey(cVar.JLZ.JMx)) {
            cVar.JMe = true;
            try {
                if (cVar.JMa != null) {
                    try {
                        cVar.JMa.getInputStream().close();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.Wepkg.WePkgDownloadTask", e2.getMessage());
                    }
                    cVar.JMa.disconnect();
                }
                if (cVar.jKp != null) {
                    cVar.jKp.cancel(false);
                }
            } catch (Exception e3) {
                Log.i("MicroMsg.Wepkg.WePkgDownloadTask", "stop, " + e3.getMessage());
            }
            this.JMi.remove(cVar.JLZ.JMx);
            AppMethodBeat.o(110600);
            return true;
        }
        AppMethodBeat.o(110600);
        return false;
    }
}

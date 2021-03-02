package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class n {
    private final LinkedList<String> JbE = new LinkedList<>();

    public n() {
        AppMethodBeat.i(79225);
        AppMethodBeat.o(79225);
    }

    public final void add(String str) {
        AppMethodBeat.i(79226);
        try {
            aZz(str);
            AppMethodBeat.o(79226);
        } catch (Exception e2) {
            Log.e("MicroMsg.WebViewURLRouteList", "add exp = %s", Util.stackTraceToString(e2));
            AppMethodBeat.o(79226);
        }
    }

    private void aZz(String str) {
        AppMethodBeat.i(79227);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(79227);
            return;
        }
        synchronized (this.JbE) {
            try {
                String peekLast = this.JbE.peekLast();
                String encode = URLEncoder.encode(str);
                if (peekLast == null || !peekLast.equals(encode)) {
                    this.JbE.addLast(encode);
                }
                if (this.JbE.size() > 10) {
                    this.JbE.removeFirst();
                }
            } finally {
                AppMethodBeat.o(79227);
            }
        }
    }

    public final String[] gdF() {
        String[] strArr;
        AppMethodBeat.i(79228);
        synchronized (this.JbE) {
            try {
                strArr = new String[this.JbE.size()];
                Iterator<String> it = this.JbE.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    strArr[i2] = it.next();
                    i2++;
                }
            } finally {
                AppMethodBeat.o(79228);
            }
        }
        return strArr;
    }

    public final void gdG() {
        AppMethodBeat.i(79229);
        if (!CrashReportFactory.hasDebuger()) {
            AppMethodBeat.o(79229);
            return;
        }
        StringBuilder sb = new StringBuilder("routeList: ");
        synchronized (this.JbE) {
            try {
                Iterator<String> it = this.JbE.iterator();
                while (it.hasNext()) {
                    sb.append(URLDecoder.decode(it.next())).append("\n");
                }
            } catch (Throwable th) {
                AppMethodBeat.o(79229);
                throw th;
            }
        }
        Log.d("MicroMsg.WebViewURLRouteList", sb.toString());
        AppMethodBeat.o(79229);
    }
}

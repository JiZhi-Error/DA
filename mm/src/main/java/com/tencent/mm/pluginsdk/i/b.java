package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static b JYm = new b(BuildConfig.KINDA_DEFAULT);
    private ConcurrentHashMap<String, Integer> JYj = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Long> JYk = new ConcurrentHashMap<>();
    private String JYl = "";
    private boolean ded = false;

    static {
        AppMethodBeat.i(151895);
        AppMethodBeat.o(151895);
    }

    public b(String str) {
        AppMethodBeat.i(151893);
        if (CrashReportFactory.hasDebuger()) {
            this.ded = true;
        }
        this.JYl = str;
        AppMethodBeat.o(151893);
    }

    public final void bdU(String str) {
        int i2;
        long j2;
        AppMethodBeat.i(151894);
        if (!this.ded) {
            AppMethodBeat.o(151894);
            return;
        }
        if (this.JYj.containsKey(str)) {
            i2 = this.JYj.get(str).intValue();
        } else {
            i2 = 0;
        }
        int i3 = i2 + 1;
        this.JYj.put(str, Integer.valueOf(i3));
        if (this.JYk.containsKey(str)) {
            j2 = this.JYk.get(str).longValue();
        } else {
            j2 = 0;
        }
        if (System.currentTimeMillis() - j2 > 1000) {
            new StringBuilder().append(this.JYl).append("user get fps ").append(i3).append(" fpswraper: ").append(str);
            this.JYj.put(str, 0);
            this.JYk.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        AppMethodBeat.o(151894);
    }
}

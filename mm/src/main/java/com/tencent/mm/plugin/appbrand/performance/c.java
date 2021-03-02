package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class c {
    private static long dkt;
    private static final List<a> nwO = Collections.synchronizedList(new LinkedList());

    static {
        AppMethodBeat.i(139903);
        AppMethodBeat.o(139903);
    }

    public static void Bo(long j2) {
        dkt = j2;
    }

    public static void b(String str, String str2, long j2, long j3) {
        AppMethodBeat.i(139897);
        a(str, "Native", str2, j2, j3, null);
        AppMethodBeat.o(139897);
    }

    public static void a(String str, String str2, String str3, long j2, long j3, String str4) {
        AppMethodBeat.i(139898);
        a(str, str2, str3, "X", j2, j3, str4);
        AppMethodBeat.o(139898);
    }

    public static void a(String str, String str2, String str3, double d2) {
        AppMethodBeat.i(139899);
        long currentTimeMillis = System.currentTimeMillis();
        a(str, str2, str3, "C", currentTimeMillis, currentTimeMillis, String.format("{\"%s\":%f}", str3, Double.valueOf(d2)));
        AppMethodBeat.o(139899);
    }

    public static void a(String str, String str2, String str3, String str4, long j2, long j3, String str5) {
        String str6;
        AppMethodBeat.i(139900);
        a aVar = new a();
        aVar.appId = str;
        aVar.name = str3;
        aVar.category = str2;
        aVar.nwP = str4;
        aVar.start = j2;
        aVar.boX = j3;
        if (str5 != null) {
            str6 = URLEncoder.encode(str5);
        } else {
            str6 = "";
        }
        aVar.nbc = str6;
        if (nwO.size() < 10000) {
            nwO.add(aVar);
        }
        AppMethodBeat.o(139900);
    }

    static boolean ael(String str) {
        AppMethodBeat.i(139901);
        StringBuilder sb = new StringBuilder();
        synchronized (nwO) {
            try {
                if (nwO.size() == 0) {
                    return true;
                }
                Log.d("MicroMsg.AppBrandPerformanceTracer", "dumpTrace events size: %d", Integer.valueOf(nwO.size()));
                for (a aVar : nwO) {
                    if (aVar.appId.equals(str) && aVar.start >= dkt) {
                        sb.append(aVar.toString()).append("\n");
                    }
                }
                nwO.clear();
                boolean eu = eu(str, sb.toString());
                AppMethodBeat.o(139901);
                return eu;
            } finally {
                AppMethodBeat.o(139901);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086 A[SYNTHETIC, Splitter:B:19:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[SYNTHETIC, Splitter:B:26:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean eu(java.lang.String r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 164
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.performance.c.eu(java.lang.String, java.lang.String):boolean");
    }

    public static class a {
        String appId;
        long boX;
        String category;
        String name;
        String nbc;
        String nwP;
        long start;

        public final String toString() {
            AppMethodBeat.i(139896);
            String str = this.name + "," + this.category + "," + this.nwP + "," + (this.start - c.dkt) + "," + (this.boX - c.dkt) + "," + this.nbc;
            AppMethodBeat.o(139896);
            return str;
        }
    }
}

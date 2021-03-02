package com.tencent.mm.plugin.trafficmonitor;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.trafficmonitor.e;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class g {
    private static Map<Integer, e> GsX = new ConcurrentHashMap();
    private static g GsY;

    static {
        AppMethodBeat.i(123929);
        AppMethodBeat.o(123929);
    }

    private g() {
        AppMethodBeat.i(123923);
        o(1, 471859200, 300000);
        o(2, 838860800, 600000);
        o(3, 1887436800, 1800000);
        o(4, -1673527296, 3603000);
        AppMethodBeat.o(123923);
    }

    public static g fAk() {
        AppMethodBeat.i(123924);
        if (GsY == null) {
            synchronized (g.class) {
                try {
                    if (GsY == null) {
                        GsY = new g();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(123924);
                    throw th;
                }
            }
        }
        g gVar = GsY;
        AppMethodBeat.o(123924);
        return gVar;
    }

    private void o(final int i2, long j2, long j3) {
        e bVar;
        AppMethodBeat.i(123925);
        f fVar = new f(j2);
        if (Build.VERSION.SDK_INT >= 28) {
            bVar = new d();
        } else {
            bVar = new b();
        }
        bVar.id = i2;
        bVar.interval = j3;
        bVar.type = 0;
        bVar.GsO = fVar;
        bVar.GsP = new e.a() {
            /* class com.tencent.mm.plugin.trafficmonitor.g.AnonymousClass1 */
        };
        GsX.put(Integer.valueOf(i2), bVar);
        AppMethodBeat.o(123925);
    }

    public static void fAl() {
        AppMethodBeat.i(123926);
        for (e eVar : GsX.values()) {
            eVar.fAh();
        }
        AppMethodBeat.o(123926);
    }

    public static void fAm() {
        AppMethodBeat.i(123927);
        for (e eVar : GsX.values()) {
            eVar.currentIndex = 0;
        }
        AppMethodBeat.o(123927);
    }

    public static int fAn() {
        AppMethodBeat.i(123928);
        int i2 = -1;
        long j2 = 0;
        Iterator<e> it = GsX.values().iterator();
        while (true) {
            long j3 = j2;
            if (it.hasNext()) {
                e next = it.next();
                if (next.interval > j3) {
                    j3 = next.interval;
                    i2 = next.id;
                }
                j2 = j3;
            } else {
                AppMethodBeat.o(123928);
                return i2;
            }
        }
    }
}

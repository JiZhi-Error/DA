package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.n.h;
import com.tencent.mm.sdk.platformtools.Util;

public final class u {
    private static volatile u JVz = null;

    public static class a {
        public int JVA;
        public int JVB;
        public String JVC;
        public int JVD;
        public String JVE;
    }

    private u() {
    }

    public static u gmF() {
        AppMethodBeat.i(109473);
        if (JVz == null) {
            synchronized (u.class) {
                try {
                    if (JVz == null) {
                        JVz = new u();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(109473);
                    throw th;
                }
            }
        }
        u uVar = JVz;
        AppMethodBeat.o(109473);
        return uVar;
    }

    public static t A(int i2, Bundle bundle) {
        AppMethodBeat.i(109474);
        switch (i2) {
            case 1:
                y yVar = new y();
                AppMethodBeat.o(109474);
                return yVar;
            case 2:
                d dVar = new d(bundle);
                AppMethodBeat.o(109474);
                return dVar;
            default:
                r rVar = new r();
                AppMethodBeat.o(109474);
                return rVar;
        }
    }

    public static int ahE(int i2) {
        AppMethodBeat.i(109475);
        switch (i2) {
            case 0:
                int i3 = Util.getInt(h.aqK().aj("QQBroswer", "RecommendCount"), 5);
                AppMethodBeat.o(109475);
                return i3;
            case 1:
                AppMethodBeat.o(109475);
                return Integer.MAX_VALUE;
            default:
                AppMethodBeat.o(109475);
                return 5;
        }
    }

    public static void ahF(int i2) {
        AppMethodBeat.i(109476);
        switch (i2) {
            case 0:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10998, 0);
                AppMethodBeat.o(109476);
                return;
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 0);
                break;
        }
        AppMethodBeat.o(109476);
    }

    public static void ahG(int i2) {
        AppMethodBeat.i(109477);
        switch (i2) {
            case 0:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10998, 1);
                AppMethodBeat.o(109477);
                return;
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 1);
                break;
        }
        AppMethodBeat.o(109477);
    }

    public static void ahH(int i2) {
        AppMethodBeat.i(109478);
        switch (i2) {
            case 0:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10998, 3);
                AppMethodBeat.o(109478);
                return;
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 3);
                break;
        }
        AppMethodBeat.o(109478);
    }

    public static void ahI(int i2) {
        AppMethodBeat.i(109479);
        switch (i2) {
            case 0:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10998, 2);
                AppMethodBeat.o(109479);
                return;
            case 1:
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11091, 2);
                break;
        }
        AppMethodBeat.o(109479);
    }
}

package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.core.stack.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;

public final class c {
    private static volatile c sHR;
    public final a sHP = new a();
    public d.c sHQ;
    private boolean sHS = false;
    private boolean sHT = false;
    private boolean sHU = true;

    public static c cPx() {
        AppMethodBeat.i(122031);
        if (sHR == null) {
            synchronized (c.class) {
                try {
                    if (sHR == null) {
                        sHR = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(122031);
                    throw th;
                }
            }
        }
        c cVar = sHR;
        AppMethodBeat.o(122031);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(122032);
        AppMethodBeat.o(122032);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0512 A[Catch:{ Exception -> 0x0538 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r11, java.lang.String r12, int r13, long r14) {
        /*
        // Method dump skipped, instructions count: 1466
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.c.c.a(int, java.lang.String, int, long):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean apY(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 388
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.c.c.apY(java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean apZ(java.lang.String r8) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.c.c.apZ(java.lang.String):boolean");
    }

    /* renamed from: do  reason: not valid java name */
    private static com.tencent.mm.vending.j.d<String, Integer, Boolean> m18do(String str, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        bn cNR;
        AppMethodBeat.i(220534);
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNM();
        try {
            com.tencent.mm.vending.j.c<String, Integer> cNO = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNO();
            com.tencent.mm.vending.j.c<String, Integer> cNP = com.tencent.mm.plugin.expt.hellhound.core.stack.d.cNP();
            if (str == null || cNO == null || cNP == null) {
                Log.e("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: illeagal Event");
                AppMethodBeat.o(220534);
                return null;
            }
            String str2 = (String) cNO.get(0);
            if (b.aoN(str2)) {
                Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFakeSwitchAccountUI true");
                AppMethodBeat.o(220534);
                return null;
            }
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: Resume: %s, Pause: %s, Stop: %s", cNO, cNP, str);
            Integer num = (Integer) cNO.get(1);
            Integer num2 = (Integer) cNP.get(1);
            if (num == null || num2 == null) {
                z = false;
            } else {
                z = i2 == num.intValue() && i2 == num2.intValue();
            }
            if (!str.equals(str2) || !str.equals(cNP.get(0))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 || !z) {
                z3 = false;
            } else {
                z3 = true;
            }
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop, case-1：%b", Boolean.valueOf(z3));
            if (z3 && !b.aoO(str) && !b.aoP(str) && (cNR = e.cNR()) != null) {
                Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8: %s, %s", cNR.KFh.activityName, Integer.valueOf(cNR.KFh.aHK));
                if (!cNR.KFh.activityName.startsWith("com.tencent.mm")) {
                    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop: NOT wx activity");
                } else if (cNR.KFh.aHK <= 0 && !cNR.KFh.activityName.equals(str)) {
                    Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop isEvent8-1: false");
                    z3 = false;
                }
            }
            Log.i("HABBYGE-MALI.HellFrontBackMonitor", "isFront2BackOnStop case1 && case2：%b", Boolean.valueOf(z3));
            com.tencent.mm.vending.j.d<String, Integer, Boolean> i3 = a.i(str, Integer.valueOf(i2), Boolean.valueOf(z3));
            AppMethodBeat.o(220534);
            return i3;
        } catch (Exception e2) {
            Log.printErrStackTrace("HABBYGE-MALI.HellFrontBackMonitor", e2, "isFront2BackOnStop", new Object[0]);
            h.INSTANCE.idkeyStat(932, 43, 1, false);
            AppMethodBeat.o(220534);
            return null;
        }
    }

    private void r(String str, int i2, long j2) {
        AppMethodBeat.i(220535);
        if (this.sHQ != null) {
            this.sHQ.i(str, i2, j2);
        }
        AppMethodBeat.o(220535);
    }

    private void s(String str, int i2, long j2) {
        AppMethodBeat.i(220536);
        if (this.sHQ != null) {
            this.sHQ.j(str, i2, j2);
        }
        AppMethodBeat.o(220536);
    }
}

package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;

public final class ax {
    public static int DOc = -1;
    public static int DOd = 0;
    public static int DOe = 1;
    public static int DOf = 2;
    public boolean DOg = true;
    public boolean dJM = false;
    public int dJN = 0;
    public String objectId = "";

    public final void a(String str, boolean z, int i2, long j2, int i3) {
        int i4;
        AppMethodBeat.i(179115);
        if (i3 == 2) {
            this.objectId = str;
            this.dJM = z;
            this.dJN = i2;
            this.DOg = false;
            an.DMh = 0;
            g.aAi();
            t tVar = g.aAg().hqi;
            int i5 = DOd;
            if (z) {
                i4 = 4;
            } else {
                i4 = 8;
            }
            tVar.a(new ab(str, j2, z, i2, i5, 0, i4, 2), 0);
            AppMethodBeat.o(179115);
            return;
        }
        if (i3 == 1) {
            g.aAi();
            g.aAh().azQ().set(68377, "");
            g.aAi();
            g.aAg().hqi.a(new z(j2, 0, 0), 0);
        }
        AppMethodBeat.o(179115);
    }

    public static void b(String str, boolean z, int i2, long j2, int i3) {
        int i4;
        AppMethodBeat.i(179116);
        if (i3 == 2) {
            an.DMh = an.DIf;
            g.aAi();
            t tVar = g.aAg().hqi;
            long j3 = an.DIf;
            int i5 = DOe;
            if (z) {
                i4 = 4;
            } else {
                i4 = 8;
            }
            tVar.a(new ab(str, j3, z, i2, i5, 0, i4, 2), 0);
            AppMethodBeat.o(179116);
            return;
        }
        if (i3 == 1) {
            g.aAi();
            g.aAh().azQ().set(68377, "");
            g.aAi();
            g.aAg().hqi.a(new z(0, j2, 1), 0);
        }
        AppMethodBeat.o(179116);
    }

    public static void f(String str, boolean z, int i2) {
        int i3;
        AppMethodBeat.i(95953);
        g.aAi();
        t tVar = g.aAg().hqi;
        long j2 = an.DIg;
        int i4 = DOf;
        if (z) {
            i3 = 4;
        } else {
            i3 = 8;
        }
        tVar.a(new ab(str, j2, z, i2, i4, 0, i3, 2), 0);
        AppMethodBeat.o(95953);
    }
}

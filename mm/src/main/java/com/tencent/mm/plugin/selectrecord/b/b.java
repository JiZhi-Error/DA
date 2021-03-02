package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public static b CXe = null;
    public gf CXf;

    public static b eSz() {
        AppMethodBeat.i(187914);
        if (CXe == null) {
            eSA();
        }
        b bVar = CXe;
        AppMethodBeat.o(187914);
        return bVar;
    }

    public static void eSA() {
        AppMethodBeat.i(187915);
        CXe = new b();
        AppMethodBeat.o(187915);
    }

    public b() {
        AppMethodBeat.i(187916);
        this.CXf = null;
        this.CXf = new gf();
        AppMethodBeat.o(187916);
    }

    public final void Xk(int i2) {
        AppMethodBeat.i(187917);
        gf gfVar = this.CXf;
        gfVar.eJg = gfVar.x("HasConfirmed", String.valueOf(i2), true);
        AppMethodBeat.o(187917);
    }

    public final void IH(long j2) {
        this.CXf.eJh = j2;
    }

    public final boolean eSB() {
        AppMethodBeat.i(187918);
        Xk(2);
        boolean bfK = bfK();
        AppMethodBeat.o(187918);
        return bfK;
    }

    public final boolean bfK() {
        AppMethodBeat.i(187919);
        this.CXf.eJl = 1;
        Log.d("MicroMsg.MultiMessageForwardReportManager", "%s", this.CXf.abW());
        boolean bfK = this.CXf.bfK();
        AppMethodBeat.o(187919);
        return bfK;
    }
}

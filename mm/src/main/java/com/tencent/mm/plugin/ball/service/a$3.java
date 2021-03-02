package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.a;

/* access modifiers changed from: package-private */
public class a$3 implements Runnable {
    final /* synthetic */ FloatBallHelper oWJ;

    a$3(FloatBallHelper floatBallHelper) {
        this.oWJ = floatBallHelper;
    }

    public final void run() {
        AppMethodBeat.i(216972);
        if (this.oWJ.oWG != null) {
            this.oWJ.oWG.q(this.oWJ.oWE);
        }
        if (this.oWJ.oWE != null) {
            if (this.oWJ.cij()) {
                this.oWJ.ciu();
            }
            ((a) g.af(a.class)).d(this.oWJ.oWE.oWs.hDa, this.oWJ.ciq(), this.oWJ.bCG());
        }
        AppMethodBeat.o(216972);
    }
}

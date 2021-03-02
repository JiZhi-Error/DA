package com.tencent.mm.plugin.ball.service;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class a$1 implements Runnable {
    final /* synthetic */ FloatBallHelper oWJ;

    a$1(FloatBallHelper floatBallHelper) {
        this.oWJ = floatBallHelper;
    }

    public final void run() {
        AppMethodBeat.i(258539);
        if (this.oWJ.oWG != null) {
            this.oWJ.oWG.o(this.oWJ.oWE);
        }
        if (this.oWJ.oWE != null) {
            FloatBallHelper.a(this.oWJ);
            FloatBallHelper.b(this.oWJ);
        }
        AppMethodBeat.o(258539);
    }
}

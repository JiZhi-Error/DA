package com.tencent.mm.plugin.ball.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.d.e;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public f oXA;
    private e oXB;

    public b(f fVar, e eVar) {
        this.oXA = fVar;
        this.oXB = eVar;
    }

    public final void stop() {
        AppMethodBeat.i(106281);
        Log.i("MicroMsg.FloatBallFadeInController", "stop FloatIndicatorController");
        this.oXA.a((f.a) null);
        AppMethodBeat.o(106281);
    }
}

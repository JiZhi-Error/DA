package com.tencent.mm.plugin.ball.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class f {
    public static void cji() {
        AppMethodBeat.i(258765);
        e(false, true, true);
        AppMethodBeat.o(258765);
    }

    public static void cjj() {
        AppMethodBeat.i(258766);
        e(true, true, true);
        AppMethodBeat.o(258766);
    }

    public static void cjk() {
        AppMethodBeat.i(188581);
        e(true, false, true);
        AppMethodBeat.o(188581);
    }

    public static void e(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(184419);
        b bVar = (b) g.af(b.class);
        if (bVar == null) {
            Log.i("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, service is null");
            AppMethodBeat.o(184419);
        } else if (z) {
            Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, hide float ball, mark:%s", Boolean.valueOf(z3));
            if (z3) {
                bVar.jN(z2);
                AppMethodBeat.o(184419);
                return;
            }
            bVar.jL(z2);
            AppMethodBeat.o(184419);
        } else {
            Log.printInfoStack("MicroMsg.FloatBallVisibilityUtil", "operateFloatBall, show float ball, mark:%s", Boolean.valueOf(z3));
            if (z3) {
                bVar.jO(z2);
                AppMethodBeat.o(184419);
                return;
            }
            bVar.jM(z2);
            AppMethodBeat.o(184419);
        }
    }
}

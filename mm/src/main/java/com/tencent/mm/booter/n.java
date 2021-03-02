package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.Util;

public final class n {
    private static long gmF = Util.MILLSECONDS_OF_DAY;

    public static void run() {
        boolean z;
        AppMethodBeat.i(19898);
        bg.aVF();
        if (Util.secondsToNow(Util.nullAsNil((Long) c.azQ().get(81944, (Object) null))) * 1000 > gmF) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            d bfP = d.bfP();
            d.bfQ();
            if (!bfP.gYQ) {
                g.aAi();
                if (g.aAh().isSDCardAvailable()) {
                    bfP.release();
                    bfP.gYQ = true;
                    g.azz().a(JsApiGetBackgroundAudioState.CTRL_INDEX, bfP);
                    g.azz().a(new com.tencent.mm.bb.n(9), 0);
                }
            }
        }
        AppMethodBeat.o(19898);
    }
}

package com.tencent.mm.plugin.game.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.i.a;
import com.tencent.mm.plugin.wepkg.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.concurrent.atomic.AtomicInteger;

public final class f {
    private static AtomicInteger xwf = new AtomicInteger(0);

    static {
        AppMethodBeat.i(186829);
        AppMethodBeat.o(186829);
    }

    public static void cyc() {
        AppMethodBeat.i(186827);
        xwf.getAndIncrement();
        AppMethodBeat.o(186827);
    }

    public static void remove() {
        AppMethodBeat.i(186828);
        int decrementAndGet = xwf.decrementAndGet();
        Log.i("MicroMsg.LuggageGameWebViewActivityStack", "remove count = ".concat(String.valueOf(decrementAndGet)));
        if (decrementAndGet <= 0) {
            if (a.dTW() != null) {
                a dTW = a.dTW();
                Log.i("MicroMsg.GameJsCore", "stop");
                dTW.xzp = a.EnumC1399a.stopped;
                dTW.azS("onStop");
                dTW.cve = new MTimerHandler(new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.game.luggage.i.a.AnonymousClass3 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(186988);
                        if (a.this.xzp == EnumC1399a.stopped) {
                            a.d(a.this);
                        }
                        AppMethodBeat.o(186988);
                        return false;
                    }
                }, false);
                dTW.cve.startTimer(300000);
            }
            b.vC();
        }
        AppMethodBeat.o(186828);
    }
}

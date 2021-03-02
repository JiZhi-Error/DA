package com.tencent.luggage.game.b;

import com.tencent.luggage.game.g.a;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class d {
    private static final a.C0173a cuF = new a.C0173a();

    static {
        AppMethodBeat.i(130481);
        AppMethodBeat.o(130481);
    }

    public final void LW() {
        AppMethodBeat.i(130478);
        a.a(cuF, new Runnable() {
            /* class com.tencent.luggage.game.b.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(130472);
                d.this.LY();
                AppMethodBeat.o(130472);
            }
        });
        AppMethodBeat.o(130478);
    }

    /* access modifiers changed from: protected */
    public void LX() {
        AppMethodBeat.i(130479);
        long currentTicks = Util.currentTicks();
        b.loadLibraries();
        Log.i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush [%d]ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(130479);
    }

    /* access modifiers changed from: protected */
    public final void LY() {
        AppMethodBeat.i(130480);
        LX();
        c.C0193c.a(new c.b() {
            /* class com.tencent.luggage.game.b.d.AnonymousClass2 */

            @Override // com.tencent.magicbrush.a.c.b
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130473);
                Log.d(str, str2, objArr);
                AppMethodBeat.o(130473);
            }

            @Override // com.tencent.magicbrush.a.c.b
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130474);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(130474);
            }

            @Override // com.tencent.magicbrush.a.c.b
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130475);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(130475);
            }

            @Override // com.tencent.magicbrush.a.c.b
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130476);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(130476);
            }

            @Override // com.tencent.magicbrush.a.c.b
            public final void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(130477);
                Log.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(130477);
            }
        });
        AppMethodBeat.o(130480);
    }
}

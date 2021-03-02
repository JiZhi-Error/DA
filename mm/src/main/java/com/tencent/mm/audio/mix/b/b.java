package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;

public class b {
    private static b duh;
    private ArrayList<com.tencent.mm.audio.mix.a.b> dui = new ArrayList<>();

    private b() {
        AppMethodBeat.i(136727);
        AppMethodBeat.o(136727);
    }

    public static b YD() {
        AppMethodBeat.i(136728);
        if (duh == null) {
            synchronized (b.class) {
                try {
                    if (duh == null) {
                        duh = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136728);
                    throw th;
                }
            }
        }
        b bVar = duh;
        AppMethodBeat.o(136728);
        return bVar;
    }

    public final synchronized com.tencent.mm.audio.mix.a.b YE() {
        com.tencent.mm.audio.mix.a.b bVar;
        AppMethodBeat.i(136729);
        if (this.dui.size() > 0) {
            bVar = this.dui.remove(this.dui.size() - 1);
            AppMethodBeat.o(136729);
        } else {
            bVar = new com.tencent.mm.audio.mix.a.b();
            AppMethodBeat.o(136729);
        }
        return bVar;
    }

    public final synchronized void a(com.tencent.mm.audio.mix.a.b bVar) {
        AppMethodBeat.i(136730);
        if (bVar == null || bVar.dtQ == null) {
            AppMethodBeat.o(136730);
        } else {
            bVar.channels = 0;
            bVar.sampleRate = 0;
            bVar.dtR.clear();
            Arrays.fill(bVar.dtQ, 0, bVar.dtQ.length, (byte) 0);
            this.dui.add(0, bVar);
            AppMethodBeat.o(136730);
        }
    }
}

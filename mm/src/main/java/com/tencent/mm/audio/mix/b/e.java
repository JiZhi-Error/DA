package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class e {
    private static e dun;
    private ArrayList<com.tencent.mm.audio.mix.a.e> dud = new ArrayList<>();
    private Object sLock = new Object();

    private e() {
        AppMethodBeat.i(136735);
        AppMethodBeat.o(136735);
    }

    public static e YJ() {
        AppMethodBeat.i(136736);
        if (dun == null) {
            synchronized (e.class) {
                try {
                    if (dun == null) {
                        dun = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136736);
                    throw th;
                }
            }
        }
        e eVar = dun;
        AppMethodBeat.o(136736);
        return eVar;
    }

    public final com.tencent.mm.audio.mix.a.e YI() {
        AppMethodBeat.i(136737);
        synchronized (this.sLock) {
            try {
                if (this.dud.size() > 0) {
                    return this.dud.remove(this.dud.size() - 1);
                }
                com.tencent.mm.audio.mix.a.e eVar = new com.tencent.mm.audio.mix.a.e();
                AppMethodBeat.o(136737);
                return eVar;
            } finally {
                AppMethodBeat.o(136737);
            }
        }
    }

    public final void b(com.tencent.mm.audio.mix.a.e eVar) {
        AppMethodBeat.i(136738);
        if (eVar == null || eVar.dtQ == null) {
            AppMethodBeat.o(136738);
            return;
        }
        eVar.reset();
        synchronized (this.sLock) {
            try {
                this.dud.add(0, eVar);
            } finally {
                AppMethodBeat.o(136738);
            }
        }
    }

    public final synchronized long YK() {
        long size;
        AppMethodBeat.i(136739);
        size = (long) (this.dud.size() * 3536);
        AppMethodBeat.o(136739);
        return size;
    }
}

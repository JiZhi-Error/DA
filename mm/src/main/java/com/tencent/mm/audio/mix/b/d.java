package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;

public final class d {
    private static d dum;
    private int count = 0;
    private ArrayList<e> dud = new ArrayList<>();
    private long dul = 3000000;
    private Object sLock = new Object();
    private int size = 0;

    private d() {
        AppMethodBeat.i(136731);
        AppMethodBeat.o(136731);
    }

    public static d YH() {
        AppMethodBeat.i(136732);
        if (dum == null) {
            synchronized (e.class) {
                try {
                    if (dum == null) {
                        dum = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136732);
                    throw th;
                }
            }
        }
        d dVar = dum;
        AppMethodBeat.o(136732);
        return dVar;
    }

    public final e YI() {
        AppMethodBeat.i(136733);
        synchronized (this.sLock) {
            try {
                if (this.dud.size() > 0) {
                    return this.dud.remove(this.dud.size() - 1);
                } else if (((long) this.size) >= this.dul) {
                    b.e("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "size >= FIX_SIZE, size:%d", Integer.valueOf(this.size));
                    AppMethodBeat.o(136733);
                    return null;
                } else {
                    this.count++;
                    this.size = this.count * 3536;
                    b.i("MicroMsg.Mix.AudioPcmDataTrackFixedSizePool", "pool tract count:%d", Integer.valueOf(this.count));
                    e eVar = new e();
                    eVar.dub = true;
                    AppMethodBeat.o(136733);
                    return eVar;
                }
            } finally {
                AppMethodBeat.o(136733);
            }
        }
    }

    public final void b(e eVar) {
        AppMethodBeat.i(136734);
        if (eVar == null || eVar.dtQ == null) {
            AppMethodBeat.o(136734);
        } else if (!eVar.dub) {
            AppMethodBeat.o(136734);
        } else {
            eVar.reset();
            synchronized (this.sLock) {
                try {
                    this.dud.add(0, eVar);
                } finally {
                    AppMethodBeat.o(136734);
                }
            }
        }
    }
}

package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.ArrayList;

public class c {
    private static c duj;
    private volatile int count = 0;
    public volatile ArrayList<com.tencent.mm.audio.mix.a.c> duk = new ArrayList<>();
    private long dul = 50;

    private c() {
        AppMethodBeat.i(182541);
        AppMethodBeat.o(182541);
    }

    public static c YF() {
        AppMethodBeat.i(182542);
        if (duj == null) {
            synchronized (c.class) {
                try {
                    if (duj == null) {
                        duj = new c();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(182542);
                    throw th;
                }
            }
        }
        c cVar = duj;
        AppMethodBeat.o(182542);
        return cVar;
    }

    public final synchronized com.tencent.mm.audio.mix.a.c YG() {
        com.tencent.mm.audio.mix.a.c cVar;
        AppMethodBeat.i(182543);
        if (this.duk.size() > 0) {
            cVar = this.duk.remove(this.duk.size() - 1);
            AppMethodBeat.o(182543);
        } else if (((long) this.count) >= this.dul) {
            b.e("MicroMsg.Mix.AudioOutputMixBufferPool", "size >= FIX_SIZE, size:%d", Integer.valueOf(this.count));
            cVar = null;
            AppMethodBeat.o(182543);
        } else {
            this.count++;
            cVar = new com.tencent.mm.audio.mix.a.c();
            AppMethodBeat.o(182543);
        }
        return cVar;
    }
}

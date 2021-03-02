package com.tencent.mm.audio.mix.d;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends j {
    private k dvg;
    public boolean dvh = false;
    public l dvi;

    public b(k kVar, String str) {
        super(str);
        this.dvg = kVar;
    }

    @Override // com.tencent.mm.audio.mix.d.j
    public final void run() {
        AppMethodBeat.i(136797);
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s", this.name);
        if (this.dvh) {
            AppMethodBeat.o(136797);
            return;
        }
        Process.setThreadPriority(-16);
        this.dvg.a(this.dvi);
        this.dvg.a(this);
        this.dvh = true;
        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeTask", "run task %s end", this.name);
        AppMethodBeat.o(136797);
    }

    @Override // com.tencent.mm.audio.mix.d.j
    public final void reset() {
        this.dvh = false;
    }

    public final void b(l lVar) {
        AppMethodBeat.i(136798);
        this.dvi = lVar;
        this.addTime = System.currentTimeMillis();
        AppMethodBeat.o(136798);
    }

    public final boolean YT() {
        return this.dvi == null;
    }
}

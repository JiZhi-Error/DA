package com.tencent.mm.audio.mix.e;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;

public final class c extends j {
    public g dvX;
    public com.tencent.mm.audio.mix.h.c dvY;
    public boolean dvh = false;

    public c(g gVar, String str) {
        super(str);
        this.dvX = gVar;
    }

    @Override // com.tencent.mm.audio.mix.d.j
    public final void run() {
        AppMethodBeat.i(198118);
        b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s", this.name);
        if (this.dvh) {
            this.dvX.a(this);
            AppMethodBeat.o(198118);
            return;
        }
        Process.setThreadPriority(10);
        this.dvX.a(this.dvY);
        this.dvX.a(this);
        this.dvh = true;
        b.i("MicroMsg.Mix.AudioDownloadTask", "run task %s end", this.name);
        AppMethodBeat.o(198118);
    }

    @Override // com.tencent.mm.audio.mix.d.j
    public final void reset() {
        this.dvh = false;
    }

    public final void b(com.tencent.mm.audio.mix.h.c cVar) {
        AppMethodBeat.i(198119);
        this.dvY = cVar;
        this.addTime = System.currentTimeMillis();
        AppMethodBeat.o(198119);
    }
}

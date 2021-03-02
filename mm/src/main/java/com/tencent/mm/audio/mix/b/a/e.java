package com.tencent.mm.audio.mix.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.j;

public final class e extends j {
    private f dur;

    public e(f fVar, String str) {
        super(str);
        this.dur = fVar;
    }

    @Override // com.tencent.mm.audio.mix.d.j
    public final void run() {
        AppMethodBeat.i(136755);
        if (this.dur != null) {
            this.dur.YC();
            this.dur.end();
        }
        this.dur = null;
        i.b(this);
        AppMethodBeat.o(136755);
    }
}

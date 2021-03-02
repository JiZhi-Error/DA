package com.tencent.mm.compatible.b;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends AudioTrack {
    public e(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, 2, i5, 1);
        AppMethodBeat.i(155555);
        g.oo(hashCode());
        AppMethodBeat.o(155555);
    }

    public final void release() {
        AppMethodBeat.i(155556);
        super.release();
        g.op(hashCode());
        AppMethodBeat.o(155556);
    }
}

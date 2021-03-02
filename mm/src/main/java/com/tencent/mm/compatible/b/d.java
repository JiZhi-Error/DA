package com.tencent.mm.compatible.b;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends AudioRecord {
    public d(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, 2, i5);
        AppMethodBeat.i(155553);
        g.oq(hashCode());
        AppMethodBeat.o(155553);
    }

    public final void release() {
        AppMethodBeat.i(155554);
        super.release();
        g.or(hashCode());
        AppMethodBeat.o(155554);
    }
}

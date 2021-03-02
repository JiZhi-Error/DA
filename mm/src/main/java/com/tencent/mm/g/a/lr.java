package com.tencent.mm.g.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lr extends IEvent {
    public a dRb;

    public static final class a {
        public Intent dRc;
    }

    public lr() {
        this((byte) 0);
    }

    private lr(byte b2) {
        AppMethodBeat.i(121050);
        this.dRb = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(121050);
    }
}

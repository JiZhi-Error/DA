package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class si extends IEvent {
    public a dYX;
    public b dYY;

    public static final class a {
        public Context context;
    }

    public static final class b {
        public boolean dYN;
    }

    public si() {
        this((byte) 0);
    }

    private si(byte b2) {
        AppMethodBeat.i(149886);
        this.dYX = new a();
        this.dYY = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149886);
    }
}
